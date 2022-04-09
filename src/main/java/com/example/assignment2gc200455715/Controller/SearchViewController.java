package com.example.assignment2gc200455715.Controller;

import com.example.assignment2gc200455715.Models.BookDetails;
import com.example.assignment2gc200455715.Models.Item;
import com.example.assignment2gc200455715.Models.Volume;
import com.example.assignment2gc200455715.Utility.APIUtility;
import com.example.assignment2gc200455715.Utility.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ListView<Volume> resultListView;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private ImageView imageView;

    //Following block of code runs after the search button is clicked.
    @FXML
    void searchBooks(ActionEvent event){
        imageView.setVisible(false);
        if( searchTextField.getText() != ""){
            BookDetails bd = APIUtility.getBookDetails(searchTextField.getText().trim());
            resultListView.getItems().clear();
            for (Item i :bd.getItems() ){
                resultListView.getItems().add(i.getVolumeInfo());
            }
            if(bd.getTotalItems() ==0){
                msgLabel.setText("No books found with this keyword");
            }
            else{
                msgLabel.setText("Top 10 results under the keyword '" + searchTextField.getText().trim()+"'.");
            }
        }
        else{
            msgLabel.setText("Please enter the key work to search");
        }
    }

    @FXML
    void getBookDetail(ActionEvent event) throws IOException {
        Volume selectedVolume = resultListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "book-details.fxml", selectedVolume);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldBookSelected, newBookSelected) -> {
                    imageView.setVisible(true);
                    try {
                        imageView.setImage(new Image(newBookSelected.getImageLinks().toString()));
                    }
                    catch (IllegalArgumentException e)
                    {
                        imageView.setImage(new Image("http://errantscience.com/wp-content/uploads/Image-not-found.jpg"));
                    }
                });
    }
}
