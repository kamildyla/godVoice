package com.godVoice.service;

import com.godVoice.exceptions.BusinessException;
import com.godVoice.service.ds.GodMessageDs;

/**
 * Service for producing a message contained shorten volume name, chapter number and verses.
 */
public interface MessageService {

    /**
     * Prepares randomized message.
     * @return message contained shorten volume name, chapter number and verses.
     * @throws BusinessException when inputs to methods does not match criteria.
     */
    GodMessageDs prepareGodMessage() throws BusinessException;

}
