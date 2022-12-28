package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals ;
    protected Map<Vector2d, Grass> grasses;
    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public boolean place (Animal animal){
        Vector2d pos = animal.getPosition();
        if (!canMoveTo(pos)) {
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied!");
        }
        animals.put(pos, animal);
        mapBoundary.addPosition(pos);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return this.objectAt(position) != null;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){

        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    public Vector2d[] getBounds() {
        return mapBoundary.getBounds();
    }

}
