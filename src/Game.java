public class Game {

	private int GameNumber;

	private Team team1;
	
	private Team team2;

	private double effort1;
	
	private double effort2;
	
	public Game(int gameNumber, Team team1, Team team2) {
		GameNumber = gameNumber;
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public Team getWinner() {
		// case team2 in "Bye" state OR both teams used the same effort
		if(team2 == null || effort1 == effort2)
			return null;
		return effort1 > effort2 ? team1 : team2;
	}

	public int getGameNumber() {
		return GameNumber;
	}

	public void setGameNumber(int gameNumber) {
		GameNumber = gameNumber;
	}

	public double getEffort1() {
		return effort1;
	}

	public void setEffort1(double effort1) {
		this.effort1 = effort1;
	}

	public double getEffort2() {
		return effort2;
	}

	public void setEffort2(double effort2) {
		this.effort2 = effort2;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		if(this.team2!=null){
			return team1 + " vs " + team2;
		}
		return team1 + " Bye";
	}


}