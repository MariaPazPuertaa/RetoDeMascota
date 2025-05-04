/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Maria Paz Puerta
 */
public class Dog extends Sprite {
    public static final int STEP = 10;
    public static final int EAT_SIZE = 10;
    
    public Dog(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(255, 182, 193));
        
        
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
