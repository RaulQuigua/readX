package model;

import java.util.Calendar;

/**
 * Class representing a book, which is a type of bibliography product.
 */
public class Book extends BibliographyProduct {
    private String review;
    private int gender;
    private String frontPage;
    private int sales;
    private int readPages;

    /**
     * Constructor for the Book class.
     *
     * @param name      The name of the book.
     * @param date      The publication date of the book.
     * @param numPages  The number of pages of the book.
     * @param review    The review of the book.
     * @param value     The value of the book.
     * @param id        The identifier of the book.
     * @param gender    The gender of the book.
     * @param frontPage The front page of the book.
     */
    public Book(String name, Calendar date, int numPages, String review, int value, String id, int gender, String frontPage) {
        super(name, date, numPages, value, id);
        this.review = review;
        this.gender = gender;
        this.frontPage = frontPage;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A string representation of the book.
     */
    @Override
    public String toString() {
        return super.toString() + "* Review: " + review + " \n " +
                "* Gender: " + gender + " \n " +
                "* frontPage:" + frontPage;
    }

    /**
     * Returns the name of the book.
     *
     * @return The name of the book.
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Returns the sales of the book.
     *
     * @return The sales of the book.
     */
    public int getSales() {
        return sales;
    }

    /**
     * Sets the sales of the book.
     *
     * @param sales The sales of the book.
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * Returns the number of read pages of the book.
     *
     * @return The number of read pages of the book.
     */
    public int getReadPages() {
        return readPages;
    }

    /**
     * Sets the number of read pages of the book.
     *
     * @param readPages The number of read pages of the book.
     */
    public void setReadPages(int readPages) {
        this.readPages = readPages;
    }
}

