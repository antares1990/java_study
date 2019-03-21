package ru.stqa.study.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance() {
        Point p = new Point(5,9,6,9);
        Assert.assertEquals(p.distance(), 5.0);
    }
}
