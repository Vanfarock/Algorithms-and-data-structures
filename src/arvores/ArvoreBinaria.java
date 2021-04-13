package arvores;

public class ArvoreBinaria<T> {
	private NoArvoreBinaria<T> raiz;
	
	public void setRaiz(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}
	
	public Boolean vazia() {
		return raiz == null;
	}
	
	public NoArvoreBinaria<T> pertence(T info) {
		if (vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}
	
	@Override
	public String toString() {
		if (raiz == null) {
			return "";
		}
		return raiz.imprimePre();
	}
}
