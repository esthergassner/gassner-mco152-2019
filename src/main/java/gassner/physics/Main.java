package gassner.physics;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        final int NR_PROJECTILES = 5;
        final int NR_SECONDS = 120;
        final int UP_BOUND_VELOCITY = 120;
        final int LOW_BOUND_VELOCITY = 50;
        final int UP_BOUND_DEGREES = 150;
        final int LOW_BOUND_DEGREES = 30;

        Random rand = new Random();
        ArrayList<Projectile> projectiles = new ArrayList<>();
        for (int second = 0; second < NR_SECONDS; ++second)
        {
            for (Projectile projectile : projectiles)
            {
                projectile.addTime(1);
            } //should this go before or after adding new projectiles?
            int nrProjectiles = rand.nextInt(NR_PROJECTILES + 1);
            for (int ix = 0; ix < nrProjectiles; ++ix)
            {
                projectiles.add(new Projectile(
                        (double)rand.nextInt(UP_BOUND_VELOCITY + LOW_BOUND_VELOCITY + 1) + LOW_BOUND_VELOCITY,
                        (double)rand.nextInt(UP_BOUND_DEGREES + LOW_BOUND_DEGREES + 1) + LOW_BOUND_DEGREES));
            }
        }

        for (Projectile projectile : projectiles)
        {
            if (projectile.calcY() > 0)
            {
                System.out.println(projectile.toString());
            }
        }
    }
}
