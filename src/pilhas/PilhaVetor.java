package pilhas;

public class PilhaVetor<T> implements Pilha<T> {
	private T[] info;
	private int limite;
	private int tamanhoAtual;
	
	@SuppressWarnings("unchecked")
	public PilhaVetor(int limite) {
		this.limite = limite;
		this.info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
	}
	
	@Override
	public void push(T info) {
		if (tamanhoAtual >= limite) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}
		
		this.info[tamanhoAtual] = info;
		tamanhoAtual++;
	}

	@Override
	public T pop() {
		T retorno = peek();
		
		tamanhoAtual--;
		info[tamanhoAtual] = null; 
		
		return retorno;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha está vazia");
		}
		return info[tamanhoAtual - 1];
	}

	@Override
	public Boolean estaVazia() {
		return this.tamanhoAtual == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void liberar() {
		this.info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
	}
	
	@Override
	public String toString() {
		String resultado = "[";
		for (int i = 0; i < this.tamanhoAtual; i++) {
			resultado += this.info[i];
			if (i != this.tamanhoAtual - 1) {
				resultado += ", ";				
			}
		}
		resultado += "]";
		return resultado;
	}
}
