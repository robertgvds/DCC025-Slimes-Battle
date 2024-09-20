package com.exercicio3.slime_types;

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
