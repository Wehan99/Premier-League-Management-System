public class SchoolFootballClub extends FootballClub{
    private String schoolName;
    private String schoolLocation;

    public SchoolFootballClub(String clubName, String clubLocation, int noOfDefeats, int noOfDraws, int noOfGoals,int receivedGoals, int noOfPlayedMatches,
                              int noOfPoints, int noOfWins, String achieves, String schoolName,String schoolLocation) {
        super(clubName, clubLocation, noOfDefeats, noOfDraws, noOfGoals,receivedGoals, noOfPlayedMatches, noOfPoints, noOfWins, achieves);
        this.schoolName=schoolName;
        this.schoolLocation=schoolLocation;
    }

    public SchoolFootballClub() {

    }


    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


}

