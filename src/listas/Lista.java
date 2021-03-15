package listas;

public interface Lista {
	public Boolean estaVazia();
	public int buscar(int valor);
	public int getTamanho();
	public int pegar(int pos);
	public Lista copiar();
	public Lista dividir();
	public String exibir();
	public void concatenar(Lista outro);
	public void inserir(int valor);
	public void inserir(int valor, int pos);
	public void retirar(int valor);
}
