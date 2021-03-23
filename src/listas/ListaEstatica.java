package listas;

public class ListaEstatica<T> implements Lista<T> {
	private final int INITIAL_LIST_SIZE = 10;
	
	private T[] info;
	private int tamanho;

	@SuppressWarnings("unchecked")
	public ListaEstatica() {
		this.info = (T[])new Object[INITIAL_LIST_SIZE];
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
	public int buscar(T valor) {
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
	public T pegar(int pos) {
		if (this.posicaoValida(pos)) {
			return this.info[pos]; 			
		}
		return null;
	}
	
	private Boolean posicaoValida(int pos) {
		return pos >= 0 && pos <= this.getTamanho();
	}
	
	@Override
	public ListaEstatica<T> copiar() {
		ListaEstatica<T> listaCopiada = new ListaEstatica<T>();
		for (int i = 0; i < this.tamanho; i++) {
			listaCopiada.inserir(this.info[i]);
		}
		return listaCopiada;	
	}
	
	@Override
	public ListaEstatica<T> dividir() {
		int indiceDivisao = this.tamanho / 2;
		ListaEstatica<T> segundaParte = new ListaEstatica<T>();
		while (this.tamanho > indiceDivisao) {
			T itemCopiado = this.info[indiceDivisao];
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
	public void concatenar(Lista<T> outro) {
		for (int i = 0; i < outro.getTamanho(); i++) {
			this.inserir(outro.pegar(i));
		}		
	}

	@Override
	public void inserir(T valor) {
		if (this.getCapacidade() <= this.tamanho) {
			this.redimensionar();
		}
		this.info[this.tamanho] = valor;
		this.tamanho++;		
	}
	
	@Override
	public void inserir(T valor, int pos) {
		if (this.posicaoValida(pos)) {
			if (this.getCapacidade() <= this.tamanho) {
				this.redimensionar();
			}
			
			T ultimoValor = this.info[pos];
			T valorParaAtualizar; 
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
	
	@SuppressWarnings("unchecked")
	private void redimensionar() {
		T[] novaInfo = (T[])new Object[this.getCapacidade() + INITIAL_LIST_SIZE];
		for (int i = 0; i < this.getCapacidade(); i++) {
			novaInfo[i] = this.info[i];
		}
		this.info = novaInfo;
	}
	
	@Override
	public void retirar(T valor) {
		int posicao = this.buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < this.tamanho; i++) {
				info[i] = info[i + 1];
			}
			this.tamanho--;
		}
	}
}
