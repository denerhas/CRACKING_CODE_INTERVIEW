
public class Node {

    private State state;
	private Node[] adjacentList;
	
	public Node[] getAdjacentList()
	{
		return adjacentList;
	}
	
	public State getState()
	{
		return state;
	}
	
	public void setVisitState(State visitState)
	{
		state = visitState;
	}
}
