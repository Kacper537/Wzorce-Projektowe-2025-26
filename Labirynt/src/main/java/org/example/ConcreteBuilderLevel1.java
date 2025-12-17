package org.example;

public class ConcreteBuilderLevel1 implements MazeBuilder{
    private Maze maze;
    @Override
    public void buildMaze(){
        maze = new Maze();
    }

    @Override
    public void buildRoom(int x, int y, int nr){
        Room room = new Room(nr, x, y);
        room.setSide(Directions.North,new Wall(Directions.North));
        room.setSide(Directions.South,new Wall(Directions.South));
        room.setSide(Directions.West,new Wall(Directions.West));
        room.setSide(Directions.East,new Wall(Directions.East));
        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int room_1, int room_2){
        Room roomOne = maze.getRoom(room_1);
        Room roomTwo = maze.getRoom(room_2);
        if (roomOne != null && roomTwo != null) {
            Door door = new Door(roomOne,roomTwo,false);

            int x1 = roomOne.getX();
            int y1 = roomOne.getY();
            int x2 = roomTwo.getX();
            int y2 = roomTwo.getY();

            if (x1 == x2) { // Same column, vertical door
                if (y1 > y2) {
                    roomOne.setSide(Directions.North, door);
                    roomTwo.setSide(Directions.South, door);
                } else {
                    roomOne.setSide(Directions.South, door);
                    roomTwo.setSide(Directions.North, door);
                }
            } else if (y1 == y2) { // Same row, horizontal door
                if (x1 > x2) {
                    roomOne.setSide(Directions.West, door);
                    roomTwo.setSide(Directions.East, door);
                } else {
                    roomOne.setSide(Directions.East, door);
                    roomTwo.setSide(Directions.West, door);
                }
            }
        }
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}
