package com.desafio.docket.config;

import com.desafio.docket.service.CertidaoDocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class IntegracaoDocket {
    @Autowired
    CertidaoDocketService certidaoDocketService;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        certidaoDocketService.salvaCertidoesDocket();
    }
}