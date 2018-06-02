public class RoundRobinTournamentFactory 
{
	private final static int BYE = -1;
	
	private int[][] tournament2dArray;
		
	public RoundRobinTournamentFactory(int num_teams) {
	    if (num_teams % 2 == 0)
	        GenerateRoundRobinEven(num_teams);
	    else
	        GenerateRoundRobinOdd(num_teams);
	} 

	// Return an array where results(i, j) gives
	// the opponent of team i in round j.
	private void GenerateRoundRobinOdd(int num_teams) {
	    int n2 = (int)((num_teams - 1) / 2);
	    tournament2dArray = new int[num_teams] [num_teams];

	    // Initialize the list of teams.
	    int[] teams = new int[num_teams];
	    for (int i = 0; i < num_teams; i++) 
	    	teams[i] = i;

	    // Start the rounds.
	    for (int round = 0; round < num_teams; round++)
	    {
	        for (int i = 0; i < n2; i++)
	        {
	            int team1 = teams[n2 - i];
	            int team2 = teams[n2 + i + 1];
	            tournament2dArray[team1][round] = team2;
	            tournament2dArray[team2][round] = team1;
	        }

	        // Set the team with the bye.
	        tournament2dArray[teams[0]][round] = BYE;

	        // Rotate the array.
	        RotateArray(teams);
	    }
	}
	
	// Rotate the entries one position.
	private void RotateArray(int[] teams)	{
	        int temp = teams[teams.length - 1];
	        for ( int i = teams.length - 1; i > 0; i-- )
	        {
	        	teams[i] = teams[i - 1];
	        }
	        teams[0] = temp;
	}
	
	private void GenerateRoundRobinEven(int num_teams)
	{
	    // Generate the result for one fewer teams.
		GenerateRoundRobinOdd(num_teams - 1);

	    // Copy the results into a bigger array,
	    // replacing the byes with the extra team.
	    int[][] results2 = new int[num_teams][num_teams - 1];
	    for (int team = 0; team < num_teams - 1; team++)
	    {
	        for (int round = 0; round < num_teams - 1; round++)
	        {
	            if (tournament2dArray[team][round] == BYE)
	            {
	                // Change the bye to the new team.
	                results2[team][round] = num_teams - 1;
	                results2[num_teams - 1][round] = team;
	            }
	            else
	            {
	                results2[team][round] = tournament2dArray[team][round];
	            }
	        }
	    }
	    tournament2dArray = results2.clone();
	}

	public int[][] getTournament2dArray() {
		return tournament2dArray;
	}
}
