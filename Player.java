import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	public int playerID;
	public String playerName;
	private int location;
	private int balance;
	private HashMap<Integer, List<Integer>> properties = new HashMap<Integer, List<Integer>>();
	
	//constructors
	public Player() {
		//unused
	}

	public Player(int ID) {
		playerID = ID;
		playerName = "Player";
		location = 0;
		balance = 1500;
	}
	
	public Player(int ID, String name) {
		playerID = ID;
		playerName = name;
		location = 0;
		balance = 1500;
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
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int newBalance) {
		balance = newBalance;
	}
	
	public HashMap<Integer, List<Integer>> getProperties() {
		return properties;
	}
	
	public void addProperty(int newPropertyIndex) {
		List<Integer> emptyList = new ArrayList<Integer>();
		emptyList.add(0);
		emptyList.add(0);
		properties.put(newPropertyIndex, emptyList);
	}
	
	//TODO add intricacies of house purchases including having monopoly on spaces, 32 houses limit, etc
	//can also add setBalance in here later
	public void buyHouse(int propertyIndex) {
		List<Integer> houseList = properties.get(propertyIndex);
		int houseNum = houseList.get(0) + 1;
		houseList.set(0, houseNum);
		properties.replace(propertyIndex, houseList);
	}
	
	//TODO add intricacies of hotel purchases such as neededing all houses maxed
	//can also add setBalance in here later
	public void buyHotel(int propertyIndex) {
		List<Integer> hotelList = properties.get(propertyIndex);
		int houseNum = hotelList.get(1) + 1;
		hotelList.set(1, houseNum);
		properties.replace(propertyIndex, hotelList);
	}
}
