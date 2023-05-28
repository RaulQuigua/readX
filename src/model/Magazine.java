package model;

import java.util.Calendar;

/**
 * Class representing a magazine, which is a type of bibliography product.
 */
public class Magazine extends BibliographyProduct {
    private String category;
    private int valueSubscription;
    private int issuancePeriodicity;
    private int activeSubscriptions;
    private int readPages;

    /**
     * Constructor for the Magazine class.
     *
     * @param name                The name of the magazine.
     * @param date                The publication date of the magazine.
     * @param numPages            The number of pages of the magazine.
     * @param value               The value of the magazine.
     * @param id                  The identifier of the magazine.
     * @param issuancePeriodicity The issuance periodicity of the magazine.
     */
    public Magazine(String name, Calendar date, int numPages, int value, String id, int issuancePeriodicity) {
        super(name, date, numPages, value, id);
        this.issuancePeriodicity = issuancePeriodicity;
    }

    /**
     * Returns the name of the magazine.
     *
     * @return The name of the magazine.
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Returns the category of the magazine.
     *
     * @return The category of the magazine.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the magazine.
     *
     * @param category The category of the magazine.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the value of the magazine subscription.
     *
     * @return The value of the magazine subscription.
     */
    public int getValueSubscription() {
        return valueSubscription;
    }

    /**
     * Sets the value of the magazine subscription.
     *
     * @param valueSubscription The value of the magazine subscription.
     */
    public void setValueSubscription(int valueSubscription) {
        this.valueSubscription = valueSubscription;
    }

    /**
     * Returns the issuance periodicity of the magazine.
     *
     * @return The issuance periodicity of the magazine.
     */
    public int getIssuancePeriodicity() {
        return issuancePeriodicity;
    }

    /**
     * Sets the issuance periodicity of the magazine.
     *
     * @param issuancePeriodicity The issuance periodicity of the magazine.
     */
    public void setIssuancePeriodicity(int issuancePeriodicity) {
        this.issuancePeriodicity = issuancePeriodicity;
    }

    /**
     * Returns the number of active subscriptions of the magazine.
     *
     * @return The number of active subscriptions of the magazine.
     */
    public int getActiveSubscriptions() {
        return activeSubscriptions;
    }

    /**
     * Sets the number of active subscriptions of the magazine.
     *
     * @param activeSubscriptions The number of active subscriptions of the magazine.
     */
    public void setActiveSubscriptions(int activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }

    /**
     * Returns the number of read pages of the magazine.
     *
     * @return The number of read pages of the magazine.
     */
    public int getReadPages() {
        return readPages;
    }

    /**
     * Sets the number of read pages of the magazine.
     *
     * @param readPages The number of read pages of the magazine.
     */
    public void setReadPages(int readPages) {
        this.readPages = readPages;
    }
}

