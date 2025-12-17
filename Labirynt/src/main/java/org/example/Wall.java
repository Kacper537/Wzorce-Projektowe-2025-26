package org.example;


import java.awt.*;

public class Wall extends MapSite {

    public Wall(Directions d) {
        super(0, 0);
        direction = d;
    }

    public void setDirection(Directions d){
            direction = d;
    }

    private Directions direction;

    public Directions getDirection(){
        return direction;
    }

    @Override
    public void draw(Image image) {
        super.draw(image);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);  // ustawiamy kolor
        switch (direction)
        {
            case South:
            case North: // linia pozioma
                g.drawLine(getX(), getY(), getX() + MapSite.LENGTH, getY());
                break;
            case East:
            case West:
                g.drawLine(getX(), getY(), getX(), getY() + MapSite.LENGTH);
                break;  // linia pionowa
            default:
                break;
        }
        // debug print removed


    }
}