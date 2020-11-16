package exercises.challenges_section_10.Generics_challenge;

import java.util.ArrayList;

public class Team<PlayerType extends Player> implements Comparable<Team<PlayerType>>{
    //we can only use class type that is derived from Player class
    //and we do not have to cast ((Player)player).getName() in addPlayer method (because of extends Player)
    //if want to do multiple bound we need to use interfaces like<Team Type extends Player & Interface1 & Interface2>
    //we want to be able to compare team rankings to each other so we implement interface Comparable with type
    // Team<TeamType> as we want to compare football to football, soccer to soccer etc.
    //then we have to implement method compareTo()
    private String name;
    private int played = 0;
    private int won=0;
    private int lost=0;
    private int tied=0;
    private ArrayList<PlayerType> members = new ArrayList<>();
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(PlayerType player){
        if(this.members.contains(player)){
            System.out.println("Player " + player.getName() + " already on the team " + this.name);
            return false;
        }else{
            this.members.add(player);
            System.out.println(player.getName() + " added successfully to team " + this.name);
            return true;
        }
    }

    public void getResult(Team<PlayerType> opponents, int ourScore, int theirScore){
        if(ourScore>theirScore){
            played++;
            won++;
            System.out.println("We won.");
        }else if(ourScore<theirScore){
            played++;
            lost++;
            System.out.println("We lost.");
        }else{
            played++;
            tied++;
            System.out.println("We tied.");
        }

        if(opponents != null){
            opponents.getResult(null, theirScore, ourScore);
        }
    }
    public void stats(){
        System.out.println("Won: " + this.won);
        System.out.println("Lost: " + this.lost);
        System.out.println("Tied: " + this.tied);
    }

    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<PlayerType> o) {
        if(this.ranking() > o.ranking()){
            return -1;
        }else if(this.ranking() < o.ranking()){
            return 1;
        }
        return 0;
    }
}
