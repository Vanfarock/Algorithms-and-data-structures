package arvores;

public class TesteArvore {
	public static void main(String[] args) {
		NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		n4.inserirFilho(n10);
		n4.inserirFilho(n9);
		
		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		n3.inserirFilho(n8);
		
		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);
		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		n2.inserirFilho(n7);
		n2.inserirFilho(n6);
		n2.inserirFilho(n5);
		
		NoArvore<Integer> n11 = new NoArvore<Integer>(11);
		n5.inserirFilho(n11);
		
		NoArvore<Integer> n12 = new NoArvore<Integer>(12);
		n11.inserirFilho(n12);
		
		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		n1.inserirFilho(n4);
		n1.inserirFilho(n3);
		n1.inserirFilho(n2);
		
		// NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		// NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		// NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		// n1.inserirFilho(n2);
		// n1.inserirFilho(n3);
		
		// NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		// NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		// NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		// n2.inserirFilho(n4);
		// n2.inserirFilho(n5);
		// n2.inserirFilho(n6);
		
		// NoArvore<Integer> n7 = new NoArvore<Integer>(7);
		// NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		// n6.inserirFilho(n7);
		// n6.inserirFilho(n8);
		
		// NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		// n3.inserirFilho(n9);
		
		// NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		// n9.inserirFilho(n10);
		
		// NoArvore<Integer> n11 = new NoArvore<Integer>(11);
		// n10.inserirFilho(n11);

		Arvore<Integer> a = new Arvore<>();
		a.setRaiz(n1);
		
		for (int i = 0; i < 13; i++) {
			System.out.println(i + " " + a.getNivel(i));
		}
	}
}
