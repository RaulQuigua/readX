package model;

import java.util.Calendar;

public class UserCritical extends UserPremium{
    private String area;
    private int CriticsCount;
    private String blog;

    public UserCritical(String name, String id, Calendar date, String email, String nickname, String avatar, String creditCard, String area, int CriticsCount, String blog) {
        super(name, id, date, email, nickname ,avatar, creditCard);
        this.area = area;
        this.CriticsCount = CriticsCount;
        this.blog = blog;
    }
    
    public String surprise(int i, char letter){
        String message = "";
        if(CriticsCount>i){
            message = getName()+" You have win a travel to San Andres Island";
        } else {
            message = "Nobody wins!";
        }
        return message;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCriticsCount() {
        return CriticsCount;
    }

    public void setCriticsCount(int criticsCount) {
        CriticsCount = criticsCount;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}

