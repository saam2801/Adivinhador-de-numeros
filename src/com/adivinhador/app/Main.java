package com.adivinhador.app;
import java.util.*;
//usei o gemini para resolver alguns problemas de modularização e resource leaks (resolvido com try-with-resources)

public class Main {

	public static void main(String[] args) {
        System.out.println("Boas vindas ao adivinhador de números! ");
        Main.boasVindas();
	}
    //"INÍCIO"
    public static void boasVindas(){
        boolean continuar = true;

        try(Scanner scan = new Scanner(System.in)) {

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
    //PERGUNTAS COMEÇAR E ENCERRAR
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
    //LÓGICA PRINCIPAL
	public static void logicaJogo(Scanner scan) {
		System.out.println("Por favor, digite o seu palpite!");
        int palpite = scan.nextInt();
        int gerado = (int)(Math.random() * 11);
        System.out.println("E o número gerado foi: " + gerado);
        if(gerado == palpite){
            System.out.println("Parabéns! você acertou!");
            boolean jogarDeNovo = Main.jogarDeNovo(scan);

            if(jogarDeNovo){
                Main.logicaJogo(scan);
            }else{
                System.out.println("Obrigado por jogar! \nEncerrando.");
                System.exit(0);
            }
        }else{
            System.out.println("Por pouco! mas não foi desta vez.");
            boolean jogarDeNovo = Main.jogarDeNovo(scan);

            if(jogarDeNovo){
                Main.logicaJogo(scan);
            }else{
                System.out.println("Obrigado por jogar! \nEncerrando.");
                System.exit(0);
            }
        }
	}
    //JOGAR DE NOVO
    public static boolean jogarDeNovo(Scanner scan){
        System.out.println("Deseja jogar de novo? (sim/nao)");
        String resposta = scan.next().trim().toLowerCase();

        return resposta.equals("sim");
    }
}
