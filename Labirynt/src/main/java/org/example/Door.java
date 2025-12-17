package org.example;


import java.awt.*;

public class Door extends MapSite{
    private boolean isOpen = true;
    private Room roomOne;
    private Room roomTwo;
    private boolean isHorizontal;

    public boolean getHorizontal(){
        return isHorizontal;
    }

    public Door(Room r1, Room r2, boolean isOpen){
        super(-1,-1);
        this.isOpen = isOpen;
        this.roomOne = r1;
        this.roomTwo = r2;

        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();

        if (y1 == y2) {//I
            isHorizontal=false;
            if (x2 > x1){
                setX(x2);
                roomOne.setSide(Directions.East,this);
                roomTwo.setSide(Directions.West,this);
            }
            else{
                setX(x1);
                roomOne.setSide(Directions.West,this);
                roomTwo.setSide(Directions.East,this);
            }
            setY(y1);
        }
        else{
            isHorizontal = true;
            if (y2 > y1){
                setY(y2);
                roomOne.setSide(Directions.South,this);
                roomTwo.setSide(Directions.North,this);

            }
            else{
                setY(y1);
                roomOne.setSide(Directions.North,this);
                roomTwo.setSide(Directions.South,this);
            }
            setX(x1);
        }

    }
    @Override
    public void draw(Image image){
        super.draw(image);
        Graphics g = image.getGraphics();

        if (isHorizontal == true){
            g.drawLine(getX(), getY(),getX()+LENGTH/3, getY());
            g.drawLine(getX()+2*LENGTH/3,getY(),getX()+LENGTH,getY());
        }
        else{
            g.drawLine(getX(),getY(),getX(),getY()+LENGTH/3);
            g.drawLine(getX(),getY()+2*LENGTH/3,getX(),getY()+LENGTH);
        }

    }



}