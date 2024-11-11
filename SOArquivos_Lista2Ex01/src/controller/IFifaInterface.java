package controller;

import java.io.IOException;

import fatec.sp.gov.lib.listas.ListaGenerica;
import model.PilhaString;

public interface IFifaInterface {

	public PilhaString empilhaBrasileiros(String caminho, String nomeDoArquivo) throws IOException;
	public void desempilhaBonsBrasileiros(PilhaString jogadoresBR) throws Exception;
	public ListaGenerica<String> listaRevelacoes(String caminho, String nomeDoArquivo) throws Exception;
	public void buscaListaBonsJovens(ListaGenerica<String> revelacoes) throws Exception;
}
