package arvores;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<Integer> arvore = new ArvoreBST<Integer>();
		arvore.inserir(5);
		arvore.inserir(2);
		arvore.inserir(1);
		arvore.inserir(10);
		arvore.inserir(11);
		arvore.inserir(8);
		
		System.out.println(arvore);
	}

}
