package controller;
import java.io.*;

import fatec.sp.gov.lib.listas.ListaGenerica;
import model.PilhaString;

public class FifaController implements IFifaInterface{

	public PilhaString empilhaBrasileiros(String caminho, String nomeDoArquivo) throws IOException {
		PilhaString jogadoresBR = new PilhaString();
		File arq = new File(caminho, nomeDoArquivo);
		if (arq.exists()) {
			try {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				while (linha != null) {
					if (linha.contains("Brazil")) {
						jogadoresBR.Push(linha);
					}
					linha = br.readLine();
				}
				fis.close();
				isr.close();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return jogadoresBR;
	}

	public void desempilhaBonsBrasileiros(PilhaString jogadoresBR) throws Exception {
		while (!jogadoresBR.isEmpty()) {
			String jogador = jogadoresBR.Pop();
			String dadosJogador[] = jogador.split(",");
			System.out.println("Nome: " + dadosJogador[2] + "\t|\tOverall: " + dadosJogador[7]);
		}
	}

	public ListaGenerica<String> listaRevelacoes(String caminho, String nomeDoArquivo) throws Exception {
		ListaGenerica<String> revelacoes = new ListaGenerica<String>();
		File arq = new File(caminho, nomeDoArquivo);
		if (arq.exists()) {
			try {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				linha = br.readLine();
				while (linha != null) {
					String[] linhaDados = linha.split(",");
					int idadeJogador = (int)Integer.parseInt(linhaDados[3]);
					if (idadeJogador <= 20) {
						if(revelacoes.isEmpty()) {
							revelacoes.addFirst(linha);
						}else {
							revelacoes.addLast(linha);							
						}
					}
					linha = br.readLine();
				}
				fis.close();
				isr.close();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return revelacoes;
	}

	public void buscaListaBonsJovens(ListaGenerica<String> revelacoes) throws Exception {
		while(!revelacoes.isEmpty()) {
			int tamanho = revelacoes.size() - 1;
			String jogador = revelacoes.get(tamanho);
			String dadosJogador[] = jogador.split(",");
			System.out.println(
					"Nome: " + dadosJogador[2] + "\t|\tIdade: " + dadosJogador[3] + "\t|\tOverall: " + dadosJogador[7]);
			revelacoes.removeLast();
		}
	}

}
