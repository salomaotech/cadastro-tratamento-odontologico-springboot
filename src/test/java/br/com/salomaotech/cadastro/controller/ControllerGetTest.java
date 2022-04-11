package br.com.salomaotech.cadastro.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerGetTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetErro404() throws Exception {

        /* testa se a model está funcionando */
        this.mockMvc.perform(get("/pagina_erro404")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testGetCadastra() throws Exception {

        /* testa se a model está funcionando */
        this.mockMvc.perform(get("/pagina_cadastro")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testGetAtualiza() throws Exception {

        /* testa se a model está funcionando */
        this.mockMvc.perform(get("/pagina_cadastro/1")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testGetDeleta() throws Exception {

        /* testa se a model está funcionando */
        this.mockMvc.perform(get("/pagina_deleta/1")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testGetResultados() throws Exception {

        /* testa se a model está funcionando */
        this.mockMvc.perform(get("/pagina_resultados")).andDo(print()).andExpect(status().isOk());

    }

}
