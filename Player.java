import java.util.Scanner;

public class Player{
	// declare instance variables 

	private String name;
	private int health;
	private Item currentWeapon;
	private Game game;
	private boolean hasPowerWeapon = true;

	// constructor
	public Player(String name, Game game, Item currentWeapon)

	{
		this.name = name;
		this.currentWeapon = currentWeapon;
		health = 100; //initial health

		this.game = game;
	}

	// create player
	public static Player createPlayer(Game game, String name, Item currentWeapon){
		Player newPlayer = new Player(name, game, currentWeapon);
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

	public void incrementHealth(int x)
	{
		health += x;
		if (health > 100){
			health = 100;
		}
		if (health < 0){
			health = 0;
		}
	}


	public void hasPowerWeapon(){
		hasPowerWeapon = true;
	}

	public boolean checkPowerWeapon(){
		return hasPowerWeapon;
	}

	public void checkStatus(){
		System.out.println(name + "'s health: " + health);
		System.out.println(name + "'s weapon: " + currentWeapon.name);
		System.out.println("Current room: " + game.getCurrentRoom().getName());
	}

	public String getName(){
		return name;
	}
} 
