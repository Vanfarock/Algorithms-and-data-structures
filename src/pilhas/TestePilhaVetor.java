package pilhas;

public class TestePilhaVetor {

	public static void main(String[] args) {
		PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(5);
		pilha.push(5);
		pilha.push(4);
		pilha.push(3);
		
		System.out.println(pilha);
		System.out.println(pilha.peek());
		
		pilha.pop();
		System.out.println(pilha);
		System.out.println(pilha.estaVazia());
		
		pilha.liberar();
		System.out.println(pilha);
		System.out.println(pilha.estaVazia());
	}
}
