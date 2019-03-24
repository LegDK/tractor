/**
 * Енум отвечающий за ориентацию трактора
 */
public enum Orientation {

    NORTH {
        public Orientation turnClockwise() {
            return Orientation.EAST;
        }

        public Position moveForwards(Position Position) {
            return new Position(Position.getX(), Position.getY() + 1);
        }

    }, WEST {
        public Orientation turnClockwise() {
            return Orientation.NORTH;
        }

        public Position moveForwards(Position Position) {
            return new Position(Position.getX() - 1, Position.getY());
        }

    }, SOUTH {
        public Orientation turnClockwise() {
            return Orientation.WEST;
        }

        public Position moveForwards(Position Position) {
            return new Position(Position.getX(), Position.getY() - 1);
        }

    }, EAST {
        public Orientation turnClockwise() {
            return Orientation.SOUTH;
        }

        public Position moveForwards(Position Position) {
            return new Position(Position.getX() + 1, Position.getY());
        }
    };

    public abstract Orientation turnClockwise();

    public abstract Position moveForwards(Position Position);

}
