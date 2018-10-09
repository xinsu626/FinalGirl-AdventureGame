public class Inspect implements Action{

    private Room room;
    private Player player;

    public boolean execute(String[] tokens){
        if (tokens.length == 1){
            System.out.println("Inspect what?");
            return false;
        }

        String thing = tokens[1];

        if (thing.equals("room")){
            if (room.items = null) {
                System.out.println("There's nothing in this room.");
            } else {
                System.out.println("This room contains the following:");
                for (Item item : room.items) {
                    System.out.println(item);
                }
            }
        }
        else if (thing.equals("backpack")){
            System.out.println("Your backpack contains:");
            for (Item item : player.backpack){
                System.out.println(item);
            }
        }
        else{
            System.out.println("That's not something you can inspect!");
        }
        return false;
    }

    /** @return the command name */
    public String getCommandName(){
        return "inspect";
    }

    /** @return the help string */
    public String help(){
        return "Enter\n     inspect [room, backpack]\n" +
                "to see what's in the current room\n" +
                "or in your own backpack.";
    }

    public Inspect(Room room, Player player){
        this.room = room;
        this.player = player;
    }
}
