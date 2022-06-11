package com.godVoice.service.impl;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VolumeServiceImplTest {

    @Autowired
    VolumeService volumeService;

    @Test
    public void shouldReturnRandomVolume() throws EntityNotExistException {
        VolumeDTO volumeDTO = volumeService.chooseVolume();
        System.out.println("Hello");
    }

}