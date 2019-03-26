package gassner.golf;

import gassner.physics.Projectile;

import javax.swing.*;
import java.awt.*;

public class GolfCourseComponent extends JComponent
{
    private Projectile ballFlight = new Projectile(20, 50);
    private double x = 0.0;
    private double y = 0.0;
    private double cloudMovement = 0.0;

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        final double BALL_START_X = 30;
        int groundHeight = getHeight() - getHeight()/3;

        drawSky(graphics);
        drawClouds(graphics);
        drawGround(graphics, groundHeight);
        drawBall(graphics, BALL_START_X, groundHeight);
        drawFlag(graphics, groundHeight);
        drawFlagpole(graphics, groundHeight);

            repaint();
    }

    private void drawSky(Graphics graphics)
    {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void drawGround(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(this.getX(), groundHeight, this.getWidth(), groundHeight/10);
        graphics.setColor(new Color(110, 55, 8));
        graphics.fillRect(getX(), groundHeight + groundHeight/10, getWidth(), groundHeight/10);
        graphics.fillRect(getX(), (groundHeight + (groundHeight/10)*3), getWidth(), groundHeight/10);
        graphics.setColor(new Color(148, 87, 4));
        graphics.fillRect(getX(), (groundHeight + (groundHeight/10)*2), getWidth(), groundHeight/10);
        graphics.fillRect(getX(), (groundHeight + (groundHeight/10)*4), getWidth(), groundHeight/10);
    }

    private void drawBall(Graphics graphics, double ball_start_x, int groundHeight)
    {
        ImageIcon ball = new ImageIcon("golfBall.png");
        graphics.drawImage(ball.getImage(), (int) (ball_start_x + x), (int) ((groundHeight - 25) + y), null);
        ballFlight.addTime(1);
        x += .1;

        if(ballFlight.calcY() > 0)
        {
            y = 0;
        }
        else y -= .1;
//        else
//        {
//        //the projectile situation is not acting as expected.
//        y = (ballFlight.calcY() / 10000);
//        x = (ballFlight.calcX() / 10000);
//        }
    }
    private void drawFlag(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.RED);
        graphics.fillPolygon(new int[]{700, 750, 750},
                new int[]{groundHeight - 120, groundHeight - 100, groundHeight - 140}, 3);
    }

    private void drawFlagpole(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(745, groundHeight - 100, 5, 100);
    }

    private void drawClouds(Graphics graphics)
    {
        if (cloudMovement > 300.0)
        {
            cloudMovement = 0.0;
        }
        ImageIcon cloud1 = new ImageIcon("cloud.png");
        ImageIcon cloud2 = new ImageIcon("cloud2.png");
        for (int ix = 0; ix < (getWidth() - 50); ix += 150)
        {
            if (ix % 100 != 0)
            {
                graphics.drawImage(cloud1.getImage(),  (int)(ix + cloudMovement), 10 + getHeight()/10, null );
                graphics.drawImage(cloud2.getImage(), (int) (ix - cloudMovement), 10 + getHeight() / 10, null);
            }
            else
            {
                graphics.drawImage(cloud2.getImage(),  (int)(ix + cloudMovement), 80 + getHeight()/10, null );
                graphics.drawImage(cloud1.getImage(),  (int)(ix - cloudMovement), 80 + getHeight()/10, null );
            }
        }
        cloudMovement += .005;
    }
}
