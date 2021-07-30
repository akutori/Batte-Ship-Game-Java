import java.util.*;
public class Game {
    
    public static int turn=1;
    private int[][] shipXY= new int[5][5];
    int x;
    int y;
    
    public static void GameStart() {
        System.out.printf("----------\n戦艦ゲーム\n----------\n\n");
        
    }
    
    public static void GameTurn() {
        System.out.printf("---------- ターン:%d ----------\n",turn);
        turn++;
    }
     
    public static void miss () {
        System.out.printf("ヒットしませんでした\n");
    }

}