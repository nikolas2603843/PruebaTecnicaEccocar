package com.nicolas.eccocar.application.command;

import java.time.LocalDateTime;

public class CreateBookingCommand {
/* tipado de lo que se va a insertar en db crear una reserva (solo tipado) */
    private String nameCustomer;
    private LocalDateTime date;
    private String description;

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}