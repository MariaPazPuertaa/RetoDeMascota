/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.retodemascota.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Maria Paz Puerta <mariap.puertaa@autonoma.edu.co>
 * @since 20252704
 * @version 1.0.0
 */
public abstract class Sprite {
    /*
     * Coordenada horizontal del sprite. 
     */
    protected int x;
    
    /*
     * Coordenada vertical del sprite. 
     */
    protected int y;
    
    /*
     * Ancho del sprite. 
     */
    protected int width;
    
    /*
     * Altura del sprite. 
     */
    protected int height;
    
    /*
     * Color del sprite (puede ser usado como fondo o borde si no hay imagen). 
     */
    protected Color color;

    /**
     * Constructor para inicializar las propiedades básicas de un sprite.
     * 
     * @param x coordenada horizontal.
     * @param y coordenada vertical.
     * @param width ancho del sprite.
     * @param height altura del sprite.
     * @param color color asociado al sprite.
     */
    public Sprite(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Método abstracto para dibujar el sprite.
     * Cada clase hija debe definir cómo se dibuja.
     * 
     * @param g contexto gráfico sobre el que se dibujará el sprite.
     */
    public abstract void draw(Graphics g);

    /**
     * Verifica si este sprite colisiona con otro.
     * 
     * @param other otro sprite con el que se quiere verificar colisión.
     * @return true si hay colisión entre ambos sprites, {@code false} en caso contrario.
     */
    public boolean hit(Sprite other) {
        return x < other.getX() + other.getWidth() &&
               x + width > other.getX() &&
               y < other.getY() + other.getHeight() &&
               y + height > other.getY();
    }

    // Getters y setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
