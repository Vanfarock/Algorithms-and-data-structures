package arvores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<Integer> arvore = new ArvoreBST<Integer>();
//		arvore.inserir(5);
//		arvore.inserir(2);
//		arvore.inserir(1);
//		arvore.inserir(10);
//		arvore.inserir(11);
//		arvore.inserir(8);
//		
//		arvore.retirar(10);
		
		ArrayList<Integer> numerosAleatorios = gerarNumerosAleatorios(100);
		for (int numero : numerosAleatorios) {
			arvore.inserir(numero);
		}
		
		Collections.shuffle(numerosAleatorios);
		
		for (int numero : numerosAleatorios) {
			System.out.println(arvore);
			arvore.retirar(numero);
		}
		System.out.println(arvore);
	}

	public static ArrayList<Integer> gerarNumerosAleatorios(int qtd) {
		ArrayList<Integer> numerosAleatorios = new ArrayList<Integer>();
		
		Random gerador = new Random();
		for (int i = 0; i < qtd; i++) {
			numerosAleatorios.add(gerador.nextInt(50));
		}
		return numerosAleatorios;
	}
}
