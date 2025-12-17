package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    private JMyPanel panel;  // do wyświetlenia labiryntu przy pomocy Image
    private Image image; // obiekt, na którym rysujemy labirynt
    private Maze maze;

    public App() {
        setSize(600, 300);  // rozmiar okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // standardowy sposób zamykania aplikacji
        panel = new JMyPanel();
        JButton button = new JButton("Draw maze"); // przecisk wyświetlający labirynt
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
//                drawMaze();
                drawMazeFactory();
                //drawMazesUsingBuilder();
                panel.repaint();   // odświeżenie panelu - odrysowanie labiryntu
            }
        });
        JButton buttonDet = new JButton("Detonation"); // przycisk detonacji
        buttonDet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
                drawBombedMaze();
                panel.repaint();   // odświeżenie panelu - odrysowanie labiryntu
            }
        });

        setLayout((new BorderLayout())); // ustawiamy menedżera rozkładu dla JFrame
        JPanel menuPanel = new JPanel(new GridLayout(1, 2)); // panel z przyciskami
        menuPanel.add(button);
        menuPanel.add(buttonDet);
        add(menuPanel, "North"); // wstawiamy panel z przyciskiem na górze aplikacji
        add(panel, BorderLayout.CENTER);

    }

    public void drawBombedMaze(){
        if (image == null) image = panel.getImage();
        if (maze == null) return;
        Graphics g = image.getGraphics();
        g.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
        for (int i = 0; i < maze.size(); i++){
            MapSite roomObj = maze.getRoomAt(i);
            if (roomObj instanceof RoomWithBomb) {
                RoomWithBomb room = (RoomWithBomb) roomObj;
                room.setDetonated();
            }
        }
        maze.draw(image);
        panel.repaint();
    }

    public void drawMazeFactory(){
        int x = 50;
        int y = 100;
        int nr = 1;

        MazeFactory mazeFactory = new BombedMazeFactory(x, y);
        this.maze = mazeFactory.createMaze();
        if (image == null) image = panel.getImage();
        if (this.maze != null) this.maze.draw(image);
    }

    public void drawMaze() {
        Wall wall = new Wall(Directions.East);
        wall.setX(50);
        wall.setY(100);
        //wall.draw(image);
        int x = 50;
        int y = 100;
        int nr = 1;

        Room room1 = new Room(1,50,100);
        room1.setSide(Directions.North, new Wall(Directions.North));
        room1.setSide(Directions.East, new Wall(Directions.East));
        room1.setSide(Directions.South, new Wall(Directions.South));
        room1.setSide(Directions.West, new Wall(Directions.West));

        Room room2 = new Room(2,50,100 + MapSite.LENGTH);
        room2.setSide(Directions.North, new Wall(Directions.North));
        room2.setSide(Directions.East, new Wall(Directions.East));
        room2.setSide(Directions.South, new Wall(Directions.South));
        room2.setSide(Directions.West, new Wall(Directions.West));

        Room room3 = new Room(3,50,100 + 2*MapSite.LENGTH);
        room3.setSide(Directions.North, new Wall(Directions.North));
        room3.setSide(Directions.East, new Wall(Directions.East));
        room3.setSide(Directions.South, new Wall(Directions.South));
        room3.setSide(Directions.West, new Wall(Directions.West));

        Room room4 = new Room(4,50 + MapSite.LENGTH,100 + MapSite.LENGTH);
        room4.setSide(Directions.North, new Wall(Directions.North));
        room4.setSide(Directions.East, new Wall(Directions.East));
        room4.setSide(Directions.South, new Wall(Directions.South));
        room4.setSide(Directions.West, new Wall(Directions.West));

        Room room5 = new Room(5,50 + 2*MapSite.LENGTH,100);
        room5.setSide(Directions.North, new Wall(Directions.North));
        room5.setSide(Directions.East, new Wall(Directions.East));
        room5.setSide(Directions.South, new Wall(Directions.South));
        room5.setSide(Directions.West, new Wall(Directions.West));

        Room room6 = new Room(6,50 + 2*MapSite.LENGTH,100 + MapSite.LENGTH);
        room6.setSide(Directions.North, new Wall(Directions.North));
        room6.setSide(Directions.East, new Wall(Directions.East));
        room6.setSide(Directions.South, new Wall(Directions.South));
        room6.setSide(Directions.West, new Wall(Directions.West));

        Room room7 = new Room(7,50 + 2*MapSite.LENGTH,100 + 2*MapSite.LENGTH);
        room7.setSide(Directions.North, new Wall(Directions.North));
        room7.setSide(Directions.East, new Wall(Directions.East));
        room7.setSide(Directions.South, new Wall(Directions.South));
        room7.setSide(Directions.West, new Wall(Directions.West));

        Room room8 = new Room(8,50 + 3*MapSite.LENGTH,100 + MapSite.LENGTH);
        room8.setSide(Directions.North, new Wall(Directions.North));
        room8.setSide(Directions.East, new Wall(Directions.East));
        room8.setSide(Directions.South, new Wall(Directions.South));
        room8.setSide(Directions.West, new Wall(Directions.West));
        
        Door door1 = new Door(room1,room2,false);
        Door door2 = new Door(room2,room3,false);
        Door door3 = new Door(room2,room4,true);
        Door door4 = new Door(room4,room6,true);
        Door door5 = new Door(room6,room5,false);
        Door door6 = new Door(room6,room7,false);
        Door door7 = new Door(room6,room8,true);

        Maze maze = new Maze();
        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        maze.draw(image);

/*
        room1.draw(image);
        room2.draw(image);
        room3.draw(image);
        room4.draw(image);
        room5.draw(image);
        room6.draw(image);
        room7.draw(image);
        room8.draw(image);
*/
    }


    public void drawMazesUsingBuilder() {
        Director director = new Director();
        MazeBuilder builder1 = new ConcreteBuilderLevel1();
        MazeBuilder builder2 = new ConcreteBuilderLevel1();

        image = panel.getImage();

        director.createMaze(builder1);
        Maze maze1 = builder1.getMaze();
        maze1.draw(image);

        director.createMazeWithOffset(builder2, 400);
        Maze maze2 = builder2.getMaze();
        maze2.draw(image);
    }


    public static void main( String[] args )
    {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}