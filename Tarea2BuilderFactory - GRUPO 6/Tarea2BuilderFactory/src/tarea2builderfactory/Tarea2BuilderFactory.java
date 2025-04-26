
package tarea2builderfactory;

import java.util.Scanner;

/*
INTEGRANTES GRUPO 6
    - CALLE PINEDO, DIEGO ANDRÉS
    - PEÑA REYNA, RENATO PAOLO
    - VALDIVIA VERANO, SANTIAGO
    - HARTH ALVARIÑO, SIMON
*/

public class Tarea2BuilderFactory {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        //Menú que permite al usuario crear enemigos básicos y personalizados
        while (!salir) {
            System.out.println("---- Generador de Enemigos para Mario Bros ----");
            System.out.println("1. Crear enemigo basico (Factory)");
            System.out.println("2. Crear enemigo personalizado (Builder)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el tipo de enemigo (Goomba, Koopa, Piranha, Boo, ShyGuy, CheepCheep, Lakitu ):");
                    String tipo = scanner.nextLine();

                    try {
                        Enemigo enemigo = EnemigoFactory.crearEnemigo(tipo);
                        enemigo.mostrarEnemigo();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Para omitir Strings, oprima Enter. Para omitir enteros, ingrese 0");
                    System.out.println("Creando enemigo personalizado...");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Vida: ");
                    int vida = scanner.nextInt();

                    
                    System.out.print("Daño: ");
                    int daño = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Velocidad (Lenta, Media, Rápida): ");
                    String velocidad = scanner.nextLine();

                    System.out.print("Tamaño (Pequeño, Normal, Grande): ");
                    String tamaño = scanner.nextLine();

                    System.out.print("Habilidad Especial: ");
                    String habilidad = scanner.nextLine();

                    EnemigoPersonalizado enemigoPersonalizado = new EnemigoBuilder()
                            .setNombreEnemigo(nombre)
                            .setVida(vida)
                            .setDaño(daño)
                            .setVelocidad(velocidad)
                            .setTamaño(tamaño)
                            .setHabilidadEspecial(habilidad)
                            .build();
                    
                    enemigoPersonalizado.mostrarEnemigoPersonalizado();
                }

                case 3 -> {
                    salir = true;
                    System.out.println("Fin del programa");
                }

                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
    
