/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2builderfactory;

/**
 *
 * @author simon
 */
public class EnemigoFactory {
    public static Enemigo crearEnemigo(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "goomba" -> new Goomba();
            case "koopa" -> new KoopaTroopa();
            case "piranha" -> new PiranhaPlant();
            case "boo" -> new Boo();
            case "cheepcheep" -> new CheepCheep();
            case "shyguy" -> new ShyGuy();
            case "lakitu" -> new Lakitu();
            default -> throw new IllegalArgumentException("Tipo de enemigo no reconocido.");
        };
    }
}
