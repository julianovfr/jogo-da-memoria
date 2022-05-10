import java.util.Scanner;

public class Test {
	static String[][] tabuleiroReserva = new String[4][4];

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		boolean choice;
		int x1, y1, x2, y2;

		do {
			Board board = new Board();
			board.setTabuleiro();
			board.imprimeTabuleiro();
			criaTabuleiro(tabuleiroReserva);
			do {
				System.out.print("\nPrimeiro parâmetro>> ");
				x1 = input.nextInt(); y1 = input.nextInt();
				System.out.print("Segundo parâmetro>> ");
				x2 = input.nextInt(); y2 = input.nextInt();
				
				comparaTeste(x1,x2,y1,y2,board.getTabuleiro());
				mostraTabuleiro();
				
			}while(choiceOver());
			
			criaTabuleiro(board.getTabuleiro());
			
			
			System.out.println("\nContinuar jogando:\n 1 - SIM, 2 - Não\n>>");
			if(input.nextInt()==1) choice = true;
			else choice = false;
			System.out.println();
		}while(keepPlaying(choice));
		
		System.out.println("*****FIM DE JOGO*******");
	}
	
	public static boolean keepPlaying(boolean choice) {
		return choice;
	}
	
	public static void criaTabuleiro(String[][] table) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				tabuleiroReserva[i][j] = "X";
			}

		}
	}
	
	public static boolean choiceOver() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(tabuleiroReserva[i][j] == "X") return true;
			}

		}
		return false;
	}
	
	public static void mostraTabuleiro() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(tabuleiroReserva[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public static boolean comparaTeste(int x1, int x2, int y1, int y2, String[][] tabuleiro) {
		
		if(tabuleiro[x1][y1] == tabuleiro[x2][y2] && (x1!=x2 || y1!=y2) ) {
			tabuleiroReserva[x1][y1] = tabuleiro[x1][y1];
			tabuleiroReserva[x2][y2] = tabuleiro[x2][y2];
			System.out.println("Acertou!!");
			return true;
		}
		else {
			System.out.println("Errou!!");
		}
		
		return false;
	}
}
