package exercises.section_6.Coding_exercise_35;

public class Circle {
    private double radius;
    public Circle(double radius){
        if(radius<0){
            this.radius=0;
        }else{
            this.radius=radius;
        }
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }
}
