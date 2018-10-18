/**
 * Creates the player and sets its attributes, such as health and
 * attack power, and tracks them throughout the game.
 */
public class Player{

	private String name;
	private int health;
	private Item currentWeapon;
	private Game game;
	private boolean hasPowerWeapon;
	private int maxHealth;

	public Player(String name, Game game, Item currentWeapon, int health)
	{
		this.name = name;
		this.currentWeapon = currentWeapon;
		this.health = health; //initial health
		this.maxHealth = health;
		this.game = game;
	}

	public static Player createPlayer(Game game, String name, Item currentWeapon, int health){
		Player newPlayer = new Player(name, game, currentWeapon, health);
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
		if (health > maxHealth){
			health = maxHealth;
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
		System.out.println(name + "'s weapon: " + currentWeapon.getName());
		System.out.println("Current room: " + game.getCurrentRoom().getName());
	}

	public String getName(){
		return name;
	}
} 
