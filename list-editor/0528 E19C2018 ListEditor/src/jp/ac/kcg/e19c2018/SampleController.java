package jp.ac.kcg.e19c2018;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class SampleController {

    @FXML
    private TextField tf;

    @FXML
    private ListView<String> lv;
    
    @FXML
    void initialize() {
    	lv.setCellFactory(TextFieldListCell.forListView());
    }

    @FXML
    void onAction(ActionEvent event) {
    	additem();
    }

    @FXML
    void onCommit(EditEvent<String> event) {
//    	initialize();
    	String newValue = event.getNewValue();
    	int index = event.getIndex();
    	updateItem(index, newValue);
		
    }
    
    private void updateItem(int index, String item) {
    	ObservableList <String> model = lv.getItems();
		String currentItem = model.get(index);
		if(model.contains(item)) {//check have duplicate item or not
			model.set(index, currentItem);
		}else if(item.trim().length() > 0){ //check item empty or not
			model.set(index, item);	
		}else {
			model.remove(index); //if empty delete list based on index
		}
    }
    
    void additem() {
		 ObservableList <String> model = lv.getItems();
		String input = tf.getText().trim();
		if( !input.equals("") && !model.contains(input)) { //Check input (empty and same item)
			model.add(tf.getText());
			tf.setText(""); //reset textfield		
		}else if (model.contains(input)) {
			tf.setText("");
		}
    }
    

}
