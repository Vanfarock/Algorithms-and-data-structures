package arvores;

public abstract class ArvoreBinariaAbstract<T> {
	protected NoArvoreBinaria<T> raiz;
	
	protected NoArvoreBinaria<T> getRaiz() {
		return this.raiz;
	}
	
	protected void setRaiz(NoArvoreBinaria<T> no) {
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
