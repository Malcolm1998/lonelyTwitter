package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malcolmmacarthur on 2018-01-19.
 */

public abstract class NeutralMood {
    private Date date;

    NeutralMood (){
        this.date = new Date();
    }

    NeutralMood (Date date){
        this.date = date;
    }

    Date getDate(){
        return this.date;
    }

    void setDate(Date date){
        this.date = date;
    }

    public String CurrentMood() { return "Neutral";}

    public abstract String wantTo();
}
