package com.godVoice.rest.controller;

import com.godVoice.constants.UrlPathNames;
import com.godVoice.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
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
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(messageService).prepareGodMessage();
        Mockito.verifyNoMoreInteractions(messageService);
    }

}