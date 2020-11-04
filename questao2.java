import java.io.*;

public class questao2 {
	
	
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
		arq.fecharArquivo();
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
		selecao(selecionados, selecionados.length);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		
		CriaArquivo.criaArquivo("matrícula_selecao.txt");
		CriaArquivo.preencheArquivo("matrícula_selecao.txt", "xxxxx", tempoExecucao, comparacoes, movimentacoes);
		
	}

}

