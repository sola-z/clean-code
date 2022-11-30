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
       double price = 0;
       switch (category) {
           case REGULAR:
               price += 2;
               if (daysRented > 2)
                   price += (daysRented - 2) * 1.5;
               break;
           case NEW_RELEASE:
               price += daysRented * 3;
               break;
           case CHILDRENS:
               price += 1.5;
               if (daysRented > 3)
                   price += (daysRented - 3) * 1.5;
               break;
       }
       return price;
   }

    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((category == Category.NEW_RELEASE)
                &&
                daysRented > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }
}