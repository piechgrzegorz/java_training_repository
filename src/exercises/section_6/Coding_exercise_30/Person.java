package exercises.section_6.Coding_exercise_30;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setAge(int age){
        if(age<0 || age>100){
            this.age=0;
        }else{
            this.age=age;
        }
    }
    public boolean isTeen(){
        if(age>12 && age<20){
            return true;
        }else{
            return false;
        }
    }
    public String getFullName(){
        if(firstName=="" && lastName==""){
            return "";
        }else if(firstName==""){
            return lastName;
        }else if(lastName==""){
            return firstName;
        }else{
            return firstName+" "+lastName;
        }
    }
}
