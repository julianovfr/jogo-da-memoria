import java.util.Random;

public class Board {
	
	Random random = new Random();
	
	// variaveis >> A,B,C,D,E,F,G,H
	private String[][] tabuleiro = new String[4][4];
	
	Board() {
		for(int i = 0; i<4;i++) {
			for(int j = 0; j<4;j++) {
				tabuleiro[i][j] = "";
			}
		}
	}

	
	
	//getter and setters methods
	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro() {
		int line, column,i=0; String letra[] = {"A", "B", "C", "D", "E", "F", "G","H"},valorLetra;
		
		while(tabuleiroEmpty()) {
			int count = 0;
			valorLetra = letra[i];
			while(count<2) {
				do {
					line = random.nextInt(4);
					column = random.nextInt(4);
				}while(!espacoVazio(line, column));	
				tabuleiro[line][column] = valorLetra;
				count++;
			}
			i++;
		}
	}
	
	public boolean tabuleiroEmpty() {
		for(int i = 0;i<4;i++) {
			for (int j = 0; j<4;j++) {
				if(tabuleiro[i][j].isEmpty()) return true;
			}
		}
		return false;
	}
	
	public boolean espacoVazio(int line, int column) {
	
		if(tabuleiro[line][column].isEmpty()) return true;
		return false;
	}
	
	public void imprimeTabuleiro() {
		for(int i = 0 ; i<4;i++) {
			for(int j = 0;j<4;j++) {
				System.out.print(tabuleiro[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
