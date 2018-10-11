import java.util.Scanner;

public class Player{
	// declare instance variables 
	public String name;
	public int health;
	public int strength;
	public Item currentWeapon;

	// consturctor
	public Player(String name)
	{
		this.name = name;
		this.health = 100; //initial health
		this.strength = 5; //initial strength
		this.currentWeapon = new Item("slingshot");
	}

	// create player
	public static Player createPlayer(){
		Scanner userInput = new Scanner(System.in);

		System.out.println("Enter a name for your player: ");
		String playerName = userInput.nextline();
		System.out.println("Your player's name is now " + playerName)

		Player newPlayer = new Player(playerName);
		
		userInput.close();

		return newPlayer;}

	// setters 
	public void setHealth(int health){
		this.health = health;}

	public void setStrength(int strength){
		this.strength = strength;}

	public void setCurrentWeapon(Item Weapon){
		this.currentWeapon = weapon;}

	// getters 
	public int getHealth(){
		return health;}

	public int getStrength(){
		return strength;}

	public void checkStatus(){
	System.out.println("\tYour health: " + health);
	System.out.println("\tYour strength: " + strength);
	System.out.println("\tYou have: " + currentWeapon.name + " in hand.")} 
} 
