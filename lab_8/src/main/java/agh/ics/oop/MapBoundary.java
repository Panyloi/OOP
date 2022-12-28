package agh.ics.oop;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
public class MapBoundary implements IPositionChangeObserver{
    private SortedSet<Vector2d> xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    private SortedSet<Vector2d> yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public void addPosition(Vector2d position) {
        xAxis.add(position);
        yAxis.add(position);
    }

    public void removePosition(Vector2d position){
        xAxis.remove(position);
        yAxis.remove(position);
    }

    public Vector2d getUpperRight(){
        return xAxis.last().upperRight(yAxis.last());
    }

    public Vector2d getLowerLeft(){
        return xAxis.first().lowerLeft(yAxis.first());
    }

    public Vector2d[] getBounds(){
        return new Vector2d[] {this.getLowerLeft(), this.getUpperRight()};
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.removePosition(oldPosition);
        this.addPosition(newPosition);
    }
}
