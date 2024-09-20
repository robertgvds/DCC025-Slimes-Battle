package com.exercicio3;

import java.util.Scanner;

import com.exercicio3.slime_types.*;

/*
* Autor: Robert Gonçalves Vieira de Souza
* Matricula: 202365505B
* 
* A classe Interface representa a interface do usuário para o jogo de Slimes.
* Ela contém métodos para iniciar o jogo, obter entradas do usuário, imprimir
* o estado atual do jogo e determinar o resultado final do jogo.
*/

public class Interface {
    
    private static Partida partida; // A partida atual.
    private static Scanner teclado = new Scanner(System.in); // Scanner para obter entradas do usuário.
    
    public static void start() {
        // Inicia o jogo, exibe as regras e permite que os jogadores escolham os ancestrais dos seus slimes.
        
        System.out.println("Bem vindo ao jogo de Slimes!");
        
        System.out.println("\nRegras:");
        System.out.println("Cada slime tem 3 habilidades ativadas pelos seguintes comandos:");
        System.out.println("0: Terminar o turno");
        System.out.println("1: Ataque");
        System.out.println("2: Energizar");
        System.out.println("3: Especial");
        System.out.println(
            "Cada jogador pode escolher o ancestral do slime no comeco do jogo, que determina a habilidade especial do slime.");
            
            System.out.println("\nOs ancestrais disponíveis são:\n");
            System.out.println("1 - Vampiro");
            System.out.println("2 - Dragão");
            System.out.println("3 - Sereia");
            System.out.println("4 - Anjo");
            System.out.println("5 - Demônio");
            
            System.out.println("\nEscolha o ancestral do slime A:");
            Slime slimeA = getAncestral();
            
        System.out.println("\nEscolha o ancestral do slime B:");
        Slime slimeB = getAncestral();
        
        System.out.println( "-----------------------------------\r\n" +
        "INICIADO O JOGO\r\n" +
        "-----------------------------------");
        
        partida = new Partida(slimeA, slimeB);
        partida.startPartida();
    }
    
    private static String arredondar(double valor) {
        // Arredonda um valor double para duas casas decimais.
        
        return String.format(java.util.Locale.US, "%.2f", valor);
    }
    
    public static int getInput() {
        // Obtém a entrada do usuário e a converte para um inteiro.
        
        try {
            int input = Integer.parseInt(teclado.next());
            return input;
        } catch (Exception e) {
            System.out.println("\nEntrada inválida, escolha um número válido.\n");
            return getInput();
        }
    }

    private static Slime getAncestral() {
        // Obtém a escolha do ancestral do slime a partir da entrada do usuário.

        switch (getInput()) {
            case 1:
                return new Vampiro();
            case 2:
                return new Dragao();
            case 3:
                return new Sereia();
            case 4:
                return new Anjo();
            case 5:
                return new Demonio();
            default:
                System.out.println("\nAncestral inválido, escolha um ancestral válido.\n");
                
                return getAncestral();
        }
    }

    public static void printJogada(char slimeAtual, char slimeAdversario) {
        // Imprime o estado atual dos slimes e solicita ao jogador que escolha uma habilidade para o slime atual usar.

        System.out.println("\nVida atual dos slimes: A: " + arredondar(partida.getSlime('A').getVida()) + " B: " + arredondar(partida.getSlime('B').getVida()));
        System.out.println("Digite a habilidade para o slime " + slimeAtual + " usar: (energia restante: " + partida.getSlime(slimeAtual).getEnergia() + ")");
        System.out.println("0: Terminar o turno");
        System.out.println("1: Ataque");
        System.out.println("2: Energizar");
        System.out.println("3: Especial: " + partida.getSlime(slimeAtual).getEspecial() + "\n");
    }

    public static void finalDoJogo() {
        // Determina e imprime o resultado final do jogo com base na vida restante dos slimes.

        if (partida.getSlime('A').getVida() <= 0 && partida.getSlime('B').getVida() <= 0) {
            System.out.println( "-----------------------------------\r\n" + //
                                "Empate\r\n" + //
                                "-----------------------------------");
        } else if (partida.getSlime('A').getVida() <= 0) {
            System.out.println( "-----------------------------------\r\n" + //
                                "Slime B venceu\r\n" + //
                                "-----------------------------------");
        } else {
            System.out.println( "-----------------------------------\r\n" + //
                                "Slime A venceu\r\n" + //
                                "-----------------------------------");
        }
    }
}
