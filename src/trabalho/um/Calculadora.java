package trabalho.um;

import pilhas.Pilha;
import pilhas.PilhaLista;
import pilhas.PilhaVetor;

public class Calculadora {
	private boolean tipoLista;

	public boolean isTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(boolean tipoLista) {
		this.tipoLista = tipoLista;
	}
	
	public double calcular(String expressao) throws Exception {
		if(expressao.isEmpty()) {
			throw new NumberFormatException("A express�o n�o pode ser vazia!");
		}
		
		String[] termosExpressao = expressao.replaceAll("\\s+", " ")
											.trim()
											.split(" ");
		
		Pilha<Double> pilha = getPilha(termosExpressao.length);

		try {
			for (String termo : termosExpressao) {
				if (ehOperador(termo)) {
					double segundoTermo = pilha.pop();
					double primeiroTermo = pilha.pop();
					pilha.push(realizarOperacao(primeiroTermo, segundoTermo, termo));
					
				} else {
					pilha.push(Double.parseDouble(termo));
				}
			}			
		}
		catch (NumberFormatException e) {
			throw new RuntimeException(
					"Digite apenas n�meros e operadores (+, -, *, /) e os separe por espa�o!");
		}
		catch (RuntimeException e) {
			throw new RuntimeException(
					"Est�o faltando operandos suficientes para computar a express�o!"); 
		}

		double resultado = pilha.pop();
		if (!pilha.estaVazia()) {
			throw new RuntimeException(
					"Est�o faltando operadores para que todos os elementos da express�o possam ser utilizados!");
		}
		return resultado;
	}

	private Pilha<Double> getPilha(int capacidade) {
		if(this.isTipoLista()) {
			return new PilhaLista<Double>(capacidade);
		}
		return new PilhaVetor<Double>(capacidade);
	}
	
	private Boolean ehOperador(String termo) {
		return termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/");
	}

	private double realizarOperacao(double valorUm, double valorDois, String operador) {
		switch (operador) {
		case "+":
			return valorUm + valorDois;
		case "-":
			return valorUm - valorDois;
		case "*":
			return valorUm * valorDois;
		case "/":
			return valorUm / valorDois;
		default:
			return 0;
		}
	}
}
