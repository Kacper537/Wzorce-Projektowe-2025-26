package org.example;

public class BombedMazeFactory extends MazeFactory{
    public BombedMazeFactory(int x, int y){
        super(x, y);
    }

    public Room makeRoom(int n, int x, int y){
        // only rooms 1 and 2 have bombs by default
        boolean isBomb = (n == 1 || n == 2);
        return new RoomWithBomb(n, x, y, isBomb);
    }

    public Door makeDoor(Room r1, Room r2, boolean isOpen){
        return new BombedDoor(r1, r2, isOpen);
    }

    public Wall makeWall(Directions direction){
        return new BombedWall(direction);
    }
}
