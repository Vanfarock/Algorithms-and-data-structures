package listas;

public class ListaEstatica implements Lista {
	private final int INITIAL_LIST_SIZE = 10;
	
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		this.info = new int[INITIAL_LIST_SIZE];
		this.tamanho = 0;
	}

	private int getCapacidade() {
		return this.info.length;
	}
	
	@Override
	public Boolean estaVazia() {
		return this.tamanho == 0;
	}
	
	@Override
	public int buscar(int valor) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public int getTamanho() {
		return this.tamanho;
	}
	
	@Override
	public int pegar(int pos) {
		if (this.posicaoValida(pos)) {
			return this.info[pos]; 			
		}
		return 0;
	}
	
	private Boolean posicaoValida(int pos) {
		return pos >= 0 && pos <= this.getTamanho();
	}
	
	@Override
	public ListaEstatica copiar() {
		ListaEstatica listaCopiada = new ListaEstatica();
		for (int i = 0; i < this.tamanho; i++) {
			listaCopiada.inserir(this.info[i]);
		}
		return listaCopiada;	
	}
	
	@Override
	public ListaEstatica dividir() {
		int indiceDivisao = this.tamanho / 2;
		ListaEstatica segundaParte = new ListaEstatica();
		while (this.tamanho > indiceDivisao) {
			int itemCopiado = this.info[indiceDivisao];
			segundaParte.inserir(itemCopiado);
			this.retirar(itemCopiado);
		}
		return segundaParte;
	}
	
	@Override
	public String exibir() {
		String resultado = "[";
		for (int i = 0; i < this.getTamanho(); i++) {
			resultado += this.info[i];
			if (i != this.getTamanho() - 1) {
				resultado += ", ";				
			}
		}
		resultado += "]";
		return resultado;
	}

	@Override
	public void concatenar(Lista outro) {
		for (int i = 0; i < outro.getTamanho(); i++) {
			this.inserir(outro.pegar(i));
		}		
	}

	@Override
	public void inserir(int valor) {
		if (this.getCapacidade() <= this.tamanho) {
			this.redimensionar();
		}
		this.info[this.tamanho] = valor;
		this.tamanho++;		
	}
	
	@Override
	public void inserir(int valor, int pos) {
		if (this.posicaoValida(pos)) {
			if (this.getCapacidade() <= this.tamanho) {
				this.redimensionar();
			}
			
			int ultimoValor = this.info[pos];
			int valorParaAtualizar; 
			for (int i = pos; i <= this.getTamanho(); i++) {				
				if (i == pos) {
					valorParaAtualizar = valor;					
				} else {
					valorParaAtualizar = ultimoValor;
				}
				
				ultimoValor = this.info[i];
				this.info[i] = valorParaAtualizar;
			}
			this.tamanho++;					
		}
	}
	
	private void redimensionar() {
		int[] novaInfo = new int[this.getCapacidade() + INITIAL_LIST_SIZE];
		for (int i = 0; i < this.getCapacidade(); i++) {
			novaInfo[i] = this.info[i];
		}
		this.info = novaInfo;
	}
	
	@Override
	public void retirar(int valor) {
		int posicao = this.buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < this.tamanho; i++) {
				info[i] = info[i + 1];
			}
			this.tamanho--;
		}
	}
}
