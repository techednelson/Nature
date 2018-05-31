package model;

public class Animal extends LivingBeing {

    private static int totalAnimals;
    private static int totalLions;
    private static int totalTigers;
    private static int totalGoats;
    private static int totalSheeps;

    private int age;
    private int ageToGiveBirth;
    private int speed;
    private int hungerResistance;

    public Animal (
            int y,
            int x, int ageToGiveBirth,
            int speed,
            int hungerResistance,
            String type
        )
    {
        super(y, x, type);

        this.ageToGiveBirth = ageToGiveBirth;
        this.speed = speed;
        this.hungerResistance = hungerResistance;

        switch(type) {
            case "tiger":
                totalTigers++;
                break;
            case "lion":
                totalLions++;
                break;
            case "goat":
                totalGoats++;
                break;
            case "sheep":
                totalSheeps++;
                break;
        }
        totalAnimals++;
    }

    public static int getTotalAnimals() { return totalAnimals; }

    public static int getTotalLions() { return totalLions; }

    public static int getTotalTigers() { return totalTigers; }

    public static int getTotalGoats() { return totalGoats; }

    public static int getTotalSheeps() { return totalSheeps; }

    public int getAge() { return age; }

    public void setAge() { this.age++; }

    public int getAgeToGiveBirth() { return ageToGiveBirth; }

    public void setAgeToGiveBirth(int ageToGiveBirth) { this.ageToGiveBirth = ageToGiveBirth; }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getHungerResistance() { return hungerResistance; }

    public void setHungerResistance(int hungerResistance) { this.hungerResistance = hungerResistance; }

}
