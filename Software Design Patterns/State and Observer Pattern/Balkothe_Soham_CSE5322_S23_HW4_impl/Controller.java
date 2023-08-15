
import java.util.ArrayList;
import java.util.Observer;
// observer pattern
public class Controller extends Observer {
    private Mower mower;
    private Boolean mowerOn;
    private int[] cellPosition;

    public void setMoverOn(Boolean mowerOn) {
        this.mowerOn = mowerOn;
    }

    public Controller() {
        this.mower = new Mower();
        this.mowerOn = false;
    }
    
    public int[] mowLawn(){
        if (mowerOn){
            mower.mowLawn();
        }
    }

    public void update(int[] cellPosition){
        this.cellPosition = cellPosition;
    }

    public int[] getPosition(){
        return this.cellPosition;
    }
    
    
}
