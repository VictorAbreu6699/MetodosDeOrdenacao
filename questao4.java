import java.io.*;

public class questao4 {
	private static int comparacoes;
	private static int movimentacoes;
	static boolean comparaMaiorAltura(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getAltura() == jogador2.getAltura())
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
		else if (jogador1.getAltura() > jogador2.getAltura()) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	static boolean comparaMenorAltura(jogador jogador1, jogador jogador2)
	{
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getAltura() == jogador2.getAltura())
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
		else if (jogador1.getAltura() < jogador2.getAltura()) {
			comparacoes++;
			resultado = true;
		}
		return resultado;
	}
	public static void heapsort(jogador[] array) {
        buildMaxHeap(array);
        int n = array.length;
 
        for (int i = array.length - 1; i > 0; i--) {
        	comparacoes++;
            swap(array, i, 0);
            maxHeapify(array, 0, --n);
        }        
        comparacoes++;
        
    }
 
    private static void buildMaxHeap(jogador[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
        	comparacoes++;
            maxHeapify(array, i, array.length);
        }
        comparacoes++;
 
    }
 
    private static void maxHeapify(jogador[] array, int pos, int tamanhoDoVetor) {
 
        int max = 2 * pos + 1, right = max + 1;
        comparacoes++;
        if (max < tamanhoDoVetor) {
        	comparacoes++;
            if (right < tamanhoDoVetor && comparaMenorAltura(array[max], array[right])) {
                max = right;
            }
            comparacoes++;
            if (comparaMaiorAltura(array[max], array[pos])) {
                swap(array, max, pos);
                maxHeapify(array, max, tamanhoDoVetor);
            }
        }
    }
 
    public static void swap(jogador[] array, int j, int aposJ) {
        jogador aux = array[j];
        array[j] = array[aposJ];
        array[aposJ] = aux;
        movimentacoes++;
    }
    static void criaArquivo(String nomeArquivo)
	{
		File file = new File(nomeArquivo);		
        
        try{

           file.createNewFile();           
        
        }catch(IOException io){
            System.out.println("Erro ao criar o arquivo!\n"+io.toString());
        }
	}
	static void preencheArquivo(String nomeArquivo ,String matricula, long tempoExecucao)
	{
		ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita();
		
		arqEscrita.abrirArquivo(nomeArquivo);
		arqEscrita.escrever(matricula + "\t" + tempoExecucao+"ms" + "\t" + comparacoes + " comparaçoes" + "\t" + movimentacoes + " movimentações");
		arqEscrita.fecharArquivo();
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
		heapsort(selecionados);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		
		for (int j = 0; j < selecionados.length; j++) {
			selecionados[j].imprimir();
		}
		
		criaArquivo("matrícula_heapsort.txt");
		preencheArquivo("matrícula_heapsort.txt", "xxxxx", tempoExecucao);
	}

}

