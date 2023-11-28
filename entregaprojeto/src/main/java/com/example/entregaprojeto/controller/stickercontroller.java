package com.example.entregaprojeto.controller;

import com.example.entregaprojeto.service.figurinhaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class stickercontroller {

    @Autowired
    private figurinhaservice figurinhaService;

    @PostMapping("/api/stickers/generate")
    public String generateStickers(@RequestParam String imageUrl) {
        try {
            figurinhaService.gerarStickers(imageUrl);
            return "Stickers gerados com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao gerar stickers.";
        }
    }
}
