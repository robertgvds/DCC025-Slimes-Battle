package com.exercicio3.slime_types;

public class Dragao extends Slime {
    public Dragao() {
        super();
    }

    @Override
    public void especial(Slime adversario) {
        if(this.getEnergia() >= 2) {
            this.setMultiplicador(this.getMultiplicador() + 0.2);
            this.setInvulneravel(true);
            this.setEnergia(getEnergia() - 4);
        } else {
            System.out.println("\nVocê não tem energia suficiente!");
        }
    }

    @Override
    public String getEspecial() {
        return "Ganha 20% de dano e invulnerabilidade por um turno.";
    }
}
