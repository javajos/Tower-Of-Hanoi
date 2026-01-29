import java.util.Arrays;

@SuppressWarnings("unused")
public class Hanoi {
    Tower tower;

    public Hanoi() {
        tower = new Tower(3);
        System.out.println("\u001B[34mHanoi console Initiated, default tower(3) created");
        System.out.print("Hanoi\u001B[0m" + ">");
    }

    public void consoleLoop(String input) {
        if (input.matches("(?i)^Tower\\s+(?:[1-9]|[1-9][1-9])$")) {
            cTower(input);
        } else if (input.matches("(?i)^Check\\s+[A-C],[A-C]")) {
            cCheck(input);
        } else if (input.matches("(?i)^(?:Exit|End)")) {
            cExit();
        } else if (input.matches("(?i)^Help")) {
            cHelp();
        } else if (input.matches("(?i)^List")) {
            cList();
        } else if (input.matches("(?i)^Move\\s+[A-C],[A-C]")) {
            cMove(input);
        } else if (input.matches("(?i)^size")) {
            cSize();
        } else {
            cErr();
        }
        System.out.print("\u001B[34mHanoi\u001B[0m" + ">");
    }

    public void checkSolved() {
        if (tower.towers.get("A").isEmpty() && tower.towers.get("B").isEmpty()) {
            long elapsedTimeSeconds = (System.currentTimeMillis() - tower.startTime) / 1000;
            System.out.printf("\u001B[32mCongradulations! You have completed the tower in %d minutes and %d seconds. Use the tower command to start again.",
                    elapsedTimeSeconds % 60, elapsedTimeSeconds - elapsedTimeSeconds % 60);

        }
    }

    private void cReturn(String message, boolean isErr) {
        String mColor = isErr ? "\u001B[31m" : "\u001B[0m";
        System.out.printf("\u001B[34mHanoi: %s%s\n", mColor, message);
    }

    private void cSize() {
        int minMoves = (int) ((Math.pow(2, tower.size)) - 1);
        String out = String.format("Tower is size %d\nAnd requires at least %d moves to solve.%n", tower.size, minMoves);
        cReturn(out, false);
    }

    private void cMove(String input) {
        String[] moves = input.split("\\s+")[1].split(",");
        Move move = new Move(moves[0].toUpperCase(), moves[1].toUpperCase());
        boolean test = tower.executeMove(move);
        String success = test ? "Executed Successfully" : "Failed due to a validation error";
        String out = String.format("Move %s %s", Arrays.toString(moves), success);
        cReturn(out, !test);
    }

    private void cHelp() {
        String out = "Welcome to tower of Hanoi console. All commands are case insensitive.\n" +
                "Available commands are: Check, Tower, Exit/End, Move, List, Size, and Help";
        cReturn(out, false);
    }

    private void cErr() {
        String out = "Not a recognized command at this time, or syntax error.";
        cReturn(out, true);
    }

    private void cList() {
        String out = String.format("Tower A: %s\nTower B: %s\nTower C: %s%n", tower.towers.get("A"), tower.towers.get("B"), tower.towers.get("C"));
        cReturn(out, false);
    }

    private void cExit() {
        System.out.println("\u001B[34Goodbye, thanks for playing!");
        System.exit(0);
    }

    private void cCheck(String input) {
        String[] moves = input.split("\\s+")[1].split(",");
        Move move = new Move(moves[0].toUpperCase(), moves[1].toUpperCase());
        String valid = tower.checkMove(move) ? "valid" : "invalid";
        String out = String.format("The move %s is %s.", Arrays.toString(moves), valid);
        cReturn(out, !tower.checkMove(move));
    }

    private void cTower(String input) {
        int size = Integer.parseInt(input.split("\\s+")[1]);
        boolean success;
        try {
            tower = new Tower(size);
            success = true;
        } catch (IllegalArgumentException e) {
            success = false;
        }

        String out = success ? ("New tower created of size " + size) : "Error, tower must be less than size 10";
        cReturn(out, !success);
    }
}
