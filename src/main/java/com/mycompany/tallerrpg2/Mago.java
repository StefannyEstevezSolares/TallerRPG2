package com.mycompany.tallerrpg2;

public class Mago extends Personaje implements Curable {

    private double mana;
    private double manaMax;

    public Mago(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double mana) {

        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.mana = mana;
        this.manaMax = mana;
    }

    public Mago() {

        this("Mago Aprendiz", 80.0, 20.0, 2.0, 100.0);

    }

    @Override
    public void atacar(Personaje objetivo) {

        if (this.mana < 5.0) {

            System.out.println(this.nombre + " no tiene suficiente mana");
            objetivo.recibirDano(3.0);
            return;
        }

        this.mana -= 5.0;

        double dano = this.puntosAtaque - (objetivo.puntosDefensa / 2.0);

        if (dano < 3.0) {
            dano = 3.0;
        }

        System.out.println(this.nombre + " lanza Rayo Arcano contra " + objetivo.getNombre() + " y causa " + dano + " de danio");

        objetivo.recibirDano(dano);
    }

    //hacemos Override ya que estas están declaradas como clases abstractas, entonces debemos utilizarlas pero nosotros debemos indicar cómo.
    
    @Override
    public void habilidadEspecial(Personaje objetivo) {

        if (this.mana < 30.0) {

            System.out.println(this.nombre + " no tiene suficiente mana para usar Bola de Fuego");
            atacar(objetivo);
            return;
        }

        this.mana -= 30.0;

        double dano = this.puntosAtaque * 2.0;

        System.out.println(this.nombre + " lanza una Bola de Fuego contra " + objetivo.getNombre() + " y causa " + dano + " de danio");

        objetivo.recibirDano(dano);
    }

    @Override
    public void curar() {

        if (this.mana < 20.0) {

            System.out.println(this.nombre + " no tiene suficiente mana para curarse");
            return;
        }

        this.mana -= 20.0;

        double vidaAntes = this.puntosVida;

        this.puntosVida += CURACION_BASE + 5.0;

        if (this.puntosVida > this.puntosVidaMax) {
            this.puntosVida = this.puntosVidaMax;
        }

        double recuperado = this.puntosVida - vidaAntes;

        System.out.println(this.nombre + " recupero " + recuperado + " puntos de vida");
    }

    @Override
    public void subirNivel() {

        super.subirNivel();

        this.manaMax += 20.0;
        this.mana = this.manaMax;
    }

    @Override
    public void mostrarEstado() {

        super.mostrarEstado();

        System.out.println("Mana: " + this.mana + " / " + this.manaMax);
    }

    @Override
    public String getTipo() {

        return "Mago";
    }
}