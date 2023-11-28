package com.example.entregaprojeto.controller;

import com.example.entregaprojeto.service.figurinhaservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class figurinhacontroller {

    private final figurinhaservice figurinhaService;

    public figurinhacontroller(figurinhaservice figurinhaService) {
        this.figurinhaService = figurinhaService;
    }

    @GetMapping("/")
    public String home() {
        return "formulario";
    }

    @PostMapping("/api/gerarFigurinha")
    public void gerarFigurinha(
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("titulo") String titulo,
            @RequestParam("nomeArquivo") String nomeArquivo) throws IOException {

        figurinhaService.gerarFigurinha(imageUrl, titulo, nomeArquivo);
    }
}
