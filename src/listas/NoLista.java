package listas;

public class NoLista {
	private int info;
	private NoLista prox;
	
	public int getInfo() {
		return info;
	}
	
	public void setInfo(int novaInfo) {
		this.info = novaInfo;
	}
	
	public NoLista getProx() {
		return this.prox;
	}
	
	public void setProx(NoLista novoProx) {
		this.prox = novoProx;
	}
}
