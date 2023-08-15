public class SouthEast extends State {

    private State nextState;

    @Override
    public int[] move(int[] position) {
        int[] updatedPosition = new int [2];
        int x = position[0];
        int y = ++position[1];
        updatedPosition[0] = x;
        updatedPosition[1] = y;
        return updatedPosition;
    }

    @Override
    public State getNextState() {
        return this.nextState;
    }

    public SouthEast() {
        this.nextState = new West();
    }
    
    
}
