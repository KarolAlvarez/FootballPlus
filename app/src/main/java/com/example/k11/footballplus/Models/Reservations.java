package com.example.k11.footballplus.Models;

/**
 * Created by k11 on 29/11/17.
 */

public class Reservations {
private int idReservations,phoneCampReservation;
private String nameCampReservation,startTimeReservation,
        endTimeResrvation,dateReservation,addresCampReservation;

    public int getIdReservations() {
        return idReservations;
    }

    public void setIdReservations(int idReservations) {
        this.idReservations = idReservations;
    }

    public int getPhoneCampReservation() {
        return phoneCampReservation;
    }

    public void setPhoneCampReservation(int phoneCampReservation) {
        this.phoneCampReservation = phoneCampReservation;
    }

    public String getNameCampReservation() {
        return nameCampReservation;
    }

    public void setNameCampReservation(String nameCampReservation) {
        this.nameCampReservation = nameCampReservation;
    }

    public String getStartTimeReservation() {
        return startTimeReservation;
    }

    public void setStartTimeReservation(String startTimeReservation) {
        this.startTimeReservation = startTimeReservation;
    }

    public String getEndTimeResrvation() {
        return endTimeResrvation;
    }

    public void setEndTimeResrvation(String endTimeResrvation) {
        this.endTimeResrvation = endTimeResrvation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getAddresCampReservation() {
        return addresCampReservation;
    }

    public void setAddresCampReservation(String addresCampReservation) {
        this.addresCampReservation = addresCampReservation;
    }
}
