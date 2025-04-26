
package tarea2builderfactory;


public class EnemigoPersonalizado extends Enemigo{

    private EnemigoPersonalizado(EnemigoBuilder builder){
        this.setNombreEnemigo(builder.getNombreEnemigo());
        this.setVida(builder.getVida());
        this.setDaño(builder.getDaño());
        this.setVelocidad(builder.getVelocidad());
        this.setTamaño(builder.getTamaño());
        this.setHabilidadEspecial(builder.getHabilidadEspecial());
    }
    
    //Método estatico para crear un EnemigoPersonalizado a partir de un EnemigoBuilder
    public static EnemigoPersonalizado crearDesdeEnemigoBuilder(EnemigoBuilder builder){
        return new EnemigoPersonalizado(builder);
    }
    
    //Muestra los datos del enemigo personalizado
    public void mostrarEnemigoPersonalizado(){
        System.out.println("===============================================================");
        System.out.println("Se ha generado un enemigo de tipo: " + (!"".equals(this.getNombreEnemigo()) ? this.getNombreEnemigo():"Sin nombre"));
        System.out.println("Vida: " + (this.getVida()!=0 ? this.getVida():"Sin vida"));
        System.out.println("Daño: " + (this.getDaño()!=0 ? this.getDaño():"Sin Daño"));
        System.out.println("Velocidad: " + (!"".equals(this.getVelocidad()) ? this.getVelocidad():"Sin velocidad"));
        System.out.println("Tamaño: " + (!"".equals(this.getTamaño()) ? this.getTamaño():"Sin Tamaño"));
        System.out.println("Habilidad Especial: " + (!"".equals(this.getHabilidadEspecial()) ? this.getHabilidadEspecial():"Sin Habilidad Especial"));
        System.out.println("===============================================================");
    }
}
