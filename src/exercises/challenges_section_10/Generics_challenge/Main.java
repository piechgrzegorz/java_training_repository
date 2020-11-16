package exercises.challenges_section_10.Generics_challenge;

public class Main {
    public static void main(String[] args) {
    FootballPlayer tim = new FootballPlayer("Tim");
    FootballPlayer jim = new FootballPlayer("Jim");
    FootballPlayer dan = new FootballPlayer("Dan");

    Team<FootballPlayer> teamA = new Team<>("A-Team");
    Team<FootballPlayer> teamB = new Team<>("B-Team");
    Team<FootballPlayer> teamC = new Team<>("C-Team");

        teamA.getResult(teamB, 1, 2);
                teamB.getResult(teamC, 2, 3);
                teamC.getResult(teamA, 4, 5);
                teamB.getResult(teamA, 5, 2);
                League<Team<FootballPlayer>> rocketLeague = new League<>("Rocket League");
        rocketLeague.addTeam(teamA);
        rocketLeague.addTeam(teamB);
        rocketLeague.addTeam(teamC);
        rocketLeague.ranking();
    }
}

























