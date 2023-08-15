import java.util.ArrayList;

public class AddCommand extends Command{
    
    Item item;

    public AddCommand(Item item) {
        this.item = item;
    }

    public void execute(ArrayList<Item> itemsList){
        itemsList.add(this.item);
    }

    public void undo(ArrayList<Item> itemsList){
        itemsList.remove(item);
    }

    public void redo(ArrayList<Item> itemsList){
        itemsList.add(this.item);
    }

}
