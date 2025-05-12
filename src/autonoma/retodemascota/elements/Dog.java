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
 * @author Maria Paz Puerta <mariap.puertaa@autonoma.edu.co>
 * @since 20252704
 * @version 1.0.0
 */
public class Dog extends Sprite {
    
    /** 
     * Cantidad de píxeles que se mueve el perro en cada paso. 
     */
    public static final int STEP = 10;

    /*
     * Tamaño en píxeles en que el perro crece o se reduce. 
     */
    public static final int EAT_SIZE = 10;

    // Atributos para el seguimiento del cursor
    private int targetX;
    private int targetY;

    // Imagen y dimensiones
    private Image imagen;
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructor de la clase Dog.
     * 
     * @param x posición inicial en el eje X.
     * @param y posición inicial en el eje Y.
     * @param width ancho inicial del perro.
     * @param height alto inicial del perro.
     */
    public Dog(int x, int y, int width, int height) {
        super(x, y, 200, 200, new Color(255, 182, 193)); // Llama al constructor de Sprite
        imagen = new ImageIcon(getClass().getResource("/autonoma/RetoDeMascota/images/Dog2.png")).getImage();
    }

    /**
     * Dibuja la imagen del perro en el panel gráfico.
     * 
     * @param g objeto Graphics utilizado para el dibujo.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(imagen, getX(), getY(), getWidth(), getHeight(), null);
    }

    /**
     * Aumenta el tamaño del perro.
     */
    public void grow() {
        width += EAT_SIZE;
        height += EAT_SIZE;
    }

    /**
     * Reduce el tamaño del perro si su tamaño es mayor al mínimo permitido.
     */
    public void shrink() {
        if (width > EAT_SIZE && height > EAT_SIZE) {
            width -= EAT_SIZE;
            height -= EAT_SIZE;
        }
    }

    /**
     * Determina si el perro ha colisionado con una croqueta.
     * 
     * @param croquette croqueta a verificar.
     * @return true si hay colisión, false en caso contrario.
     */
    public boolean hit(Croquette croquette) {
        return this.x < croquette.getX() + croquette.getWidth() &&
               this.x + this.width > croquette.getX() &&
               this.y < croquette.getY() + croquette.getHeight() &&
               this.y + this.height > croquette.getY();
    }

    /**
     * Establece la posición actual del perro.
     * 
     * @param x nueva coordenada X.
     * @param y nueva coordenada Y.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** @return posición X del perro. */
    public int getX() {
        return x;
    }

    /** @param x nueva posición X del perro. */
    public void setX(int x) {
        this.x = x;
    }

    /** @return posición Y del perro. */
    public int getY() {
        return y;
    }

    /** @param y nueva posición Y del perro. */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Mueve al perro un paso hacia la posición objetivo.
     */
    public void moveTowardsTarget() {
        if (x < targetX) x += STEP;
        if (x > targetX) x -= STEP;
        if (y < targetY) y += STEP;
        if (y > targetY) y -= STEP;
    }

    /**
     * Establece la posición objetivo hacia la cual el perro se moverá.
     * 
     * @param x coordenada X objetivo.
     * @param y coordenada Y objetivo.
     */
    public void setTargetPosition(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }

}
