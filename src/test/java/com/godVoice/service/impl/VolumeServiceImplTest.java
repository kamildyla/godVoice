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
    private VolumeService volumeService;

    @Test
    public void shouldReturnRandomVolume() throws EntityNotExistException {
        VolumeDTO volumeDTO = volumeService.drawVolume();
        VolumeDTO volumeDTO1 = volumeService.drawVolume();
        VolumeDTO volumeDTO2 = volumeService.drawVolume();
        VolumeDTO volumeDTO3 = volumeService.drawVolume();
        System.out.println("Hello");
    }

}