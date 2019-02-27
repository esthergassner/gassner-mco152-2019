package gassner.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.Assert.*;

class ProjectileTest {

    @Test
    public void getLocationAfter3Seconds() {
        //given
        Projectile p = new Projectile(67, 48);

        //when
        p.addTime(3);

        //then
        double x = p.calcX();
        double y = p.calcY();
        assertEquals(134.49, x, 0.01);
        assertEquals(105.27, y, 0.01);
    }

}