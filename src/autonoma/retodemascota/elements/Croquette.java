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
 *
 * @author Maria Paz Puerta
 */
public class Croquette extends Sprite{

    private final Image imagen;
    public Croquette(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(255, 215, 0));
        imagen = new ImageIcon(getClass().getResource("/autonoma/RetoDeMascota/images/Croquettes.png")).getImage();
    }
    
    @Override
    public void draw(Graphics g) {
       g.drawImage(imagen, getX(), getY(), 100, 100, null);
    }
}
