// Vinícius Manuel Martins e João Henrique Cardoso Bragantino

package arvores;

public class Arvore<T> {
	private NoArvore<T> raiz;

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}

	public boolean vazia() {
		return raiz == null;
	}
	
	public NoArvore<T> pertence(T info) {
		if (vazia()) return null;
		
		return this.raiz.pertence(info);		
	}
	
	public int getAltura() {
		if (vazia())
			return -1;
		
		return raiz.getAltura();
	}
	
	public int getNivel(T info) {
		if (vazia())
			return -1;
		
		return raiz.getNivel(info, 0);
	}
	
	public boolean isBalanceada() {
		if (vazia()) 
			return true;
		
		return raiz.isBalanceada();
	}

  public int getQuantidadeDeNosFolha() {
    if (vazia()) {
      return 0;
    }

    return raiz.getQuantidadeDeNosFolha();
  }

  public String imprimePosOrdem() {
		if (vazia()) return "<>";
    return raiz.imprimePosOrdem();
	}
	
	@Override
	public String toString() {
		if (vazia()) return "<>";
		return raiz.imprimePre();
	}
}
