package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    private final Vector2d leftLower;
    private final Vector2d rightUpper;
    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.leftLower = new Vector2d(0,0);
        this.rightUpper = new Vector2d(this.width-1, this.height-1);
        animals = new HashMap<>();
    }

    public Vector2d lowerLeft(){
        return leftLower;
    }
    public Vector2d upperRight(){
        return rightUpper;
    }


    @Override
    public boolean canMoveTo(Vector2d position){
        return position.follows(leftLower) && position.precedes(rightUpper) && !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals.values()){
            if (animal.getPosition().equals(position)) return true;
        }
        return false;
    }
//    public boolean place (Animal animal){
//        if (isOccupied(animal.getPosition())) return false;
//        animals.add(animal);
//        return true;
//    }
    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal: animals.values()){
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

//    public String toString(){
//        MapVisualizer visualizer = new MapVisualizer(this);
//        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width-1, height-1));
//    }
}
