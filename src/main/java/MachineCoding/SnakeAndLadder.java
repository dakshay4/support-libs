package MachineCoding;

import java.util.*;

/**
 * Created by dakshay on 22/10/2021.
 */
public class SnakeAndLadder {
    public static int random(){
        final int diceMax = 6;
        final int diceMin = 1;
        Random random = new Random();
        return random.nextInt(diceMax - diceMin + 1) + diceMin;
    }
    public static void main(String[] args) {

        try {
            int noIfLadders = 8;
            Scanner sc = new Scanner(System.in);
            int numberOfSnakes = sc.nextInt();
            Map<Integer, Integer> snakeMap = new HashMap<>();
            for (int i = 0; i < numberOfSnakes; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                snakeMap.put(a, b);

            }
            System.out.println("SNAKES"+snakeMap);
            int noOfLadders = sc.nextInt();
            Map<Integer, Integer> ladderMap = new HashMap<>();
            for (int i = 0; i < noOfLadders; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                ladderMap.put(a, b);
            }
            System.out.println("LADDERS"+ladderMap);

            int totalPlayer = sc.nextInt();
//            String[] names = new String[totalPlayer];
//            for(int i=0;i<totalPlayer;i++){
//                names[i] = sc.nextLine();
//            }
            boolean gameRunning = true;
            int winner = -1;
            Integer[] loc = new Integer[totalPlayer]; Arrays.fill(loc, 0);
            System.out.println("totalPlayers "+ totalPlayer);
//            System.out.println("names ");
//            for(int i=0;i<totalPlayer;i++){
//                System.out.print(names[i] + " ,, ,");
//            }
            while (gameRunning) {
                for (int i = 0; i < totalPlayer; i++) {
                    int randomDice = random();
                    String temp = i + " Rolled a " + randomDice + " and moved from " + loc[i];
//                    System.out.println(temp);
                    if(loc[i] + randomDice <=100 ) {
                        loc[i] += randomDice;
                        positionMovement(loc, i, snakeMap, ladderMap);
                        if (loc[i] == 100) {
                            gameRunning = false;
                            winner = i;
                        }
                    }
                    temp+=" to " + loc[i];
                    System.out.println(temp);
                }
            }
            System.out.println("Winner is: " + winner);
        }catch (Exception ex) {
            System.out.println();
        }
    }

    private static void positionMovement(Integer[] ar, int index,  Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap) {
        while(snakeMap.containsKey(ar[index])) {
            ar[index]=snakeMap.get(ar[index]);
        }
        while(ladderMap.containsKey(ar[index])) {
            ar[index]=ladderMap.get(ar[index]);
        }
    }
}
