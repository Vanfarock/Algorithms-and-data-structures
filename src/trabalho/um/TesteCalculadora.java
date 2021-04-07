package trabalho.um;

public class TesteCalculadora {

	public static void main(String[] args) throws Exception {
		Calculadora calc = new Calculadora();
		System.out.println(calc.calcular("1 2 - 4 5 + *"));
		System.out.println(calc.calcular("23 12 + 7 / 3 12 - 5 + *"));
		System.out.println(calc.calcular("10 2 1 - 7 + -"));
	}

}
