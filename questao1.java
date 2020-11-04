
public class questao1 {

	public static void main(String[] args) {
		ArquivoTextoLeitura arq = new ArquivoTextoLeitura();		
		jogador jogador[] = new jogador[3922];
		String dados[], textoEntrada;
		arq.abrirArquivo("players.csv");
		
		
		dados = arq.ler().split(",");
		for (int i = 0; i < jogador.length; i++) {
			dados = arq.ler().split(",", -1);			
			jogador[i] = new jogador(Integer.parseInt(dados[0]), dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[4], Integer.parseInt(dados[5]), dados[6], dados[7]);
		}
		
		textoEntrada = MyIO.readLine();
		while (!textoEntrada.equals("FIM")) {		
			for (int i = 0; i < jogador.length; i++) {
				if (jogador[i].getId() == Integer.parseInt(textoEntrada)) {
					jogador[i].imprimir();
				}
			}
			textoEntrada = MyIO.readLine();			
		} 
	}
}



