package CoordTests;

import main.Models.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CoordinateTest {

    @Test
    void getX() {
        Coordinate coord = new Coordinate();
        coord.setX(2);
        Assertions.assertEquals(2,coord.getX());
    }

    @Test
    void setX() {
        Coordinate coord = new Coordinate();
        coord.setX(2);
        Assertions.assertEquals(2,coord.getX());
    }

    @Test
    void getY() {
        Coordinate coord = new Coordinate();
        coord.setY(4);
        Assertions.assertEquals(4,coord.getY());
    }

    @Test
    void setY() {
        Coordinate coord = new Coordinate();
        coord.setY(4);
        Assertions.assertEquals(4,coord.getY());
    }
}