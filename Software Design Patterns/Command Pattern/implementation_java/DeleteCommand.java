import java.util.ArrayList;

public class DeleteCommand extends Command{
   
    public Item item;

    public DeleteCommand(Item item) {
        this.item = item;
    }

    public void execute(ArrayList<Item> itemsList){
        itemsList.remove(item);
    }

    public void undo(ArrayList<Item> itemsList){
        itemsList.add(item);
    }

    public void redo(ArrayList<Item> itemsList){
        itemsList.remove(item);
    }
}
