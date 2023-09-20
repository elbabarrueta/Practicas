package cochep0;

public class CocheP0 {

	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	private String piloto; // Nombre de piloto
	//
	public CocheP0(double miVelocidad, double miDireccionActual, double posX, double posY, String piloto) {
		super();
		this.miVelocidad = miVelocidad;
		this.miDireccionActual = miDireccionActual;
		this.posX = posX;
		this.posY = posY;
		this.piloto = piloto;
	}
	public CocheP0() {
		super();
		this.miVelocidad = 0.0;
		this.miDireccionActual = 0.0;
		this.posX = 0.0;
		this.posY = 0.0;
		this.piloto = "Piloto";
	}
	//
	public final double getMiVelocidad() {
		return miVelocidad;
	}
	public final void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}
	public final double getMiDireccionActual() {
		return miDireccionActual;
	}
	public final void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}
	public final double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public final double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public final String getPiloto() {
		return piloto;
	}
	public final void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	//
	public String toString() {
		return "Coche [Piloto: " + piloto +
				", Posicion: (" + posX + ", " + posY +
				"), Velocidad; " + miVelocidad +
				"segundos, Direccion: " + miDireccionActual + " grados]";
	}
	
	// Tarea 4
	public void acelera(double aceleracion) {
		miVelocidad += aceleracion;
	}	
		
	public void gira(double giro) {
		miDireccionActual += giro;
		//direccion entre -180 y 180 grados
		if(miDireccionActual < -180) {
			miDireccionActual += 180;
		}else  if(miDireccionActual > 180) {
			miDireccionActual -= 180;
		}
	}
		
	public void mueve(double tiempoDeMovimiento) {
		double desplazX = miVelocidad * tiempoDeMovimiento *  Math.cos(Math.toRadians(miDireccionActual));
		double desplazY = miVelocidad * tiempoDeMovimiento * Math.sin(Math.toRadians(miDireccionActual));
		posX += desplazX;
		posY += desplazY;
	
	}
}
