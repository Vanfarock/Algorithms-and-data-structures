package listas;

public interface Lista<T> {
	public Boolean estaVazia();
	public int buscar(T valor);
	public int getTamanho();
	public T pegar(int pos);
	public Lista<T> copiar();
	public Lista<T> dividir();
	public String exibir();
	public void concatenar(Lista<T> outro);
	public void inserir(T valor);
	public void inserir(T valor, int pos);
	public void retirar(T valor);
}
