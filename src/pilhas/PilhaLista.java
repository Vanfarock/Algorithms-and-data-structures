package pilhas;

import listas.ListaEncadeada;

public class PilhaLista<T> implements Pilha<T> {
	private int limite;
	private ListaEncadeada<T> info;
	
	public PilhaLista(int limite) {
		this.limite = limite;
		this.info = new ListaEncadeada<T>();
	}
	
	@Override
	public void push(T info) {
		if (this.info.getTamanho() >= limite) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}

		this.info.inserir(info);
	}

	@Override
	public T pop() {
		T valorExcluido = this.peek();
		info.retirar(valorExcluido);
		return valorExcluido;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}

		return info.pegar(info.getTamanho() - 1);
	}

	@Override
	public Boolean estaVazia() {
		return info.estaVazia();
	}

	@Override
	public void liberar() {
		this.info = new ListaEncadeada<T>();
	}
	
	@Override
	public String toString() {
		return info.exibir();
	}
}
