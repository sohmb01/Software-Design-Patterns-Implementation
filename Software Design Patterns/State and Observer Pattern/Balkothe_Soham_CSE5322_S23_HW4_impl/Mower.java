import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/// observer psttern

public class Mower extends Observable{
    private int[] currentPosition;
    private State currenState;
    private ArrayList<Observer> observers = new ArrayList<Observer>() {
        
    };

    public Mower() {
        this.currentPosition = new int[]{0,0};
        this.currenState = new East();
    }
    
    public void setCurrentState(){
        this.currenState = currenState.getNextState();
    }

    public void mowLawn(){
        this.currentPosition = this.currenState.move(currentPosition);
    }

    public Boolean stateChangeRequired(){
        
        Boolean stateChangeRequired = currentPosition[0]+1 >= 15 || currentPosition[1]+1 >= 15 ;  
        if (stateChangeRequired){
            setCurrentState();
        }
        return stateChangeRequired;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void notifyAll(){
        for (Observer observer : observers){
            observer.update(this, currentPosition);
        }
    }

}
