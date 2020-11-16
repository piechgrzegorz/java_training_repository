package exercises.challenges_section_10.Generics_challenge;

import java.util.ArrayList;
import java.util.Collections;

public class League <TeamType extends Team>{
    private String name;
    private ArrayList<TeamType> leagueTeams;

    public League(String name) {
        this.name = name;
        leagueTeams = new ArrayList<TeamType>();
    }
    public boolean addTeam(TeamType team){
        if(leagueTeams.contains(team)){
            System.out.println(team.getName() + " already in the " + this.name + " League.");
            return false;
        }else{
            leagueTeams.add(team);
            System.out.println(team.getName()+" added successfully to " + this.name + " League.");
            return true;
        }
    }

    public void ranking(){
        Collections.sort(leagueTeams);
        printTeams();
    }

    public void printTeams(){
        for(TeamType team:leagueTeams){
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }
}
