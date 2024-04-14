import java.util.Random;


public class Match {
    public static String simulateMatch(Team team1, Team team2) {
        int team1Score = calculateScore(team1);
        int team2Score = calculateScore(team2);

        if (team1Score > team2Score) {
            return team1.getTeamName() + " wins! (" + team1Score + "-" + team2Score + ")";
        } else if (team1Score < team2Score) {
            return team2.getTeamName() + " wins! (" + team2Score + "-" + team1Score + ")";
        } else {
            return "It's a draw! (" + team1Score + "-" + team2Score + ")";
        }
    }

    private static int calculateScore(Team team) {
        int score = 0;
        Random random = new Random();
        for (Player player : team.getPlayers()) {
            score += player.getSkillLevel() * (1 + random.nextDouble());
        }
        return score / 100;
    }
}
