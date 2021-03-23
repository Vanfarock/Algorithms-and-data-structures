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
	
	public NoLista<T> getProx() {
		return this.prox;
	}
	
	public void setProx(NoLista<T> novoProx) {
		this.prox = novoProx;
	}
}
