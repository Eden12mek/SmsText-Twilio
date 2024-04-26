package com.example.smstext.controller;

import com.example.smstext.model.SMSSendRequest;
import com.example.smstext.service.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SMSRestController {

    @Autowired
    SMSService smsService;


    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SMSSendRequest sendRequest) {
        log.info("processSMS started sendRequest: " + sendRequest.toString());
        return smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessage());
    }
}
