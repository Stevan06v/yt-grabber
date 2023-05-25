package com.ytgrabber.model;
import java.io.File;
import java.net.URL;
import com.github.axet.vget.VGet;
public class YoutubeVideo {
    private String url;
    private static final String path = "C:\\Users\\steva\\Desktop\\Videos";
    public YoutubeVideo(String url) {
        this.url = url;
    }
    public void download(){
        try {
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return String.format("%s",this.url);
    }
}

