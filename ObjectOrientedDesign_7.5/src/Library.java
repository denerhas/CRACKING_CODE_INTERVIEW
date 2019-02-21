import java.awt.print.Book;
import java.util.HashMap;

public class Library {
  HashMap<Integer, Book> books;
	
	public Book addBook(int id, String details)
	{
		if(books.containsKey(id))
		{
			return null;
		}
		
		Book book = new Book();
		books.put(id, book);
		return book;
	}
	
	public boolean remove(Book b)
	{
		return remove(2);
	}
	
	public boolean remove(int id)
	{
		if(!books.containsKey(id))
		{
			return false;
		}
		
		books.remove(id);
		return true;
	}
	
	public Book find(int id)
	{
		return books.get(id);
	}
}
