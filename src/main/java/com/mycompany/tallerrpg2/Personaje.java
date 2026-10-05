//Creamos la clase abstracta de personajes, para que no se pueda crear New Personaje();
// ya que el personaje es un concepto de lo que queremos lograr.

package com.mycompany.tallerrpg2;


public abstract class Personaje implements Mejorable{
    
    
    protected String nombre;
    protected double puntosVida;
    protected double puntosVidaMax;
    protected double puntosAtaque;
    protected double puntosDefensa;
    protected int nivel;
    
    private static int totalPersonajesCreados = 0;
    
    public Personaje(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa){
        
        this.nombre = nombre;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosVida = puntosVidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = 1;
        
        totalPersonajesCreados++;
      
    }
    
    public void recibirDano(double cantidad){
    
    this.puntosVida -= cantidad;
    
    if (this.puntosVida < 0.0){
    this.puntosVida = 0.0;
    
    }
    
    }
    
    public boolean estaVivo(){
        
        return this.puntosVida > 0.0;
    }
    
    protected double calcularDanoBase(Personaje objetivo){
    
    double dano = this.puntosAtaque - objetivo.puntosDefensa;
    
    if(dano < 3.0){
    
        dano = 3.0;
    }
    
    return dano;
    
    }
    
    @Override
    public void subirNivel(){
    
        this.nivel++;
        this.puntosVidaMax += 20.0;
        this.puntosAtaque += 5.0;
        this.puntosDefensa += 2.0;
        this.puntosVida = this.puntosVidaMax;
        
        mostrarMensajeNivel(this.nivel);
        
    }
    
    public void mostrarEstado(){
    
        System.out.println("-------------------------------------");
        System.out.println("Tipo: " + getTipo());
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + puntosVida + "/" + puntosVidaMax);
        System.out.println("Ataque: " + puntosAtaque);
        System.out.println("Defensa: " + puntosDefensa);
        System.out.println("--------------------------------------");
        
    }
    
    public static int getTotalPersonajesCreados(){
    
    return totalPersonajesCreados;
    
    }
    
    public String getNombre(){
    
        return nombre;
    }
    
    public double getPuntosVdia(){
    
        return puntosVida;
        
    }
    
    //Se crearon los métodos abstractos para así forzarlos como requerimientos para otros personajes que se vayan creando
    //ya sea los magos, guerreros, o arqueros, y si en el futuro decidieran implementar más.
    
    public abstract void atacar(Personaje objetivo);
    
    public abstract void habilidadEspecial(Personaje objetivo);
    
    public abstract String getTipo();
}
