import java.util.Arrays;

@SuppressWarnings("unused")
public class Hanoi {
    Tower tower;
    public Hanoi(){
        tower = new Tower(3);
        System.out.println("\u001BHanoi Hanoi Initiated, default tower(3) created");
        System.out.print("[34mHanoi\u001B[0m"+">");
    }
    public void consoleLoop(String input){
        if(input.matches("(?i)^Tower\\s+(?:[1-9]|10)$")){
            int size = Integer.parseInt(input.split("\\s+")[1]);
            tower = new Tower(size);
            System.out.println("New tower created of size " + size);
        } else if(input.matches("(?i)^Check\\s+[A-C],[A-C]")) {
            String[] moves = input.split("\\s+")[1].split(",");
            Move move = new Move(moves[0].toUpperCase(),moves[1].toUpperCase());
            String valid = tower.checkMove(move)? "valid": "invalid";
            String output = String.format("The move %s is %s.", Arrays.toString(moves),valid);
            System.out.println(output);
        } else if (input.matches("(?i)^(?:Exit|End)")){
            System.exit(0);
        }else if(input.matches("(?i)^Help")){
            System.out.println("Welcome to tower of Hanoi console. All commands are case insensitive.\n" +
                    "Available commands are: Check, Tower, Exit/End, Move, List, Size, and Help");
        }else if(input.matches("(?i)^List")){
            System.out.printf("Tower A: %s\nTower B: %s\nTower C: %s%n", tower.towers.get("A"), tower.towers.get("B"), tower.towers.get("C"));
        }else if(input.matches("(?i)^Move\\s+[A-C],[A-C]")){
            String[] moves = input.split("\\s+")[1].split(",");
            Move move = new Move(moves[0].toUpperCase(),moves[1].toUpperCase());
            String success = tower.executeMove(move)? "Executed Successfully":"Failed due to a validation error";
            String output = String.format("Move %s %s", Arrays.toString(moves),success);
            System.out.println(output);
        }else if(input.matches("(?i)^size")){
            int minMoves = (int) ((Math.pow(2,tower.size)) - 1);
            System.out.printf("Tower is size %d\nAnd requires at least %d moves to solve.%n", tower.size, minMoves);
        }else{
            System.out.println("\u001B[31mNot a recognized command at this time, or syntax error.\u001B[0m");
        }
        System.out.print("\u001B[34mHanoi\u001B[0m"+">");
    }
    public void checkSolved(){
        if (tower.towers.get("A").isEmpty() && tower.towers.get("B").isEmpty()){
            long elapsedTimeSeconds = (System.currentTimeMillis() - tower.startTime)/1000;
            System.out.printf("\u001B[32mCongradulations! You have completed the tower in %d minutes and %d seconds. Use the tower command to start again.",
                    elapsedTimeSeconds%60, elapsedTimeSeconds - elapsedTimeSeconds%60);

        }
    }
}
