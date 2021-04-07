// Vinícius Manuel Martins e Gustavo Henrique Kistner

package listas;

public class ListaEncadeada<T> implements Lista<T> {
	protected NoLista<T> primeiro;
	protected NoLista<T> ultimo;
	protected int qtdElementos;
	
	public int ultimoIndiceDe(T x) {
		int indiceAtual = -1;
		int ultimoIndice = -1;
		
		NoLista<T> temp = this.primeiro;
		while (temp != null) {
			indiceAtual++;
			if (temp.getInfo().equals(x)) {
				ultimoIndice = indiceAtual;
			}
			temp = temp.getProximo();
		}
		return ultimoIndice;
	}
	
	public ListaEncadeada<T> intercala(ListaEncadeada<T> outra) {
		ListaEncadeada<T> resultado = new ListaEncadeada<T>();
		for (int i = 0; i < Math.max(this.getTamanho(), outra.getTamanho()); i++) {
			if (this.getTamanho() > i) {
				resultado.inserir(this.pegar(i));
			}
			
			if (outra.getTamanho() > i) {
				resultado.inserir(outra.pegar(i));
			}
		}
		
		return resultado;
	}
	
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
			
			p = p.getProximo();
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
			resultado = resultado.getProximo();
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
			itemCopiar = itemCopiar.getProximo();
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
				itemAtual = itemAtual.getProximo();
				index++;
			}
			
			metadeLista.primeiro = itemAtual.getProximo();
			metadeLista.ultimo = this.ultimo;
			metadeLista.qtdElementos = this.getTamanho() - indiceMetadeLista - 1;
			
			this.ultimo = itemAtual;
			this.ultimo.setProximo(null);
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
			
			p = p.getProximo();
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
			this.ultimo.setProximo(novoNo);			
		}
		
		this.ultimo = novoNo;
		
		qtdElementos++;
	}

	@Override
	public void inserir(T valor, int pos) {
		if (pos < 0 || pos > this.getTamanho()) {
			return;
		}
		
		NoLista<T> novoNo = new NoLista<T>();
		novoNo.setInfo(valor);
		
		if (pos == 0) {
			novoNo.setProximo(primeiro);
			this.primeiro = novoNo;
			this.qtdElementos++;
			return;
		}
		
		if (pos == this.getTamanho()) {
			this.ultimo.setProximo(novoNo);
			this.ultimo = novoNo;
			this.qtdElementos++;
			return;
		}
		
		NoLista<T> atual = this.primeiro;
		int index = 0;
		while (atual != null) {
			if (index == pos - 1) {
				break;
			}
			atual = atual.getProximo();
			index++;
		}
		
		if (atual != null) {
			NoLista<T> proximo = atual.getProximo();
			
			atual.setProximo(novoNo);
			novoNo.setProximo(proximo);
			this.qtdElementos++;
		}
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> atual = this.primeiro;
		
		while (atual != null && atual.getInfo() != valor) {
			anterior = atual;
			atual = atual.getProximo();
		}
		
		if (atual != null) {
			if (anterior != null) {
				anterior.setProximo(atual.getProximo());			
			} else {
				this.primeiro = atual.getProximo();
			}
			
			if (atual == this.ultimo) {
				this.ultimo = anterior;
			}
			
			qtdElementos--;
		}
	}
	
	public void inserirNoFinal(T valor) {
		NoLista<T> novoNo = new NoLista<T>();
		novoNo.setInfo(valor);
		novoNo.setProximo(null);
		
		if (estaVazia()) {
			primeiro = novoNo;
		} else {
			ultimo.setProximo(novoNo);
		}
		ultimo = novoNo;
		qtdElementos++;
	}
}
