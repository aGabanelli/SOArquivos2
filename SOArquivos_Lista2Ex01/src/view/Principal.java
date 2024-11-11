package view;

import java.io.IOException;

import controller.FifaController;
import controller.IFifaInterface;
import fatec.sp.gov.lib.listas.ListaGenerica;
import model.PilhaString;

public class Principal {

	public static void main(String[] args) throws Exception {

		IFifaInterface controller = new FifaController();

		String caminho = "C:\\TEMP\\";
		String nomeDoArquivo = "data.csv";
		PilhaString jogadoresBR = new PilhaString();
		ListaGenerica<String> revelacoes = new ListaGenerica<String>();

		try {
			jogadoresBR = controller.empilhaBrasileiros(caminho, nomeDoArquivo);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			revelacoes = controller.listaRevelacoes(caminho, nomeDoArquivo);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			System.out.println("\n\n\n===========================================================");
			System.out.println("Jogadores Brasileiros");
			controller.desempilhaBonsBrasileiros(jogadoresBR);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			System.out.println("\n\n\n===========================================================");
			System.out.println("Jogadores Jovens");
			controller.buscaListaBonsJovens(revelacoes);
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

	}

}
