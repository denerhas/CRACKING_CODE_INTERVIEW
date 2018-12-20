import java.util.LinkedList;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean search(Graph g, Node start, Node end)
	{
		if(start == null)
			return false;
		
		for(Node u : g.getNodeList())
		{
			u.setVisitState(State.UnVisited);
		}
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(start);
		
		while(!queue.isEmpty())
		{
			Node u = queue.removeFirst();
			u.setVisitState(State.Visiting);
			
			if(u != null)
			{
				for(Node n : u.getAdjacentList())
				{
					if(n.getState().equals(State.UnVisited))
					{
						if(n == end)
							return true;
						
						n.setVisitState(State.Visiting);
						queue.add(n);
					}
				}
			}
			
			u.setVisitState(State.Visited);
		}
		
		return false;
	}
}
