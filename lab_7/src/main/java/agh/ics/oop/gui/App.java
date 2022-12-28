package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class App extends Application {
    AbstractWorldMap map;
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        Label label = new Label("y\\x");
        GridPane.setHalignment(label, HPos.CENTER);
        grid.add(label, 0 , 0);

        grid.getColumnConstraints().add(new ColumnConstraints(40));
        grid.getRowConstraints().add(new RowConstraints(40));

        Vector2d[] boundary = map.getBounds();

        int xLeft = boundary[0].x;
        int yLeft = boundary[0].y;
        int xRight = boundary[1].x;
        int yRight = boundary[1].y;

        int count = 1 ;
        for (int i = xLeft; i <= xRight; i++){
            label = new Label(String.valueOf(i));
            grid.add(label, count, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
            count ++;
        }
        count = 1;
        for (int i = yRight; i >= yLeft; i--){
            label = new Label(String.valueOf(i));
            grid.add(label, 0, count);
            grid.getRowConstraints().add(new RowConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
            count ++;
        }


        for (int i = xLeft; i<= xRight; i++){
            for (int j = yRight; j >= yLeft; j--){
                Vector2d position = new Vector2d(i, j);
                if (map.isOccupied(position)){
                    Object object = map.objectAt(position);
                    label = new Label(object.toString());
                    label.setFont(new Font(30));
                    grid.add(label, i + 1 - xLeft, yRight - j + 2 + yLeft);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

    int ySize = grid.getRowConstraints().size() * 40;
    int xSize = grid.getColumnConstraints().size() * 40;
    Scene scene = new Scene(grid, xSize, ySize);
    primaryStage.setScene(scene);
    primaryStage.show();

    }

    @Override
    public void init() {
        try {
            MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

        }
        catch (IllegalArgumentException f){
            System.out.println(f);
        }
    }
}
