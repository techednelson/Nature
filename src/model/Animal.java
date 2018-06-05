package model;

public class Animal extends LivingBeing {

    private static int totalAnimals;
    private static int totalLions;
    private static int totalTigers;
    private static int totalGoats;
    private static int totalSheeps;
    private static int diedAnimalsForStarvation;
    private static int animalsEaten;

    private int age;
    private int ageToGiveBirth;
    private int speed;
    private int hungerResistance;
    private boolean isAnimalInSameLocationWithPlant;

    public Animal (
            int y,
            int x,
            int ageToGiveBirth,
            int speed,
            String type
        )
    {
        super(y, x, type);

        this.ageToGiveBirth = ageToGiveBirth;
        this.speed = speed;
        this.hungerResistance = 4;

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

    public static int getDiedAnimalsForStarvation() { return diedAnimalsForStarvation; }

    public static void setDiedAnimalsForStarvation() { diedAnimalsForStarvation++; }

    public static int getAnimalsEaten() { return animalsEaten; }

    public static void setAnimalsEaten() { animalsEaten++; }

    public int getAge() { return age; }

    public void setAge() { this.age++; }

    public int getAgeToGiveBirth() { return ageToGiveBirth; }

    public int getSpeed() { return speed; }

    public int getHungerResistance() { return hungerResistance; }

    public void setHungerResistance() { this.hungerResistance = 4; }

    public boolean isAnimalInSameLocationWithPlant() { return isAnimalInSameLocationWithPlant; }

    public void setAnimalInSameLocationWithPlant(boolean isSameLocation) { this.isAnimalInSameLocationWithPlant = isSameLocation; }

}
