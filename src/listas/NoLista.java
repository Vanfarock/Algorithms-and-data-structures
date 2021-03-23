package listas;

public class NoLista<T> {
	private T info;
	private NoLista<T> prox;
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T novaInfo) {
		this.info = novaInfo;
	}
	
	public NoLista<T> getProximo() {
		return this.prox;
	}
	
	public void setProximo(NoLista<T> novoProx) {
		this.prox = novoProx;
	}
}
