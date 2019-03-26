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

        GolfCourseComponent golfCourseComponent = new GolfCourseComponent();
        root.add(golfCourseComponent, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent)
    {
        System.out.println("CLICK");
    }
}

