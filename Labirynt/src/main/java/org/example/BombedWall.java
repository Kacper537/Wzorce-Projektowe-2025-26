package org.example;

import java.awt.*;

public class BombedWall extends Wall{
    private boolean isDetonated;

    public BombedWall(Directions d){
        super(d);
    }

    public BombedWall(Directions d, boolean isDetonated){
        super(d);
        this.isDetonated = isDetonated;
    }

    public void setDetonated(boolean detonated){
        isDetonated = detonated;
    }

    public void draw(Image image){
        int delta = 3;
        super.draw(image);
        if (isDetonated){
            Graphics g = image.getGraphics();
            g.setColor(Color.RED);
            switch (getDirection()){
                case East -> {
                    g.drawOval(getX() - delta, getY()+ MapSite.LENGTH/3, delta, delta);
                }
                case West -> {
                    g.drawOval(getX() + delta, getY()+ MapSite.LENGTH/3, delta, delta);
                }
                case North -> {
                    g.drawOval(getX() + MapSite.LENGTH/3, getY() + delta, delta, delta);
                }
                default -> {g.drawOval(getX() - MapSite.LENGTH/3, getY() + delta, delta, delta);}
            }
        }
    }
}
