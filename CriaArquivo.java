import java.io.*;

public class CriaArquivo {
	static void criaArquivo(String nomeArquivo)
	{
		File file = new File(nomeArquivo);		
                
        try{

           file.createNewFile();           
        
        }catch(IOException io){
            System.out.println("Erro ao criar o arquivo!\n"+io.toString());
        }
	}
	static void preencheArquivo(String nomeArquivo ,String matricula, long tempoExecucao, int comparacoes, int movimentacoes)
	{
		ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita();
		
		arqEscrita.abrirArquivo(nomeArquivo);
		arqEscrita.escrever(matricula + "\t" + tempoExecucao+"ms" + "\t" + comparacoes + " comparaçoes" + "\t" + movimentacoes + " movimentações");
		arqEscrita.fecharArquivo();
	}
}
