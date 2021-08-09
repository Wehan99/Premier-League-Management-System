import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Match implements Serializable {
    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private Date date;



    public Match(String club1Name, String club2Name, int team1Goals, int team2Goals, Date matchDate) {
        this.team1=club1Name;
        this.team2=club2Name;                                       //creating constructor
        this.team1Score=team1Goals;
        this.team2Score=team2Goals;
        this.date=matchDate;

    }


    public String getTeam1(){
        return team1;
    }               //get and set methods
    public String getTeam2(){
        return team2;
    }

    public int getTeam1Score(){
        return team1Score;
    }
    public int getTeam2Score(){
        return team2Score;
    }

    public Date getDate(){
        return date;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    }







