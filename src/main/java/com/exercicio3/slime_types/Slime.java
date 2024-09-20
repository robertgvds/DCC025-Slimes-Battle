package com.exercicio3.slime_types;

public abstract class Slime {
    private double vida;
    private double multiplicador;
    private double resistencia;
    private int energia;

    private boolean usouEnergizar;
    private boolean invulneravel;

    public Slime() {
        this.vida = 10;
        this.multiplicador = 1;
        this.resistencia = 0;
        this.energia = 5;
        this.usouEnergizar = false;
        this.invulneravel = false;
    }

    public double getVida() {
        return this.vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getMultiplicador() {
        return this.multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(double d) {
        this.resistencia = d;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean usouEnergizar() {
        return this.usouEnergizar;
    }

    public void setUsouEnergizar(boolean usouEnergizar) {
        this.usouEnergizar = usouEnergizar;
    }

    public boolean ehInvulneravel() {
        return this.invulneravel;
    }

    public void setInvulneravel(boolean invulneravel) {
        this.invulneravel = invulneravel;
    }

    public void atacar(Slime adversario) {
        if (adversario.ehInvulneravel()) {
            System.out.println("\nO adversário está invulnerável, não é possível atacar.\n");
            return;
        }

        this.energia -= 1;
        
        double energiaNoAtaque = this.usouEnergizar ? 0.5 : 0;
        double dano = this.multiplicador - adversario.getResistencia() + energiaNoAtaque;

        adversario.setVida(adversario.getVida() - dano);
    }

    public void energizar() {
        this.usouEnergizar = true;
        this.energia -= 2;
    }

    public abstract void especial(Slime adversario);

    public abstract String getEspecial();
}
