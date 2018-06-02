import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Round Robin Tournament Application \nbased on the research of Dmitry Dagaev & Andrey Zubanov, 2017 - \"Round-Robin Tournaments with Limited Resources\"\n");
		System.out.print("Please enter the number of teams in this tournament: ");
		int numOfTeams = scan.nextInt();
		System.out.println();

		String[] teamsName = new String[numOfTeams];
		for(int i = 0; i < numOfTeams; i++){
			System.out.print("Please enter the name of Team " + (i+1) + ": ");
			teamsName[i] = scan.next();
		}
		System.out.println();

		int numOfRounds = numOfTeams % 2 == 0 ? numOfTeams - 1 : numOfTeams;
		Tournament tournament = new Tournament(teamsName, numOfTeams); 
		HashMap<Integer, List<Game>> tournamentRounds = tournament.getGamesMap();

		for(int i = 0; i < numOfRounds; i++) {
			List<Game> listOfGamesInRound = tournamentRounds.get(i);
			System.out.println("Round " + (i+1) + " : ");
			System.out.println();
			for(Game game: listOfGamesInRound) {
				System.out.println(game);
			}
			System.out.println();
		}

		System.out.println("For each game set the efforts of the teams: ");
		System.out.println("Note that each team has an effort value of 1, for the entire tournament");
		System.out.println();

		for(int i = 0; i < numOfRounds; i++)
		{
			List<Game> listOfGamesInRound = tournamentRounds.get(i);
			System.out.println("Round " + (i+1) + " : ");
			System.out.println();
			for(Game game: listOfGamesInRound) {

				Team team1 = game.getTeam1();
				Team team2 = game.getTeam2();

				if(team2 != null){
					System.out.println("For " + game);
					System.out.print("The effort of "+ team1.getTeamName() + " is : ");
					game.setEffort1(scan.nextDouble());

					System.out.print("The effort of "+ team2.getTeamName() + " is : ");
					game.setEffort2(scan.nextDouble());
					System.out.println();
				}
			}
		}
		tournament.runTournament();
		int max = 0;
		for(Team team: tournament.getTeamsList()) {
			System.out.println("The score of " + team + " is - " + team.getScore());
			if(team.getScore() > max)
				max = team.getScore();
		}
		System.out.println();
		System.out.print("The winners : ");
		for(Team team: tournament.getTeamsList()) {
			if(team.getScore() == max)
				System.out.print(team + " ");
		}	
		System.out.println();
	}
}