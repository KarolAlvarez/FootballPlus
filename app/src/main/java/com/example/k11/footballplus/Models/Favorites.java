package com.example.k11.footballplus.Models;

/**
 * Created by k11 on 29/11/17.
 */

public class Favorites {
    private Integer idFavorite, idUser, idCamp;
    private String nameCamp, descriptionCamp, imageCamp;

    public Integer getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(Integer idFavorite) {
        this.idFavorite = idFavorite;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCamp() {
        return idCamp;
    }

    public void setIdCamp(Integer idCamp) {
        this.idCamp = idCamp;
    }

    public String getNameCamp() {
        return nameCamp;
    }

    public void setNameCamp(String nameCamp) {
        this.nameCamp = nameCamp;
    }

    public String getDescriptionCamp() {
        return descriptionCamp;
    }

    public void setDescriptionCamp(String descriptionCamp) {
        this.descriptionCamp = descriptionCamp;
    }

    public String getImageCamp() {
        return imageCamp;
    }

    public void setImageCamp(String imageCamp) {
        this.imageCamp = imageCamp;
    }
}
