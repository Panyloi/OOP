package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Vector2dTest {
    private Vector2d vec1 = new Vector2d(2 ,3);
    private Vector2d vec2 = new Vector2d(2, 3);
    private Vector2d vec3 = new Vector2d(-3, 0);
    private Vector2d vec4 = new Vector2d(1,4);
    private Vector2d vec5 = new Vector2d(3,1);
    private Vector2d vec6 = new Vector2d(3,6);

    @Test
    public void equalsTest(){
        assertEquals(vec1, vec2);
        assertEquals(vec1.hashCode(), vec2.hashCode());
        assertNotEquals(vec1, vec4);
        assertNotEquals(vec1.hashCode(), vec6.hashCode());
    }

    @Test
    public void toStringTest(){
        assertEquals("(2,3)", vec1.toString());
        assertNotEquals("(-1,3)",vec4.toString());
    }

    @Test
    public void precedesTest(){
        assertTrue(vec1.precedes(vec2));
        assertTrue(vec1.precedes(vec6));
        assertFalse(vec1.precedes(vec4));
        assertFalse(vec1.precedes(vec5));
        assertFalse(vec1.precedes(vec3));
    }

    @Test
    public void followsTest(){
        assertTrue(vec1.follows(vec2));
        assertTrue(vec1.follows(vec3));
        assertFalse(vec1.follows(vec4));
        assertFalse(vec1.follows(vec5));
        assertFalse(vec1.follows(vec6));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(2,3), vec1.upperRight(vec3));
        assertEquals(new Vector2d(2, 4), vec1.upperRight(vec4));
        assertEquals(new Vector2d(3, 3), vec1.upperRight(vec5));
        assertNotEquals(new Vector2d(2,3),vec1.upperRight(vec6));
        assertNotEquals(new Vector2d(1,3),vec1.upperRight(vec4));
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(2,3),vec1.lowerLeft(vec6));
        assertEquals(new Vector2d(1,3),vec1.lowerLeft(vec4));
        assertEquals(new Vector2d(2,1),vec1.lowerLeft(vec5));
        assertNotEquals(new Vector2d(2,3),vec1.lowerLeft(vec3));
        assertNotEquals(new Vector2d(1,4),vec1.lowerLeft(vec4));
    }

    @Test
    public void addTest(){
        assertEquals(new Vector2d(4,6), vec1.add(vec2));
        assertNotEquals(new Vector2d(4,3), vec1.add(vec2));
    }

    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(0,0), vec1.subtract(vec2));
        assertNotEquals(new Vector2d(2,0), vec1.subtract(vec2));
    }

    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(-2,-3), vec1.opposite());
        assertEquals(new Vector2d(3,0), vec3.opposite());
        assertNotEquals(new Vector2d(2,-3), vec1.opposite());
    }
}
