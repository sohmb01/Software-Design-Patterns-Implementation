
/// State Pattern Implemented

public abstract class State {
    abstract int[] move(int[] position);
    abstract State getNextState();
}
