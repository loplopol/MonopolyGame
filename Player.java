
public class Player {

	public int playerID;
	public String playerName;
	private int location;
	
	public Player() {
		
	}
	
	public Player(int ID) {
		playerID = ID;
		playerName = "Player";
		location = 0;
	}
	
	public Player(int ID, String name) {
		playerID = ID;
		playerName = name;
		location = 0;
	}

	public void setLocation(int rollSum) {
		//Go = 0 .... Boardwalk = 39
		//Jail = 40
		
		location += rollSum;
		if (location >= 40) location -= 40;
		
	}
	
	public int getLocation() {
		return location;
	}
}
