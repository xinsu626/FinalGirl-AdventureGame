import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Monster{
	// class variables to control number of monster
	
	// create a random object
	Random rand = new Random();

	// declare variables
	private int maxMonsterHealth;
	private int miniMonsterHealth;
	private int maxMonsterStrength;
	private int miniMonsterStrength;
	private String monsterName;
	private String monsterPic;
	private int currentHealth;
	private int currentStrength;

	// constructor 
	public Monster(String monsterName, String monsterPic, int maxMonsterHealth, int miniMonsterHealth, int maxMonsterStrength, int miniMonsterStrength){
		this.monsterName = monsterName;
		this.monsterPic = monsterPic;
		this.maxMonsterStrength = maxMonsterStrength;
		this.miniMonsterStrength = miniMonsterStrength;
		this.maxMonsterHealth = maxMonsterHealth;
		this.miniMonsterHealth = miniMonsterHealth;
		this.currentHealth = rand.nextInt(maxMonsterHealth - miniMonsterHealth) + miniMonsterHealth; //generate random number from range
		this.currentStrength = rand.nextInt(maxMonsterStrength - miniMonsterStrength) + miniMonsterStrength;
	}

	// Create a monster 
	public static HashMap<String, Monster> createMonsters(Scanner in){
		HashMap<String, Monster> monsters = new HashMap<String, Monster>();

		while(true){
			String monsterName = FileUtil.getNonCommentLine(in); // read monster name from txt file
			if(monsterName.equals("****************************************")){
				break;
			}
			int maxMonsterHealth = FileUtil.getInt(in); 		 // read monster max health from txt file
			int miniMonsterHealth = FileUtil.getInt(in); 		 // read monster minimum health from txt file
			int maxMonsterStrength = FileUtil.getInt(in); 		 // read monster max strength from txt file
			int miniMonsterStrength = FileUtil.getInt(in); 		 // read monster minimum strength from txt file
			String monsterPic = FileUtil.readParagraph(in);

			monsters.put(monsterName, new Monster(monsterName, monsterPic, maxMonsterHealth, miniMonsterHealth,
					maxMonsterStrength, miniMonsterStrength));	 // put the pairs in HashMap instantiate monsters
		}

		return monsters;
	}

	// setters 
	public void setCurrentHealth(int newHealth)
	{
		this.currentHealth = newHealth;
	}


	// getters
	public int getCurrentHealth(){
		return currentHealth;
	}
	public int getCurrentStrength(){
		return currentStrength;
	}
	public String getName(){
		return monsterName;
	}

	public void printMonster() {
		System.out.println(monsterPic);
	}

	public void checkStatus()
	{
		if (currentHealth > 0)
		{
			System.out.println(monsterName + " strength: " + currentStrength);
			System.out.println(monsterName + " health: " + currentHealth);
		}

	}

}