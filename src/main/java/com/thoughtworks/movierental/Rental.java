package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

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
        double price = 0;
        switch (this.getMovie().getCategory()) {
            case Movie.REGULAR:
                if (this.getDaysRented() > 2)
                    price += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                price += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                price += 1.5;
                if (this.getDaysRented() > 3)
                    price += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return price;
    }
}