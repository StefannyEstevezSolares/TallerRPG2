package com.mycompany.tallerrpg2;

public class Guerrero extends Personaje implements Curable {

    private double escudo;

    public Guerrero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double escudo) {

        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.escudo = escudo;
    }

    public Guerrero() {

        this("Guerrero Novato", 120.0, 15.0, 8.0, 20.0);

    }
    
    //hacemos Override ya que estas están declaradas como clases abstractas, entonces debemos utilizarlas pero nosotros debemos indicar cómo.

    @Override
    public void atacar(Personaje objetivo) {

        double dano = calcularDanoBase(objetivo);
        System.out.println(this.nombre + " ataca a: " + objetivo.getNombre() + " y causa " + dano + " de danio");
        objetivo.recibirDano(dano);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {

        System.out.println(this.nombre + " usa Golpe Furioso");

        double dano = (this.puntosAtaque * 1.5) - objetivo.puntosDefensa;

        if (dano < 3.0) {
            dano = 3.0;
        }

        objetivo.recibirDano(dano);

        this.puntosVida -= 10.0;

        if (this.puntosVida < 1.0) {
            this.puntosVida = 1.0;
        }

        System.out.println(this.nombre + " se hiere a si mismo. Vida restante: " + this.puntosVida);
    }

    @Override
    public void recibirDano(double cantidad) {

        if (this.escudo >= cantidad) {

            this.escudo -= cantidad;

            System.out.println("El escudo de " + this.nombre + " absorbio todo el danio. Escudo actual: " + this.escudo);

        } else {

            double danoRestante = cantidad - this.escudo;

            System.out.println("El escudo de " + this.nombre + " absorbio " + this.escudo + " de danio");

            this.escudo = 0.0;

            super.recibirDano(danoRestante);
        }
    }

    @Override
    public void curar() {

        double vidaAntes = this.puntosVida;

        this.puntosVida += CURACION_BASE;

        if (this.puntosVida > this.puntosVidaMax) {
            this.puntosVida = this.puntosVidaMax;
        }

        double recuperado = this.puntosVida - vidaAntes;

        System.out.println(this.nombre + " recupero " + recuperado + " puntos de vida");
    }

    @Override
    public void subirNivel() {

        super.subirNivel();

        this.escudo += 10.0;
    }

    @Override
    public void mostrarEstado() {

        super.mostrarEstado();

        System.out.println("Escudo: " + this.escudo);
    }

    @Override
    public String getTipo() {

        return "Guerrero";
    }
}