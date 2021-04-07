package filas;

import listas.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {
	private ListaEncadeada<T> info;
	private int limite;

	public FilaLista(int limite) {
		this.limite = limite;
		this.info = new ListaEncadeada<T>();
	}
	
	@Override
	public void inserir(T valor) {
		if (info.getTamanho() >= limite) {
			throw new RuntimeException("Capacidade esgotada da fila");
		}
		
		info.inserirNoFinal(valor);
	}

	@Override
	public T retirar() {
		T itemRemovido = peek();
		info.retirar(itemRemovido);
		return itemRemovido;
	}

	@Override
	public T peek() {
		if (estaVazio()) {
			throw new RuntimeException("Fila está vazia");
		}
		
		return info.pegar(0);
	}

	@Override
	public Boolean estaVazio() {
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
