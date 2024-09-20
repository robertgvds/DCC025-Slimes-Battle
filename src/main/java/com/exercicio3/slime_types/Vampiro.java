package com.exercicio3.slime_types;

public class Vampiro extends Slime {
    public Vampiro() {
        super();
    }

    @Override
    public void especial(Slime adversario) {
        if(this.getEnergia() >= 2) {
            adversario.setVida(adversario.getVida() - 2);
            this.setVida(this.getVida() + 1);
            this.setEnergia(getEnergia() - 4);
        } else {
            System.out.println("\nVocê não tem energia suficiente!");
        }
    }

    @Override
    public String getEspecial() {
        return "Dado de 2 de vida no adversário e ganha 1 de vida.";
    }
}
