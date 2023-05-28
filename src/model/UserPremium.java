/**
 * UserPremium Class
 * 
 * Represents a premium user in the application.
 */
package model;

import java.util.Calendar;

public class UserPremium extends User {
    private String nickname;
    private String avatar;
    private String creditCard;
    private int lastMonthPay;
    private double[] payment;
    private final double pay;
    private boolean isWinSurprise = false;
    
    /**
     * UserPremium Constructor
     * 
     * Initializes a new instance of the UserPremium class with the specified parameters.
     * 
     * @param name The name of the user.
     * @param id The ID of the user.
     * @param date The registration date of the user.
     * @param email The email address of the user.
     * @param nickname The nickname of the user.
     * @param avatar The avatar of the user.
     * @param creditCard The credit card information of the user.
     */
    public UserPremium(String name, String id, Calendar date, String email, String nickname, String avatar, String creditCard) {
        super(name, id, date, email);
        this.nickname = nickname;
        this.avatar = avatar;
        this.creditCard = creditCard;
        this.lastMonthPay = super.getDate().get(Calendar.MONTH);
        this.payment = new double[12];
        this.pay = 15000;
    }
    
    /**
     * surprise Method
     * 
     * Generates a surprise message for the user based on a given integer and letter.
     * 
     * @param i The integer value.
     * @param letter The letter value.
     * @return The generated surprise message.
     */
    public String surprise(int i, char letter) {
        String message = "";
        
        if (payment[i] != 0) {
            message = getName() + " You have won a free Spotify month!!";
        } else {
            message = "Nobody wins :cccccc";
        }
        
        return message;
    }
    
    /**
     * generatepay Method
     * 
     * Generates the payment information for the user.
     * 
     * @param pay The payment amount.
     * @return The payment information.
     */
    public String generatepay(double pay) {
        payment[lastMonthPay - 1] = pay;
        String message = "You have to pay: " + payment[lastMonthPay - 1] + " this month";
        return message;
    }
    
    /**
     * getId Method
     * 
     * Retrieves the ID of the user.
     * 
     * @return The ID of the user.
     */
    @Override
    public String getId() {
        return super.getId();
    }
    
    /**
     * getNickname Method
     * 
     * Retrieves the nickname of the user.
     * 
     * @return The nickname of the user.
     */
    public String getNickname() {
        return nickname;
    }
    
    /**
     * setNickname Method
     * 
     * Sets the nickname of the user.
     * 
     * @param nickname The nickname of the user.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * getAvatar Method
     * 
     * Retrieves the avatar of the user.
     * 
     * @return The avatar of the user.
     */
    public String getAvatar() {
        return avatar;
    }
    
    /**
     * setAvatar Method
     * 
     * Sets the avatar of the user.
     * 
     * @param avatar The avatar of the user.
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    /**
     * getCreditCard Method
     * 
     * Retrieves the credit card information of the user.
     * 
     * @return The credit card information of the user.
     */
    public String getCreditCard() {
        return creditCard;
    }
    
    /**
     * setCreditCard Method
     * 
     * Sets the credit card information of the user.
     * 
     * @param creditCard The credit card information of the user.
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    
    /**
     * getLastMonthPay Method
     * 
     * Retrieves the last month's payment for the user.
     * 
     * @return The last month's payment for the user.
     */
    public int getLastMonthPay() {
        return lastMonthPay;
    }
    
    /**
     * setLastPay Method
     * 
     * Sets the last month's payment for the user.
     * 
     * @param lastMonthPay The last month's payment for the user.
     */
    public void setLastPay(int lastMonthPay) {
        this.lastMonthPay = lastMonthPay;
    }
    
    /**
     * getPayment Method
     * 
     * Retrieves the payment history of the user.
     * 
     * @return The payment history of the user.
     */
    public double[] getPayment() {
        return payment;
    }
    
    /**
     * setPayment Method
     * 
     * Sets the payment history of the user.
     * 
     * @param payment The payment history of the user.
     */
    public void setPayment(double[] payment) {
        this.payment = payment;
    }
    
    /**
     * getPay Method
     * 
     * Retrieves the monthly payment amount for the user.
     * 
     * @return The monthly payment amount for the user.
     */
    public double getPay() {
        return pay;
    }
    
    /**
     * isWinSurprise Method
     * 
     * Checks if the user has won a surprise.
     * 
     * @return True if the user has won a surprise, false otherwise.
     */
    public boolean isWinSurprise() {
        return isWinSurprise;
    }
    
    /**
     * setWinSurprise Method
     * 
     * Sets whether the user has won a surprise.
     * 
     * @param isWinSurprise The boolean value indicating whether the user has won a surprise.
     */
    public void setWinSurprise(boolean isWinSurprise) {
        this.isWinSurprise = isWinSurprise;
    }
}

