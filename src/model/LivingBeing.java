package model;

public class LivingBeing {
    private int x;
    private int y;
    private String type;

    public LivingBeing (int y, int x, String type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
