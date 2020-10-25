package pl.wiktor.backend.board;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Field implements Comparable<Field>{
    private final int x;
    private final int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int distance(Field to){
        int xDistance = Math.abs(x - to.getX());
        int yDistance = Math.abs(y - to.getY());

        return Integer.max(xDistance, yDistance);
    }

    public List<Field> fieldsBetween(Field to){
        List<Field> fieldsBetween = new ArrayList<>();
        int distance = distance(to);

        int x = this.x;
        int y = this.y;

        if(this.x > to.x) {
            x = to.x;
        }
        if(this.y > to.y) {
            y = to.y;
        }

        for(int i = 1; i < distance; i++){
            fieldsBetween.add(new Field(x + i, y + i));
        }

        return fieldsBetween;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return x == field.x &&
                y == field.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Field o) {
        return Comparator.comparingInt(Field::getX).thenComparingInt(Field::getY).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%d|%d", x, y);
    }
}
