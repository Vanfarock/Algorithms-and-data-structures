package filas;

public class FilaVetor<T> implements Fila<T> {
	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio;

	@SuppressWarnings("unchecked")
	public FilaVetor(int limite) {
		this.limite = limite;
		this.info = (T[]) new Object[limite];
		this.tamanho = 0;
		this.inicio = 0;
	}

	@Override
	public void inserir(T valor) {
		if (tamanho >= limite) {
			throw new RuntimeException("Capacidade esgotada da fila");
		}
		info[(inicio + tamanho) % limite] = valor;
		tamanho++;
	}

	@Override
	public T retirar() {
		T retorno = peek();
		
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		
		return retorno;
	}

	@Override
	public T peek() {
		if (estaVazio()) {
			throw new RuntimeException("Fila está vazia");
		}

		return info[inicio];
	}

	@Override
	public Boolean estaVazio() {
		return tamanho == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void liberar() {
		this.info = (T[]) new Object[limite];
		this.tamanho = 0;
		this.inicio = 0;
	}

	@Override
	public String toString() {
		String resultado = "[";
		for (int count = 0; count < tamanho; count++) {
			int i = (inicio + count) % limite;
			
			resultado += this.info[i];			
			if (count != tamanho - 1) {
				resultado += ", ";				
			}
		}
		resultado += "]";
		return resultado;
	}
}
