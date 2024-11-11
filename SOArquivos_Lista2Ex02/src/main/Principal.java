package main;

import java.util.Scanner;

import controller.Controller;

public class Principal {

	public static void main(String[] args) {
		
		Controller c = new Controller();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Diretório: ");
		String caminho = scanner.next();

		
		c.tamanhoDosArquivos(caminho);
		
	}
	
}
