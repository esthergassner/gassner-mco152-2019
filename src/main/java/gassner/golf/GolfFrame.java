package gassner.golf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GolfFrame extends JFrame
{
    public GolfFrame()
    {
        setTitle("Esther Golf");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JLabel north = new JLabel(new ImageIcon("mario.jpg"));
        root.add(north, BorderLayout.NORTH);

        JLabel south = new JLabel("SOUTH");
        south.setBackground(Color.MAGENTA);
        root.add(south, BorderLayout.SOUTH);
        south.setOpaque(true);

        JLabel west = new JLabel("WEST");
        west.setBackground(Color.CYAN);
        root.add(west, BorderLayout.WEST);
        west.setOpaque(true);

        JButton center = new JButton("CENTER");
        center.setBackground(Color.LIGHT_GRAY);
        center.setOpaque(true);

        center.addActionListener(this::printClick);

        root.add(center, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent)
    {
        System.out.println("CLICK");
    }
}

