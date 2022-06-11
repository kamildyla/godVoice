package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ds.GodMessage;

public interface MainAppService {

    GodMessage prepareGodMessage() throws EntityNotExistException;
}
