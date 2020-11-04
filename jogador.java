public class jogador{
	
	private int id;
	private String nome;
	private int altura;
	private int peso;
	private String universidade;
	private int anoNascimento;
	private String cidadeNascimento;
	private String estadoNascimento;
	
	public jogador() {
		this.id = 0;
		this.nome = "nao informado";
		this.altura = 0;
		this.peso = 0;
		this.universidade = "nao informado";
		this.anoNascimento = 0;
		this.cidadeNascimento = "nao informado";
		this.estadoNascimento = "nao informado";
	}
	
	public jogador clonar()
	{	
		jogador clone = new jogador(this.id, this.nome, this.altura, this.peso, this.universidade, this.anoNascimento, this.cidadeNascimento, this.estadoNascimento);
		
		return clone;
	}
	
	public jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento)
	{
		this.id = id;
		if (nome.equals("")) {
			this.nome = "nao informado";
		}
		else {
			this.nome = nome;
		}
		
		this.altura = altura;
		this.peso = peso;
		
		if (universidade.equals("")) {
			this.universidade = "nao informado";
		}
		else {
			this.universidade = universidade;
		}
		
		this.anoNascimento = anoNascimento;
		
		if (estadoNascimento.equals("")) {
			this.estadoNascimento = "nao informado";
		}
		else {
			this.estadoNascimento = estadoNascimento;
		}
		
		if (cidadeNascimento.equals("")) {
			this.cidadeNascimento = "nao informado";
		}
		else {
			this.cidadeNascimento = cidadeNascimento;
		}
	}
	
	public void imprimir() {
		String textoSaida;
		
		textoSaida = "[" + id + " ## ";
		
		if (nome.equals("")) {
			textoSaida += "nao informado ## ";
		}
		else {
			textoSaida += nome + " ## ";
		}
		if (altura == 0) {
			textoSaida += "nao informado ## ";
		} else {
			textoSaida += altura + " ## ";
		}
		if (peso == 0) {
			textoSaida += "nao informado ## ";
		} else {
			textoSaida += peso + " ## ";
		}
		if (anoNascimento == 0) {
			textoSaida += "nao informado ## ";
		} else {
			textoSaida += anoNascimento + " ## ";
		}
		if(universidade.equals(""))
		{
			textoSaida += "nao informado ## ";
		}
		else {
			textoSaida += universidade + " ## ";
		}
		if (cidadeNascimento.equals("")) {
			textoSaida += "nao informado ## ";
		}
		else {
			textoSaida += cidadeNascimento + " ## ";
		}
		if (estadoNascimento.equals("")) {
			textoSaida += "nao informado]";
		}
		else {
			textoSaida += estadoNascimento + "]";
		}
		
		MyIO.println(textoSaida);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}
	public void setNome(String nome)
	{
		this.nome = nome; 
	}
	public String getNome()
	{
		return this.nome;
	}
	
	public void setAltura(int altura)
	{
		this.altura = altura; 
	}
	public int getAltura()
	{
		return this.altura;
	}			
	
	public void setPeso(int peso)
	{
		this.peso = peso;
	}
	public int getPeso()
	{
		return this.peso;
	}
	
	public void setUniversidade(String universidade)
	{
		this.universidade = universidade; 
	}
	public String getUniversidade()
	{
		return this.universidade;
	}
	
	public void setAnoNascimento(int anoNascimento)
	{
		this.anoNascimento = anoNascimento; 
	}
	public int getAnoNascimento()
	{
		return this.anoNascimento;
	}
	
	public void setCidadeNascimento(String cidadeNascimento)
	{
		this.cidadeNascimento = cidadeNascimento; 
	}
	public String getCidadeNascimento()
	{
		return this.cidadeNascimento;
	}
	
	public void setEstadoNascimento(String estadoNascimento)
	{
		this.estadoNascimento = estadoNascimento; 
	}
	public String getEstadoNascimento()
	{
		return this.estadoNascimento;
	}
	
}
