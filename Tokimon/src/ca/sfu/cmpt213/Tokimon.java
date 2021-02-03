package ca.sfu.cmpt213;

//contains all the required data and set/get methods for a Tokimon
public class Tokimon {
    //all the required stats for a Tokimon
    private String name;
    private String type;
    private double height;
    private double weight;
    private int strength;

    //default constructor
    public Tokimon(){
        name = "";
        type = "";
        height = 0;
        weight = 0;
        strength = 0;
    }

    //constructor used for addNewToki()
    public Tokimon(String name, String type, double height, double weight, int strength){
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public double getHeight(){
        return height;
    }

    public double getWeight(){
        return weight;
    }

    public int getStrength(){
        return strength;
    }

    //since augment increases strength I used += instead of =
    public void changeStrength(int num){
        strength+=num;
    }

    //clean toString() for a Tokimon
    @Override
    public String toString(){
        return(getClass().getName() + " [Name: " + name + ", Type: " + type + ", Height: " + height + ", Weight: " + weight + ", Strength: " + strength + "]");
    }
}
