package org.example;

import java.awt.*;

public class RoomWithBomb extends Room{
    private boolean isBomb;
    private boolean isDetonated;

    public RoomWithBomb(int nr, int x, int y){
        super(nr, x, y);
    }

    public RoomWithBomb(int nr, int x, int y, boolean isBomb){
        super(nr, x, y);
        this.isBomb = isBomb;
    }

    public void setBomb(boolean bomb){
        isBomb = bomb;
    }

    public void setDetonated(){
        if (isBomb) {
            isDetonated = true;
        }
    }

    public void draw(Image image) {
        super.draw(image);
        if (isDetonated == false) {
            if (isBomb) {
                Graphics g = image.getGraphics();
                g.drawString("B", getX() + MapSite.LENGTH / 2, getY() + MapSite.LENGTH / 2);
            }
        } else {
            if (isBomb == true) {
                isBomb = false;
            }
        }
    }
}
