package exercises.section_6.Coding_Exercise_33;

import exercises.section_6.Coding_Exercise_33.Carpet;
import exercises.section_6.Coding_Exercise_33.Floor;

public class Calculator{
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet){
        this.floor = floor;
        this.carpet = carpet;
    }
    public double getTotalCost(){
        return floor.getArea()*carpet.getCost();
    }
}
