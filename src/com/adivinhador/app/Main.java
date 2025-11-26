package com.adivinhador.app;
import java.util.*;
//usei o gemini para resolver alguns problemas de modularização e resource leaks

public class Main {

	public static void main(String[] args) {
		boolean continuar = true;
		
		try(Scanner scan = new Scanner(System.in)) {
			//fazer uma condicional depois, para fazer com que
			//o jogo possa continuar sem ter que reiniciar o sistema
			//tirar esse boas vindas da classe main talvez
			System.out.println("Boas vindas ao adivinhador de números!");
			while(continuar) {
				boolean comecarJogo = Main.comecar(scan);
				if(comecarJogo) {
					Main.logicaJogo(scan);
				}else {
					continuar = !Main.encerrar(scan);
				}
			}
			System.out.println("Obrigado por jogar, encerrando sistema.");
			System.exit(0);
		}catch(InputMismatchException e) {
			System.out.println("ERRO" + e.getMessage());
		}
	}
	public static boolean comecar(Scanner scan) {
		System.out.println("Deseja comecar? (sim/nao)");
		String resposta = scan.next().trim().toLowerCase();
		
		return resposta.equals("sim");
	}
	public static boolean encerrar(Scanner scan) {
		System.out.println("Deseja encerrar o jogo? (sim/nao)");
		String resposta = scan.next().trim().toLowerCase();
		
		return resposta.equals("sim");
	}	
	public static void logicaJogo(Scanner scan) {
		
	}
}
