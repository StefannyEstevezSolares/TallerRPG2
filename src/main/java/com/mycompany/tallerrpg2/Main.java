package com.mycompany.tallerrpg2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Personaje p1 = null;
        Personaje p2 = null;

        int opcion;

        do {

            System.out.println("\nSIMULADOR DE COMBATE RPG");
            System.out.println("1. Crear Personaje 1");
            System.out.println("2. Crear Personaje 2");
            System.out.println("3. Ver ficha tecnica");
            System.out.println("4. Subir de nivel");
            System.out.println("5. Curar");
            System.out.println("6. Ataque basico");
            System.out.println("7. Habilidad especial");
            System.out.println("8. Batalla automatica");
            System.out.println("9. Total de personajes creados");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    p1 = crearPersonaje(scanner);
                    break;

                case 2:
                    p2 = crearPersonaje(scanner);
                    break;

                case 3:

                    if (p1 != null) {
                        p1.mostrarEstado();
                    } else {
                        System.out.println("Personaje 1 no ha sido creado");
                    }

                    if (p2 != null) {
                        p2.mostrarEstado();
                    } else {
                        System.out.println("Personaje 2 no ha sido creado");
                    }

                    break;

                case 4:

                    Personaje personajeNivel = seleccionarPersonaje(scanner, p1, p2);

                    if (personajeNivel != null) {
                        personajeNivel.subirNivel();
                    }

                    break;

                case 5:

                    Personaje personajeCurar = seleccionarPersonaje(scanner, p1, p2);

                    if (personajeCurar != null) {
                        Batalla.intentarCurar(personajeCurar);
                    }

                    break;

                case 6:

                    realizarAtaque(scanner, p1, p2, false);
                    break;

                case 7:

                    realizarAtaque(scanner, p1, p2, true);
                    break;

                case 8:

                    if (p1 == null || p2 == null) {

                        System.out.println("Debes crear ambos personajes");

                    } else if (!p1.estaVivo() || !p2.estaVivo()) {

                        System.out.println("Ambos personajes deben estar vivos");

                    } else {

                        Batalla.iniciarPeleaAutomatica(p1, p2);
                    }

                    break;

                case 9:

                    System.out.println("Total de personajes creados: "
                            + Personaje.getTotalPersonajesCreados());

                    break;

                case 10:

                    System.out.println("Fin del programa");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 10);

        scanner.close();
    }

    public static Personaje crearPersonaje(Scanner scanner) {

        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Seleccione el tipo: ");

        int tipo = scanner.nextInt();

        System.out.println("1. Constructor predeterminado");
        System.out.println("2. Constructor parametrizado");
        System.out.print("Seleccione una opcion: ");

        int constructor = scanner.nextInt();

        if (constructor == 1) {

            switch (tipo) {

                case 1:
                    return new Guerrero();

                case 2:
                    return new Mago();

                case 3:
                    return new Arquero();

                default:
                    System.out.println("Tipo invalido");
                    return null;
            }
        }

        if (constructor == 2) {

            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Vida maxima: ");
            double vidaMax = scanner.nextDouble();

            System.out.print("Ataque: ");
            double ataque = scanner.nextDouble();

            System.out.print("Defensa: ");
            double defensa = scanner.nextDouble();

            switch (tipo) {

                case 1:

                    System.out.print("Escudo: ");
                    double escudo = scanner.nextDouble();

                    return new Guerrero(nombre, vidaMax, ataque, defensa, escudo);

                case 2:

                    System.out.print("Mana: ");
                    double mana = scanner.nextDouble();

                    return new Mago(nombre, vidaMax, ataque, defensa, mana);

                case 3:

                    System.out.print("Precision: ");
                    int precision = scanner.nextInt();

                    return new Arquero(nombre, vidaMax, ataque, defensa, precision);

                default:

                    System.out.println("Tipo invalido");
                    return null;
            }
        }

        System.out.println("Opcion invalida");
        return null;
    }

    public static Personaje seleccionarPersonaje(Scanner scanner, Personaje p1, Personaje p2) {

        System.out.print("Seleccione personaje (1 o 2): ");

        int numero = scanner.nextInt();

        if (numero == 1) {

            if (p1 == null) {
                System.out.println("Personaje 1 no existe");
                return null;
            }

            return p1;
        }

        if (numero == 2) {

            if (p2 == null) {
                System.out.println("Personaje 2 no existe");
                return null;
            }

            return p2;
        }

        System.out.println("Personaje invalido");
        return null;
    }

    public static void realizarAtaque(Scanner scanner, Personaje p1, Personaje p2, boolean especial) {

        if (p1 == null || p2 == null) {

            System.out.println("Debes crear ambos personajes");
            return;
        }

        System.out.println("1. Personaje 1");
        System.out.println("2. Personaje 2");

        System.out.print("Seleccione atacante: ");
        int atacanteNumero = scanner.nextInt();

        System.out.print("Seleccione objetivo: ");
        int objetivoNumero = scanner.nextInt();

        Personaje atacante;
        Personaje objetivo;

        if (atacanteNumero == 1 && objetivoNumero == 2) {

            atacante = p1;
            objetivo = p2;

        } else if (atacanteNumero == 2 && objetivoNumero == 1) {

            atacante = p2;
            objetivo = p1;

        } else {

            System.out.println("Seleccion invalida");
            return;
        }

        if (!atacante.estaVivo()) {

            System.out.println(atacante.getNombre() + " esta derrotado");
            return;
        }

        if (!objetivo.estaVivo()) {

            System.out.println(objetivo.getNombre() + " esta derrotado");
            return;
        }

        if (especial) {

            atacante.habilidadEspecial(objetivo);

        } else {

            atacante.atacar(objetivo);
        }

        if (!objetivo.estaVivo()) {

            System.out.println(objetivo.getNombre() + " ha sido derrotado");
        }
    }
}