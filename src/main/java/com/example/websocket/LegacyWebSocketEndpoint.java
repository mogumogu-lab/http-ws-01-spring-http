package com.example.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws-old")
public class LegacyWebSocketEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Legacy WebSocket opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println("Legacy received: " + message);
        session.getBasicRemote().sendText("Echo (old): " + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Legacy error: " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Legacy WebSocket closed: " + session.getId());
    }
}