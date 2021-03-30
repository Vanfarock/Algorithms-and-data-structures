package filas;

public interface Fila<T> {
	public void inserir(T valor);
	public T retirar();
	public T peek();
	public Boolean estaVazia();
	public void liberar();
}
