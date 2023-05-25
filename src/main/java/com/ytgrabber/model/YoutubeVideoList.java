package com.ytgrabber.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.PixelReader;

import java.util.LinkedList;

public class YoutubeVideoList {
    private static YoutubeVideoList instance;
    private ObservableList<YoutubeVideo> videos;

    private YoutubeVideoList(){
        this.videos = FXCollections.observableList(new LinkedList<>());
    }

    public static synchronized YoutubeVideoList getInstance(){
        if(instance == null){
            instance = new YoutubeVideoList();
        }
        return instance;
    }

    public void addVideo(String url){
        YoutubeVideo youtubeVideo = new YoutubeVideo(url);
        this.videos.add(youtubeVideo);
    }

    public void download(){
        this.videos.forEach(YoutubeVideo::download);
    }

    public ObservableList<YoutubeVideo> getVideos(){
        return FXCollections.unmodifiableObservableList(this.videos);
    }

}
