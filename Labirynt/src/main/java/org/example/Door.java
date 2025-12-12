package org.example;

import java.awt.*;

public class Door extends MapSite{
    private boolean isOpen = true;
    private Room room1;
    private Room room2;
    private boolean isHorizontal;

    public Door(Room r1, Room r2, boolean isOpen){
        this.isOpen = isOpen;
        room1 = r1;
        room2 = r2;
        int x1 = room1.getX();
        int y1 = room1.getY();
        int x2 = room2.getX();
        int y2 = room2.getY();
        if (y1==y2){
            if(x2>x1){
                setX(x2);
                room1.setSide(Directions.East, this);
                room2.setSide(Directions.West, this);
            }
            else{
                setX(x1);
                room1.setSide(Directions.West, this);
                room2.setSide(Directions.East, this);
            }
            setY(y1);
        }
        else {

            if(y1>y2){
                setY(y1);

                isHorizontal = true;
                room1.setSide(Directions.North,this);
                room2.setSide(Directions.South,this);
            }
            else{
                setY(y2);
                isHorizontal = true;
                room1.setSide(Directions.South,this);
                room2.setSide(Directions.North,this);
            }


            setY(y1>y2 ? y1 : y2);
            setX(x1);
        }
    }

    public void draw(Image image){
        Graphics g = image.getGraphics();
        if (isHorizontal == true){
            g.drawLine(getX(), getY(), getX() + LENGTH/3, getY());
            g.drawLine(getX()+(LENGTH/3*2), getY(), getX() + LENGTH, getY());
        }
        else{
            g.drawLine(getX(), getY(), getX(), getY() + LENGTH);
        }
    }
}

