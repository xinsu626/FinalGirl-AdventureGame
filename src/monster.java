import java.util.Random;

public class Monster{
	// class variables to controll number of monster
	
	// create a random object
	Random rand = new Random();


	// declare variables
	private int maxMonsterHealth;
	private int miniMonsterHealth;
	private int maxMonsterStrength;
	private int miniMonsterStrength;
	private String category; //["boss", "easy"]
	private int currentHealth;
	private int currentStrength;
	// private String name; //["Zombie", "Skeletons", "Ghost"] ["Mummy", "Werewolf", "Vampire"]

	// constructor 
	public Monster(int maxMonsterHealth, int miniMonsterHealth, int maxMonsterStrength, int miniMonsterStrength, String category){
		this.maxMonsterStrength = maxMonsterStrength;
		this.miniMonsterStrength = miniMonsterStrength;
		this.maxMonsterHealth = maxMonsterHealth;
		this.miniMonsterHealth = miniMonsterHealth;
		this.category = category;
		this.currentHealth = rand.nextInt(maxMonsterHealth - miniMonsterHealth) + miniMonsterHealth; //genrate random number from range
		this.currentStrength = rand.nextInt(maxMonsterStrength - miniMonsterStrength) + miniMonsterStrength;
	}

	// Create a monster 
	public static Monster createMonsters(Scanner in){
		HashMap<String, Monster> monsters = new HashMap<String, Monster>();

		while(in.hasNext()){
			String name = FileUtil.getNonCommentLine(in); // read monster name from txt file 
			int maxMonsterHealth = FileUtil.getNonCommentLine(in); // read monster max health from txt file 
			int miniMonsterHealth = FileUtil.getNonCommentLine(in); // read monster minimum health from txt file 
			int maxMonsterStrength = FileUtil.getNonCommentLine(in); // read monster max strength from txt file 
			int miniMonsterStrength = FileUtil.getNonCommentLine(in); // read monster minimum strength from txt file
			String category = FileUtil.getNonCommentLine(in); // read monster category("easy" or "boss") from txt file
			monsters.put(name, new Monster(maxMonsterHealth, miniMonsterHealth, maxMonsterStrength, miniMonsterStrength, category))	// put the pairs in Hashmap instantiate monsters 
		}
		in.close(); // close the scanner object 

		return monsters
	}

	// setters 
	public void setCurrentHealth(int newHealth)
	{
		this.currentHealth = newHealth
	}


	// getters
	public int getCurrentHealth(){
		return currentHealth;
	}
	public int getCurrentStrength(){
		return currentStrength;
	}
	public int getName(){
		return name;
	}
	public int getcategory(){
		return category;
	}

	public void checkStatus()
	{
		System.out.println(name + "'s strength: " + currentStrength);
		System.out.println(name + "'s health: " + currentHealth);
	}

}