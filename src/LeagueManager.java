import java.io.IOException;

public interface LeagueManager {

    public void addFootballClub(FootballClub footballClub);
    public boolean deleteFootballClub(String footballClubName);
    public void clubStatistics();
    public void displayPremierLeagueTable();
    public void addPlayedMatch();
    public void saveFile() throws IOException;
    public void loadFile() throws IOException;
    public void displayGui();
}

