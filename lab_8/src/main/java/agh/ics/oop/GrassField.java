package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    final private int amountOfGrass;

    //    final private List<Grass> grasses;
//    final private List<Animal> animals;
    public GrassField(int n) {
        this.amountOfGrass = n;
        grasses = new HashMap<>();
        animals = new HashMap<>();
//        RandomGenerator.setSeed(0x259B7F73);

        int limit = (int) Math.sqrt(n * 10);
        int i = 0;
        while (i < n) {
            int x = RandomGenerator.randint(0, limit);
            int y = RandomGenerator.randint(0, limit);
            Vector2d checkVector = new Vector2d(x, y);
            if (!this.isOccupied(checkVector)) {
                grasses.put(checkVector, new Grass(checkVector));
                this.mapBoundary.addPosition(checkVector);
                i++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = this.objectAt(position);
        return object == null || object instanceof Grass;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {
//            System.out.println("Ok grass" );
            return true;
        }
        for (Grass grass : grasses.values()) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        if (animals.containsKey(position)) {
            return animals.get(position);
        }

        if (grasses.containsKey(position)) {
            return grasses.get(position);
        }

        return null;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d[] bounds = this.mapBoundary.getBounds();
        return visualizer.draw(bounds[0], bounds[1]);
    }
}
