import java.util.Scanner;

public class Player{
	// declare instance variables 
	public String name;
	public int health;
	public Item currentWeapon;
	private Game game;

	// consturctor
	public Player(String name, Game game)
	{
		this.name = name;
		health = 100; //initial health
		currentWeapon = new Item("slingshot", "weapon", 5);
		this.game = game;
	}

	// create player
	public static Player createPlayer(Game game, String name){
		Player newPlayer = new Player(name, game);
		System.out.println("Your player's name is now " + name);
		return newPlayer;
	}

	public int getHealth(){
		return health;
	}

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
		System.out.println("Your health: " + health);
		System.out.println("Your weapon: " + currentWeapon.name);
		System.out.println("Current room: " + game.getCurrentRoom().getName());
	}
} 
