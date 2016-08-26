/**
 * Created by GreenMan on 3/22/2016.
 */
package sample;
public class Attack {

    private String name;
    private String range;
    private Dice dice;
    private int AttackBonus;

    public String getRange(){return this.range;}
    public String getName(){return this.name;}
    public String getDice(){return dice.getDice();}

    public void setRange(String type){this.range = range;}
    public void setName(String name){this.name = name;}
    public void setAttackBonus(int atkBonus){this.AttackBonus = atkBonus;}
    public void setDice(int num, int dice, int bonus){this.dice.setDice(num, dice, bonus);}



    Attack(String nameIn, String rangeIn, Dice die, int AB){

        this.name = nameIn;
        this.dice = die;
        this.range = rangeIn;
        this.AttackBonus = AB;

    };
}
