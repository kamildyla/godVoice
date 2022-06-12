package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ds.GodMessage;

public interface MessageService {

    GodMessage prepareGodMessage() throws EntityNotExistException;

    String messageToString(GodMessage message) throws EntityNotExistException;
}
