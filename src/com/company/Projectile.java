package com.company;

public class Projectile
{
    private final double velocity;
    private final double degrees;
    private double time;

    public Projectile(double velocity, double degrees)
    {

        this.velocity = velocity;
        this.degrees = degrees;
    }

    public void addTime(double deltaTime)
    {
        time += deltaTime;
    }

    public double calcX()
    {
        return Math.cos(Math.toRadians(degrees)) * velocity * time;
    }

    public double calcY()
    {
        return Math.sin(Math.toRadians(degrees)) * velocity * time - 9.8 * .5 * Math.pow(time, 2);
    }

    @Override
    public String toString()
    {
        return time + " " + calcX() + " " + calcY();
    }

}
