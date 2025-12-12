package org.example;

import java.awt.*;

enum Directions {North, East, South, West};

public abstract class MapSite {
    private int x;
    private int y;  // współrzędne

    public MapSite(int x, int y){
        this.x = x;
        this.y = y;
    }
    public MapSite(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int LENGTH = 30;   // długość boku pokoju
    /**
     * Służy do rysowania
     * @param image
     */
    public void draw(Image image) {}
}
