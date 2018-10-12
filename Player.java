import java.util.Scanner;

public class Player{
	// declare instance variables 
	public String name;
	public int health;
	public Item currentWeapon;

	// consturctor
	public Player(String name)
	{
		this.name = name;
		this.health = 100; //initial health
		this.currentWeapon = new Item("slingshot", "weapon", 5);
	}

	// create player
	public static Player createPlayer(){
		String playerName = UI.promptLine("Enter a name for your player: ").trim();
		Player newPlayer = new Player(playerName);
		System.out.println("Your player's name is now " + playerName);
		return newPlayer;
	}

	public int getHealth(){
		return health;
	}

	//public void incrementStrength(int x){
	//	strength += x;
	//}

	public Item getCurrentWeapon(){
		return currentWeapon;
	}

	public void setCurrentWeapon(Item weapon){
		currentWeapon = weapon;}

	public void incrementHealth(int x){
		health += x;
	}

	//public int getStrength(){
	//	return strength;}

	public void checkStatus(){
	System.out.println("\tYour health: " + health);
	//System.out.println("\tYour strength: " + strength);
	System.out.println("\tYou have: " + currentWeapon.name + " in hand.");
	}
} 
