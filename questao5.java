
public class questao5 {
	private static int comparacoes;
	private static int movimentacoes;
	static boolean comparaUniversidade(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getUniversidade().compareTo(jogador2.getUniversidade()) == 0)
		{
			comparacoes++;
			if(jogador1.getNome().compareTo(jogador2.getNome()) < 0)
			{
				resultado = true;
			}
			else {
				resultado = false;
			}
		}
		else if (jogador1.getUniversidade().compareTo(jogador2.getUniversidade()) < 0) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	private static void mergesort(jogador[] array, int esq, int dir) {
		comparacoes++;
		if (esq < dir) {
	        	int meio = (esq + dir) / 2;
	         	mergesort(array,esq, meio);
	         	mergesort(array, meio + 1, dir);
	         	intercalar(array, esq, meio, dir);
	      	}
	}
	private static void intercalar(jogador[] array, int esq, int meio, int dir) {

		int n1, n2, i, j, k;

	      	//Definir tamanho dos dois subarrays
	      	n1 = meio - esq + 1;
	      	n2 = dir - meio;

	      	jogador[] a1 = new jogador[n1];
	      	jogador[] a2 = new jogador[n2];

	      	//Inicializar primeiro subarray
	      	for (i = 0; i < n1; i++) {
	        	a1[i] = array[esq + i];
	        	comparacoes++;
	      	}
	      	comparacoes++;

	      	//Inicializar segundo subarray
	      	for (j = 0; j < n2; j++) {
	        	a2[j] = array[meio + j + 1];
	        	comparacoes++;
	      	}
	      	comparacoes++;

		//Intercalação propriamente dita
	      	for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
	      		comparacoes+=2;
	        	if (comparaUniversidade(a1[i], a2[j]))
	        	{
	        		movimentacoes++;
				array[k] = a1[i++];
	        	}
	        	else
	        	{
	        		movimentacoes++;
				array[k] = a2[j++];
	        	}
	      	}
	      	comparacoes+=2;		
	      if (i == n1) {
			for (; k <= dir; k++) {
				comparacoes++;
				movimentacoes++;
		    	array[k] = a2[j++];
		    	}
	      	comparacoes++;
	      }
	      	else {
		    	for (; k <= dir; k++) {
		    		comparacoes++;
		    		movimentacoes++;
		    		array[k] = a1[i++];
		    	}
		    	comparacoes++;
	      	}
	      
	}
	public static void main(String[] args) {
		ArquivoTextoLeitura arq = new ArquivoTextoLeitura();	
		long tempoExecucao;
		jogador jogador[] = new jogador[3922];
		String dados[], textoEntrada = "";
		arq.abrirArquivo("players.csv");
		
		
		arq.ler();
		for (int i = 0; i < jogador.length; i++) {
			dados = arq.ler().split(",", -1);			
			jogador[i] = new jogador(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[4], Integer.parseInt(dados[5]), dados[6], dados[7]);
		}		
		int ids[] = new int[jogador.length], i = 0;
		
		while (!textoEntrada.equals("FIM")) {
			textoEntrada = MyIO.readLine();
			if (textoEntrada.equals("FIM")) {
				break;
			}
			else {
				ids[i] = Integer.parseInt(textoEntrada);
				i++;
			}
		}
		jogador selecionados[] = new jogador[i];
		for (int j = 0; j < jogador.length; j++) {
			for (int j2 = 0; j2 < i; j2++) {
				if (jogador[j].getId() == ids[j2]) {
					selecionados[j2] = jogador[j];
				}
			}
		}
		tempoExecucao = System.currentTimeMillis();
		mergesort(selecionados, 0, selecionados.length-1);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		CriaArquivo.criaArquivo("matrícula_mergesort.txt");
		CriaArquivo.preencheArquivo("matrícula_mergesort.txt", "xxxxx", tempoExecucao, comparacoes, movimentacoes);
		
	}

}

