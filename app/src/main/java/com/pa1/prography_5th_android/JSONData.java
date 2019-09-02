package com.pa1.prography_5th_android;

public class JSONData {
    private int num;
    private String id;
    private String title;
    private String director;
    private String release_date;
    private String description;
    private String producer;
    private int rt_score;

    public int getNum() { return num; }

    public void setNum(int num) { this.num = num; }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getRt_score() {
        return rt_score;
    }

    public void setRt_score(int rt_score) {
        this.rt_score = rt_score;
    }
}
