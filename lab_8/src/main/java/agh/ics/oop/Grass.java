package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {


    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/grass.png";
    }

    public String toString(){
        return "*";
    }

}
