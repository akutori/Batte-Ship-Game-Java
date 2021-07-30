import java.util.Random;
public class Ship {
    public String name;
    public int hp=3;
    public static int[][] position= new int [5][5]; 
    
    public final int[][] st = {{0,1,0},{0,1,0}};//攻撃判定
    
    Random r =new Random();
    int randomX = 1+ r.nextInt(4); //船位置決めX
    int randomY = 1+ r.nextInt(4); //船位置決めY
    int flg = 1;
   Ship(String name,int randomX,int randomY, int hp) {//コンストラクタによる値の初期化
        this.name = name;
        this.hp = hp;
        while(flg!=0) {
        	if(position[randomX][randomY]!=1) {
        		position[randomX][randomY] = 1 ;//X,Y座標に位置である1を設定
        		System.out.println(randomX+" "+randomY+this.name);
        		flg--;
        	} else {
        		randomX = 1+ r.nextInt(4);
        		randomY = 1+ r.nextInt(4);
        	}
        }
    }
    
    public void nearmiss(int x,int y,String name) {
        System.out.printf("%s::X=%d,Y=%d:波高し\n",this.name,x,y);
    }
    
    public int getXY(int x,int y) { //値取り出し
    	return position[x][y];
    }

    public void shoot(int x,int y) { 
        //入力値と船の位置が同じならメソッド実行。近いならニアミスメソッド実行。
    	if(position[x][y]==1&&getXY(x,y)==1){

    		hit(this.hp,x,y);

    	} else if(st[0][1]==getXY(x,y)||st[1][0]==getXY(x,y)||st[1][2]==getXY(x,y)||st[2][1]==getXY(x,y)) {
    		
            nearmiss(x,y,this.name);

    	} else {
    		Game.miss();
    	}
    }
    
    public void ShipA(int hp) {
    	switch(this.hp) {
    		case 3:
    			System.out.printf("%s:生きてる\n",this.name);
    			break;
    		case 2:
    			System.out.printf("%s:少し生きてる\n",this.name);
    			break;
    		case 1:
    			System.out.printf("%s:死にかけ\n",this.name);
    			break;
    		default:
    			System.out.printf("%s:死亡\n",this.name);
    			break;
    	}
    }
    
    public void hit(int hp,int x,int y) {
    	if(this.hp>0) {
    		this.hp -=1;
    		System.out.printf("%sにヒット残り%d\n\n",this.name,this.hp);
                randomX = 1+ r.nextInt(4);
        		randomY = 1+ r.nextInt(4);
                position[x][y]=0;
                position[randomX][randomY]=1;
            if(this.hp==0){
                System.out.printf("%s撃沈\n",this.name);
            }
    	}else {
    		Game.miss();
    	}
    }
    
}