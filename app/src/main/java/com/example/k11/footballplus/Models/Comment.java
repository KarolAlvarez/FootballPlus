package com.example.k11.footballplus.Models;

/**
 * Created by k11 on 29/11/17.
 */

public class Comment {

    private int idComment,idUserComment,idCampComment;
    private String titleCommnet, DescriptionComment;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUserComment() {
        return idUserComment;
    }

    public void setIdUserComment(int idUserComment) {
        this.idUserComment = idUserComment;
    }

    public int getIdCampComment() {
        return idCampComment;
    }

    public void setIdCampComment(int idCampComment) {
        this.idCampComment = idCampComment;
    }

    public String getTitleCommnet() {
        return titleCommnet;
    }

    public void setTitleCommnet(String titleCommnet) {
        this.titleCommnet = titleCommnet;
    }

    public String getDescriptionComment() {
        return DescriptionComment;
    }

    public void setDescriptionComment(String descriptionComment) {
        DescriptionComment = descriptionComment;
    }
}
