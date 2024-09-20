package com.exercicio3;

import java.util.HashMap;
import java.util.Map;

import com.exercicio3.slime_types.Slime;

/*
* Autor: Robert Gonçalves Vieira de Souza
* Matricula: 202365505B
*
* A classe Partida representa uma partida do jogo de Slimes.
* Ela gerencia o estado dos slimes, alterna os turnos entre eles,
* e determina se é o fim do jogo.
*/

public class Partida {
    
    // Um mapa que associa um caractere ('A' ou 'B') a um objeto Slime.
    private Map<Character, Slime> slimes = new HashMap<>(); 

    Partida(Slime slimeA, Slime slimeB) {
        // Inicializa uma nova partida com dois slimes.

        this.slimes.put('A', slimeA);
        this.slimes.put('B', slimeB);
    }

    public Slime getSlime(char slime) {
        // Retorna o slime associado ao caractere fornecido.

        return this.slimes.get(slime);
    }
    
    public void startPartida() {
        // Inicia a partida, alterna os turnos entre os slimes e gerencia o fluxo do jogo.

        char slimeAtual = 'A';
        char slimeAdversario = 'B';

        while (!ehFimDoJogo()) {
            System.out.println( "-----------------------------------\r\n" +
                                "TURNO DO SLIME " + slimeAtual + " \r\n" +
                                "-----------------------------------");

            do {

            Interface.printJogada(slimeAtual, slimeAdversario);

            } while (jogada(slimeAtual, slimeAdversario) && this.getSlime(slimeAtual).getEnergia() > 0 && !ehFimDoJogo());

            this.getSlime(slimeAtual).setEnergia(this.getSlime(slimeAtual).getEnergia() + 2);

            for(Slime slime : this.slimes.values()) {
                slime.setUsouEnergizar(false);
            }

            this.getSlime(slimeAdversario).setInvulneravel(false);

            slimeAtual = (slimeAtual == 'A') ? 'B' : 'A';
            slimeAdversario = (slimeAdversario == 'B') ? 'A' : 'B';
        }

        Interface.finalDoJogo();
    }

    private boolean jogada(char slimeAtual, char slimeAdversario) {
        // Executa a jogada do slime atual com base na entrada do usuário.

        switch (Interface.getInput()) {
            case 0:
                return false;
            case 1:
                this.getSlime(slimeAtual).atacar(this.getSlime(slimeAdversario));
                break;
            case 2:
                this.getSlime(slimeAtual).energizar();
                break;
            case 3:
                this.getSlime(slimeAtual).especial(this.getSlime(slimeAdversario));
                break;
            default:
                System.out.println("\nEscolha inválida, escolha uma opção válida.\n");
                return jogada(slimeAtual, slimeAdversario);
        }
        return true;
    }

    private boolean ehFimDoJogo() {
        // Verifica se o jogo chegou ao fim com base na vida dos slimes.

        return (this.getSlime('A').getVida() <= 0 || this.getSlime('B').getVida() <= 0);
    }
}
