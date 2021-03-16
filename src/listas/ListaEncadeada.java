package listas;

public class ListaEncadeada implements Lista {
	protected NoLista primeiro;
	protected NoLista ultimo;
	protected int qtdElementos;
	
	@Override
	public Boolean estaVazia() {
		return primeiro == null;
	}

	@Override
	public int buscar(int valor) {
		NoLista p = this.primeiro;
		int index = 0;
		while (p != null) {
			if (p.getInfo() == valor) {
				return index;
			}
			
			p = p.getProx();
			index++;
		}
		return -1;
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public int pegar(int pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Lista copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista dividir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista p = this.primeiro;
		while (p != null) {
			resultado += p.getInfo();
			if (!p.equals(this.ultimo)) {
				resultado += ", ";
			}
			
			p = p.getProx();
		}
		resultado += "]";
		return resultado;
	}

	@Override
	public void concatenar(Lista outro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserir(int valor) {
		NoLista novoNo = new NoLista();
		novoNo.setInfo(valor);
		
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProx(novoNo);			
		}
		
		this.ultimo = novoNo;
		
		qtdElementos++;
	}

	@Override
	public void inserir(int valor, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista atual = this.primeiro;
		
		while (atual != null && atual.getInfo() != valor) {
			anterior = atual;
			atual = atual.getProx();
		}
		
		if (atual != null) {
			if (anterior != null) {
				anterior.setProx(atual.getProx());			
			} else {
				this.primeiro = atual.getProx();
			}
			
			if (atual == this.ultimo) {
				this.ultimo = anterior;
			}
			
			qtdElementos--;
		}
	}
}
