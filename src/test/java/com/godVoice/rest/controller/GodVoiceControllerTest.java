package com.godVoice.rest.controller;

import com.godVoice.constants.UrlPathNames;
import com.godVoice.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)

class GodVoiceControllerTest {

    private MockMvc mockMvc;
    @Mock
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GodVoiceController(messageService))
                .build();
    }

    @Test
    public void shouldReturnOkForHomePage() throws Exception {
        this.mockMvc.perform(get(UrlPathNames.HOME_PAGE))
                .andDo(print())
                .andExpect(status().isOk());
        Mockito.verify(messageService).prepareGodMessage();
        Mockito.verifyNoMoreInteractions(messageService);
    }

}