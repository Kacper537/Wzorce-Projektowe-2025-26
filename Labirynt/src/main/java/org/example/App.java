package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App extends JFrame
{
    private JMyPanel panel;  
    private Image image; 

    public App() {
        setSize(600, 300);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        panel = new JMyPanel();
        JButton button = new JButton("Draw maze"); 
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
               drawMaze();
               panel.repaint();  
            }
        });
        setLayout((new BorderLayout()));
        JPanel menuPanel = new JPanel(new GridLayout(1, 1)); 
        menuPanel.add(button);
        add(menuPanel, "North"); 
        add(panel, BorderLayout.CENTER);

    }


    public void drawMaze() {
        int x = 50;
        int y =100;
        int L = MapSite.LENGTH; 


        Room r1 = new Room(1, x, y);
        Room r2 = new Room(2, x, y + L);
        Room r3 = new Room(3, x, y + 2*L);

        Room r4 = new Room(4, x + 1*L, y + L);
        Room r5 = new Room(5, x + 2*L, y);
        Room r6 = new Room(6, x + 2*L, y + L);
        Room r7 = new Room(7, x + 2*L, y + 2*L);

        Room r8 = new Room(8, x + 3*L, y + L);

        Room[] rooms = {r1,r2,r3,r4,r5,r6,r7,r8};
        for (Room r : rooms) {
            r.setSide(Directions.North, new Wall(Directions.North));
            r.setSide(Directions.East,  new Wall(Directions.East));
            r.setSide(Directions.South, new Wall(Directions.South));
            r.setSide(Directions.West,  new Wall(Directions.West));
        }


        Door d12 = new Door(r1, r2, true);
        r1.setSide(Directions.South, d12);
        r2.setSide(Directions.North, d12);

        Door d23 = new Door(r2, r3, true);
        r2.setSide(Directions.South, d23);
        r3.setSide(Directions.North, d23);

        Door d24 = new Door(r2, r4, true);
        r2.setSide(Directions.East, d24);
        r4.setSide(Directions.West, d24);

        Door d46 = new Door(r4, r6, true);
        r4.setSide(Directions.East, d46);
        r6.setSide(Directions.West, d46);

        Door d56 = new Door(r5, r6, true);
        r5.setSide(Directions.South, d56);
        r6.setSide(Directions.North, d56);

        Door d67 = new Door(r6, r7, true);
        r6.setSide(Directions.South, d67);
        r7.setSide(Directions.North, d67);

        Door d68 = new Door(r6, r8, true);
        r6.setSide(Directions.East, d68);
        r8.setSide(Directions.West, d68);
        

        for (Room r : rooms) {
            r.draw(image);
        }

        Door[] doors = {d12, d23, d24, d46, d56, d67, d68};
        for (Door d : doors) {

            d.draw(image);
        }
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
