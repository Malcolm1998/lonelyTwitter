package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malcolmmacarthur on 2018-01-19.
 */

public class SadMood extends NeutralMood {

    SadMood () {super();}
    SadMood (Date date) {super(date);}

    @Override
    public String CurrentMood() { return "Sad";}

    @Override
    public String wantTo() {return "sulk";}
}
