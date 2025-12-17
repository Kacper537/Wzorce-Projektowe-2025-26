package org.example;


import java.awt.*;

public class Wall extends MapSite {

    public Wall(Directions d) {
        super(0,0);
        direction = d;
    }

    public void setDirection(Directions d){
        direction = d;
    }
  
    private Directions direction;


    @Override
    public void draw(Image image) {
        super.draw(image);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);  // ustawiamy kolor

        int x = getX();
        int y = getY();
        int len =MapSite.LENGTH;


        switch (direction)
        {
            case North: // linia pozioma
                g.drawLine(getX(), getY(), getX() + MapSite.LENGTH, getY());
                break;
            case South:
                g.drawLine(getX(), getY(), getX() + MapSite.LENGTH, getY());
                break;
            case West:
                g.drawLine(getX(), getY(), getX(), getY()+ MapSite.LENGTH);
                break;
            case East:
                g.drawLine(getX(), getY(), getX(), getY() + MapSite.LENGTH);
                break;
            default:   // linia pionowa
                break;
        }


    }
}
