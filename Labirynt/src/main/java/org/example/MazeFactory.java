package org.example;

public class MazeFactory implements MazeFactoryMethod{
    private Maze maze;
    private int x;
    private int y;

    public MazeFactory(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Maze createMaze(){
        maze = new Maze();

        int x = 50;
        int y = 100;
        int nr = 1;

        Room room1 = makeRoom(1,50,100);
        room1.setSide(Directions.North, makeWall(Directions.North));
        room1.setSide(Directions.East, makeWall(Directions.East));
        room1.setSide(Directions.South, makeWall(Directions.South));
        room1.setSide(Directions.West, makeWall(Directions.West));

        if (room1 instanceof RoomWithBomb) {
            ((RoomWithBomb) room1).setBomb(true);
        }

        Room room2 = makeRoom(2,50,100 + MapSite.LENGTH);
        room2.setSide(Directions.North, new Wall(Directions.North));
        room2.setSide(Directions.East, new Wall(Directions.East));
        room2.setSide(Directions.South, new Wall(Directions.South));
        room2.setSide(Directions.West, new Wall(Directions.West));

        Room room3 = makeRoom(3,50,100 + 2*MapSite.LENGTH);
        room3.setSide(Directions.North, new Wall(Directions.North));
        room3.setSide(Directions.East, new Wall(Directions.East));
        room3.setSide(Directions.South, new Wall(Directions.South));
        room3.setSide(Directions.West, new Wall(Directions.West));

        Room room4 = makeRoom(4,50 + MapSite.LENGTH,100 + MapSite.LENGTH);
        room4.setSide(Directions.North, new Wall(Directions.North));
        room4.setSide(Directions.East, new Wall(Directions.East));
        room4.setSide(Directions.South, new Wall(Directions.South));
        room4.setSide(Directions.West, new Wall(Directions.West));

        Room room5 = makeRoom(5,50 + 2*MapSite.LENGTH,100);
        room5.setSide(Directions.North, new Wall(Directions.North));
        room5.setSide(Directions.East, new Wall(Directions.East));
        room5.setSide(Directions.South, new Wall(Directions.South));
        room5.setSide(Directions.West, new Wall(Directions.West));

        Room room6 = makeRoom(6,50 + 2*MapSite.LENGTH,100 + MapSite.LENGTH);
        room6.setSide(Directions.North, new Wall(Directions.North));
        room6.setSide(Directions.East, new Wall(Directions.East));
        room6.setSide(Directions.South, new Wall(Directions.South));
        room6.setSide(Directions.West, new Wall(Directions.West));

        Room room7 = makeRoom(7,50 + 2*MapSite.LENGTH,100 + 2*MapSite.LENGTH);
        room7.setSide(Directions.North, new Wall(Directions.North));
        room7.setSide(Directions.East, new Wall(Directions.East));
        room7.setSide(Directions.South, new Wall(Directions.South));
        room7.setSide(Directions.West, new Wall(Directions.West));

        Room room8 = makeRoom(8,50 + 3*MapSite.LENGTH,100 + MapSite.LENGTH);
        room8.setSide(Directions.North, new Wall(Directions.North));
        room8.setSide(Directions.East, new Wall(Directions.East));
        room8.setSide(Directions.South, new Wall(Directions.South));
        room8.setSide(Directions.West, new Wall(Directions.West));

        Door door1 = makeDoor(room1,room2,false);
        Door door2 = makeDoor(room2,room3,false);
        Door door3 = makeDoor(room2,room4,true);
        Door door4 = makeDoor(room4,room6,true);
        Door door5 = makeDoor(room6,room5,false);
        Door door6 = makeDoor(room6,room7,false);
        Door door7 = makeDoor(room6,room8,true);

        Maze maze = new Maze();
        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        return maze;
    }

    public Room makeRoom(int n, int x, int y){
        return new Room(n, x, y);
    }

    public Wall makeWall(Directions direction){
        return new Wall(direction);
    }

    public Door makeDoor(Room r1, Room r2, boolean isOpen){
        return new Door(r1, r2, isOpen);
    }
}
