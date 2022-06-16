package com.godVoice.rest.controller;

import com.godVoice.exceptions.BusinessException;
import com.godVoice.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GodVoiceController {

    private final MessageService messageService;

    public GodVoiceController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public String showGodMessage() throws BusinessException {
        return messageService.messageToString(messageService.prepareGodMessage());
    }
}
