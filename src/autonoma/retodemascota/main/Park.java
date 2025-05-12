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
 * @author Maria Paz Puerta <mariap.puertaa@autonoma.edu.co>
 * @since 20252704
 * @version 1.0.0
 * 
 */
public class Park extends Sprite {

    /**
     * El perro que se encuentra en el parque.
     */
    private Dog dog;

    /**
     * Lista de croquetas que el perro puede comer.
     */
    private ArrayList<Croquette> croquettes = new ArrayList<>();

    /**
     * Constructor para inicializar un parque con un perro y un fondo de color.
     * 
     * @param x     Coordenada horizontal del parque.
     * @param y     Coordenada vertical del parque.
     * @param width Ancho del parque.
     * @param height Alto del parque.
     */
    public Park(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(135, 206, 235));

        dog = new Dog(100, 100, 50, 50);
    }

    /**
     * Dibuja el parque, el perro y las croquetas en el lienzo proporcionado.
     * 
     * @param g El objeto Graphics utilizado para dibujar en el lienzo.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        dog.draw(g);
        
        for(Croquette croquette : croquettes) {
            croquette.draw(g);
        }
    }

    /**
     * Verifica si el perro ha comido alguna croqueta y, en caso afirmativo, elimina la croqueta,
     * hace crecer al perro y reproduce el sonido de comer.
     */
    public void checkForCroquetteEaten() {
        for(int i = 0; i < croquettes.size(); i++) {
            Croquette croquette = croquettes.get(i);

            if(dog.hit(croquette)) {
                croquettes.remove(croquette);
                i--;

                dog.grow();

                playEatingSound();
            }
        }
    }

    /**
     * Agrega una nueva croqueta en una posición aleatoria dentro del parque.
     */
    private void addCroquette() {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);

        Croquette croquette = new Croquette(x, y, 25, 25);

        croquettes.add(croquette);
    }

    /**
     * Maneja los eventos de teclado.
     * En este caso, cuando se presiona la tecla "A", se agrega una croqueta y se verifica si el perro la ha comido.
     * 
     * @param e El evento de teclado que contiene la información de la tecla presionada.
     */
    public void handleKey(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                
                addCroquette();
                
                checkForCroquetteEaten();
                
                playBarkSound();
                
                break;
        }
    }

    /**
     * Reproduce el sonido de comer cuando el perro come una croqueta.
     */
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

    /**
     * Reproduce el sonido de ladrido cuando el perro ladra.
     */
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

    /**
     * Devuelve el perro que se encuentra en el parque.
     * 
     * @return El objeto Dog que representa al perro.
     */
    public Dog getDog() {
        return dog;
    }

    /**
     * Establece un nuevo perro en el parque.
     * 
     * @param dog El objeto Dog que representa el perro a establecer en el parque.
     */
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    /**
     * Establece la posición del perro dentro del parque.
     * 
     * @param x La nueva coordenada horizontal del perro.
     * @param y La nueva coordenada vertical del perro.
     */
    public void setDogPosition(int x, int y) {
        if (dog != null) {
            dog.setPosition(x, y);
        }
    }
}
