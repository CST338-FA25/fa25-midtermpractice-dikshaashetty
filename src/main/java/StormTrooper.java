/**
 * @author Diksha
 * @version 0.1.0
 * @since 11/18/2025
 */
public class StormTrooper extends Trooper {
    //Fields, Data Members and Variables
    private String name = "";
    private static int soldierCount = 0;

    // Constructors
    public StormTrooper(String unit, int number) {
        super(unit, number);
        soldierCount++;
        super.trooperKind = "Storm Trooper";
        super.marchModifier = 1.10;
    }

    // Methods
    // Getters and Setters generated
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    // march implementation- required to implement the abstract method
    @Override
    public double march(double duration) {
        return marchSpeed * duration * marchModifier;
    }

    // toString() override
    @Override
    public String toString() {
        return name + "(" + super.toString() + ") a " + trooperKind;
    }
}
