import java.util.Scanner;

public class FootballManagerGame {
    private static Scanner scanner = new Scanner(System.in);

    private static Manager createManager() throws ValidationException {
        System.out.println("Enter Manager's Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Manager's Experience Years:");
        int experienceYears = Integer.parseInt(scanner.nextLine());
        if (experienceYears < 0) {
            throw new ValidationException("Experience years cannot be negative.");
        }

        return new Manager(name, experienceYears);
    }

    private static Player createPlayer() throws ValidationException {
        System.out.println("Enter Player's Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Player's Skill Level (1-10):");
        int skillLevel = Integer.parseInt(scanner.nextLine());
        if (skillLevel < 1 || skillLevel > 10) {
            throw new ValidationException("Skill level must be between 1 and 10.");
        }

        System.out.println("Enter Player's Position:");
        String position = scanner.nextLine();

        return new Player(name, skillLevel, position);
    }

    private static Team createTeam() throws ValidationException {
        Manager manager = createManager();
        System.out.println("Enter Team Name:");
        String teamName = scanner.nextLine();
        Team team = new Team(teamName, manager);

        while (true) {
            System.out.println("Add a player to the team? (yes/no)");
            String response = scanner.nextLine();
            if ("no".equalsIgnoreCase(response)) {
                break;
            }

            try {
                Player player = createPlayer();
                team.addPlayer(player);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }

        return team;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Creating Team 1:");
            Team team1 = createTeam();

            System.out.println("Creating Team 2:");
            Team team2 = createTeam();

            System.out.println("Teams have been created. Would you like to simulate a match between them? (yes/no)");
            String answer = scanner.nextLine();
            if ("yes".equalsIgnoreCase(answer)) {
                String matchResult = Match.simulateMatch(team1, team2);
                System.out.println(matchResult);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
