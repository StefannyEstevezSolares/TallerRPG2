package com.mycompany.tallerrpg2;

public class Arquero extends Personaje {

    private int precision;

    public Arquero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, int precision) {

        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.precision = precision;
    }

    public Arquero() {

        this("Arquero Novato", 90.0, 18.0, 4.0, 40);

    }

    //hacemos Override ya que estas están declaradas como clases abstractas, entonces debemos utilizarlas pero nosotros debemos indicar cómo.

    
    @Override
    public void atacar(Personaje objetivo) {

        double probabilidad = Math.random() * 100;

        if (probabilidad < this.precision) {

            Batalla.ejecutarAtaqueCritico(this, objetivo, 1.5);

        } else {

            double dano = calcularDanoBase(objetivo);

            System.out.println(this.nombre + " dispara a " + objetivo.getNombre() + " y causa " + dano + " de danio");

            objetivo.recibirDano(dano);
        }
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {

        System.out.println(this.nombre + " usa Lluvia de Flechas");

        for (int i = 1; i <= 3; i++) {

            double dano = (this.puntosAtaque * 0.6) - objetivo.puntosDefensa;

            if (dano < 3.0) {
                dano = 3.0;
            }

            System.out.println("Impacto " + i + ": causa " + dano + " de danio a " + objetivo.getNombre());

            objetivo.recibirDano(dano);

            if (!objetivo.estaVivo()) {
                break;
            }
        }
    }

    @Override
    public void subirNivel() {

        super.subirNivel();

        this.precision += 3;

        if (this.precision > 95) {
            this.precision = 95;
        }
    }

    @Override
    public void mostrarEstado() {

        super.mostrarEstado();

        System.out.println("Precision: " + this.precision);
    }

    @Override
    public String getTipo() {

        return "Arquero";
    }
}