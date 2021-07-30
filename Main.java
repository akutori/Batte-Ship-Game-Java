import java.util.*;
public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    	
    	Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int inputX;
        int inputY;
        int[][] input= new int[5][5];
        int randomValue01 =1 + random.nextInt(4);
        int randomValue02 =1 + random.nextInt(4);
        System.out.println(randomValue01+" "+randomValue02);
        
        Ship s1 = new Ship("s1",randomValue01,randomValue02,3);
        Ship s2 = new Ship("s2",randomValue01,randomValue02,3);
        Ship s3 = new Ship("s3",randomValue01,randomValue02,3);
            	
        Game.GameStart();
        
        while(s1.hp!=0&&s2.hp!=0&&s3.hp!=0) {
        	Game.GameTurn();
    		s1.ShipA(s1.hp);
    		s2.ShipA(s2.hp);
    		s3.ShipA(s3.hp);
    		System.out.printf("座標を入力してください(0-4,5以上は4になる)\n");
    		inputX = sc.nextInt();
    		inputY = sc.nextInt();
    		if(inputX>=5||inputY>=5) {
    			inputX = 4;
    			inputY = 4;
    		}
    		input[inputX][inputY]=1;
    		s1.shoot(inputX,inputY);
    		s2.shoot(inputX,inputY);
    		s3.shoot(inputX,inputY);
    	}        
        sc.close();
    }
}