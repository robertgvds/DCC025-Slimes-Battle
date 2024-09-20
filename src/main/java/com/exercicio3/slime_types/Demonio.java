package com.exercicio3.slime_types;

public class Demonio extends Slime {
    public Demonio() {
        super();
    }

    @Override
    public void especial(Slime adversario) {
        if(this.getEnergia() >= 2) {
            this.setMultiplicador(this.getMultiplicador() + 0.2);
            this.setEnergia(getEnergia() - 4);
        } else {
            System.out.println("\nVocê não tem energia suficiente!");
        }
    }
    
    @Override
    public String getEspecial() {
        return "Ganha 20% de dano pelo resto do jogo.";
    }
}
