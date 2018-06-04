package model;

public class Nature {

    private static Nature nature;
    private static LivingBeing[][] map = new LivingBeing[8][8];
    private static int turn;

    private Nature() {}

    public static Nature getNature() {

        if(nature == null) {
            nature = new Nature();
        }

        return nature;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn() {
        turn++ ;
    }

    public LivingBeing[][] getMap() { return map; }

    public static void setMap(LivingBeing[][] map) {
        Nature.map = map;
    }

    public void addLivingBeingToMap(LivingBeing being) {

        int y = being.getY();
        int x = being.getX();

        map[y][x] = being;
    }

}
