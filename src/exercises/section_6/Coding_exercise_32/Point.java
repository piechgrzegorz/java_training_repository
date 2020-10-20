package exercises.section_6.Coding_exercise_32;

public class Point {
    private int x;
    private int y;

    public Point(){
        this(0,0);
    }
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    public double distance(){
        return distance(0, 0);
    }
    public double distance(int x, int y){
        return distance(new Point(x, y));
        /*OR
        Point point = new Point(x, y);
        return distance(point);
         */
    }
    public double distance(Point another){
        return Math.sqrt(Math.pow(x-another.getX(), 2)+Math.pow(y-another.getY(), 2));
    }
}
