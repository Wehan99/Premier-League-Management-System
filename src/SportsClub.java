import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private String clubName;
    private String clubLocation;


    public SportsClub(String clubName, String clubLocation){
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public SportsClub() {

    }


    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName(){
        return clubName;
    }
    public SportsClub(String clubName) {
        this.clubName = clubName;
    }
    @Override
    public boolean equals(Object o) {                                       //equals method
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return clubName.equals(that.clubName) &&
                clubLocation.equals(that.clubLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation);
    }           //hashcode method

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }






}
