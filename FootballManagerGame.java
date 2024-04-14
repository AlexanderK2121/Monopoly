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

    public static void main(String[] args) {
        try {
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

            System.out.println("Team Created Successfully!");
            System.out.println("Team Name: " + team.getTeamName());
            System.out.println("Manager: " + team.getManager().getName());
            for (Player player : team.getPlayers()) {
                System.out.println("Player: " + player.getName() + " | Position: " + player.getPosition() + " | Skill Level: " + player.getSkillLevel());
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
