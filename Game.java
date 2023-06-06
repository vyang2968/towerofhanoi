import java.util.Scanner;

public class Game {
    private Tower first;
    private Tower second;
    private Tower third;

    public Game(Object[] input) {
        first = new Tower(toArray(input));
        second = new Tower();
        third = new Tower();
    }

    private int[] toArray(Object[] input) {
        int[] out = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            out[i] = Integer.valueOf(input[i].toString());
        }

        return out;
    }

    public boolean isComplete() {
        boolean firstIsEmpty = first.isEmpty();

        if (second.isEmpty()) {
            return third.isAscending() && firstIsEmpty;
        } else if (third.isEmpty()) {
            return second.isAscending() && firstIsEmpty;
        } else return false;
    }

    private int remove(int piece) {
        if (piece == first.getTop()) {
            return first.pop();
        } else if (piece == second.getTop()) {
            return second.pop();
        } else if (piece == third.getTop()) {
            return third.pop();
        } else {
            throw new IllegalArgumentException("Piece is not on the top or is missing");
        }
    }

    public void display() {
        
    }

    public void move(int piece, String destination) {
        try {
            piece = remove(piece);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        switch (destination) {
            case "first":
                first.push(piece);
                break;
            case "second":
                second.push(piece);
            break;
            case "third":
                third.push(piece);
            default:
                break;
        }
    }
}
