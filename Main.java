import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nInput your integer numbers from 1 to infinity. \nPress 'Enter' upon completion.");

            String line;
            int input = 0;

            while (!(line = scanner.nextLine()).isEmpty()) {    
                try {
                    input = Integer.valueOf(line);
                } catch (Exception e) {
                    System.out.println("*** Entry omitted: input must be a number ***");
                    continue;
                }

                try {
                    if (input < 1) throw new IllegalArgumentException("*** Number omitted: numbers must be at least 1 ***");
                    else if (inputs.contains(input)) throw new IllegalArgumentException("*** Number omitted: duplicate number found ***");
                    else inputs.add(input);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        for (int num : inputs) {
            System.out.print(num + ",");
        }

        Game game = new Game(inputs.toArray());
    }
}
