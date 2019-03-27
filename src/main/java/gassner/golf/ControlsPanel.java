package gassner.golf;

import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel
{
    private JLabel velocityLabel, angleLabel;
    private JTextField velocityField, angleField;
    private GolfCourseComponent golfCourseComponent;

    public ControlsPanel(GolfCourseComponent golfCourseComponent)
    {
        this.golfCourseComponent = golfCourseComponent;

        velocityLabel = createLabel("Velocity");
        velocityField = new JTextField(3);
        angleLabel = createLabel("Angle");
        angleField = new JTextField(3);
        JButton fire = createFireButton();

        add(velocityLabel);
        add(velocityField);
        add(angleLabel);
        add(angleField);
        add(fire);
    }

    private JLabel createLabel(String text)
    {
        return new JLabel(text + ":");
    }

    private JButton createFireButton()
    {
        JButton fire = new JButton("FIRE");
        fire.setBackground(new Color(196, 15, 25));
        fire.addActionListener(e -> {
            double velocity = Double.parseDouble(velocityField.getText());
            double angle = Double.parseDouble(angleField.getText());
            golfCourseComponent.fireBall(velocity, angle);
        });
        return fire;
    }

}
