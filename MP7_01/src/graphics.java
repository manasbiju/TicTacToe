import edu.illinois.cs.cs125.lib.zen.Zen;

public class graphics {
	
	static final int WINDOW_HEIGHT = 750;
	static final int WINDOW_WIDTH = 750;	
	static final int BORDER_THICKNESS = 10;
	
	public static void createWindow(){
		Zen.create(WINDOW_WIDTH, WINDOW_HEIGHT);			
		Zen.setColor(100, 100, 100);
		Zen.fillRect(WINDOW_WIDTH/3 - BORDER_THICKNESS/2 , 0, BORDER_THICKNESS, WINDOW_HEIGHT);
		Zen.fillRect(2*WINDOW_WIDTH/3 - BORDER_THICKNESS/2 , 0, BORDER_THICKNESS, WINDOW_HEIGHT);
		Zen.fillRect(0, 2*WINDOW_HEIGHT/3 - BORDER_THICKNESS/2, WINDOW_HEIGHT, BORDER_THICKNESS);
		Zen.fillRect(0, WINDOW_HEIGHT/3 - BORDER_THICKNESS/2, WINDOW_HEIGHT, BORDER_THICKNESS);
	}
	
	public static int getRow() {
		
		int row = 0;		
		int y = Zen.getMouseY();

		if (y < WINDOW_HEIGHT/3) {
			row = 1;
		}
		else if(y > WINDOW_HEIGHT/3 && y < 2*WINDOW_HEIGHT/3) {
			row = 2;
		}
		else if(y > 2*WINDOW_HEIGHT/3) {
			row = 3;
		}

		return row;

	}
	
	public static int getCol() {
		
		int col = 0;
		int y = Zen.getMouseX();

		if (y < WINDOW_WIDTH/3) {
			col = 1;
		}
		else if(y > WINDOW_WIDTH/3 && y < 2*WINDOW_WIDTH/3) {
			col = 2;
		}
		else if(y > 2*WINDOW_WIDTH/3) {
			col = 3;
		}

		return col;

	}
	
	public static void plotPlayer(int player, int row, int col) {
		Zen.setFont("Arial-250");
		if (player == 0) {	
			Zen.setColor(255, 204, 204);
			Zen.drawText("X", 250*(col-1)+40, 250*row-40);
		}
		else if(player == 1) {
			Zen.setColor(204, 229, 255);
			Zen.drawText("O", 250*(col-1)+30, 250*row-40);
		}
	}
	
	public static void printWinner(char player) {
		String winner;
		if (player == 'x') {
			Zen.setColor(255, 100, 100);
			winner = "X";
		} else {
			Zen.setColor(100, 100, 255);
			winner = "O";
		}
		Zen.setFont("Arial-100");
		Zen.drawText(winner + " has won!", 140, 400);
	}
	
	public static void printTie() {
		Zen.setColor(200, 200, 200);
		Zen.setFont("Arial-100");
		Zen.drawText("It's a tie!", 200, 400);
	}
	
}
