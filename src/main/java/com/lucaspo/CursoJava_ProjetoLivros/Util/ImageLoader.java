package com.lucaspo.CursoJava_ProjetoLivros.Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage carregarImagem(byte[] byteImagem) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(byteImagem);
		try {
			return ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static BufferedImage carregarImagemPasta(String caminhoImagem) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(caminhoImagem));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
