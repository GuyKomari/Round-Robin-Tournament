import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tournament 
{	
	private int numOfTeams;

	private int numOfRounds;
	
	private int gameCounter; 

	private int[][] tournamentAsArray;
	
	private List<Team> teamsList;
	
	private HashMap<Integer, List<Game>> gamesMap;
	
	private RoundRobinTournamentFactory RoundRobinTournamentFactory;
	
	public Tournament(String[] teamsName, int numOfTeams) {
		this.RoundRobinTournamentFactory = new RoundRobinTournamentFactory(numOfTeams);
		this.tournamentAsArray = RoundRobinTournamentFactory.getTournament2dArray();
		this.numOfTeams = numOfTeams;
		this.numOfRounds = numOfTeams % 2 == 0 ? numOfTeams - 1 : numOfTeams;
		this.teamsList = new ArrayList<>();
		this.gamesMap = new HashMap<>();
		
		for(String teamName: teamsName){
			teamsList.add(new Team(teamName));
		}
		setGames();
	}
	private void setGames() {	
		Team team1, team2;
		for(int j = 0; j < numOfRounds; j++){
			List<Game> gamesList = new ArrayList<>();
			List<Team> playingTeams = new ArrayList<>();
			for(int i = 0; i < numOfTeams; i++){
				team1 = teamsList.get(i);
				if(tournamentAsArray[i][j] != -1)
					team2 = teamsList.get(tournamentAsArray[i][j]);
				else{
					playingTeams.add(team1);
					gamesList.add(new Game(gameCounter++, team1, null));
					continue;
				}
				if(!playingTeams.contains(team1) && !playingTeams.contains(team2)){
					playingTeams.add(team1);
					playingTeams.add(team2);
					gamesList.add(new Game(gameCounter++, team1, team2));
				}				
			}
			gamesMap.put(j, gamesList);
		}
	}	
	public void runTournament() {
		for(int i = 0; i < numOfRounds; i++){
			List<Game> listOfGamesInRound = gamesMap.get(i);
			for(Game game: listOfGamesInRound) {
				Team team1 = game.getTeam1();
				Team team2 = game.getTeam2();
				Team winner = game.getWinner();
				if(team2 != null && winner != null){
					if(	winner.equals(team1)){team1.setScore(team1.getScore() + 1);}
					else{	team2.setScore(team2.getScore() + 1);	}
				}
			}
		}		
	}

	public HashMap<Integer, List<Game>> getGamesMap() {
		return gamesMap;
	}

	public List<Team> getTeamsList() {
		return teamsList;
	}

	public RoundRobinTournamentFactory RoundRobinTournamentFactory() {
		return RoundRobinTournamentFactory;
	}

	public int getNumOfTeams() {
		return numOfTeams;
	}

	public int getNumOfRounds() {
		return numOfRounds;
	}

	public int[][] getTournamentAsArray() {
		return tournamentAsArray;
	}

	public int getGameCounter() {
		return gameCounter;
	}
}
