package org.example;

import java.awt.*;

public class BombedDoor extends Door{
    private boolean isDetonated;

    public BombedDoor(Room room_1, Room room_2){
        super(room_1, room_2, true);
    }

    public BombedDoor(Room room_1, Room room_2, boolean isOpen){
        super(room_1, room_2, isOpen);
    }

    public BombedDoor(Room room_1, Room room_2, boolean isOpen, boolean isDetonated){
        super(room_1, room_2, isOpen);
        this.isDetonated = isDetonated;
    }

    public void setDetonated(boolean detonated){
        isDetonated = detonated;
    }

    public void draw(Image image){
        super.draw(image);
        Graphics g = image.getGraphics();
        if (isDetonated){
            if (getHorizontal() == true){
                g.drawString("X", getX() + MapSite.LENGTH, getY());
            }
        }
    }
}
