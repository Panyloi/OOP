package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IStepObserver {
    AbstractWorldMap map;
    Scene scene;
    Stage stage;
    GridPane grid;
    HBox buttonBox;
    SimulationEngine engine;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        buttonBox = new HBox();
        Button button = new Button("Start");
        TextField textField = new TextField();

        button.setOnAction(action ->{
            if (textField.getText().length() > 0) {
                MoveDirection[] directions = OptionsParser.parse(textField.getText().split(" "));
                engine.setDirections(directions);
            }
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        buttonBox.getChildren().addAll(button, textField);

        update();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update() throws FileNotFoundException{
        this.grid.setGridLinesVisible(false);
        this.grid.getColumnConstraints().clear();
        this.grid.getRowConstraints().clear();
        this.grid.getChildren().clear();
        this.grid.setGridLinesVisible(true);

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
                    IMapElement obj = (IMapElement) map.objectAt(position);

                    GuiElementBox guiElementBox = new GuiElementBox(obj);
                    VBox vBox = guiElementBox.getVBox();

                    grid.add(vBox, i + 1 - xLeft, yRight - j + 2 + yLeft);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        int ySize = 800;
        int xSize = 800;
//        int ySize = grid.getRowConstraints().size() * 40;
//        int xSize = grid.getColumnConstraints().size() * 40;
        VBox vBox = new VBox();
        vBox.getChildren().addAll(grid, buttonBox);

        scene = new Scene(vBox, xSize, ySize);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        // f b r l f f r r f f f f f f f f
        grid = new GridPane();
        try {
            MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
            engine = new SimulationEngine(directions, map, positions);
            engine.addObserver(this);

        }
        catch (IllegalArgumentException f){
            System.out.println(f);
        }
    }

    public void onStep() {
        try {
            Platform.runLater(() -> {
                try {
                    update();
                } catch (FileNotFoundException f) {
                    System.out.println("Error in loading files.");
                    f.printStackTrace();
                }
            });
            Thread.sleep(300);
        } catch (InterruptedException f) {
            System.out.println("Interruped");
            f.printStackTrace();
        }
    }
}
