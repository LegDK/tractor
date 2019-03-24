/**
 * Отрефакторенный трактор
 */
public class Tractor {

    /** Поле*/
    private final Field field;

    /** Текущая позици трактора*/
    private Position position;

    /** Текущая ориентация трактора*/
    private Orientation orientation;

    /** Инициализация без параметров*/
    public Tractor() {
        field = new Field(5, 5);
        position = new Position(0, 0);
        orientation = Orientation.NORTH;
    }

    /** Инициализация с параметрами*/
    public Tractor(Field field, Position position, Orientation orientation) {
        this.field = field != null ? field : new Field(5,5);
        this.position = position != null ? position : new Position(0,0);
        this.orientation = orientation != null ? orientation : Orientation.NORTH;
    }

    public void move(String command) {
        if ("F".equals(command)) moveForwards();
        else if ("T".equals(command)) turnClockwise();

    }

    private void moveForwards() {
        position = orientation.moveForwards(position);
        checkTractorInDitch();

    }

    private void turnClockwise() {
        orientation = orientation.turnClockwise();
    }


    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    private void checkTractorInDitch() {
        if (getPositionX() > field.getInitHorizontal() || getPositionY() > field.getInitVertical())
            throw new TractorInDitchException();
    }
}