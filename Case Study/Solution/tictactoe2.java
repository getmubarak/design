
import java.util.Arrays; 
import java.util.InputMismatchException;
import java.util.Scanner;

class Board{
	String[] board;
	
	public Board() {
		board = new String[9];	
		populateEmptyBoard();
	}
	String get(int index) {
		return board[index];
	}
	void put(int index,String val ) {
		board[index] =val;
	}
	public void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}
interface Input{
	int getInput();
}
class ConsoleInput implements Input{
	Scanner in;
	
	public ConsoleInput() {
		in = new Scanner(System.in);
	}
	
	public int getInput() {
		int numInput;
		try {
			numInput = in.nextInt();
		} catch (InputMismatchException e) {
			numInput= -1;
		}
		return numInput;
	}
}
interface Output{
	void printInvalidInput();
	void printBoard(); 
}
class ConsoleOutput implements Output{
	Board board;
	public ConsoleOutput(Board board) {
		this.board = board;
		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		printBoard();
		System.out.println("X's will play first. Enter a slot number to place X in:");
	}
	public void printInvalidInput() {
		System.out.println("Invalid input; re-enter slot number:");
	}
    public void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |");
		System.out.println("/---|---|---\\");
	}
}
class GameController{
	Board board;
	Output output;
    Input input;
    GameEvaluvator gameEvaluvator;
    public GameController(Output output,Input input){
    	this.output = output;
    	this.input = input;
    	board = new Board();
    	gameEvaluvator =  new GameEvaluvator(board);
    }
	public void execute() {
		String winner = null;
		while (winner == null) {
			int numInput= input.getInput();
			if (!gameEvaluvator.isValidInput(numInput)) {
				continue;
			}
			if (gameEvaluvator.isCellTaken(numInput)) {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
			gameEvaluvator.playTurn(numInput);
			output.printBoard();
			winner = gameEvaluvator.checkWinner();
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}	
}
class GameEvaluvator{
	String turn;
	Board board;
	public GameEvaluvator(Board board) {
		turn = "X";
		this.board = board;
	}
	void playTurn(int cell) {
		board.put(cell-1,turn);
		if (turn.equals("X")) {
			turn = "O";
		} else {
			turn = "X";
		}
	}
	boolean isValidInput(int numInput) {
		if(!(numInput > 0 && numInput <= 9))
			return false;
		return true;
	}
	boolean isCellTaken(int cell) {
		if (!board.get(cell-1).equals(String.valueOf(cell))) {
			return true;
		}
		return false;
	}
    String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}
}




