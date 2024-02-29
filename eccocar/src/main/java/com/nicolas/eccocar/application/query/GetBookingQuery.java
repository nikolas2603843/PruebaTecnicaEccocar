package com.nicolas.eccocar.application.query;


public class GetBookingQuery {

    private final Long id;

    public GetBookingQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
