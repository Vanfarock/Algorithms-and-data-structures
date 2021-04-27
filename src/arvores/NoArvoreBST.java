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
		if (this.getInfo().compareTo(info) > 0) {
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
		if (this.getInfo().equals(info)) {
			return this;
		}
		
		NoArvoreBST<T> ladoBusca;
		if (this.getInfo().compareTo(info) > 0) {
			ladoBusca = this.getEsq();
		} else {
			ladoBusca = this.getDir();
		}
		
		if (ladoBusca == null) {
			return null;
		}
		
		return ladoBusca.buscar(info);
	}
	
	public void substituirFilho(NoArvoreBST<T> novoFilho, T info) {
		if (this.getInfo().compareTo(info) > 0) {
			this.setEsq(novoFilho);
		} else {
			this.setDir(novoFilho);
		}
	}
	
	public boolean ehFolha() {
		return this.getEsq() == null && this.getDir() == null;
	}
	
	public boolean possuiApenasUmFilho() {
		return (this.getEsq() != null && this.getDir() == null) 
			|| (this.getEsq() == null && this.getDir() != null);
	}
	
	public NoArvoreBST<T> getNoSucessor() {
		NoArvoreBST<T> noSucessor = this.getDir();
		
		if (noSucessor == null) return noSucessor;
		
		while (noSucessor.getEsq() != null) {
			noSucessor = noSucessor.getEsq();
		}
		
		return noSucessor;
	}
}
