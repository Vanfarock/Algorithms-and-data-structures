package listas;

public class TesteListaEncadeada {
	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(9);
		lista.inserir(10);
		
		ListaEncadeada<Integer> outraLista = new ListaEncadeada<Integer>();
		outraLista.inserir(10);
		outraLista.inserir(20);
		outraLista.inserir(30);
		outraLista.inserir(40);
		
		ListaEncadeada<String> listaString = new ListaEncadeada<String>();
		listaString.inserir("Teste1");
		listaString.inserir("Teste2");
		listaString.inserir("Teste3");
		listaString.inserir("Teste4");
		
		System.out.println(listaString.exibir());
		listaString.inserir("Bla", 3);
		System.out.println(listaString.exibir());
//		System.out.println(lista.pegar(4));
//		lista.concatenar(outraLista);
//		System.out.println(lista.dividir().exibir());
//		System.out.println(lista.exibir());
//		System.out.println(lista.copiar().exibir());
	}
}
