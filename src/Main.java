import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {                         //declaring variables for 3 clubs count
    private static int clubCount = 0;
    private static int uniClubCount = 0;
    private static int schoolClubCount = 0;
    private static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override                                                           //switch case
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);
        premierLeagueManager.loadFile();

        menuLoop:
        while (true) {
            displayMenu();
            String input=sc.nextLine();
            int userInput=0;

            try {
                userInput=Integer.parseInt(input);
            }catch (Exception e){

            }

            switch (userInput) {
                case 1:
                    addTeam();

                    break;

                case 2:
                    deleteClub();
                    break;

                case 3:
                    premierLeagueManager.clubStatistics();
                    break;

                case 4:
                    premierLeagueManager.displayPremierLeagueTable();
                    break;

                case 5:
                    addPlayedMatch();
                    break;

                case 6:

                    premierLeagueManager.saveFile();
                    break;

                case 7:
                    displayGui();
                    break;


                case 8:

                    System.out.println(" Thank you far using this service.....!");
                    break menuLoop;


                default:
                    System.out.println(".....Invalid Input.....");
                    System.out.println();


            }


        }
    }


        public static void displayMenu () {


            Scanner sc = new Scanner(System.in);
            System.out.println("                 ++++++++++++++++++++++++++++++++++++++++++++++++++++                 ");         //Menu
            System.out.println("                      .....Welcome to Premier League Menu .....              ");
            System.out.println("                 ++++++++++++++++++++++++++++++++++++++++++++++++++++                 ");
            System.out.println("  Enter 1 to add a Football club to Premier League : ");
            System.out.println("  Enter 2 to delete a Football club from Premier League : ");
            System.out.println("  Enter 3 to Display statistics of a club : ");
            System.out.println("  Enter 4 to display Premier League table : ");
            System.out.println("  Enter 5 to add a played match : ");
            System.out.println("  Enter 6 to save data : ");
            System.out.println("  Enter 7 to work in GUI: ");
            System.out.println("  Enter 8  to quit the programme : ");
           


        }

        public static void addTeam () {

            Scanner sc = new Scanner(System.in);
            FootballClub fc = null;                                 //getting input for which type of club u want to add to the premier league list

                System.out.println(" Enter 'M' for add a main club , 'U' for add a university football club and 'S' for add a school football club : ");
                String choice = sc.nextLine().toUpperCase();


                switch (choice) {
                    case "M":
                        if (clubCount <= 20) {                      //getting normal club name and location
                            fc = new FootballClub();
                            System.out.println(" Enter the club name : ");
                            String fcName = sc.nextLine();
                            fc.setClubName(fcName);

                            System.out.println(" Enter the club location : ");
                            String fcLocation = sc.nextLine();
                            fc.setClubLocation(fcLocation);

                            premierLeagueManager.addFootballClub(fc);
                            clubCount++;
                        } else {
                            System.out.println(" Football club list is full ");
                        }
                        break;

                    case "U":

                        if (uniClubCount < 20) {                            //getting university club name and location
                            fc = new UniversityFootballClub();
                            System.out.println(" Enter the University club name : ");
                            String fcName = sc.nextLine();
                            fc.setClubName(fcName);

                            System.out.println(" Enter the University club location : ");
                            String fcLocation = sc.nextLine();
                            fc.setClubLocation(fcLocation);
                            premierLeagueManager.addFootballClub(fc);
                            uniClubCount++;
                        } else {
                            System.out.println(" University Football club list is full ");
                        }
                        break;

                    case "S":

                        if (schoolClubCount < 20) {
                            fc = new SchoolFootballClub();                           //getting school club name and location
                            System.out.println(" Enter school club name : ");
                            String fcName = sc.nextLine();
                            fc.setClubName(fcName);

                            System.out.println(" Enter the school club location : ");
                            String fcLocation = sc.nextLine();
                            fc.setClubLocation(fcLocation);
                            premierLeagueManager.addFootballClub(fc);
                            schoolClubCount++;


                        } else {
                            System.out.println(" School Football club list is full ");
                        }
                        break;
                    default:
                        System.out.println("Wrong input");
                }


            }


        public static void deleteClub () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Name of football club :");  //getting club name want to delete and calling delete method in premierLeagueManager class
            String clubName = sc.next();
            boolean count = premierLeagueManager.deleteFootballClub(clubName);
            if (count) {
                clubCount--;
            }

        }


        private static void addPlayedMatch () {
            premierLeagueManager.addPlayedMatch();    //calling addPlayedMatch method

        }

        private static void displayGui (){
            premierLeagueManager.displayGui();              //calling displayGui method
        }


    }













