import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args)
	{
		
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index) { // Base case - add empty set
			
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else
		{
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets)
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			
			allsubsets.addAll(moresubsets);
		}
		
		return allsubsets;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set)
	{
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		
		for(int k=0; k<max; k++)
		{
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set)
	{
		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		int index = 0;
		for(int k=x; k>0; k>>=1) {
			if((k & 1) == 1)
				subset.add(set.get(index));
			
			index++;
		}
		
		return subset;
	}
}
