package com.example.entregaprojeto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entregaprojeto.service.figurinhaservice;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EntregaprojetoTests {

    @Autowired
    private figurinhaservice stickerService;

    @Test
    void testGerarStickers() {
        String imageUrl = "https://www.landrin.com.br/upload/pragas_5_66_1538744895.jpg";

        try {
            stickerService.gerarStickers(imageUrl);
            // Verificar se o arquivo de saída foi gerado
            File outputFile = new File("saida/figurinha.png");
            assertTrue(outputFile.exists());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Falha ao gerar figurinhas: " + e.getMessage());
        }
    }
}
