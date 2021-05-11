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
	
	public void retirar(T info) {
		NoArvoreBST<T> noRemover = this.buscar(info);
		retirar(noRemover);
	}
	
	public void retirar(NoArvoreBST<T> noRemover) {
		if (noRemover != null) {
			Boolean ehRaiz = this.getRaiz() == noRemover;
			NoArvoreBST<T> pai = (NoArvoreBST<T>) noRemover.pai;
			
			if (noRemover.ehFolha()) {
				if (ehRaiz) {
					this.setRaiz(null);
				} else {
					pai.substituirFilho(null, noRemover.getInfo());
				}
			} else if (noRemover.possuiApenasUmFilho()) {
				NoArvoreBST<T> filho = noRemover.getEsq() == null ? noRemover.getDir()
						: noRemover.getEsq();
				if (ehRaiz) {
					this.setRaiz(filho);
				} else {
					pai.substituirFilho(filho, noRemover.getInfo());					
				}
			} else {
				NoArvoreBST<T> noSucessor = noRemover.getNoSucessor();
				noRemover.setInfo(noSucessor.getInfo());
				this.retirar(noSucessor);
			}
		}
	}
	
	public NoArvoreBST<T> getMenor() {
		NoArvoreBST<T> menor = this.getRaiz();
		if (!vazia()) {
			while (menor.getEsq() != null) {
				menor = menor.getEsq();
			}			
		}
		return menor;
	}
	
	public NoArvoreBST<T> getMaior() {
		NoArvoreBST<T> maior = this.getRaiz();
		if (!vazia()) {
			while (maior.getDir() != null) {
				maior = maior.getDir();
			}			
		}
		return maior;
	}
	
	public String toStringOrdered() {
		if (vazia() ) {
			return "";
		}
		
		return this.getRaiz().toStringOrdered();
	}
}
