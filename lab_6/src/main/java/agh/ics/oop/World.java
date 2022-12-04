package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
//        Map<Vector2d, Integer> animals  = new HashMap<>();
//        animals.put(new Vector2d(2,2) , 3);
//        System.out.println(animals.get(new Vector2d(2,3)));
    }
}