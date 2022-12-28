package agh.ics.oop.gui;
import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private Image image;
    private ImageView imageView;
    private VBox vBox;
    private Label label;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getImagePath()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        if (element instanceof Animal){
            label = new Label("Z" + element.getPosition().toString());
        }
        else {
            label = new Label("Trawa");
        }
        GridPane.setHalignment(imageView, HPos.CENTER);
        GridPane.setHalignment(label, HPos.CENTER);
        vBox = new VBox();
        vBox.getChildren().addAll(imageView, label);
        GridPane.setHalignment(vBox, HPos.CENTER);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getVBox(){
        return this.vBox;
    }
}
