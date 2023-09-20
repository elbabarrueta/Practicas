package cochep0;

public class CocheJuegoP0 extends CocheP0{

	private JLabelCocheP0 labelCoche;

	 public CocheJuegoP0() {
	   super(); // Llama al constructor de la clase Coche 

	   labelCoche = new JLabelCocheP0();
	   labelCoche.setBounds((int) posX, (int) posY, 100, 100);
	   //actualizarPosicionCoche();
	   }

	    // Redefirnir metodos
	    @Override
	    public void setPosX(double posX) {
	        super.setPosX(posX);
	        actualizarPosicionCoche();
	    }

	    @Override
	    public void setPosY(double posY) {
	        super.setPosY(posY);
	        actualizarPosicionCoche();
	    }

	    // Actualiza la posición del JLabelCoche en pantalla
	    private void actualizarPosicionCoche() {
	        int x = (int) Math.round(getPosX());
	        int y = (int) Math.round(getPosY());
	        labelCoche.setLocation(x, y);
	    }

	    // Obtén el JLabelCoche para agregarlo a la ventana
	    public JLabelCocheP0 getLabelCoche() {
	        return labelCoche;
	    }
}
