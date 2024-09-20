package com.exercicio3.slime_types;

/*
* Autor: Robert Gonçalves Vieira de Souza
* Matricula: 202365505B
* 
* Esta representa um tipo de Slime com uma habilidade especial do seu ancestral.
* Esta classe estende a classe Slime e sobrescreve os métodos especial e getEspecial.
*/

public class Sereia extends Slime {
    public Sereia() {
        super();
    }

    @Override
    public void especial(Slime adversario) {

        if(this.getEnergia() >= 6) {
            this.setEnergia(2);
            adversario.setEnergia(0);
            this.setEnergia(getEnergia() - 4);
        } else {
            System.out.println("\nVocê não tem energia suficiente!"); // error
        }
    }

    @Override
    public String getEspecial() {
        return "Se tiver 6 ou mais de energia, fica com 2 de energia para zerar a energia do adversário.";
    }
}
