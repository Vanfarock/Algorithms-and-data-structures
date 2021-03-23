package listas;

public class ListaEncadeada<T> implements Lista<T> {
	protected NoLista<T> primeiro;
	protected NoLista<T> ultimo;
	protected int qtdElementos;
	
	@Override
	public Boolean estaVazia() {
		return primeiro == null;
	}

	@Override
	public int buscar(T valor) {
		NoLista<T> p = this.primeiro;
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
	public T pegar(int pos) {
		int index = 0;
		NoLista<T> resultado = primeiro;
		while (index != pos) {
			resultado = resultado.getProx();
			if (resultado == null) {
				return null;
			}
			
			index++;
		}
		return resultado.getInfo();
	}

	@Override
	public Lista<T> copiar() {
		ListaEncadeada<T> listaCopiada = new ListaEncadeada<T>();
		NoLista<T> itemCopiar = this.primeiro;
		while (itemCopiar != null) {
			listaCopiada.inserir(itemCopiar.getInfo());
			itemCopiar = itemCopiar.getProx();
		}
		return listaCopiada;
	}

	@Override
	public Lista<T> dividir() {
		ListaEncadeada<T> metadeLista = new ListaEncadeada<T>();
		if (!this.estaVazia()) {
			NoLista<T> itemAtual = this.primeiro;
			int index = 0;
			int indiceMetadeLista = this.getTamanho() / 2 - 1;
			
			while (index < indiceMetadeLista) {
				itemAtual = itemAtual.getProx();
				index++;
			}
			
			metadeLista.primeiro = itemAtual.getProx();
			metadeLista.ultimo = this.ultimo;
			metadeLista.qtdElementos = this.getTamanho() - indiceMetadeLista - 1;
			
			this.ultimo = itemAtual;
			this.ultimo.setProx(null);
			this.qtdElementos = indiceMetadeLista + 1;
			
		}
		return metadeLista;		
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista<T> p = this.primeiro;
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
	public void concatenar(Lista<T> outro) {
		for (int index = 0; index < outro.getTamanho(); index++) {
			inserir(outro.pegar(index));
		}
	}

	@Override
	public void inserir(T valor) {
		NoLista<T> novoNo = new NoLista<T>();
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
	public void inserir(T valor, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> atual = this.primeiro;
		
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
