package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
	@Override
	protected NoArvoreBST<T> getRaiz() {
		return (NoArvoreBST<T>)super.getRaiz();
	}
	
	public void inserir(T info) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<T>(info));
			return;
		}
		
		this.getRaiz().inserir(info);
	}
	
	public NoArvoreBST<T> buscar(T info) {
		if (this.vazia()) {
			return null;
		}
		return (NoArvoreBST<T>) this.getRaiz().buscar(info);
	}
}
