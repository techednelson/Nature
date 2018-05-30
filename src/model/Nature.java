package model;

public class Nature {

    private static Nature nature;
    private static LivingBeing[][] map = new LivingBeing[8][8];
    private int turn;

    private Nature() {}

    public static Nature getNature() {

        if(nature == null) {
            nature = new Nature();
        }

        return nature;
    }

    public LivingBeing[][] getMap() { return map; }

    public void addLivingBeingToMap(LivingBeing being) {

        int y = being.getY();
        int x = being.getX();

        map[y][x] = being;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
