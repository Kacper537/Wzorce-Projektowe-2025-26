package org.example;

public interface MazeFactoryMethod {
    public Room makeRoom(int n, int x, int y);
    public Wall makeWall(Directions d);
    public Door makeDoor(Room r1, Room r2, boolean isOpen);
}
