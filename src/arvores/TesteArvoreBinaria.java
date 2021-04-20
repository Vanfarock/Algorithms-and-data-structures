package arvores;

public class TesteArvoreBinaria {

	public static void main(String[] args) {
		NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
		NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);
		NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, no4, no5);
		
		NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<Integer>(7); 
		NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, no7, null); 
		NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, null, no6); 
		
		NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);
		
		ArvoreBinariaAbstract<Integer> arvore = new ArvoreBinaria<Integer>();
		arvore.setRaiz(no1);
		
		System.out.println(arvore);
//		for (int i = 1; i <= 7; i++) {
//			System.out.println(arvore.pertence(i).imprimePre());			
//		}
	}

}
