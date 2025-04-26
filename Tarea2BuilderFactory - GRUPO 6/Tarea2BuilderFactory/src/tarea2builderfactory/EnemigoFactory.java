
package tarea2builderfactory;


public class EnemigoFactory {
    public static Enemigo crearEnemigo(String tipo) {
        // Devuelve una instancia de un enemigo básico según el tipo especificado usando el patrón Factory
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
