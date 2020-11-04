
public class questao6 {
	private static int comparacoes;
	private static int movimentacoes;
	
	static boolean comparaEstado(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getEstadoNascimento().compareTo(jogador2.getEstadoNascimento()) == 0)
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
		else if (jogador1.getEstadoNascimento().compareTo(jogador2.getEstadoNascimento()) < 0) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	private static void quicksort(jogador[] array, int esq, int dir) {
		
		int part;
		comparacoes++;
		if (esq < dir){
			part = particao(array, esq, dir);
			quicksort(array, esq, part - 1);
			quicksort(array, part + 1, dir);
		}
	}
					
	private static int particao(jogador[] array, int inicio, int fim) {
			
		jogador pivot = array[fim];
		int part = inicio - 1;
		for (int i = inicio; i < fim; i++) {
			comparacoes+=2;
			if (comparaEstado(array[i], pivot)) {
				part++;
				swap(array, part, i);
			}
		}
		comparacoes++;
		part++;
		swap(array, part, fim);
		return (part);
	}
		
	private static void swap(jogador[] array, int i, int j) {
		      
		jogador temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		movimentacoes+=2;
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
		quicksort(selecionados, 0, selecionados.length-1);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		
		CriaArquivo.criaArquivo("matrícula_quicksort.txt");
		CriaArquivo.preencheArquivo("matrícula_quicksort.txt", "xxxxx", tempoExecucao, comparacoes, movimentacoes);
	}

}

