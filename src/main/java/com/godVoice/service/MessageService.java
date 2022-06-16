package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.service.ds.GodMessage;

public interface MessageService {

    GodMessage prepareGodMessage() throws EntityNotExistException, VolumeNumberException;

    String messageToString(GodMessage message) throws EntityNotExistException;
}
