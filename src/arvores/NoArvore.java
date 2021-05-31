// Vinícius Manuel Martins e João Henrique Cardoso Bragantino

package arvores;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;

	public NoArvore(T info) {
		this.setInfo(info);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void inserirFilho(NoArvore<T> filho) {
		filho.irmao = this.filho;
		this.filho = filho;
	}
	
	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;			
		}
		
		if (filho != null) {
			NoArvore<T> retorno = filho.pertence(info);
			if (retorno != null) {
				return retorno;
			}
		}
		
		if (irmao != null) {
			NoArvore<T> retorno = irmao.pertence(info);
			if (retorno != null) {
				return retorno;
			}
		}
		
		return null;
	}

	public String imprimePre() {
		String impressao = "<" + info + " ";

		if (filho != null) {
			impressao += filho.imprimePre();
		}
		impressao += ">";

		if (irmao != null) {
			impressao += irmao.imprimePre();
		}
		return impressao;
	}

  public String imprimePosOrdem() {
		String impressao = "<";

		if (filho != null) {
			impressao += filho.imprimePosOrdem();
		}

		if (irmao != null) {
			impressao += irmao.imprimePosOrdem();
		}

		impressao += info + ">";
    
		return impressao;
	}

  public int getQuantidadeDeNosFolha() {
    int qtdNosFolha = 0;

		if (filho != null) {
			qtdNosFolha += filho.getQuantidadeDeNosFolha();
		}

		if (irmao != null) {
			qtdNosFolha += irmao.getQuantidadeDeNosFolha();
		}
		return qtdNosFolha;
  }
	
	public int getAltura() {
		int altura = 0;
		NoArvore<T> filhoAtual = filho;
		while (filhoAtual != null) {
			altura = Math.max(altura, filhoAtual.getAltura() + 1);
			filhoAtual = filhoAtual.irmao;
		}
		return altura;
	}
	
	public int getMenorAltura() {
		if (filho == null)
			return 0;
		
		int altura = Integer.MAX_VALUE;
		NoArvore<T> filhoAtual = filho;
		while (filhoAtual != null) {
			altura = Math.min(altura, filhoAtual.getMenorAltura() + 1);
			filhoAtual = filhoAtual.irmao;
		}
		return altura;
	}
	
	public int getNivel(T info, int altura) {
		if (this.info.equals(info))
			return altura;
		
		altura++;
		
		NoArvore<T> currentChild = filho;
		while (currentChild != null) {
			int tmp = currentChild.getNivel(info, altura);
			if (tmp >= 0) {
				return tmp;							
			}
			
			currentChild = currentChild.irmao;
		}
		
		return -1;
	}
	
	public boolean isBalanceada() {
		boolean balanceada = true;
		int menorAltura = Integer.MAX_VALUE;
		int maiorAltura = Integer.MIN_VALUE;
		
		NoArvore<T> filhoAtual = filho;
		while (filhoAtual != null && balanceada) {
			balanceada &= filhoAtual.isBalanceada();
			
			menorAltura = Math.min(menorAltura, getMenorAltura());
			maiorAltura = Math.max(maiorAltura, getAltura());
			
			filhoAtual = filhoAtual.irmao;
		}

		return balanceada && maiorAltura - menorAltura <= 1;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}
}
