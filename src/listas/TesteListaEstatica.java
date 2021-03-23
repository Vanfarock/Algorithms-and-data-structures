package listas;

public class TesteListaEstatica {

	public static void main(String[] args) {
		ListaEstatica<Integer> lista = new ListaEstatica<Integer>();
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(9);
		
		ListaEstatica<Integer> outraLista = new ListaEstatica<Integer>();
		outraLista.inserir(10);
		outraLista.inserir(20);
		outraLista.inserir(30);
		outraLista.inserir(40);
	
//		lista.inserir(10, 3);
		System.out.println(lista.dividir().exibir());
		System.out.println(lista.exibir());
	}

}
