package actions;

public class Division implements Calcule {

	public double apply(double operande1, double operande2) throws Exception {

		if (operande2 == 0) {
			System.err.println("Impossible de divisé parb zéro !");
			throw new Exception();
		}
		return operande1 / operande2;
	}
}

/*******
**@MHA**
*******/