import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Diksha
 * @version 0.1.0
 * @since 11/18/2025
 */
public abstract class Trooper {
    //Field. Data Members and Variables
    private String unit;
    private int number;
    protected String trooperKind;
    protected double marchSpeed;
    protected double marchModifier;

    //Constructors
    //No-parameter constructor
    public Trooper() {
        this("AA",0);   // using "this" to call the parameterized constructor with default values of “AA” and 0
    }

    //Parameterized Constructor
    public Trooper(String unit, int number) {
        //using the input parameters to set the fields unit and number
        this.unit = unit;
        this.number= number;
        this.marchSpeed=5;  //set marchSpeed to 5
    }

    //Getters and Setters generated
    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    //equals and hashCode generated
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(marchSpeed, trooper.marchSpeed) == 0 && Double.compare(marchModifier, trooper.marchModifier) == 0 && Objects.equals(unit, trooper.unit) && Objects.equals(trooperKind, trooper.trooperKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }

    //toString
    @Override
    public String toString() {
        // Returns unit number
        return unit + number + ":";
    }

    // addToUnit method
    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        //to check if the Trooper object is null, if so return
        if (t == null) {
            return;
        }
        String unitKey = t.getUnit();
        if (!units.containsKey(unitKey)) {   //to check if hashMap has the key
            units.put(unitKey, new ArrayList<Trooper>());   //if no, creat a new list and add it to the hashmap
        }
        units.get(unitKey).add(t);   //add the Trooper object to the List
    }

    //abstract method
    public abstract double march(double duration);

    //attack method
    public boolean attack(Trooper target, int roll) {
        System.out.println(this.toString() + " is attacking " + target.toString());
        System.out.println(this.toString() + " rolled a " + roll);

        //1) Self-Targeting or Roll of 1 Check
        if (this.equals(target) || roll == 1) {
            System.out.println(this.toString() + " is targeting itself...");
            System.out.println(this.toString() + " rolled a " + roll + " and hurt itself in the confusion.");
            return true;
        }

        //2) Storm Trooper Attacking Logic
        if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {    // Target is RebelTrooper
                System.out.println("Rolled a " + roll + " against the rebel scum.");
                // return true if roll > 10 AND roll is even
                return (roll > 10 && roll % 2 == 0);
            } else if (target instanceof StormTrooper) {    // Target is Stormtrooper
                System.out.println("No treason in the ranks!");
                return false;
            } else {     // Target is anything else
                System.out.println("Acceptable Collateral Damage!");
                // return TRUE if roll > 10 OR roll is even
                return (roll > 10 || roll % 2 == 0);
            }
        }
        //3) Rebel Trooper Attacking Logic
        else if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {    // Target is RebelTrooper
                System.out.println("Imperial Spy!");
                return false;
            } else if (target instanceof StormTrooper) {    // Target is Stormtrooper
                System.out.println("Rolled a " + roll + " against the imperial scum.");
                // return true if roll is greater than 5 OR roll is odd
                return (roll > 5 || roll % 2 != 0);
            } else {    // Target is anything else
                System.out.println("Rebels target an innocent bystander");
                // return TRUE if roll >= 18 AND roll is even
                return (roll >= 18 && roll % 2 == 0);
            }
        }
        return false;
    }
}
