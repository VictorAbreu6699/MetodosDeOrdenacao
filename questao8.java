
public class questao8 {
	private static int comparacoes;
	private static int movimentacoes;
	static boolean comparaCidade(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getCidadeNascimento().compareTo(jogador2.getCidadeNascimento()) == 0)
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
		else if (jogador1.getCidadeNascimento().compareTo(jogador2.getCidadeNascimento()) > 0) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	static void bolha(jogador[] array, int n) {
		for (int i = (n - 1); i > 0; i--) {
			comparacoes++;
			for (int j = 0; j < i; j++) {
				comparacoes+=2;
				if (comparaCidade(array[j], array[j + 1])) {
	               			
					jogador temp = array[j];
	      				array[j] = array[j+1];
	      				array[j+1] = temp;
	      				movimentacoes++;
				}
			}
			comparacoes++;
		}
		comparacoes++;
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
		bolha(selecionados, selecionados.length);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		
		CriaArquivo.criaArquivo("matrícula_bolha.txt");
		CriaArquivo.preencheArquivo("matrícula_bolha.txt", "xxxxx", tempoExecucao, comparacoes, movimentacoes);
	}

}

