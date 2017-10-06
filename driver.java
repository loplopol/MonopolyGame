import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class driver {
	
	//class variables
	public static int turn = 1;
	public static int num_players = 1;
	public static ArrayList<Player> player_list = new ArrayList<Player>();
	public static boolean gameover = false;

	public static void main(String[] args) {
		
		start_game();
		
		while(gameover != true) {
			player_turn(player_list.get(turn-1));
		    player_turn(player_list.get(turn-1));
		    gameover = true;
		}
		
		//run tester to check if it works correctly
		//tester();
	}
	
	public static void start_game() {
		
		Scanner input = new Scanner(System.in);
		
		//welcome screen
		System.out.println("Welcome to Monopoly!");
		
		//ask user for number of players
		System.out.println("How many people are playing?: ");
		num_players = input.nextInt();
		input.nextLine(); //eat next line
		
		//gather user info
		for(int i = 0; i < num_players; i++) {
			
			//get user info
			System.out.println("Player " + (i+1) + ", what is your name?: ");
			String name = input.nextLine();
			
			//create player object
			Player newPlayer = new Player(i+1, name);
			
			//add to player list
			player_list.add(newPlayer);

		}
		
	}

	public static void player_turn(Player player) {
		
		System.out.println(player.playerName + "'s turn:");
		
		//roll dice
		int[] roll_info = roll_dice();
		
		System.out.println(player.playerName + " rolled a " + roll_info[0] +  " and a " + roll_info[1]);
		
		//move player around the board
		movePlayer(player, roll_info[0] + roll_info[1]);
		
		//TODO Other turn options
		
		//if doubles then player gets another turn roll again
		//TODO later make double rolls limited
		if(roll_info[2] == 1) {
			System.out.println("Since you rolled doubles you get to roll again!");
			turn = player.playerID;
		}
		else if(turn == num_players) turn = 1;
		else turn++;
	}

	public static int[] roll_dice() {
		
		//roll two dice
		Random r = new Random();
		int die1 = r.nextInt(6) + 1;
		int die2 = r.nextInt(6) + 1;
		
		//check if rolled doubles
		int roll_double;
		if(die1 == die2) {
			roll_double = 1;
		}
		else roll_double = 0;
		
		//build return variable
		int[] out = {die1, die2, roll_double};
		
		return out;
	}
	
	public static void movePlayer(Player player, int rollSum) {
		
		player.setLocation(rollSum);
		
		System.out.println(player.playerName + " moved " + rollSum +  " spaces around the board and landed on " + player.getLocation());
		//board[player.getLocation()]
		
	}
	
	public static void tester() {
		
		//test players counted and created correctly
		System.out.println("Num players: " + num_players);
		System.out.println("Player array size: " + player_list.size());
		for(Player p : player_list) {
			System.out.println("Player ID: " + p.playerID);
			System.out.println("Player Name: " + p.playerName);
		}
		
	}
}
