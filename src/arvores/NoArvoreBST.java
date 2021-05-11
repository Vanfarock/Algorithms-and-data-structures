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
		NoArvoreBST<T> paiNos = (NoArvoreBST<T>) this.pai;
		
		if (noSucessor == null) {
			while (paiNos != null) {
				if (this.getInfo().compareTo(paiNos.getInfo()) > 0) {
					paiNos = (NoArvoreBST<T>)paiNos.pai;
				} else {
					return paiNos;
				}
			}
			return null;
		}
		
		while (noSucessor.getEsq() != null) {
			noSucessor = noSucessor.getEsq();
		}
		
		return noSucessor;
	}
	
	public NoArvoreBST<T> getNoAntecessor() {
		NoArvoreBST<T> noAntecessor = this.getEsq();
		NoArvoreBST<T> paiNo = (NoArvoreBST<T>) this.pai;
		
		if (noAntecessor == null) {
			while (paiNo != null) {
				if (this.getInfo().compareTo(paiNo.getInfo()) < 0) {
					paiNo = (NoArvoreBST<T>)paiNo.pai;
				} else {
					return paiNo;
				}
			}
			return null;
		};
		
		while (noAntecessor.getDir() != null) {
			noAntecessor = noAntecessor.getDir();
		}
		
		return noAntecessor;
	}
	
	public String toStringOrdered() {
		String impressao = "";
		if (this.getEsq() != null) {
			impressao += this.getEsq().toStringOrdered();
		}
		
		impressao += this.getInfo() + " ";

		if (this.getDir() != null) {
			impressao += this.getDir().toStringOrdered();
		}
		
		return impressao;
	}
}
