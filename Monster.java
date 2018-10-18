import java.util.Scanner;
import java.util.HashMap;

/**
 * Creates a given monster and sets its attributes, such as health
 * and attack power, and tracks and tracks them during battle.
 */
public class Monster{
	private String monsterName;
	private String monsterPic;
	private int currentHealth;
	private int currentStrength;

	public Monster(String monsterName, String monsterPic, int maxMonsterHealth, int maxMonsterStrength){
		this.monsterName = monsterName;
		this.monsterPic = monsterPic;
        this.currentStrength = maxMonsterStrength;
        this.currentHealth = maxMonsterHealth;
	}

	public static HashMap<String, Monster> createMonsters(Scanner in){
		HashMap<String, Monster> monsters = new HashMap<String, Monster>();

		while(true){
			String monsterName = FileUtil.getNonCommentLine(in); // read monster name from txt file
			if(monsterName.equals("****************************************")){
				break;
			}
			int maxMonsterHealth = FileUtil.getInt(in); 		 // read monster max health from txt file
			int maxMonsterStrength = FileUtil.getInt(in); 		 // read monster max strength from txt file
			String monsterPic = FileUtil.readParagraph(in);

			monsters.put(monsterName, new Monster(monsterName, monsterPic, maxMonsterHealth,
					maxMonsterStrength));	 // put the pairs in HashMap instantiate monsters
		}

		return monsters;
	}

	public void setCurrentHealth(int newHealth)
	{
		currentHealth = newHealth;
		if (currentHealth < 0){
			currentHealth = 0;
		}
	}

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
