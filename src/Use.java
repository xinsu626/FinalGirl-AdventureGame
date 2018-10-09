public class Use implements Action{

    private Item item;
    private Player player;
    private Monster monster;

    public Use(Item item, Player player, Monster monster){
        this.item = item;
        this.player = player;
        this.monster = monster;
    }

    boolean execute(String[] tokens){
        if (tokens.length == 1){
            System.out.println("Use what?");
            return false;
        }

        String thing = tokens[1];

        if (thing.equals("weapon")){
            Weapon weapon = game.getCurrentWeapon();
            //????
            System.out.println("This room contains the following:");
        }
        else if (thing.equals("potion")){
            player.setHealth(player.getHealth() + 10);
            player.setNumPotions(player.getNumPotions() - 1);
            System.out.println("Your health has increased by 10 and is now " + player.getHealth() + ".");
            System.out.println("You have " + player.getNumPotions() + " left.");
        }
        else{
            System.out.println("That's not something you can inspect!");
        }
        return false;
    }

    String getCommandName(){

    }

    String help(){

    }
}
