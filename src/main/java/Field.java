/**
 * Класс отвечающий за размеры поля
 */
class Field {

    /** Ось Х*/
    private final int initHorizontal;

    /** Ось Y*/
    private final int initVertical;

    public Field(int initHorizontal, int initVertical) {
        this.initHorizontal = initHorizontal;
        this.initVertical = initVertical;
    }

    public int getInitHorizontal() {
        return initHorizontal;
    }

    public int getInitVertical() {
        return initVertical;
    }
}
