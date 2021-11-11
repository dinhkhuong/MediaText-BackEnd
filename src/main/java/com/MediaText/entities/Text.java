package com.MediaText.entities;

import javax.persistence.*;

//text entity
@Entity
@Table(name = "text")
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "artist")
    private String artist;

    @Column(name = "category")
    private String category;

    @Column(name = "source")
    private String source;

    public Text(){}

    public Text(String toContent, String toArtist, String toCategory, String toSource){
        this.content = toContent;
        this.artist = toArtist;
        this.category = toCategory;
        this.source = toSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
