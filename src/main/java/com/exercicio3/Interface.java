package com.exercicio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.exercicio3.slime_types.*;

public class Interface {
    
    private static Map<Character, Slime> slimes = new HashMap<>();
    private static Scanner teclado = new Scanner(System.in);
    
    public static void start() {

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
        slimes.put('A', getAncestral());

        System.out.println("\nEscolha o ancestral do slime B:");
        slimes.put('B', getAncestral());

        System.out.println( "-----------------------------------\r\n" +
                            "INICIADO O JOGO\r\n" +
                            "-----------------------------------");

        startPartida();
    }

    private static int getInput() {
        try {
            int input = Integer.parseInt(teclado.next());
            return input;
        } catch (Exception e) {
            System.out.println("\nEntrada inválida, escolha um número válido.\n");
            return getInput();
        }
    }

    private static String arredondar(double valor) {
        return String.format(java.util.Locale.US, "%.2f", valor);
    }

    private static Slime getAncestral() {
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

    private static void startPartida() {
        char slimeAtual = 'A';
        char slimeAdversario = 'B';

        while (!ehFimDoJogo()) {
            System.out.println( "-----------------------------------\r\n" +
                                "TURNO DO SLIME " + slimeAtual + " \r\n" +
                                "-----------------------------------");

            do {
                System.out.println("\nVida atual dos slimes: A: " + arredondar(slimes.get('A').getVida()) + " B: " + arredondar(slimes.get('B').getVida()));
                System.out.println("Digite a habilidade para o slime " + slimeAtual + " usar: (energia restante: " + slimes.get(slimeAtual).getEnergia() + ")");
                System.out.println("0: Terminar o turno");
                System.out.println("1: Ataque");
                System.out.println("2: Energizar");
                System.out.println("3: Especial: " + slimes.get(slimeAtual).getEspecial() + "\n");

            } while (jogada(slimeAtual, slimeAdversario) && slimes.get(slimeAtual).getEnergia() > 0 && !ehFimDoJogo());

            slimes.get(slimeAtual).setEnergia(slimes.get(slimeAtual).getEnergia() + 2);

            for(Slime slime : slimes.values()) {
                slime.setUsouEnergizar(false);
            }

            slimes.get(slimeAdversario).setInvulneravel(false);

            slimeAtual = (slimeAtual == 'A') ? 'B' : 'A';
            slimeAdversario = (slimeAdversario) == 'A' ? 'B' : 'A';
        }

        finalDoJogo();
    }

    private static boolean jogada(char slimeAtual, char slimeAdversario) {
        switch (getInput()) {
            case 0:
                return false;
            case 1:
                slimes.get(slimeAtual).atacar(slimes.get(slimeAdversario));
                break;
            case 2:
                slimes.get(slimeAtual).energizar();
                break;
            case 3:
                slimes.get(slimeAtual).especial(slimes.get(slimeAdversario));
                break;
            default:
                System.out.println("\nEscolha inválida, escolha uma opção válida.\n");
                return jogada(slimeAtual, slimeAdversario);
        }
        return true;
    }

    private static boolean ehFimDoJogo() {
        return (slimes.get('A').getVida() <= 0 || slimes.get('A').getVida() <= 0);
    }

    private static void finalDoJogo() {
        if (slimes.get('A').getVida() <= 0 && slimes.get('B').getVida() <= 0) {
            System.out.println( "-----------------------------------\r\n" + //
                                "Empate\r\n" + //
                                "-----------------------------------");
        } else if (slimes.get('A').getVida() <= 0) {
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
