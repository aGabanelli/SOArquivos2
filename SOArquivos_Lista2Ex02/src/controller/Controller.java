package controller;

import java.io.File;
import java.util.Arrays;

import model.PilhaString;

public class Controller {

	public void tamanhoDosArquivos(String caminhoDiretorio) {
		File diretorio = new File(caminhoDiretorio);

		if (!diretorio.exists()) {
			System.out.println("O diretório não existe.");
			return;
		}

		if (!diretorio.isDirectory()) {
			System.out.println("O caminho não é um diretório.");
			return;
		}

		File[] arquivos = diretorio.listFiles(File::isFile);

		if (arquivos == null || arquivos.length == 0) {
			System.out.println("O diretório não contém arquivos.");
			return;
		}

		int n = arquivos.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arquivos[j].length() > arquivos[j + 1].length()) {
					File temp = arquivos[j];
					arquivos[j] = arquivos[j + 1];
					arquivos[j + 1] = temp;
				}
			}
		}

		System.out.println("Arquivos no diretório " + caminhoDiretorio + " ordenados por tamanho (MB):");
		for (File arquivo : arquivos) {
			double tamanhoMB = (double) arquivo.length() / (1024 * 1024); // Converter bytes para MB
			System.out.printf("%s - %.2f MB%n", arquivo.getName(), tamanhoMB);
		}
	}

}
