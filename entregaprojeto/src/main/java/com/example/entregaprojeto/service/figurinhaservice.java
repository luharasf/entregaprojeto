package com.example.entregaprojeto.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

@Service
public class figurinhaservice {

    public void gerarFigurinha(String imageUrl, String titulo, String nomeArquivo) throws IOException {
        try {
            URL url = new URI(imageUrl).toURL();
            BufferedImage imagemOriginal = ImageIO.read(url);

            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();
            int novaAltura = altura + 100;

            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = novaImagem.createGraphics();

            graphics.drawImage(imagemOriginal, 0, 0, null);

            Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 35);
            graphics.setFont(fonte);
            graphics.setColor(Color.YELLOW);
            graphics.drawString(titulo, 50, novaAltura - 80);

            ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo + ".png"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new IOException("Erro ao criar a URL", e);
        }
    }

    public void gerarStickers(String imageUrl) {
    
    }
}
