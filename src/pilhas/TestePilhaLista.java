package pilhas;

public class TestePilhaLista {

	public static void main(String[] args) {
		PilhaLista<Integer> pilha = new PilhaLista<Integer>(5);
		pilha.push(5);
		pilha.push(4);
		pilha.push(3);
		
		System.out.println(pilha);
		System.out.println(pilha.peek());
		
		System.out.println(pilha.pop());
		System.out.println(pilha);
		System.out.println(pilha.estaVazia());
		
		pilha.liberar();
		System.out.println(pilha);
		System.out.println(pilha.estaVazia());
	}
}
