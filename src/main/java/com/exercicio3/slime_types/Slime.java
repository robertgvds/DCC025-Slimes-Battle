package com.exercicio3.slime_types;

/*
* Autor: Robert Gonçalves Vieira de Souza
* Matricula: 202365505B
* 
* A classe Slime representa uma classe abstrata para diferentes tipos de slimes.
* Ela contém atributos e métodos comuns a todos os slimes, como vida, energia,
* resistência, multiplicador de dano e mecanismos de ataque.
*/

public abstract class Slime {
    private double vida; // vida do slime
    private double multiplicador; // multiplicador de dano para ataques
    private double resistencia; // resistência do slime, reduzindo o dano recebido
    private int energia; // nível de energia do slime, usado para executar ações nos turnos

    private boolean usouEnergizar; // indicador de se o slime usou a habilidade energizar
    private boolean invulneravel; // indicador de se o slime está invulnerável a ataques

    public Slime() {
        // Inicializa os atributos do slime com valores padrão.
        
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
        // Ataca o slime adversário, reduzindo sua vida com base nos atributos do atacante.

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
        // Usa a habilidade energizar, aumentando o poder do próximo ataque e reduzindo a energia.

        this.usouEnergizar = true;
        this.energia -= 2;
    }

    public abstract void especial(Slime adversario); // Ataque especial do slime

    public abstract String getEspecial(); // Descrição do ataque especial do slime
}
