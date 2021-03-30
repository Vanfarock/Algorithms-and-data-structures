package filas;

public class TesteFilaLista {

	public static void main(String[] args) {
		FilaLista<Integer> fila = new FilaLista<Integer>(5);
		fila.inserir(5);
		fila.inserir(4);
		fila.inserir(3);
		
		System.out.println(fila);
		System.out.println(fila.peek());
		
		System.out.println(fila.retirar());
		System.out.println(fila);
		System.out.println(fila.estaVazia());
		
		fila.liberar();
		System.out.println(fila);
		System.out.println(fila.estaVazia());
	}

}
