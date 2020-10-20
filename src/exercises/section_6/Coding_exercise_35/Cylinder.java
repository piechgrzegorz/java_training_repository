package exercises.section_6.Coding_exercise_35;

public class Cylinder extends Circle{
    private double height;
    public Cylinder(double radius, double height){
        super(radius);
        if(height<0){
            this.height=0;
        }else{
            this.height=height;
        }
    }
    public double getHeight(){
        System.out.println("ddddddddddddddd");
        return this.height;
    }
    public double getVolume(){
        return this.height*getArea();
    }
}
