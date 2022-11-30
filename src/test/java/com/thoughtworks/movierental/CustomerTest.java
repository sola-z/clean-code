package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testStatement() {
        Customer customer = new Customer("Ying");
        customer.addRental(new Rental(new Movie("Kingkong 1", Category.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Kingkong 2", Category.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Kingkong 3", Category.CHILDRENS), 10));
//        System.out.println(customer.statement());
        String statement = "Rental Record for <b>Ying</b>\n" +
                "\tKingkong 1\t3.5\n" +
                "\tKingkong 2\t3.0\n" +
                "\tKingkong 3\t12.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 3 frequent renter points";
        Assert.assertEquals(statement, customer.statement());
    }


}