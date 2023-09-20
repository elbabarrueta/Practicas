package cochep0;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class JLabelCocheP0 extends JLabel{

	private BufferedImage ImagenCoche;

    public JLabelCocheP0() {
        try {
        	ImagenCoche = ImageIO.read(new File("coche.png"));

            // Escalar la imagen tamaño (100x100 píxeles)
            ImagenCoche = resizeImage(ImagenCoche, 100, 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escalar una imagen
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage tamaño = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D grap = tamaño.createGraphics();
        grap.drawImage(originalImage, 0, 0, width, height, null);
        grap.dispose();
        return tamaño;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Imagen del coche en el JLabel
        g.drawImage(ImagenCoche, 0, 0, this);
    }
}
