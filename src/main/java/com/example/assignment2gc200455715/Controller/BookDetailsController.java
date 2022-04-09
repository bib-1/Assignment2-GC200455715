package com.example.assignment2gc200455715.Controller;

import com.example.assignment2gc200455715.Models.Volume;
import com.example.assignment2gc200455715.Utility.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Arrays;


public class BookDetailsController {

    @FXML
    private Label lblSubtitle;

    @FXML
    private Label lblPageCount;

    @FXML
    private Label lblCategory;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblPublishedDate;

    @FXML
    private ImageView coverImageView;

    @FXML
    private Label title;

    @FXML
    private TextArea lblDescription;

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }

    public void loadDetails(Volume vol){
        lblDescription.setEditable(false);
        title.setText(vol.getTitle());

        String subTitle = vol.getSubtitle();
        String category = Arrays.toString(vol.getCategories());
        String author = Arrays.toString(vol.getAuthors());
        String publishedDate = vol.getPublishedDate();
        String pageCount = String.valueOf(vol.getPageCount());
        String description = vol.getDescription();

       lblDescription.setText(description);
       if(subTitle == null){
           lblSubtitle.setText("N/A");
       }
       else {
           lblSubtitle.setText(subTitle);
       }
       if(category.equals("null")){
           lblCategory.setText("N/A");
       }
       else{
           category = category.substring(1, category.length()-1);
           lblCategory.setText(category);
       }
       if(author.equals("null")){
           lblAuthor.setText("N/A");
       }
       else {
           author = author.substring(1,author.length()-1);
           lblAuthor.setText(author);
       }
       if(publishedDate == null){
           lblPublishedDate.setText("N/A");
       }
       else {
           lblPublishedDate.setText(publishedDate);
       }
        try{
            lblPageCount.setText("N/A");
        }
        catch (Exception e){
            lblPageCount.setText(pageCount);
        }


        try {
            coverImageView.setImage(new Image(vol.getImageLinks().toString()));
        }
        catch (IllegalArgumentException e)
        {
            coverImageView.setImage(new Image("http://errantscience.com/wp-content/uploads/Image-not-found.jpg"));
        }
    }
}
