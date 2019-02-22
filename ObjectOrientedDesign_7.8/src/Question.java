
public class Question {
	
	public static void main(String[] args) {
		Game game = Game.getInstance();
		game.getBoard().initialize();
		game.getBoard().printBoard();
		
	}
}