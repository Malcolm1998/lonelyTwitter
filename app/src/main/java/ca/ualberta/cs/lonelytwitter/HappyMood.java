package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malcolmmacarthur on 2018-01-19.
 */

public class HappyMood extends NeutralMood {

    HappyMood () {super();}
    HappyMood (Date date) {super(date);}

    @Override
    public String CurrentMood() { return "Happy";}

    @Override
    public String wantTo() {return "jump with joy";}
}
