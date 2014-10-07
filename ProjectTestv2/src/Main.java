/**
 * 	author Eric Lin
 * 	Completed
 * 		Main class
 */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;


public class Main {
	static boolean repeat= true;
	static Scanner console = new Scanner(System.in);
	static int total;
	static int num = 5;
	static final int MIN = 0;
	static Test2 window;
	
	public static void main(String[] args){
		
		window = new Test2();
		window.pack();
		window.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.setVisible(true);
		
		do{
		startGame();
		}
		while(repeat);
		console.close();
	}
	
	public static void startGame(){
		Test2.addText("game1 = Player vs Player\n");
		Test2.addText("game2 = Player vs New AI\n");
		Test2.addText("game3 = Player vs Normal AI that, from time to time, act retarded\n");
		Test2.addText("game4 = Player vs Somewhat unbeatable AI\n");
		Test2.addText("Select game:(1-4)\n\n");
		String gameNum = input();
		gameNumError(gameNum,1,4);
		if(repeat==true){
			restart();
		}
	}
	
	public static void game(int num){
		if(num==1){
			game1();
		}
		if(num==2){
			game2();
		}
		if(num==3){
			game3();
		}
		if(num==4){
			game4();
		}
	}
	
	public static void game1(){
		Test2.addText("Game1 chosen/n");
		Game1 game = new Game1();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game2(){
		Test2.addText("Game2 chosen/n");
		Game2 game = new Game2();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game3(){
		Test2.addText("Game3 chosen/n");
		Game3 game = new Game3();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game4(){
		//to be implemented
		Test2.addText("Game4 chosen/n");
		Game4 game = new Game4();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static String input(){
		String gameNum = "";
		for(int x=0; x<1; x++){
			if(gameNum.length() < 1){
				gameNum = window.returnText();
				x--;
			}
		}
		window.jtfInput.setText("");
		window.textClear();
		return gameNum;
	}
	
	public static void gameNumError(String gameNum, int min, int max){
		if(isInteger(gameNum)){
			int num = Integer.parseInt(gameNum);
			if(num>=min && num<=max){
				game(num);
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "/n");
				gameNumError(input(),min,max);
			}
		}
		else if(checkInput(gameNum)){
			Test2.addText("error: input not an int/n");
			gameNumError(input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static void restartError(String num, int min, int max){
		if(isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					Test2.addText("GAME ENDED/n");
					repeat = false;
				}
			}
			else{
				Test2.addText("error: input int not within range of "+ min + " and " + max + "/n");
				restartError(input(),min,max);
			}
		}
		else if(checkInput(num)){
			Test2.addText("error: input not an int/n");
			restartError(input(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			Test2.addText("GAME ENDED/n");
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void restart(){
		Test2.addText("Play another game?(0-1)/n");
		restartError(input(),0,1);
	}
}
