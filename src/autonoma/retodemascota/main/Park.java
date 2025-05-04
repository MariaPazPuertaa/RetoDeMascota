/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.main;

import autonoma.retodemascota.elements.Croquette;
import autonoma.retodemascota.elements.Dog;
import autonoma.retodemascota.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Maria Paz Puerta
 */
public class Park extends Sprite{

    private Dog dog;
    private ArrayList<Croquette> croquettes = new ArrayList<>();
    
    public Park (int x, int y, int width, int height)
    {
        super(x, y, width, height, new Color(135, 206, 235));
        dog = new Dog(100, 100, 50, 50);
        
    }

    @Override
    public void draw(Graphics g) {
        
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        dog.draw(g);
        
        for(Croquette croquette : croquettes){
            croquette.draw(g);
        }
       
    }

    public void checkForCroquetteEaten()
    {
        for(int i=0; i<croquettes.size(); i++)
        {
            Croquette croquette = croquettes.get(i);
            
            if(dog.hit(croquette))
            {
                croquettes.remove(croquette);
                i --;
                
                dog.grow();
                
                playEatingSound();  
            }
        }
    }
    
    private void addCroquette()
    {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Croquette croquette = new Croquette(x, y, 25, 25);
        
        croquettes.add(croquette);
    }
    
    public void handleKey(KeyEvent e)
    {
    
        switch(e.getKeyCode())
        {
          
        
            case KeyEvent.VK_A:
                addCroquette();  
                checkForCroquetteEaten();
                playBarkSound();
            break;
        
           
        }
        
    }
    
    private void playEatingSound() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("/autonoma/RetoDeMascota/sounds/SonidoDeComer2.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
    private void playBarkSound() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("/autonoma/RetoDeMascota/sounds/LadridoDePerro.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();  
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
    
    public void setDogPosition(int x, int y) {
        if (dog != null) {
            dog.setPosition(x, y);
        }
    }
}
