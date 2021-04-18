package org.jesperancinha.std.flash11.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(Flash11Controller.class)
class Flash11ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMainPage_whenMakingCall_thenGotoIndex() throws Exception {
        final var music = new Music();
        music.setArtist("Tracy Chapman");
        music.setSong("Talkin' About A Revolution");

        mockMvc.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("music", music));
    }

    @Test
    void testHandleRequest_whenMusicReceived_thenWriteCorrectPage() throws Exception {
        final var music = new Music();
        music.setArtist("Tracy Chapman");
        music.setSong("Talkin' About A Revolution");
        mockMvc.perform(
                post("/req")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(EntityUtils.toString(new UrlEncodedFormEntity(Arrays.asList(
                                new BasicNameValuePair("artist", music.getArtist()),
                                new BasicNameValuePair("song",  music.getSong())
                        )))))
                .andExpect(status().isOk())
                .andExpect(content().string("You did it!\n" +
                        "\n" +
                        "<p style=\"margin:0; font-family: monospace; color:#00aa00\"><b>{music=Music{artist='Tracy Chapman', song='Talkin' About A Revolution'}, org.springframework.validation.BindingResult.music=org.springframework.validation.BeanPropertyBindingResult: 0 errors}</b></p><p style=\"margin:0; font-family: monospace; color:#00aa00\"><b>Music{artist='Tracy Chapman', song='Talkin' About A Revolution'}</b></p><a href=\"/\">Back</a>"));
    }
}