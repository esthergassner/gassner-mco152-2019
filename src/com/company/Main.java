package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Random rand = new Random();
        ArrayList<Projectile> projectiles = new ArrayList<>();
        for (int second = 0; second < 120; ++second)
        {
            for (Projectile projectile : projectiles)
            {
                projectile.addTime(1);
            } //should this go before or after adding new projectiles?
            int nrProjectiles = rand.nextInt(6);
            for (int ix = 0; ix < nrProjectiles; ++ix)
            {
                projectiles.add(new Projectile((double)rand.nextInt(171) + 50.0, (double)rand.nextInt(181) + 30.0));
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
