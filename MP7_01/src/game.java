import edu.illinois.cs.cs125.lib.zen.Zen;

public class game {
	private char[][] board = new char[3][3];
	private char currentPlayer;
	
	
	public game() {
		this.initBoard();
		currentPlayer = 'x';
	}
	
	public int getPlayer() {
		if(currentPlayer == 'x') {
			return 0;
		}
		else {
			return 1;
		}
			
	}
	
	public void initBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public void printBoard() {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public boolean isWinner() {
		return (this.checkRows() || this.checkColumns() || this.checkDiagonals());
	}
	
	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (this.check(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (this.check(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagonals() {
		return this.check(board[0][0], board[1][1], board[2][2]) 
				|| this.check(board[0][2], board[1][1], board[2][0]);
	}
	
	private boolean check(char one, char two, char three) {
		return ((one != '-') && (one == two) && (two == three));
	}
	
	//player methods
	public void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		}else {
			currentPlayer = 'x';
		}
	}
	
	public boolean placeMark(int row, int col) {
		if ((row >= 0 && row < 3) && (col >= 0 && row < 3) && (board[row][col] == '-')) {
			board[row][col] = currentPlayer;
			return true;
		}
		return false;
	}
	
	//main method
	public static void main(String[] args) {
		game g = new game();
		graphics.createWindow();
		
		while (Zen.isRunning()) {
								
			while (!g.isWinner() && !g.isBoardFull()) {

				Zen.waitForClick();
				boolean isValid = g.placeMark(graphics.getRow() - 1, graphics.getCol() - 1);	
				
				if (isValid) {
					graphics.plotPlayer(g.getPlayer(), graphics.getRow(), graphics.getCol());
					g.changePlayer();
				}
					
			}
			
			if (g.isBoardFull() && !g.isWinner()) {
				graphics.printTie(); 
				break;
			}else {
				
				g.changePlayer();
				graphics.printWinner(g.currentPlayer);
				break;
			}
			
		}
		
	}
	
}
