/**
 * UserFree Class
 * 
 * Represents a free user in the application.
 */
package model;

import java.util.Calendar;

public class UserFree extends User {
    private boolean isWinSurprise;
    private boolean adds = true;
    
    /**
     * UserFree Constructor
     * 
     * Initializes a new instance of the UserFree class with the specified parameters.
     * 
     * @param name The name of the user.
     * @param id The ID of the user.
     * @param date The registration date of the user.
     * @param email The email address of the user.
     */
    public UserFree(String name, String id, Calendar date, String email) {
        super(name, id, date, email);
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
        
        if (letter == getName().charAt(0)) {
            message = getName() + " You have won a free day without ads!!";
        } else {
            message = "Nobody wins";
        }
        
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
     * setWinSurprise Method
     * 
     * Sets whether the user has won a surprise.
     * 
     * @param b The boolean value indicating whether the user has won a surprise.
     */
    public void setWinSurprise(boolean b) {
        this.isWinSurprise = b;
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
     * isAdds Method
     * 
     * Checks if the user has ads enabled.
     * 
     * @return True if the user has ads enabled, false otherwise.
     */
    public boolean isAdds() {
        return adds;
    }
    
    /**
     * setAdds Method
     * 
     * Sets whether the user has ads enabled.
     * 
     * @param adds The boolean value indicating whether the user has ads enabled.
     */
    public void setAdds(boolean adds) {
        this.adds = adds;
    }
}
