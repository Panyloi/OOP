package agh.isc.opp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    private Animal animalOrientation = new Animal();

    @Test
    public void correctOrientation(){
        animalOrientation.move(MoveDirection.RIGHT);
        assertEquals("pozycja: (2,2) , orientacja: wschód", animalOrientation.toString());
        animalOrientation.move(MoveDirection.FORWARD);
        animalOrientation.move(MoveDirection.FORWARD);
        assertEquals("pozycja: (4,2) , orientacja: wschód", animalOrientation.toString());
        animalOrientation.move(MoveDirection.RIGHT);
        animalOrientation.move(MoveDirection.BACKWARD);
        animalOrientation.move(MoveDirection.BACKWARD);
        assertEquals("pozycja: (4,4) , orientacja: południe", animalOrientation.toString());
        animalOrientation.move(MoveDirection.LEFT);
        animalOrientation.move(MoveDirection.LEFT);
        animalOrientation.move(MoveDirection.LEFT);
        animalOrientation.move(MoveDirection.FORWARD);
        assertEquals("pozycja: (3,4) , orientacja: zachód", animalOrientation.toString());
    }

    private Animal animalPosition = new Animal();

    @Test
    public void correctPosition(){
        animalPosition.move(MoveDirection.LEFT);
        assertEquals("pozycja: (2,2) , orientacja: zachód", animalPosition.toString());
        animalPosition.move(MoveDirection.FORWARD);
        animalPosition.move(MoveDirection.FORWARD);
        assertEquals("pozycja: (0,2) , orientacja: zachód", animalPosition.toString());
        animalPosition.move(MoveDirection.RIGHT);
        animalPosition.move(MoveDirection.BACKWARD);
        animalPosition.move(MoveDirection.BACKWARD);
        assertEquals("pozycja: (0,0) , orientacja: północ", animalPosition.toString());
        animalPosition.move(MoveDirection.RIGHT);
        animalPosition.move(MoveDirection.RIGHT);
        assertEquals("pozycja: (0,0) , orientacja: południe", animalPosition.toString());
    }

    private Animal animalOutside = new Animal();

    @Test
    public void testOutside(){
        animalOutside.move(MoveDirection.FORWARD);
        animalOutside.move(MoveDirection.FORWARD);
        animalOutside.move(MoveDirection.FORWARD);
        assertEquals("pozycja: (2,4) , orientacja: północ", animalOutside.toString());
        animalOutside.move(MoveDirection.RIGHT);
        animalOutside.move(MoveDirection.FORWARD);
        animalOutside.move(MoveDirection.FORWARD);
        animalOutside.move(MoveDirection.FORWARD);
        assertEquals("pozycja: (4,4) , orientacja: wschód", animalOutside.toString());
        animalOutside.move(MoveDirection.LEFT);
        for(int i = 0; i<10; i++){
            animalOutside.move(MoveDirection.BACKWARD);
        }
        assertEquals("pozycja: (4,0) , orientacja: północ", animalOutside.toString());
        animalOutside.move(MoveDirection.LEFT);
        for(int i = 0; i<10; i++){
            animalOutside.move(MoveDirection.FORWARD);
        }
        assertEquals("pozycja: (0,0) , orientacja: zachód", animalOutside.toString());
    }

    public boolean correctInput(String input) {
        switch (input) {
            case "f", "forward", "b", "backward", "l", "left", "r", "right":
                return true;
            default:
                return false;
        }
    }
    @Test
    public void inputTest(){
        String[] correctDirections = {"l", "left", "r", "forward", "b"};
        String[] wrongDirections = {"k", "leftt", "farward", "skos", "prawo", "lewo"};
        for(String text: correctDirections){
            assertTrue(correctInput(text));
        }
        for(String text: wrongDirections){
            assertFalse(correctInput(text));
        }
    }


}
