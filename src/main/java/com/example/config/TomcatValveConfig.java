package com.example.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatValveConfig {

    // @Bean
    // TomcatServletWebServerFactory tomcatFactory() {
    //     TomcatServletWebServerFactory f = new TomcatServletWebServerFactory();
    //     // Engine-level valve
    //     f.addEngineValves(new TraceValve("engine"));
    //     // Context-level valve (per webapp)
    //     f.addContextValves(new TraceValve("context"));
    //     return f;
    // }
}