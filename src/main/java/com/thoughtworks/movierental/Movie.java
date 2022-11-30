package com.thoughtworks.movierental;

public class Movie {

    private String title;
    private Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category arg) {
        category = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getRentalPrice(int daysRented) {
       return category.getRentalPrice(daysRented);
   }

    public int getFrequentRenterPoints(int daysRented) {
       return category.getFrequentRenterPoints(daysRented);
    }
}