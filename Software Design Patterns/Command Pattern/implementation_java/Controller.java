import java.util.ArrayList;
import java.util.Stack;

public class Controller {

    private ArrayList<Item> itemsList;
    private Stack<Command>  undoList;
    private Stack<Command> redoList;
    

    public Controller() {
        this.undoList = new Stack<Command>();
        this.redoList = new Stack<Command>();
        this.itemsList = new ArrayList<Item>();
    }

    public ArrayList<Item> addItem(Item item){
        AddCommand addCommand = new AddCommand(item);
        addCommand.execute(itemsList);
        this.undoList.push(addCommand);
        this.redoList.push(addCommand);
        return this.itemsList;
    }

    public ArrayList<Item> deleteItem(Item item){
        DeleteCommand deleteCommand = new DeleteCommand(item);
        deleteCommand.execute(itemsList);
        this.undoList.push(deleteCommand);
        this.redoList.push(deleteCommand);
        return this.itemsList;

    }

    public ArrayList<Item> undoOperation(){ 
        if (!this.undoList.empty()){
            Command command = undoList.pop();
            command.undo(itemsList);
        }
        return this.itemsList;
    }

    public ArrayList<Item> redoOperation(){
        if (!this.redoList.empty()){
            Command command = redoList.pop();
            command.redo(itemsList);
            redoList.clear();
            redoList.push(command);
        }
        return this.itemsList;
    }

}
