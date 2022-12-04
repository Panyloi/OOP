package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {
    @Test
    public void mainTest() {
        //Given
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});

        //when
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        //then
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        String output = engine.getFrame();

        assertEquals(output.strip(), """
             y\\x  0 1 2 3 4 5 6 7 8 9
             5: ---------------------
             4: | | | |N| | | | | | |
             3: | | | | | | | | | | |
             2: | | | | | | | | | | |
             1: | | | | | | | | | | |
             0: | | |S| | | | | | | |
            -1: ---------------------
           """.strip());
    }
    @Test
    public void placeTest(){
        //Given
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "f", "f", "f", "r", "r", "f", "f", "f"});

        //when
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2), new Vector2d(2,2) };

        //then
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        String output = engine.getFrame();

        assertEquals(output.strip(), """
             y\\x  0 1 2 3 4 5 6 7 8 9
             5: ---------------------
             4: | | | | | | | | | | |
             3: | | | | | | | | | | |
             2: | | | | | | | | | | |
             1: | | |S| | | | | | | |
             0: | | | | | | | | | | |
            -1: ---------------------
           """.strip());
    }
    @Test
    public void grassTest() {

        RandomGenerator.setSeed(0x259B7F73);

        MoveDirection[] directions = OptionsParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String output = engine.getFrame();

        assertEquals(output.strip(), """
             y\\x  0 1 2 3 4 5 6 7 8 9
             10: ---------------------
              9: | | | | | |*| | |*| |
              8: | | | | | | | | | | |
              7: | | | |N| | | |*| | |
              6: | |*| | | | | |*|*| |
              5: |*| | | | | | | | |*|
              4: | | | | | | | | |*| |
              3: | | | | | | | | | | |
              2: | | | | | | | | | | |
              1: | | |*| | | | | | | |
              0: | | | | | | | | | | |
             -1: | | |S| | | | | | | |
             -2: ---------------------
            """.strip());
    }
}
