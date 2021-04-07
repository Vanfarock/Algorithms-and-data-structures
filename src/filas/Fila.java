package filas;

public interface Fila<T> {
	public void inserir(T valor);
	public T retirar();
	public T peek();
	public Boolean estaVazio();
	public void liberar();
}
