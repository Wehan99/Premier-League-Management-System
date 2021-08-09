import java.util.Comparator;

public class WinComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub club1, FootballClub club2) {    //sorting clubs according to no of wins
        if(club1.getNoOfWins()>club2.getNoOfWins()){
            return -1;
        }else if(club1.getNoOfWins()<club2.getNoOfWins()){
            return 1;
        }else
        return 0;
    }
}
