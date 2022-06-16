package com.godVoice.service;

import com.godVoice.exceptions.BusinessException;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ds.GodMessage;

public interface MessageService {

    GodMessage prepareGodMessage() throws BusinessException;

    String messageToString(GodMessage message) throws EntityNotExistException;
}
