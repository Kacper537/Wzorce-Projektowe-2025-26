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

    public App() {
        setSize(600, 300);  // rozmiar okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // standardowy sposób zamykania aplikacji
        panel = new JMyPanel();
        JButton button = new JButton("Draw maze"); // przecisk wyświetlający labirynt
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
               drawMaze();
               panel.repaint();   // odświeżenie panelu - odrysowanie labiryntu
            }
        });
        setLayout((new BorderLayout())); // ustawiamy menedżera rozkładu dla JFrame
        JPanel menuPanel = new JPanel(new GridLayout(1, 1)); // panel z przyciskami
        menuPanel.add(button);
        add(menuPanel, "North"); // wstawiamy panel z przyciskiem na górze aplikacji
        add(panel, BorderLayout.CENTER);

    }

    public void drawMaze() {
//       Wall wall = new Wall(Directions.East);
//       wall.setX(50);
//       wall.setY(100);
//       wall.draw(image);

        int x = 50;
        int y =100;

        Room room1 = new Room(1,x,y);
        room1.setSide(Directions.East, new Wall(Directions.East));
        room1.setSide(Directions.North, new Wall(Directions.North));
        room1.setSide(Directions.West, new Wall(Directions.West));
        room1.setSide(Directions.South, new Wall(Directions.South));

        Room room2 = new Room(2, x,y+ MapSite.LENGTH);
        room2.setSide(Directions.East, new Wall(Directions.East));
        room2.setSide(Directions.North, new Wall(Directions.North));
        room2.setSide(Directions.West, new Wall(Directions.West));
        room2.setSide(Directions.South, new Wall(Directions.South));

        Door door = new Door(room1,room2, true);
        room1.draw(image);
        room2.draw(image);
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
