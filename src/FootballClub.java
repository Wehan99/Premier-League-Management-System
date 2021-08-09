public class FootballClub extends SportsClub implements Comparable<FootballClub>{
    private int noOfWins;
    private int noOfDefeats;
    private int noOfDraws;
    private int noOfGoals;
    private int noOfPoints;
    private int noOfPlayedMatches;
    private String achieves;
    private int receivedGoals;




    public FootballClub(String clubName, String clubLocation, int noOfDefeats, int noOfDraws, int noOfGoals, int receivedGoals, int noOfPlayedMatches,
                        int noOfPoints, int noOfWins, String achieves) {
        super(clubName, clubLocation);
        this.noOfWins=noOfWins;
        this.noOfDefeats=noOfDefeats;
        this.noOfDraws=noOfDraws;
        this.noOfGoals=noOfGoals;
        this.noOfPoints=noOfPoints;
        this.noOfPlayedMatches=noOfPlayedMatches;
        this.achieves=achieves;
        this.receivedGoals=receivedGoals;

    }

    public FootballClub() {
        super();
    }





    public FootballClub(String clubName, int noOfPlayedMatches, int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoals, int receivedGoals, int noOfPoints) {
        super(clubName);
        this.noOfWins=noOfWins;
        this.noOfDefeats=noOfDefeats;                                       //creating constructor
        this.noOfDraws=noOfDraws;
        this.noOfGoals=noOfGoals;
        this.noOfPoints=noOfPoints;
        this.noOfPlayedMatches=noOfPlayedMatches;
        this.receivedGoals=receivedGoals;
    }

    public int getNoOfWins() {
        return noOfWins;
    }
                                                                                    //get and set methods
    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPlayedMatches(int noOfPlayedMatches) {
        this.noOfPlayedMatches = noOfPlayedMatches;
    }

    public int getNoOfPlayedMatches() {
        return noOfPlayedMatches;
    }

    public String getAchieves() {
        return achieves;
    }

    public void setAchieves(String achieves) {
        this.achieves = achieves;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    @Override
    public String toString() {
        return getClubName()+ " {" +
                "Number of Wins = " + noOfWins +
                ", Number of Defeats = " + noOfDefeats +
                ", Number of Draws = " + noOfDraws +
                ", Number of Goals = " + noOfGoals +
                ", Number of Received Goals "+ receivedGoals+
                ", Points = " + noOfPoints +
                ", Number of Played Matches = " + noOfPlayedMatches +
                ", Achieves = " + achieves + '\'' +
                '}';
    }

    @Override
    public int compareTo(FootballClub fb) {
        if (this.noOfPoints>fb.noOfPoints){
            return 1;
        }else if(this.noOfPoints< fb.noOfPoints){
            return -1;


        }else if ((this.noOfPoints- this.receivedGoals) == (fb.noOfPoints-fb.receivedGoals)){
            return 1;
        }else {
            return -1;
        }



    }





}
