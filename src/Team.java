public class Team {
	
	private int teamNumber;
	
	private String teamName;
	
	private int score;
	
	private static int teamNumcounter = 0;
	
	public Team(String teamName) {
		this.teamNumber = teamNumcounter++;
		this.teamName = teamName;
		this.score = 0;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return teamName;
	}
}
