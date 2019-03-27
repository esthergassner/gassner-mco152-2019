package gassner.golf;

import gassner.physics.Projectile;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GolfCourseComponent extends JComponent
{
    private Projectile ball = new Projectile(0, 0);
    private double cloudMovement = 0.0;
    private Image cloud1 = new ImageIcon("cloud.png").getImage();
    private Image cloud2 = new ImageIcon("cloud2.png").getImage();

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        int groundHeight = getHeight() - getHeight()/3;
        final double BALL_START_X = 30;
        final int FLAGPOLE_LOCATION = 745;

        drawSky(graphics, false);
        drawClouds(graphics, cloud1, cloud2);
        drawGround(graphics, groundHeight);
        drawBall(graphics, BALL_START_X, groundHeight, FLAGPOLE_LOCATION);
        drawFlag(graphics, groundHeight);
        drawFlagpole(graphics, groundHeight, FLAGPOLE_LOCATION);

        repaint();
    }

    private void drawSky(Graphics graphics, boolean win)
    {
        if(win)
        {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random rand = new Random();
            graphics.setColor(new Color(rand.nextInt(180), rand.nextInt(180), rand.nextInt(180)));
        }
        else
        {
            graphics.setColor(Color.CYAN);
        }
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

    private void holeInOne(Graphics graphics)
    {
        drawSky(graphics, true);
        graphics.setColor(Color.WHITE);
        graphics.drawString("HOLE IN ONE!!!", getWidth()/2, getHeight()/3);
    }

    private void drawBall(Graphics graphics, double ball_start_x, int groundHeight, int flagpole_location)
    {
        double y = ball.calcY();
        double x = ball.calcX();
        ImageIcon ballImage = new ImageIcon("golfBall.png");
        graphics.drawImage(ballImage.getImage(), (int) (ball_start_x + x), (int) ((groundHeight - 25) - y), null);
        // enter values 90 and 60.1 to make this happen
        if ((int)(ball_start_x + x) == flagpole_location)
        {
            holeInOne(graphics);
        }
        if (y >= 0)
        {
            ball.addTime(.02);
        }
    }

    private void drawFlag(Graphics graphics, int groundHeight)
    {
        graphics.setColor(Color.RED);
        graphics.fillPolygon(new int[]{700, 750, 750},
                             new int[]{groundHeight - 120, groundHeight - 100, groundHeight - 140},
                            3);
    }

    private void drawFlagpole(Graphics graphics, int groundHeight, int flagpole_location)
    {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(flagpole_location, groundHeight - 100, 5, 100);
    }

    private void drawClouds(Graphics graphics, Image cloud1, Image cloud2)
    {
        if (cloudMovement > 300.0)
        {
            cloudMovement = 0.0;
        }
        for (int ix = 0; ix < (getWidth() - 50); ix += 150)
        {
            if (ix % 100 != 0)
            {
                graphics.drawImage(cloud1,  (int)(ix + cloudMovement), 10 + getHeight()/10, null );
                graphics.drawImage(cloud2, (int) (ix - cloudMovement), 10 + getHeight() / 10, null);
            }
            else
            {
                graphics.drawImage(cloud2,  (int)(ix + cloudMovement), 80 + getHeight()/10, null );
                graphics.drawImage(cloud1,  (int)(ix - cloudMovement), 80 + getHeight()/10, null );
            }
        }
        cloudMovement += .005;
    }

    void fireBall(double velocity, double angle)
    {
        ball = new Projectile(velocity, angle);
    }
}
