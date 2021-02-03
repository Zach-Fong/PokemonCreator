package ca.sfu.cmpt213;

import java.util.ArrayList;
import java.util.Scanner;
//contains the arraylist holding the Tokimon, and all required methods for game
public class Game {
    //arraylist to hold all the Tokimon
    private ArrayList<Tokimon> list = new ArrayList<Tokimon>();

    //will enter the main menu when a game is created
    public Game(){
        displayMainMenu();
    }

    public void deleteToki(){
        //prints all Tokimon so player can enter Tokimon to delete
        Scanner input = new Scanner(System.in);
        displayAllTokis();

        //if theres no Tokimon in list it exits
        if(list.size()==0){
            System.out.println("No Tokimon");
            return;
        }

        System.out.println("Enter the position of the Tokimon to remove");
        int pos = input.nextInt();

        //checks for valid entries
        while(pos>list.size() || pos<0) {
            System.out.println("Delete a Tokimon between positions 1 and " + list.size());
            pos = input.nextInt();
        }

        if(pos == 0){
            System.out.println("Cancelled");
            return;
        }

        //removes Tokimon if the entry is valid
        list.remove(pos-1);
    }

    public void addNewToki(){
        //receives all info needed to make a Tokimon
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Tokimon name: ");
        String name = input.nextLine();

        System.out.println("Enter Tokimon type: ");
        String type = input.nextLine();

        System.out.println("Enter Tokimon height (cm): ");
        double height = input.nextDouble();
        while(height<0){
            System.out.println("Must enter positive height");
            height = input.nextDouble();
        }

        System.out.println("Enter Tokimon weight (kg): ");
        double weight = input.nextDouble();
        while(weight<0){
            System.out.println("Must enter positive weight");
            weight = input.nextDouble();
        }

        System.out.println("Enter Tokimon strength (whole number): ");
        int strength = input.nextInt();
        while(strength<0 || strength>100){
            System.out.println("Must enter positive strength up to 100");
            strength = input.nextInt();
        }

        //Tokimon is created and added to the arraylist with the provided stats
        Tokimon toki = new Tokimon(name, type, height, weight, strength);
        list.add(toki);
    }

    public void displayAllTokis(){
        //base case when the arraylist is empty
        if(list.size() == 0){
            System.out.println("No Tokimon");
            return;
        }

        //prints all stats for each Tokimon in the arraylist
        Tokimon tmp = new Tokimon();
        System.out.println("********************\n    TOKIMON LIST");
        for(int a=0; a<list.size(); a++){
            tmp = list.get(a);
            System.out.println(a+1 + ")");
            System.out.println("Name: " + tmp.getName());
            System.out.println("Type: " + tmp.getType());
            System.out.println("Height: " + tmp.getHeight());
            System.out.println("Weight: " + tmp.getWeight());
            System.out.println("Strength: " + tmp.getStrength());
        }
        System.out.println("********************\n\n");
        //since you return to the main menu after the user chooses this from the main menu, the output is above the main menu text
    }

    public void alterToki(){
        //prints all Tokimon and lets user choose one
        Scanner input = new Scanner(System.in);
        displayAllTokis();

        //if list is empty theres no Tokimon to alter
        if(list.size()==0){
            return;
        }

        System.out.println("Enter the position of the Tokimon to augment");
        int pos = input.nextInt();

        //if Tokimon already at max strength return
        if(list.get(pos-1).getStrength()==100){
            System.out.println("Strength already max");
            return;
        }

        //only checks valid entries
        while(pos>list.size() || pos<0){
            System.out.println("Augment a Tokimon between positions 1 and " + list.size());
            pos = input.nextInt();
        }

        if(pos == 0) {
            System.out.println("**Cancelled**\n");
            return;
        }

        //increased the strength of the Tokimon by the amount entered
        System.out.println("Enter the amount to augment");
        int aug = input.nextInt();

        //checks to make sure the strength does not exceed 100
        while(list.get(pos-1).getStrength()+aug>100 || aug<0){
            System.out.println("strength augmented can't exceed 100 and must be positive");
            aug = input.nextInt();
        }
        list.get(pos-1).changeStrength(aug);
    }

    public void displayMainMenu(){
        //prints out main menu with all options
        Scanner input = new Scanner(System.in);;
        System.out.println("\n**** Main Menu ****\n");
        System.out.println("1. List Tokimon");
        System.out.println("2. Add Tokimon");
        System.out.println("3. Remove Tokimon");
        System.out.println("4. Augment strength");
        System.out.println("5. toString()");
        System.out.println("6. Exit");
        System.out.println("\n**** Main Menu ****\n");

        //lets user select the option desired
        int num = input.nextInt();
        if(num == 1){
            displayAllTokis();
        }
        if(num == 2){
            addNewToki();
        }
        if(num==3){
            deleteToki();
        }
        if(num==4){
            alterToki();
        }
        if(num==5){
            System.out.println(toString());
        }
        if(num == 6){
            System.out.println("Exiting");
            return;
        }
        if(num<1 || num>6){
            System.out.println("Choose between 1 and 6");
        }
        //ensures after every option is finished they return to the main menu, or exit if 6 is entered
        displayMainMenu();
    }

    @Override
    public String toString(){
        //iterates through the arraylist returning each Tokimon separated by a new line
        String out = "";
        int count = 0;
        for(Tokimon a: list){
            if(count == list.size()-1){
                return out + a.toString();
            }
            out +=  a.toString() + "\n";
            count++;
        }
        return out;
    }
}
