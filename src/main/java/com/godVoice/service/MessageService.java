package com.godVoice.service;

import com.godVoice.exceptions.BusinessException;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ds.GodMessageDs;

public interface MessageService {

    GodMessageDs prepareGodMessage() throws BusinessException;

    String messageToString(GodMessageDs message) throws EntityNotExistException;
}
