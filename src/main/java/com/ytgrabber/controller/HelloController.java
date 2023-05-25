package com.ytgrabber.controller;

import com.ytgrabber.model.YoutubeVideo;
import com.ytgrabber.model.YoutubeVideoList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button addBtn;
    @FXML
    private Button downloadBtn;
    @FXML
    private Button fileSelection;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField ytTxtField;
    @FXML
    private ListView<YoutubeVideo> lvYtVideos;
    private FilteredList<YoutubeVideo> videos;
    private YoutubeVideoList youtubeVideoList;

    @FXML
    void initialize(){
        this.youtubeVideoList = YoutubeVideoList.getInstance();
        this.videos = new FilteredList<>(this.youtubeVideoList.getVideos());

        this.lvYtVideos.setItems(this.videos);

    }

    @FXML
    void addVideo(ActionEvent event) {
        String url = ytTxtField.getText();
        this.youtubeVideoList.addVideo(url);


    }

    @FXML
    void downloadVideos(ActionEvent event) {
        try{
            this.youtubeVideoList.download();
        }catch (Exception err){
            System.out.println("Error caused: " + err);
        }
    }

    @FXML
    void selectFile(ActionEvent event) {

    }
}