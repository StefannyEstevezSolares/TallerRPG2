package com.mycompany.tallerrpg2;

public class Batalla {

    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador) {

        double dano = atacante.puntosAtaque * multiplicador;
        int danoCritico = (int) dano;

        objetivo.recibirDano(danoCritico);

        System.out.println("Golpe Critico");
        System.out.println(atacante.getNombre() + " causa " + danoCritico + " de danio a " + objetivo.getNombre());
    }

    public static void intentarCurar(Personaje p) {

        if (p instanceof Curable) {

            Curable curable = (Curable) p;
            curable.curar();

        } else {

            System.out.println(p.getTipo() + " no puede curarse");
        }
    }

    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2) {

        int turno = 1;

        System.out.println("\n--- BATALLA AUTOMATICA ---");

        while (p1.estaVivo() && p2.estaVivo()) {

            System.out.println("Turno " + turno);

            if (turno % 3 == 0) {

                p1.habilidadEspecial(p2);

            } else {

                p1.atacar(p2);
            }

            if (!p2.estaVivo()) {
                break;
            }

            if (turno % 3 == 0) {

                p2.habilidadEspecial(p1);

            } else {

                p2.atacar(p1);
            }

            turno++;
        }

        if (p1.estaVivo()) {

            System.out.println("El ganador es: " + p1.getNombre() + " (" + p1.getTipo() + ")");

        } else {

            System.out.println("El ganador es: " + p2.getNombre() + " (" + p2.getTipo() + ")");
        }
    }
}