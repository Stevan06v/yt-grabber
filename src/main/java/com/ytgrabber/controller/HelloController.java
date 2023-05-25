package com.ytgrabber.controller;

import com.ytgrabber.model.YoutubeVideo;
import com.ytgrabber.model.YoutubeVideoList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Button deleteBtn;
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

        progressBar.setProgress(0.5);

        this.lvYtVideos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<YoutubeVideo>() {
            @Override
            public void changed(ObservableValue<? extends YoutubeVideo> observableValue, YoutubeVideo from, YoutubeVideo to) {
                if(to == null){
                    deleteBtn.setDisable(true);
                }else{
                    deleteBtn.setDisable(false);
                }
            }
        });

        this.lvYtVideos.setItems(this.videos);
    }

    @FXML
    void addVideo(ActionEvent event) {
        String url = ytTxtField.getText();
        this.youtubeVideoList.addVideo(url);
    }
    @FXML
    public void deleteVideos(ActionEvent actionEvent) {
        int selectedIdx = this.lvYtVideos.getSelectionModel().getSelectedIndex();
        this.youtubeVideoList.delete(selectedIdx);
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