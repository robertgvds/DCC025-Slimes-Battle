package com.exercicio3.slime_types;

/*
* Autor: Robert Gonçalves Vieira de Souza
* Matricula: 202365505B
* 
* Esta representa um tipo de Slime com uma habilidade especial do seu ancestral.
* Esta classe estende a classe Slime e sobrescreve os métodos especial e getEspecial.
*/

public class Anjo extends Slime {
    public Anjo() {
        super();
    }

    @Override
    public void especial(Slime adversario) {

        if(this.getEnergia() >= 2) {
            this.setResistencia(this.getResistencia() + 0.2);
            this.setEnergia(getEnergia() - 4);
        } else {
            System.out.println("\nVocê não tem energia suficiente!"); // error
        }
    }
    
    @Override
    public String getEspecial() {
        return "Ganha 20% de resistência pelo resto do jogo.";
    }
}
