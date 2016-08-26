package sample;
import java.util.ArrayList;


/**
 * Created by GreenMan on 3/22/2016.
 */
public class NPC extends Character {

    private int HP;
    //private int attackBonus;
    private int AC;
    private ArrayList<Attack> attacks;
    private int fort, will, reflex;
    private String name;


    public int getFort(){return fort;}
    public int getWill(){return will;}
    public int getReflex(){return reflex;}
    public int getHP(){return HP;}
    //public int getAttackBonus(){return attackBonus;}
    public int getAC(){return AC;}
    public Attack getAtk(){return atk;}

    public void setHP(int hp){this.HP = hp;}
   // public void setAttackBonus(int AB){this.attackBonus = AB;}
    public void setAC(int ac){this.AC = ac;}
    public void setFort(int fort){this.fort = fort;}
    public void setWill(int will){this.will = will;}
    public void setReflex(int reflex){this.reflex = reflex;}

    public void addAttack(Attack attack){


        attacks.add(attack);

    }

    public NPC(){
        HP = 0;
        AC = 0;
        attacks = null;
        fort = 0;
        will = 0;
        reflex = 0;
    }

    public NPC(int HP, int ac, ArrayList<Attack> atks, int fort, int will, int reflex, int init, int initBonus, String name)
    {
        this.HP = HP;
        this.AC = ac;
        this.reflex = reflex;
        this.fort = fort;
        this.will = will;
        this.attacks = atks;
        this.setInitiative(init);
        this.setInitiativeBonus(initBonus);
        this.setName(name);
    }




}
