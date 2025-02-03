package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceDiscoveryController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/services")
    public Object getServices(){
        return eurekaClient.getApplications();
    }
}
