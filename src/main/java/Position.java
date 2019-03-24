/**
 * Класс отвечающий за текущие координаты
 */
public class Position {

    /** Ось Х*/
    private final int x;

    /** Ось Y*/
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
