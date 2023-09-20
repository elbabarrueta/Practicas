package cochep0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaJuegoP0 extends JFrame{

	private JPanel panelPrincipal;
	private JPanel panelBotones;
	private JButton bAcelera;
	private JButton bFrena;
	private JButton bGiraI;
	private JButton bGiraD;
	//private JLabelCocheP0 cocheLabel;
	private CocheJuegoP0 coche;
	
	public VentanaJuegoP0() {
		this.setTitle("Juego coche");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(Color.WHITE);
		this.add(panelPrincipal, BorderLayout.CENTER);
		
		panelBotones = new JPanel();
		bAcelera = new JButton("Acelera");
		bFrena = new JButton("Frena");
		bGiraI = new JButton("Gira Izq.");
		bGiraD = new JButton("Gira Der.");
		
		coche = new CocheJuegoP0();
		coche.setPosX(150);
		coche.setPosY(100);
		panelPrincipal.add(coche.getLabelCoche());
		
		bAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				System.out.println("Velocidad:" + coche.getMiVelocidad() + "pixel/segundo");	
			}
		});
		
		bFrena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
				System.out.println("Velocidad:" + coche.getMiVelocidad() + "pixel/segundo");
			}
		});
		
		bGiraI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
				System.out.println("Grados:" + coche.getMiDireccionActual());
			}
		});
		
		bGiraD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				System.out.println("Grados:" + coche.getMiDireccionActual());
			}
		});
		
		panelBotones.add(bAcelera);
		panelBotones.add(bFrena);
		panelBotones.add(bGiraI);
		panelBotones.add(bGiraD);
		this.add(panelBotones, BorderLayout.SOUTH);
		
		//cocheLabel = new JLabelCocheP0();
		//cocheLabel.setBounds(150, 100, 100, 100);
		//panelPrincipal.add(cocheLabel);
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				 while (true) {
		                coche.mueve(0.04);  // Mueve el coche cada 40 milisegundos
		                coche.setPosX(coche.getPosX());
		                coche.setPosY(coche.getPosY());
		                repaint();
		                try {
		                    Thread.sleep(40);
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		            }
				
			}
		});
        thread.start();
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		VentanaJuegoP0 vent = new VentanaJuegoP0();

		
		//this.setVisible(true);
		
		/*
		CocheP0 coche = new CocheP0();
		coche.setPosX(150);
		coche.setPosY(100);
		coche.setPiloto("Lucas");
		System.out.println(coche.toString());
		
		coche.acelera(10);
		coche.gira(40);
		coche.mueve(3);
		System.out.println(coche.toString());
		*/
	}

}
