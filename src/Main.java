import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hanoi gameLoop = new Hanoi();
        while (scanner.hasNextLine()) {
            final String next = scanner.nextLine();
            gameLoop.consoleLoop(next);
        }
    }
}
