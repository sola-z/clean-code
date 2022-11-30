package com.thoughtworks.movierental;

public enum Category {
    CHILDRENS {
        @Override
        double getRentalPrice(int daysRented) {
            double price = 1.5;
            if (daysRented > 3)
                price += (daysRented - 3) * 1.5;
            return price;
        }
    },
    REGULAR {
        @Override
        double getRentalPrice(int daysRented) {
            double price = 2;
            if (daysRented > 2)
                price += (daysRented - 2) * 1.5;
            return price;
        }
    }, NEW_RELEASE {
        @Override
        double getRentalPrice(int daysRented) {
            return daysRented * 3;
        }
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            if (daysRented > 1)  return 2;
            return 1;
        }
    };

    abstract double getRentalPrice(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}