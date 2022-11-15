package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private final Vector2d leftLower;
    private final Vector2d rightUpper;
    private final List<Animal> animals;
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.leftLower = new Vector2d(0,0);
        this.rightUpper = new Vector2d(this.width-1, this.height-1);
        this.animals = new ArrayList<>();
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(leftLower) && position.precedes(rightUpper) && !isOccupied(position);
    }
    @Override
    public boolean place (Animal animal){
        if (isOccupied(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals){
            if (animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal: animals){
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width-1, height-1));
    }
}
