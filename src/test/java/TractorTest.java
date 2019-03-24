import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TractorTest  {

    private Tractor tractor;
    @Before
    public void init() {
        tractor = new Tractor();
    }

    @Test
    public void testMoveForward(){
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    @Test
    public void testTurn(){
        Tractor tractor = new Tractor();
        tractor.move("T");
        assertEquals(Orientation.EAST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.WEST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    @Test
    public void testTurnAndMove(){
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
    }

    @Test (expected = TractorInDitchException.class)
    public void testException(){
        for (int i = 0; i < 6; i++) {
            tractor.move("F");
        }
    }

    @Test
    public void testInitWithParams() {
        Field field = new Field(10,10);
        Position position = new Position(5, 5);
        Orientation orientation = Orientation.EAST;
        tractor = new Tractor(field, position, orientation);
        assertEquals(5, tractor.getPositionX());
        assertEquals(5, tractor.getPositionY());
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }

    @Test
    public void testInitWithoutPosition() {
        Field field = new Field(10,10);
        Orientation orientation = Orientation.EAST;
        tractor = new Tractor(field, null, orientation);
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        assertEquals(Orientation.EAST, tractor.getOrientation());
    }
}
