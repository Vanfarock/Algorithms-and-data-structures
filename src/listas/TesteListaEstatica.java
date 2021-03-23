package listas;

public class TesteListaEstatica {

	public static void main(String[] args) {
		ListaEstatica lista = new ListaEstatica();
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(9);
		
		ListaEstatica outraLista = new ListaEstatica();
		outraLista.inserir(10);
		outraLista.inserir(20);
		outraLista.inserir(30);
		outraLista.inserir(40);
	
//		lista.inserir(10, 3);
		System.out.println(lista.dividir().exibir());
		System.out.println(lista.exibir());
	}

}
