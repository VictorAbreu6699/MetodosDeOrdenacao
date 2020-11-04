
public class Ordenacao {
	private static int comparacoes;
	private static int movimentacoes;
	
	public static void selecaoPorNome(jogador[] array, int n) {
		jogador temp = new jogador();
		
		for (int i = 0; i < (n - 1); i++) {
			comparacoes++;
	        	int menor = i;
	        	
	         	for (int j = (i + 1); j < n; j++) {	
	         		comparacoes+=2;
						if (array[menor].getNome().compareTo(array[j].getNome()) > 0 ) {
							menor = j;
							movimentacoes+=2;
						}
					}						
	         	comparacoes++;
	         	temp = array[i];
	         	
	         	array[i] = array[menor];
	         		
				array[menor] = temp;				
	      		
	      	}
		comparacoes++;
	}
}
