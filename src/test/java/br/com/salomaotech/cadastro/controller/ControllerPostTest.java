package br.com.salomaotech.cadastro.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerPostTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostAdiciona() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/adicionar")).andExpect(status().is(302));

    }

    @Test
    public void testPostAtualiza() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/adicionar/1")).andExpect(status().is(302));

    }

    @Test
    public void testPostDeleta() throws Exception {

        /* testa o redirecionamento */
        this.mockMvc.perform(post("/deletar/1")).andExpect(status().is(302));

    }

}
