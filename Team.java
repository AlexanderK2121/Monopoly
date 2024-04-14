import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private Manager manager;
    private List<Player> players;

    public Team(String teamName, Manager manager) {
        this.teamName = teamName;
        this.manager = manager;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getTeamName() {
        return teamName;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
