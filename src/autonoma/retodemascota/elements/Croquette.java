/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Maria Paz Puerta <mariap.puertaa@autonoma.edu.co>
 * @since 20252704
 * @version 1.0.0
 */
public class Croquette extends Sprite{

    /** Imagen que representa visualmente la croqueta. */
    private final Image imagen;

    /**
     * Constructor de la clase Croquette.
     *
     * @param x coordenada horizontal de la croqueta.
     * @param y coordenada vertical de la croqueta.
     * @param width ancho de la croqueta.
     * @param height alto de la croqueta.
     */
    public Croquette(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(255, 215, 0)); // Color dorado
        imagen = new ImageIcon(getClass().getResource("/autonoma/RetoDeMascota/images/Croquettes.png")).getImage();
    }

    /**
     * Dibuja la croqueta en la pantalla usando su imagen.
     *
     * @param g el contexto gráfico sobre el cual se dibuja.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(imagen, getX(), getY(), 100, 100, null);
    }
}
