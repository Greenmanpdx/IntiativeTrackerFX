/**
 * Created by GreenMan on 3/22/2016.
 */package sample;
public class Character extends Node implements Comparable<Character>{


    private String name;
    private int initiative;
    private int initiativeBonus;

    public int getInit(){return initiative;}
    public  int getInitiativeBonus(){return initiativeBonus;};
    public String getName(){return name;};

    public void setName(String charName){ this.name = charName;}
    public void setInitiative(int init){this.initiative = init;}
    public void setInitiativeBonus(int bonus){this.initiativeBonus = bonus;}



    public int compareTo(Character compChar) {

        int compareInit = (compChar).getInit();
        int compareBonus = (compChar).getInitiativeBonus();

        if (compareInit == this.initiative){
            return this.initiativeBonus - compareBonus;
        }else
            return compareInit - this.initiative;
    }


}
