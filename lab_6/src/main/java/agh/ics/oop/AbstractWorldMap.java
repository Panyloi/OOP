package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals ;
    protected Map<Vector2d, Grass> grasses;

    public abstract Vector2d upperRight();
    public abstract Vector2d lowerLeft();

    @Override
    public boolean place (Animal animal){
        if (this.isOccupied(animal.getPosition())) {
//            System.out.println("Wykonało się :" );
//            System.out.println(this.isOccupied(animal.getPosition()));
            return false;
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if (animals.get(position) != null) {
//            System.out.println("Ok abstract" );
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft(), upperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){

        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }
}
