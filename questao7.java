
public class questao7 {
	private static int comparacoes;
	private static int movimentacoes;
	static boolean comparaPeso(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getPeso() == jogador2.getPeso())
		{
			comparacoes++;
			if(jogador1.getNome().compareTo(jogador2.getNome()) > 0)
			{
				resultado = true;
			}
			else {
				resultado = false;
			}
		}
		else if (jogador1.getPeso() > jogador2.getPeso()) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	static void shellsort(jogador[] array, int n) {
	      
		int h = 1;

		do { 
			h = (h * 3) + 1;
			comparacoes++;
		} while (h < n);
			comparacoes++;
		do {
	        	h /= 3;
	         	for(int inicio = 0; inicio < h; inicio++) {
	            		insercao(array, n, inicio, h);
	         	}
	         	comparacoes+=2;
	      	} while (h != 1);
		comparacoes++;
	}	

	static void insercao(jogador[] array, int n, int inicio, int h){

		for (int i = (h + inicio); i < n; i+=h) {
			comparacoes++;
	        	jogador tmp = array[i];
	         	int j = i - h;
	         	int teste = j;
	         	while ((j >= 0) && (comparaPeso(array[j], tmp))) {
	         		comparacoes+=2;
	            		array[j + h] = array[j];
	            		movimentacoes++;
	            		j-=h;
	         	}
	         	if (teste != j) {
					movimentacoes++;
				}
	         	array[j + h] = tmp;
	      	}
		comparacoes++;
	}
	
	public static void main(String[] args) {
		ArquivoTextoLeitura arq = new ArquivoTextoLeitura();		
		jogador jogador[] = new jogador[3922];
		long tempoExecucao;
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
		shellsort(selecionados, selecionados.length);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		
		CriaArquivo.criaArquivo("matrícula_shellsort.txt");
		CriaArquivo.preencheArquivo("matrícula_shellsort.txt", "xxxxx", tempoExecucao, comparacoes, movimentacoes);
	}

}

