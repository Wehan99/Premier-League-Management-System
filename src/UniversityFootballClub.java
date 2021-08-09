public class UniversityFootballClub extends FootballClub{
    private String universityName;
    private String universityLocation;

    public UniversityFootballClub(String clubName, String clubLocation, int noOfDefeats, int noOfDraws, int noOfGoals,int receivedGoals, int noOfPlayedMatches,
                                  int noOfPoints, int noOfWins, String achieves,String universityLocation,String universityName) {
        super(clubName, clubLocation, noOfDefeats, noOfDraws, noOfGoals,receivedGoals, noOfPlayedMatches, noOfPoints, noOfWins, achieves);

        this.universityLocation=universityLocation;
        this.universityName=universityName;
    }

    public UniversityFootballClub() {

    }


    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityLocation(String universityLocation) {
        this.universityLocation = universityLocation;
    }

    public String getUniversityLocation() {
        return universityLocation;
    }


}
