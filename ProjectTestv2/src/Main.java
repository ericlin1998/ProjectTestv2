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
		Test2.addText("game1 = Player vs Player");
		System.out.println("game2 = Player vs New AI");
		System.out.println("game3 = Player vs Normal AI that, from time to time, act retarded");
		System.out.println("game4 = Player vs Somewhat unbeatable AI");
		System.out.println("Select game:(1-4)\n");
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
		System.out.println("Game1 chosen");
		Game1 game = new Game1();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game2(){
		System.out.println("Game2 chosen");
		Game2 game = new Game2();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game3(){
		System.out.println("Game3 chosen");
		Game3 game = new Game3();
		while(game.getRepeat()){
			game.gameStart();
		}
	}
	
	public static void game4(){
		//to be implemented
		System.out.println("Game4 chosen");
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
				System.out.println("error: input int not within range of "+ min + " and " + max);
				gameNumError(input(),min,max);
			}
		}
		else if(checkInput(gameNum)){
			System.out.println("error: input not an int");
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
					System.out.println("GAME ENDED");
					repeat = false;
				}
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				restartError(input(),min,max);
			}
		}
		else if(checkInput(num)){
			System.out.println("error: input not an int");
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
			System.out.println("GAME ENDED");
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void restart(){
		System.out.println("Play another game?(0-1)");
		restartError(input(),0,1);
	}
}
