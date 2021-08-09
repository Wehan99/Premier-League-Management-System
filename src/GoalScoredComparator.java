import java.util.Comparator;

public class GoalScoredComparator implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {            //sorting club list according to the goal scored
        if(club1.getNoOfGoals()>club2.getNoOfGoals()){
            return -1;

        }else if(club1.getNoOfGoals()<club2.getNoOfGoals()){
            return +1;
        }
        return 0;

    }
}
