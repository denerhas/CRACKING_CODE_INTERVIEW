
public class UserPlayResult {
	private boolean successful;
	private GameState resultingState;
	public UserPlayResult(boolean success, GameState state) {
		successful = success;
		resultingState = state;
	}
	
	public boolean successfulMove() {
		return successful;
	}
	
	public GameState getResultingState() {
		return resultingState;
	}
}
