package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for <b>" + getName() + "</b>\n";
        for (Rental rental : rentals) {
            //determine amounts for rental line
            double rentalPrice = rental.getRentalPrice();
            // add frequent renter points
            frequentRenterPoints += rental.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rentalPrice + "\n";
            totalAmount += rentalPrice;
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }


    public String htmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "<h1>Rental Record for " + getName() + "</h1>";
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            switch (each.getMovie().getCategory()) {
                case REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines result
        result += "Amount owed is <b>" + totalAmount + "</b>\n";
        result += "You earned <b>" + frequentRenterPoints
                + "</b> frequent renter points";
        return result;
    }
}

