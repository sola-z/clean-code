package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }



    public double getRentalPrice() {
        return getMovie().getRentalPrice(daysRented);
    }

    public int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }

}