package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}