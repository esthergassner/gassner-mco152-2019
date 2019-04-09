package gassner.golf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GolfFrame extends JFrame
{
    public GolfFrame()
    {
        setTitle("Esther Golf");
        setSize(1400, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        GolfCourseComponent golfCourseComponent = new GolfCourseComponent();
        ControlsPanel controlPanel = new ControlsPanel(golfCourseComponent);
       // GolfCourseComponent golfCourseComponent = controlPanel.getGolfCourseComponent();


        root.add(golfCourseComponent, BorderLayout.CENTER);
        root.add(controlPanel, BorderLayout.SOUTH);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent)
    {
        System.out.println("CLICK");
    }
}

