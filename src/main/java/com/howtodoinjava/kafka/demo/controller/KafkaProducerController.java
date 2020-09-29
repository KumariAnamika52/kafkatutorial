package com.howtodoinjava.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.howtodoinjava.kafka.demo.service.KafKaProducerService;
 
@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController 
{
    private final KafKaProducerService producerService;
 
    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) 
    {
        this.producerService = producerService;
    }
 
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) 
    {	
    	System.out.println(message+" POST METHOD");
        this.producerService.sendMessage(message);
    }
    
    @GetMapping(value = "/publish")
    public void getMessageToKafkaTopic(String message) 
    {
    	System.out.println(message+" GET METHOD");
        this.producerService.sendMessage(message);
    }
}