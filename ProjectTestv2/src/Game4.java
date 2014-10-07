/**
 * 	author Eric Lin
 * 	Completed
 * 		Game4 class
 */


public class Game4 {
		private int MAX;
		private int initial;
		private int total;
		private int player = 2;
		private boolean repeat = true;
		private differentAI bot;
		//testing variable
		//private int games = 0;
		
		public Game4(){
			Test2.addText("Initial stick amount:(10-100)");
			String str = Main.input();
			numError(str, 10, 100);
		}
		
		public void gameStart(){
			
			while(total>0 && repeat==true){
				if(player==1){
					player = 2;
					Test2.addText("Remaining:" + total);
					Test2.addText("Player1: How many do you choose?(1-"+ MAX +")");
					String str1 = Main.input();
					inputError(str1,1,MAX);
				}
				else{
					int tempNum = bot.selectNum();
					Test2.addText("Remaining:" + total);
					Test2.addText("AI chooses " + tempNum + " sticks");
					total = total - tempNum;
					Test2.addText(" ");
					player=1;
				}
			}
			if(repeat==true){
				if(player==2){
					Test2.addText("Player1 loses");
				}
				else{
					Test2.addText("AI loses");
				}
				//games++;
				//Test2.addText("games: " + games);
				player = 2;
				restart();
			}
			//bot.printArray();
		}
		
		public void numError(String temp, int min, int max){
			if(Main.isInteger(temp)){
				int num = Integer.parseInt(temp);
				if(num>=min && num<=max){
					total = num;
					initial = num;
					bot = new differentAI(total);
					MAX = bot.findMAX(initial);
					Test2.addText("");
					gameStart();
				}
				else{
					Test2.addText("error: input int not within range of "+ min + " and " + max);
					numError(Main.input(),min,max);
				}
			}
			else if(Main.checkInput(temp)){
				Test2.addText("error: input not an int");
				numError(Main.input(),min,max);
			}
			else{
				repeat = false;
			}
		}
		
		public void inputError(String temp, int min, int max){
			if(Main.isInteger(temp)){
				int num = Integer.parseInt(temp);
				if(num>=min && num<=max){
					total -= num;
					Test2.addText("Player1 chose " + num + " sticks\n");
					bot.updatePlayerInput(num);
				}
				else{
					Test2.addText("error: input int not within range of "+ min + " and " + max);
					inputError(Main.input(),min,max);
				}
			}
			else if(checkInput(temp)){
				Test2.addText("error: input not an int");
				inputError(Main.input(),min,max);
				
			}
			else{
				repeat = false;
			}
		}
		
		public boolean getRepeat(){
			return repeat;
		}
		
		public void restart(){
			Test2.addText("Play again?(0-1)");
			restartError(Main.input(),0,1);
		}
		
		public void restartError(String num, int min, int max){
			if(Main.isInteger(num)){
				int num2 = Integer.parseInt(num);
				if(num2>=min && num2<=max){
					if(num2==0){
						Test2.addText("Game4 ended\n");
						repeat = false;
					}
					else{
						total = initial;
					}
				}
				else{
					Test2.addText("error: input int not within range of "+ min + " and " + max);
					restartError(Main.input(),min,max);
				}
			}
			else if(Main.checkInput(num)){
				Test2.addText("error: input not an int");
				restartError(Main.input(),min,max);
			}
			else{
				repeat = false;
			}
		}
		
		public static boolean checkInput(String str){
			if(str.toUpperCase().equals("ENDGAME")){
				Test2.addText("Game4 ended\n");
				return false;
			}
			else{
				return true;
			}
		}

}
