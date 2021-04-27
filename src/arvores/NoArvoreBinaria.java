package arvores;

public class NoArvoreBinaria<T> {
	private T info;
	protected NoArvoreBinaria<T> pai;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.setInfo(info);
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.setInfo(info);
		this.setEsq(esq);
		this.setDir(dir);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreBinaria<T> getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
		if (esq != null) {
			esq.pai = this;
		}
	}

	public NoArvoreBinaria<T> getDir() {
		return dir;
	}

	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
		if (dir != null) {
			dir.pai = this;
		}
	}

	public NoArvoreBinaria<T> pertence(T procurado) {
		NoArvoreBinaria<T> retorno = null;

		if (this.info.equals(procurado)) {
			retorno = this;
		}
		if (retorno == null && this.esq != null) {
			retorno = this.esq.pertence(procurado);
		}
		if (retorno == null && this.dir != null) {
			retorno = this.dir.pertence(procurado);
		}
		return retorno;
	}

	public String imprimePre() {
		String impressao = "<" + this.info + " ";
		if (this.esq != null) {
			impressao += this.esq.imprimePre();
		} else {
			impressao += "<>";
		}

		if (this.dir != null) {
			impressao += this.dir.imprimePre();
		} else {
			impressao += "<>";
		}
		
		return impressao + ">";
	}
	
	@Override
	public String toString() {
		return this.getInfo().toString();
	}
}
