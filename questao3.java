import java.io.*;
public class questao3 {
	private static int comparacoes;
	private static int movimentacoes;
	
	static boolean comparaNascimento(jogador jogador1, jogador jogador2)
	{			
		boolean resultado = false;
		comparacoes++;
		if(jogador1.getAnoNascimento() > jogador2.getAnoNascimento())
		{
			resultado = true;
		}		
		else if(jogador1.getAnoNascimento() == jogador2.getAnoNascimento())
		{
			comparacoes+=2;
			if(jogador1.getNome().compareTo(jogador2.getNome()) > 0)
			{
				resultado = true;
			}
			else
			{
				resultado = false;
			}
		}
		return resultado;
	}
	static void sort(jogador [] array, int n) {
		for (int i = 1; i < n; i++) {
			comparacoes++;
			jogador tmp = new jogador();
			tmp = array[i];
			
	         	int j = i - 1;
	         	int teste = j;
	         	
	         	while ((j >= 0) && (comparaNascimento(array[j], tmp))) {
	         		comparacoes+=2;
	         		movimentacoes++;
	         		array[j + 1] = array[j];	            	
	            	j--;
	         	}
	         	comparacoes+=2;
	         	if (teste != j) {
					movimentacoes++;
				}
	         	array[j + 1] = tmp;
	         	
	      	}
		comparacoes++;
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
		jogador selecao[] = new jogador[i];
		for (int j = 0; j < jogador.length; j++) {
			for (int j2 = 0; j2 < i; j2++) {
				if (jogador[j].getId() == ids[j2]) {
					selecao[j2] = jogador[j];
				}
			}
		}
		tempoExecucao = System.currentTimeMillis();
		sort(selecao, selecao.length);
		tempoExecucao = System.currentTimeMillis() - tempoExecucao;
		
		for (int j = 0; j < selecao.length; j++) {
			selecao[j].imprimir();
		}
		criaArquivo("matrícula_insercao.txt");
		preencheArquivo("matrícula_insercao.txt", "xxxxx", tempoExecucao);
		

	}

}
