import java.util.ArrayList;
public abstract class Command {
    public void execute(ArrayList<Item> itemsList){};
    public void undo(ArrayList<Item> itemsList){};
    public void redo(ArrayList<Item> itemsList){};
}
