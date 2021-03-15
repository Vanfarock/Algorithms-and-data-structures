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

	public void inserir(int valor) {
		if (this.getCapacidade() <= this.tamanho) {
			this.redimensionar();
		}
		this.info[this.tamanho] = valor;
		this.tamanho++;
	}
	
	private void redimensionar() {
		int[] novaInfo = new int[this.getCapacidade() + INITIAL_LIST_SIZE];
		for (int i = 0; i < this.getCapacidade(); i++) {
			novaInfo[i] = this.info[i];
		}
		this.info = novaInfo;
	}
	
	public int buscar(int valor) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	public int buscarPeloIndice(int indice) {
		if (indice >= 0 && indice < this.tamanho) {
			return this.info[indice];
		}
		return 0;
	}
	
	public void retirar(int valor) {
		int posicao = this.buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < this.tamanho; i++) {
				info[i] = info[i + 1];
			}
			this.tamanho--;
		}
	}
	
	public void exibir() {
		for (int i = 0; i < this.tamanho; i++) {
			System.out.println(this.info[i]);
		}
	}
	
	public Boolean estaVazia() {
		return this.tamanho == 0;
	}
	
	public void concatenar(ListaEstatica outra) {
		for (int i = 0; i < outra.tamanho; i++) {
			this.inserir(outra.buscarPeloIndice(i));
		}
	}
	
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
	
	public ListaEstatica copiar() {
		ListaEstatica listaCopiada = new ListaEstatica();
		for (int i = 0; i < this.tamanho; i++) {
			listaCopiada.inserir(this.info[i]);
		}
		return listaCopiada;	
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public int pegar(int pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String exibir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concatenar(Lista outro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(int valor, int pos) {
		// TODO Auto-generated method stub
		
	}
}
