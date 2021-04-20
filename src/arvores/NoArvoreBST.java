package arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}
	
	@Override
	public NoArvoreBST<T> getEsq() {
		return (NoArvoreBST<T>)super.getEsq();
	}
	
	@Override
	public NoArvoreBST<T> getDir() {
		return (NoArvoreBST<T>)super.getDir();
	}
	
	public void inserir(T info) {
		if (this.getInfo().compareTo(info) >= 0) {
			if (this.getEsq() == null) {
				this.setEsq(new NoArvoreBST<T>(info));
			} else {
				this.getEsq().inserir(info);
			}
		} else {
			if (this.getDir() == null) {
				this.setDir(new NoArvoreBST<T>(info));
			} else {
				this.getDir().inserir(info);
			}
		}
	}
	
	public NoArvoreBST<T> buscar(T info) {
		NoArvoreBST<T> noBusca = new NoArvoreBST<T>(info);
		if (this.equals(noBusca)) {
			return this;
		}
		
		NoArvoreBST<T> ladoBusca;
		if (this.getInfo().compareTo(info) >= 0) {
			ladoBusca = this.getDir();
		} else {
			ladoBusca = this.getEsq();
		}
		
		if (ladoBusca == null) {
			return null;
		}
		
		return ladoBusca.buscar(info);
	}
}
