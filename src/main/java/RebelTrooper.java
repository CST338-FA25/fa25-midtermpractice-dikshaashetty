/**
 * @author Diksha
 * @version 0.1.0
 * @since 11/18/2025
 */
    public class RebelTrooper extends Trooper {
        //Fields, Data Members and Variables
        private String name = "Rebel";
        private static int soldierCount = 0;

        // Constructors
        public RebelTrooper(String unit, int number, String name) {
            super(unit, number);
            soldierCount++;
            super.trooperKind = "pilot";
            super.marchModifier = 0.75;
            this.name = name;
        }

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

    //implementing abstract method from Trooper
    @Override
    public double march(double duration) {
        // returns marchSpeed multiplied by duration multiplied by the marchModifier
        return marchSpeed * duration * marchModifier;
    }

    @Override
    public String toString() {
        // returns name + "(" + parent's toString + ") a " + trooperKind
        // Example output: Luke(red5:) a pilot
        return name + "(" + super.toString() + ") a " + trooperKind;
    }
} // End of RebelTrooper class


 }
