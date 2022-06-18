package com.godVoice.rest.controller;

import com.godVoice.constants.UrlPathNames;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.service.MessageService;
import com.godVoice.service.ds.GodMessageDs;
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
    @GetMapping(UrlPathNames.HOME_PAGE)
    public GodMessageDs showGodMessage() throws BusinessException {
        return messageService.prepareGodMessage();
    }

}
