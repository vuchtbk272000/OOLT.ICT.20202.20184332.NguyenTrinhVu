package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	@FXML
	private ToggleGroup tools;
	@FXML
	private RadioButton rbPencil;
	@FXML
	private RadioButton rbEraser;
	  

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
//	Color color = new Color.BLACK;
		Circle newCircle = new Circle(event.getX(), event.getY(), 4.0);
		if (rbPencil.isSelected()) {
			newCircle.setStroke(Color.BLACK);
			newCircle.setFill(Color.BLACK);
		}
		else if(rbEraser.isSelected()) {
			newCircle.setStroke(Color.WHITE);
			newCircle.setFill(Color.WHITE);
		}
	   	drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	void clearButtonPressed(ActionEvent event) {
	   	drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseClicked(MouseEvent event) {
	   	Circle newCircle = new Circle(event.getX(), event.getY(), 4.0);
	   	if (rbPencil.isSelected()) {
			newCircle.setStroke(Color.BLACK);
			newCircle.setFill(Color.BLACK);
	   	}
		else {
			newCircle.setStroke(Color.WHITE);
			newCircle.setFill(Color.WHITE);
		}
	   	drawingAreaPane.getChildren().add(newCircle);
	}
	
	
	    
}
