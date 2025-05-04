/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.main;

import autonoma.retodemascota.elements.Dog;
import autonoma.retodemascota.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Maria Paz Puerta
 */
public class Park extends Sprite{

    private Dog dog;
    
    public Park (int x, int y, int width, int height)
    {
        super(x, y, width, height, new Color(0, 100, 0));
        
        dog = new Dog(100, 100, 50, 50);
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
    
    
}
