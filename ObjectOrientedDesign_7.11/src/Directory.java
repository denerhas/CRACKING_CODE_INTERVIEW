import java.util.ArrayList;

public class Directory extends Entry{

	protected ArrayList<Entry> content;
	
	public Directory(String n, Directory p)
	{
		super(n, p);
		content = new ArrayList<Entry>();
	}
	
	public int size()
	{
		int size = 0;
		for(Entry e : content)
		{
			size += e.size();
		}
		
		return size;
	}
	
	public int numberOfFiles()
	{
		int count = 0;
		
		for(Entry e : content)
		{
			if(e instanceof Directory)
			{
				count++; //Directory counts as a file
				Directory d = (Directory)e;
				count += d.numberOfFiles();
			}else if(e instanceof File)
			{
				count++;
			}
		}
		
		return count;
	}
	
	public boolean deleteEntry(Entry entry)
	{
		return content.remove(entry);
	}
	
	public void addEntry(Entry entry)
	{
		content.add(entry);
	}
	
	protected ArrayList<Entry> getContents(){
		return content;
	}
}
