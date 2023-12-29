import java.util.*;
import java.lang.Math;
import java.io.*;
import java.util.concurrent.TimeUnit;

class Main {
  public static void main(String[] args) {
    System.out.println("You are at the garden of survival, get enough coins around the garden before dying of either thirst or hunger");
    System.out.println();
    System.out.println("Start Here:");

    long Start_milliseconds = System.currentTimeMillis();
    int food = 0;
    int coins = 0;
    int drink = 0;
    var userInput = 0;
    int[] Grid = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int max = 10;
    int min = 1;
    int days = 0;
    int days2 = 0;
    int days3 = 0;
    int range = max - min + 1;
    String EmptyMap = "[ ] [ ] [ ]";
    String map;
    String map1 = "[■] [ ] [ ]";
    String map2 = "[ ] [■] [ ]";
    String map3 = "[ ] [ ] [■]";
    String maps1;
    String maps2;
    String maps3;
    int x = 4; // Start
    boolean inbounds = true;
    Random randomin = new Random();
    Scanner input = new Scanner(System.in);
    map = map2;
    maps1 = EmptyMap;
    maps2 = map;
    maps3 = EmptyMap;
      while (true) {
        // print context for current decision

        int p = x % 3;
        int move = Grid[x];
        int item = randomin.nextInt(max + min) + min;


        if(move == 1 || move == 2 || move == 3){
          maps2 = EmptyMap;
          maps3 = EmptyMap;
          maps1 = map;
        }
        else if(move == 4 || move == 5 || move == 6){
          maps1 = EmptyMap;
          maps3 = EmptyMap;
          maps2 = map;
        }
        else if(move == 7 || move == 8 || move == 9){
          maps1 = EmptyMap;
          maps2 = EmptyMap;
          maps3 = map;
        }


        long Current_milliseconds = System.currentTimeMillis();
        long milliseconds = Current_milliseconds - Start_milliseconds;
        long seconds = (TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60);

      
        System.out.println("Location: " + move);
        System.out.println();
        System.out.println(maps1);
        System.out.println(maps2);
        System.out.println(maps3);
        System.out.println();
        System.out.println("Time:" + seconds);
        System.out.println("Day:" + days);  
        System.out.println("Food:" + food);
        System.out.println("Drink:" + drink);
        System.out.println("Coins:" + coins);

        // print list of options for current decision
       
        System.out.println("(0) - End Game, (1) - Move North, (2) - Move South, (3) - Move East, (4) - Move West");
        System.out.println("------Enter Movement--------");

        // read user input
        userInput = input.nextInt();
        // update decision state for next iteration

        System.out.print("\033[H\033[2J");  
        System.out.flush();





        int y = x;

        if (userInput == 1) {
          x = x - 3;
        } else if (userInput == 2) {
          x = x + 3;
        } else if (userInput == 3) {
          x = x + 1;
        } else if (userInput == 4) {
          x = x - 1;
        } else if (userInput > 4){
          System.out.println("Move Invalid");
          continue;
        } else if (userInput == 0) {
          System.out.println("Game Ended");
          break;
        }



        if (p == 2 && userInput == 4){
          map = map2;
        }
        else if (p == 0 && userInput == 3){
          map = map2;
        }
        else if (p == 1 && userInput == 3){
          map = map3;
        }
        else if (p == 1 && userInput == 4){
          map = map1;
        }



        if (p == 0 && userInput == 4){
          System.out.println("Move Invalid");
          x = y;
          continue;
        }
        else if(p == 2 && userInput == 3) {
          System.out.println("Move Invalid");
          x = y;
          continue;
        }

        else if (move == 1 && userInput == 1 || move == 2 && userInput == 1 || move == 3 && userInput == 1 ){
          System.out.println("Move Invalid");
          x = y;
          continue;
        }
        else if (move == 7 && userInput == 2 || move == 8 && userInput == 2 || move == 9 && userInput == 2 ){
          System.out.println("Move Invalid");
          x = y;
          continue;
        }



        if (item <= 2) {
          coins = coins + 10;
          System.out.println("----------------");
          System.out.println("+10 Coins");
        } else if (item >= 2 && item <= 4) {
          drink = drink + 1;
          System.out.println("----------------");
          System.out.println("+1 Drink");
        } else if (item == 5) {
          food = food + 1;
          System.out.println("----------------");
          System.out.println("+1 Food");
        } else if (item > 5) {
          System.out.println("----------------");
          System.out.println("Room Empty!");
        }


         if(seconds >= 10){
          days = days + 1;
          Start_milliseconds = Start_milliseconds + milliseconds;
          seconds = 0;
        if(days >= days2 + 3){
          days2 = days;
          drink = drink-1;
        }
        if(days >= days3 + 7){
          days3 = days;
          food = food-1;
        }
        }


        if (food == 0 && days > 3 || drink == 0 && days > 3){
          System.out.print("\033[H\033[2J");  
          System.out.flush();
          System.out.println("Game Over!");
          System.exit(0);

        }
        else if (coins == 100){
          System.out.print("\033[H\033[2J");  
          System.out.flush();
          System.out.println("You Win!");
          System.exit(0);
        }


      }


    }

}

