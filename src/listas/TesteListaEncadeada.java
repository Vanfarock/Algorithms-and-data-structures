package listas;

public class TesteListaEncadeada {
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(9);
		
		ListaEncadeada outraLista = new ListaEncadeada();
		outraLista.inserir(10);
		outraLista.inserir(20);
		outraLista.inserir(30);
		outraLista.inserir(40);
	
		lista.retirar(9);
		System.out.println(lista.exibir());
	}
}
