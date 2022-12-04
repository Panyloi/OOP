package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<Animal>();
    protected List<Grass> grasses = new ArrayList<Grass>();

    public abstract Vector2d upperRight();
    public abstract Vector2d lowerLeft();

    public boolean place (Animal animal){
        if (isOccupied(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){

        for (Animal animal: animals){
            if (animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){

        for (Animal animal : animals){
            if (animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft(), upperRight());
    }
}
