package mou;

import java.util.HashMap;

import java.util.Map;
import java.util.Stack;

import interpreteur.Undo;

public final class MoteurRpn {

	 
	 
	private Stack<Double> pile;
	 
	private Undo undo;
	 
	private MoteurRpn(final Stack<Double> operande, final Undo undoP) {
		pile = operande;
		undo = undoP;
	}
	 
	public void addOperande(final double d) {
		pile.push(d);
		undo.alertChange();
	}
	 
	
	 
	public boolean executeCommand(final String name) throws Exception {
		if (operations.containsKey(name)) {
			if (pile.size() < 2) {
				System.err.println("nombre d'opérandes "
						+ "dans l'expression invalide");
				return false;
			}
			double operande2 = pile.pop();
			double operande1 = pile.pop();
			try {
				pile.push(operations.get(name)
				.apply(operande1, operande2));
				undo.alertChange();
				return true;
			} catch (Exception e) {
				pile.push(operande1);
				pile.push(operande2);
				return false;
			}
		} else {
			 
			throw new Exception();
		}
	}
	 	
}
