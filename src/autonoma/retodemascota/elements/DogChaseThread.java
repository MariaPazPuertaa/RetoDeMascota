/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.elements;

import autonoma.retodemascota.gui.GameWindow;



/**
 *
 * @author Maria Paz Puerta <mariap.puertaa@autonoma.edu.co>
 * @since 20252704
 * @version 1.0.0
 */
public class DogChaseThread extends Thread {
    
    /*
     * Referencia al perro que se moverá. 
     */
    private Dog dog;

    /*
     * Ventana del juego que será repintada para mostrar el movimiento. 
     */
    private GameWindow window;

    /**
     * Constructor de la clase DogChaseThread.
     *
     * @param dog el perro que se moverá.
     * @param window la ventana del juego que se actualizará.
     */
    public DogChaseThread(Dog dog, GameWindow window) {
        this.dog = dog;
        this.window = window;
    }

    /**
     * Método que ejecuta el hilo. Mueve al perro hacia su posición objetivo
     * y repinta la ventana del juego periódicamente.
     */
    @Override
    public void run() {
        while (true) {
            try {
                dog.moveTowardsTarget();  
                Thread.sleep(20);         
                window.repaint();         
            } catch (InterruptedException e) {
                e.printStackTrace();      
            }
        }
    }
}
