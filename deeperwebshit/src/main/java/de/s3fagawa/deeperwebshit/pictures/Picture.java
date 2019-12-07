package de.s3fagawa.deeperwebshit.pictures;
/**
 * Klasse welche Objekt darstellt, dasss persistiert wird.
 * DB ist inmemory.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Picture {
    @Id
    @GeneratedValue
    private Long id;                //id wichtig für Datenbank
    @Lob
    @JsonIgnore
    private byte[] pictureArray;    //Pic wird als byte persistiert
    @ManyToOne
    private Set<Comment> comments;  //beliebige Anzahl von Kommentaren

    private int likes;
    private int dislikes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPictureArray() {
        return pictureArray;
    }

    public void setPictureArray(byte[] pictureArray) {
        this.pictureArray = pictureArray;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
