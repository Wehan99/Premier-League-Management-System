import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.*;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public   class PremierLeagueManager implements LeagueManager{
    Scanner sc = new Scanner(System.in);



    private    List<FootballClub> footballClubsArray=new ArrayList<>();

    private  List<Match> matches=new ArrayList<>();
    File clubFile=new File("club.txt");
    File matchFile=new File("match.txt");


        @Override
        public void addFootballClub(FootballClub footballClub) {

            boolean b= false;
            for(FootballClub fb : footballClubsArray){
                if(footballClub.equals(fb)){                //checking is this club already in the premier league
                    b=true;
                    break;

                }
            }
            if(!b){
                footballClubsArray.add(footballClub);               //if not adding club
                System.out.println("Club Successfully added to Premier League.....");

            }else{
                System.out.println("This club already in the Premier League.....");
            }




        }

        @Override
        public boolean deleteFootballClub(String footballClubName) {


            boolean check=false;
            for(SportsClub sportsClub: footballClubsArray){
                if(sportsClub.getClubName().equals(footballClubName)){              //checking club in the premier league
                    check=true;
                    footballClubsArray.remove(sportsClub);
                    System.out.println(sportsClub.getClubName() + " removed from the the Premier League Successfully.....");     //if its true deleting the club
                    break;
                }else {
                    System.out.println(" This Football club is not in the Premier League.....");
                }

            }

            return check;
        }

        @Override
        public void clubStatistics() {
            System.out.println("Enter the Football club name : ");
            String testClub = sc.nextLine();
           boolean a=false;
           for(FootballClub fc: footballClubsArray){
               if (fc.getClubName().equals(testClub)){                              //checking, club in the premier league
                   a=true;
                   System.out.println(" Club Name : "+ fc.getClubName() );
                   System.out.println(" Points : "+ fc.getNoOfPoints() );                           //print club stats
                   System.out.println(" Number of Wins : "+ fc.getNoOfWins() );
                   System.out.println(" Number of Draws : "+ fc.getNoOfDraws() );
                   System.out.println(" Number of Defeats : "+ fc.getNoOfDefeats() );
                   System.out.println(" Number of received goals : "+ fc.getReceivedGoals() );
                   System.out.println(" Number of played matches : "+ fc.getNoOfPlayedMatches() );

               }

           }
           if(a==false){
               System.out.println("This club not in the Premier League. Try Again.....");
           }

        }

        @Override
        public void displayPremierLeagueTable()  {
            Collections.sort(footballClubsArray,Collections.reverseOrder());            //showing the array data descending order
            for (FootballClub fc : footballClubsArray) {
                if (fc.getClubName().equals(fc.getClubName())) {
                    System.out.println(fc);

                }
            }

        }


    @Override
    public void addPlayedMatch() {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter the date (format :\"dd/MM/yyyy\")");
        String ud=sc.nextLine();
        Date date= null;
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);

        try{
            date=df.parse(ud);

        } catch (ParseException e) {
            System.out.println("Invalid date please try again....!");               //validating date
            System.out.println();
            return;
        }

        System.out.println(" Enter the Team 1 : ");
        String name = sc.nextLine();
        FootballClub team1 = null;                                                  //getting team 1 and check this club is in the league
        for (FootballClub fc : footballClubsArray) {
            if (fc.getClubName().equals(name))
                team1 = fc;
        }
        if (team1 == null) {
            System.out.println(" This club not in the Premier League.....");
            return;
        }


        System.out.println(" Enter the Team 2 :");
        String name2 = sc.nextLine();
        FootballClub team2 = null;                                                  //getting team  and check this club is in the league
        for (FootballClub fc : footballClubsArray) {
            if (fc.getClubName().equals(name2))
                team2 = fc;
        }
        if (team2 == null) {
            System.out.println(" This club not in the Premier League.....");
            return;
        }
        System.out.println(" Enter the Team 1 Goals : ");       // getting 1st team goals scores
        String goal = sc.nextLine();
        int team1Goals = -1;
        try {
            team1Goals = Integer.parseInt(goal);
        } catch (Exception e) {
        }
        if (team1Goals == -1) {
            System.out.println(" You should enter the number of goals ! ");
            return;
        }

        System.out.println(" Enter the Team 2 Goals : ");
        String goal1 = sc.nextLine();                                 //getting 2nd team goal scores
        int team2Goals = -1;
        try {
            team2Goals = Integer.parseInt(goal1);
        } catch (Exception e) {
        }
        if (team2Goals == -1) {
            System.out.println(" You should enter the number of goals ! ");
            return;
        }
        System.out.println("Match successfully added to the Premier League table...! ");
        System.out.println();
        Match enterMatch=new Match(name,name2,team1Goals,team2Goals,date);


        team1.setNoOfGoals(team1.getNoOfGoals() + team1Goals);            //updating club statistics
        team2.setNoOfGoals(team2.getNoOfGoals() + team2Goals);
        team1.setReceivedGoals(team1.getReceivedGoals() + team2Goals);
        team2.setReceivedGoals(team2.getReceivedGoals() + team1Goals);

        if (team1Goals > team2Goals) {
            team1.setNoOfPoints(team1.getNoOfPoints() + 3);
            team1.setNoOfWins(team1.getNoOfWins() + 1);
            team2.setNoOfDefeats((team2.getNoOfDefeats() + 1));


        } else if (team1Goals < team2Goals) {
            team2.setNoOfPoints(team2.getNoOfPoints() + 3);
            team2.setNoOfWins(team2.getNoOfWins() + 1);
            team1.setNoOfDefeats((team1.getNoOfDefeats() + 1));

        } else {
            team1.setNoOfPoints(team1.getNoOfPoints() + 1);
            team2.setNoOfPoints(team2.getNoOfPoints() + 1);
            team1.setNoOfDraws(team1.getNoOfDraws() + 1);
            team2.setNoOfDraws(team2.getNoOfDraws() + 1);
        }
        team1.setNoOfPlayedMatches(team1.getNoOfPlayedMatches() + 1);                       //updating both no of played matches
        team2.setNoOfPlayedMatches(team2.getNoOfPlayedMatches() + 1);

        matches.add(enterMatch);                        //adding the match

    }

    @Override
    public void saveFile()throws IOException {                               //save file method

        try {

            FileOutputStream clubFos = new FileOutputStream(clubFile);
            FileOutputStream matchFos = new FileOutputStream(matchFile);

            ObjectOutputStream objClub = new ObjectOutputStream(clubFos);
            ObjectOutputStream objMatch = new ObjectOutputStream(matchFos);

            for (FootballClub footballClub : footballClubsArray) {                  //save array data to file
                objClub.writeObject(footballClub);

            }

            for (Match match : matches) {
                objMatch.writeObject(match);                      //save array data to file
            }
            objClub.close();
            objMatch.close();
            clubFos.close();
            matchFos.close();

            System.out.println("Data saved successfully...!");
            System.out.println();
        } catch (Exception e) {

        }
    }


    @Override
    public void loadFile() throws IOException {
        try {
            FileInputStream clubFis = new FileInputStream(clubFile);
            FileInputStream matchFis = new FileInputStream(matchFile);
            ObjectInputStream objClub2 = new ObjectInputStream(clubFis);
            ObjectInputStream objMatch2 = new ObjectInputStream(matchFis);
            for (; ; ) {
                try {
                    FootballClub footballClub = (FootballClub) objClub2.readObject();     //load date to footballClub from the file
                    footballClubsArray.add(footballClub);

                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }

            for (; ; ) {
                try {
                    Match match = (Match) objMatch2.readObject();
                    matches.add(match);
                                                                            //load data to match from text file
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
            objClub2.close();
            objMatch2.close();
            clubFis.close();
            matchFis.close();

            System.out.println(" Previous Data loaded successfully...!");

        } catch (Exception e) {

        }
    }

    public void displayGui (){

        Stage stage = new Stage();

        Label label1 = new Label(" Premier League Manager ");         //adding styles to labels
        label1.setStyle(" -fx-font-size: 20px;\n" +
                "                -fx-font-weight: bold;\n" +
                "                -fx-text-fill: #333333;\n" +
                "                -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");


        Label label2=new Label(" Premier League Table ");
        label2.setStyle(" -fx-font-size: 15px;\n" +
                "                -fx-font-weight: bold;\n" +
                "                -fx-text-fill: #333333;\n" +
                "                -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");

        TextField text1 = new TextField();
        text1.setPromptText("dd/MM/yyyy");
        Button button1 = new Button("Random Match");
        Button button2 = new Button("Search a match");
        Button button3 = new Button("All Matches");
        Button button4=new Button("Sort by most wins");
        Button button5=new Button("Sort by most goals scored");
        button1.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +                                         //adding button styles
                "    -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");

        button3.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");
        button4.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");
        button5.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");

        TableView tableView=new TableView();

        TableColumn<FootballClub,String> column1=new TableColumn<>("Club");
        column1.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        column1.setMinWidth(160);

        TableColumn<FootballClub,Integer> column2=new TableColumn<>("Played");
        column2.setCellValueFactory(new PropertyValueFactory<>("noOfPlayedMatches"));

        TableColumn<FootballClub,Integer> column3=new TableColumn<>("Win");
        column3.setCellValueFactory(new PropertyValueFactory<>("noOfWins"));

        TableColumn<FootballClub,Integer> column4=new TableColumn<>("Drawn");
        column4.setCellValueFactory(new PropertyValueFactory<>("noOfDraws"));

        TableColumn<FootballClub,Integer> column5=new TableColumn<>("Lost");
        column5.setCellValueFactory(new PropertyValueFactory<>("noOfDefeats"));

        TableColumn<FootballClub,Integer> column6=new TableColumn<>("GS");
        column6.setCellValueFactory(new PropertyValueFactory<>("noOfGoals"));

        TableColumn<FootballClub,Integer> column7=new TableColumn<>("GR");
        column7.setCellValueFactory(new PropertyValueFactory<>("receivedGoals"));

        TableColumn<FootballClub,Integer> column8=new TableColumn<>("Points");
        column8.setCellValueFactory(new PropertyValueFactory<>("noOfPoints"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);

        tableView.setPrefHeight(450);
        tableView.setPrefWidth(550);                //set location of labels, buttons, text field and table in anchor pane

        label1.setLayoutX(220);
        label1.setLayoutY(30);

        text1.setLayoutX(400);
        text1.setLayoutY(85);

        button2.setLayoutX(550);
        button2.setLayoutY(85);

        button1.setLayoutY(85);
        button1.setLayoutX(50);

        button3.setLayoutX(250);
        button3.setLayoutY(85);

        button4.setLayoutX(670);
        button4.setLayoutY(200);

        button5.setLayoutX(670);
        button5.setLayoutY(300);

        label2.setLayoutY(150);
        label2.setLayoutX(260);

        tableView.setLayoutX(50);
        tableView.setLayoutY(200);

        Collections.sort(footballClubsArray,Collections.reverseOrder());
        for(FootballClub fb:footballClubsArray ){
            tableView.getItems().add(new FootballClub(fb.getClubName(),fb.getNoOfPlayedMatches(),fb.getNoOfWins(),fb.getNoOfDraws()
                    ,fb.getNoOfDefeats(),fb.getNoOfGoals(),fb.getReceivedGoals(),fb.getNoOfPoints()));


        }






        button2.setOnAction(e->{

            Label resultsLabel=new Label();
            Scanner sc=new Scanner(System.in);
            Date date= null;
            DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);

            try{                                                //validating date
                date=df.parse(text1.getText());

            } catch (ParseException e1) {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Invalid date input please try again....!");    //putting error if not at least two teams
                alert.showAndWait();
                text1.clear();
                System.out.println();
                return;
            }

            for(Match searchMatch:matches){                             //checking which match was in the given date

                if(date.equals(searchMatch.getDate())){                         //if "if" condition is true showing the output
                    resultsLabel.setText("Club 1 : "+searchMatch.getTeam1()+"   Goal  : "+searchMatch.getTeam1Score()+'\n'+
                            "Club 2 : "+searchMatch.getTeam2()+"   Goal  : "+searchMatch.getTeam2Score()+'\n');
                    System.out.println(searchMatch.getTeam1()+" - "+searchMatch.getTeam1Score()+" Vs "+searchMatch.getTeam2()+" - "+searchMatch.getTeam2Score());

                }else {
                    System.out.println(" No match in the searched date....!");
                }
            }


            AnchorPane anchorPane2=new AnchorPane();                            //adding anther gui and add data to searched match
            Label label3=new Label(" Match ");
            //Label labelAl=new Label()
            label3.setLayoutX(170);
            label3.setLayoutY(10);
            label3.setStyle("-fx-font:22 arial;");

            resultsLabel.setLayoutY(50);                                       //resultsLabel arrangements
            resultsLabel.setLayoutX(20);
            resultsLabel.setMaxSize(350,180);
            resultsLabel.setStyle("-fx-font:16 arial;");

            anchorPane2.getChildren().addAll(label3,resultsLabel);
            anchorPane2.setStyle("-fx-padding: 10px;\n" +
                    "   -fx-background-color: #FAFAD2");
            Scene sceneSearch=new Scene(anchorPane2,400,250);
            Stage stageAll=new Stage();
            stageAll.setScene(sceneSearch);
            stageAll.setTitle("Match");
            stageAll.show();
        });

        button4.setOnAction(e->{                                      //sort table by  most wins
            Collections.sort(footballClubsArray, new WinComparator());

            for ( int i = 0; i<tableView.getItems().size(); i++) {           //clearing current data in table
                tableView.getItems().clear();
            }

            for(FootballClub fb:footballClubsArray ){
                tableView.getItems().add(new FootballClub(fb.getClubName(),fb.getNoOfPlayedMatches(),fb.getNoOfWins(),fb.getNoOfDraws()             //adding new data to the club
                        ,fb.getNoOfDefeats(),fb.getNoOfGoals(),fb.getReceivedGoals(),fb.getNoOfPoints()));


            }



        });

        button5.setOnAction(e->{                                          //sort table by most goal scored
          Collections.sort(footballClubsArray, new GoalScoredComparator());
                                                                                 //sorting in according toGoalScoredComparator logic

            for ( int i = 0; i<tableView.getItems().size(); i++) {
                tableView.getItems().clear();                           //clear current table data
            }
            for(FootballClub fb:footballClubsArray ){
                tableView.getItems().add(new FootballClub(fb.getClubName(),fb.getNoOfPlayedMatches(),fb.getNoOfWins(),fb.getNoOfDraws()             //adding new data
                        ,fb.getNoOfDefeats(),fb.getNoOfGoals(),fb.getReceivedGoals(),fb.getNoOfPoints()));

            }

        });



        button3.setOnAction(e->{
            AnchorPane anchorPane2=new AnchorPane();                                            //adding anther gui and add data to all matches
            Label label3=new Label("All Played Matches ");
            Label re=new Label();
            for (Match allMatches:matches){
            re.setText(allMatches.getTeam1()+" - "+allMatches.getTeam1Score()+" Vs "+allMatches.getTeam2()+" - "+allMatches.getTeam2Score()+" Date : "+allMatches.getDate());
                System.out.println(allMatches.getTeam1()+" - "+allMatches.getTeam1Score()+" Vs "+allMatches.getTeam2()+" - "+allMatches.getTeam2Score()+" Date : "+allMatches.getDate());
            }



            label3.setLayoutX(170);
            label3.setLayoutY(10);
            re.setLayoutX(70);
            re.setLayoutY(60);                                                      //setting location and styling
            label3.setStyle("-fx-font:24 arial;");
            re.setStyle("-fx-font:18 arial;");

            anchorPane2.getChildren().addAll(label3,re);
            anchorPane2.setStyle("-fx-padding: 10px;\n" +
                    "   -fx-background-color: #FAFAD2");
            Scene sceneSearch=new Scene(anchorPane2,500,500);
            Stage stageSearch=new Stage();
            stageSearch.setScene(sceneSearch);
            stageSearch.setTitle("All Matches");
            stageSearch.show();
        });

        button1.setOnAction(e->{
            AnchorPane anchorPane2=new AnchorPane();                                            //creating random match operation
            Label label3=new Label("Random Match ");

            if (footballClubsArray.size()<2){
                Alert alert=new Alert(Alert.AlertType.ERROR,"Not at least 2 football clubs in the list");    //putting error if not at least two teams
                alert.showAndWait();
                return;
            }

            Random random = new Random();                   //generating random scores

            int team1=random.nextInt(footballClubsArray.size());
            int team2=random.nextInt(footballClubsArray.size());

            if (team1==team2){
                return;
            }

            int team1Goals=random.nextInt(21-0)+0;          //getting 2 random goals scores
            int team2Goals=random.nextInt(21-0)+0;

            FootballClub club1=footballClubsArray.get(team1);               //getting 2 random clubs
            FootballClub club2=footballClubsArray.get(team2);


            if(team1Goals>team2Goals){                                      //if team 1 won, updating the status of club 1 and club2
                club1.setClubName(club1.getClubName());
                club1.setNoOfPoints(club1.getNoOfPoints()+3);
                club1.setNoOfWins(club1.getNoOfWins()+1);
                club1.setNoOfPlayedMatches(club1.getNoOfPlayedMatches()+1);
                club1.setNoOfGoals(club1.getNoOfGoals()+team1Goals);
                club1.setReceivedGoals(club1.getReceivedGoals()+team2Goals);

                club2.setClubName(club2.getClubName());
                club2.setNoOfDefeats(club2.getNoOfDefeats()+1);
                club2.setNoOfPlayedMatches(club2.getNoOfPlayedMatches()+1);
                club2.setNoOfGoals(club2.getNoOfGoals()+team2Goals);
                club2.setReceivedGoals(club2.getReceivedGoals()+team1Goals);

            }else if(team2Goals>team1Goals){
                                                                                //if team 2 won, updating the status of club 1 and club2
                club2.setClubName(club2.getClubName());
                club2.setNoOfPoints(club2.getNoOfPoints()+3);
                club2.setNoOfWins(club2.getNoOfWins()+1);
                club2.setNoOfPlayedMatches(club2.getNoOfPlayedMatches()+1);
                club2.setNoOfGoals(club2.getNoOfGoals()+team2Goals);
                club2.setReceivedGoals(club2.getReceivedGoals()+team1Goals);

                club1.setClubName(club1.getClubName());
                club1.setNoOfDefeats(club1.getNoOfDefeats()+1);
                club1.setNoOfPlayedMatches(club1.getNoOfPlayedMatches()+1);
                club1.setNoOfGoals(club1.getNoOfGoals()+team1Goals);
                club1.setReceivedGoals(club1.getReceivedGoals()+team2Goals);

            }else {
                club1.setClubName(club1.getClubName());
                club1.setNoOfPoints(club1.getNoOfPoints()+1);                   //if match will draw,updating the status of club1 and club 2
                club1.setNoOfDraws(club1.getNoOfDraws()+1);
                club1.setNoOfPlayedMatches(club1.getNoOfPlayedMatches());
                club1.setNoOfGoals(club1.getNoOfGoals()+team1Goals);
                club1.setReceivedGoals(club1.getReceivedGoals()+team2Goals);

                club2.setClubName(club2.getClubName());
                club2.setNoOfPoints(club2.getNoOfPoints()+1);
                club2.setNoOfDraws(club2.getNoOfDraws()+1);
                club2.setNoOfPlayedMatches(club2.getNoOfPlayedMatches());
                club2.setNoOfGoals(club2.getNoOfGoals()+team2Goals);
                club2.setReceivedGoals(club2.getReceivedGoals()+team1Goals);

            }
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            Date date=new Date();                                               //generating date
            java.lang.String matchDate=sdf.format(date);



            Match randomMatch=new Match(club1.getClubName(),club2.getClubName(),team1Goals,team2Goals,date);        //adding the match

            matches.add(randomMatch);
            System.out.println(matches.size());
            System.out.println(matches);
            System.out.println(footballClubsArray.size());



            Label  resultLabel=new Label(club1.getClubName()+"       -  "+team1Goals);
            Label resultLabel2=new Label(club2.getClubName()+"       -  "+team2Goals);

            label3.setLayoutX(100);                                                         //adding new label for results and setting location
            label3.setLayoutY(10);
            resultLabel.setLayoutX(140);
            resultLabel.setLayoutY(70);
            resultLabel2.setLayoutX(140);
            resultLabel2.setLayoutY(110);


            label3.setStyle("-fx-font:24 arial;");                                  //styling
            resultLabel.setStyle("-fx-font:16 arial;");
            resultLabel2.setStyle("-fx-font:16 arial;");

            anchorPane2.getChildren().addAll(resultLabel,resultLabel2,label3);
            anchorPane2.setStyle("-fx-padding: 10px;\n" +
                    "   -fx-background-color: #FAFAD2");
            Scene sceneRandom=new Scene(anchorPane2,400,200);           //adding to pane
            Stage stageRandom=new Stage();
            stageRandom.setScene(sceneRandom);
            stageRandom.setTitle("Random Match");
            stageRandom.show();
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-padding: 10px;\n" +
                "   -fx-background-color: #FAFAD2");
        anchorPane.getChildren().addAll(tableView,label1,label2, text1, button1, button2, button3,button4,button5);
        Scene scene = new Scene(anchorPane, 850, 700);
        stage.setScene(scene);
        stage.showAndWait();






    }


}

