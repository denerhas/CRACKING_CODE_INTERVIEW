import java.util.ArrayList;
import java.util.Collections;

public class QuestionA {

	public static int createStack(ArrayList<Box> boxes)
	{
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		
		for(int i=0; i<boxes.size(); i++)
		{
			int height = createStack(boxes, i);
			maxHeight = Math.max(height, maxHeight);
		}
		
		return maxHeight;
	}
	
	public static int createStack(ArrayList<Box> boxes, int bottomIndex)
	{
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		
		for(int i=bottomIndex+1; i<boxes.size(); i++)
		{
			if(boxes.get(i).canBeAbove(bottom))
			{
				int height = createStack(boxes, i);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight += bottom.height;
		return maxHeight;
	}
}
