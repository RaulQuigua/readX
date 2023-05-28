package model;

import java.util.Calendar;

/**
 * Class representing a bibliography product.
 */
public class BibliographyProduct {
    private String name;
    private Calendar date;
    private int numPages;
    private int value;
    private String id;

    /**
     * Constructor for the BibliographyProduct class.
     *
     * @param name     The name of the bibliography product.
     * @param date     The publication date of the bibliography product.
     * @param numPages The number of pages of the bibliography product.
     * @param value    The value of the bibliography product.
     * @param id       The identifier of the bibliography product.
     */
    public BibliographyProduct(String name, Calendar date, int numPages, int value, String id) {
        this.name = name;
        this.date = date;
        this.numPages = numPages;
        this.value = value;
        this.id = id;
    }

    /**
     * Returns the name of the bibliography product.
     *
     * @return The name of the bibliography product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the bibliography product.
     *
     * @param name The name of the bibliography product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the publication date of the bibliography product.
     *
     * @return The publication date of the bibliography product.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Sets the publication date of the bibliography product.
     *
     * @param date The publication date of the bibliography product.
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Returns the number of pages of the bibliography product.
     *
     * @return The number of pages of the bibliography product.
     */
    public int getNumPages() {
        return numPages;
    }

    /**
     * Sets the number of pages of the bibliography product.
     *
     * @param numPages The number of pages of the bibliography product.
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * Returns the value of the bibliography product.
     *
     * @return The value of the bibliography product.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the bibliography product.
     *
     * @param value The value of the bibliography product.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the bibliography product.
     *
     * @return A string representation of the bibliography product.
     */
    @Override
    public String toString() {
        return " \n " + "BibliographyProduct" + " \n " +
                "* name: " + name + " \n " +
                "* date: " + date + " \n " +
                "* numPages: " + numPages + " \n " +
                "* value: " + value + " \n ";
    }

    /**
     * Returns the identifier of the bibliography product.
     *
     * @return The identifier of the bibliography product.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the identifier of the bibliography product.
     *
     * @param id The identifier of the bibliography product.
     */
    public void setId(String id) {
        this.id = id;
    }
}

