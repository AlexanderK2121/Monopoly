public class Player {
    private String name;
    private int skillLevel;
    private String position;
    private int goalsScored;

    public Player(String name, int skillLevel, String position) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.position = position;
        this.goalsScored = 0;
    }

    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getPosition() {
        return position;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void scoreGoal() {
        goalsScored++;
    }
}
