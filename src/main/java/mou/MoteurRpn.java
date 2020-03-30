package mou;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import interpreteur.Undo;
import actions.Addition;
import actions.Calcule;
import actions.Division;
import actions.Multiplication;
import actions.Soustraction;



public final class MoteurRpn {

	 
	private Map<String, Calcule> operations;
	 
	private Stack<Double> pile;
	 
	private Undo undo;
	 
	private MoteurRpn(final Stack<Double> pileOperandes, final Undo undoM) {
		operations = new HashMap<String, Calcule>();
		pile = pileOperandes;
		undo = undoM;
	}
	 
	
	public void addOperande(final double d) {
		pile.push(d);
		undo.alertChange();
	}
	 
	public void addCommand(final String sof, final Calcule command) {
		this.operations.put(sof, command);
	}
	 
	public boolean executeCommand(final String name) throws Exception {
		if (operations.containsKey(name)) {
			if (pile.size() < 2) {
				System.err.println("Il vous faut au moins deux opérandes!!!");
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
	 	public static MoteurRpn init(final Stack<Double> pile, final Undo u) {
		MoteurRpn HOU = new MoteurRpn(pile, u);
		HOU.addCommand("+", new Addition());
		HOU.addCommand("-", new Soustraction());
		HOU.addCommand("*", new Multiplication());
		HOU.addCommand("/", new Division());
		return HOU;
	}



		public Object getStack() {
			// TODO Auto-generated method stub
			return null;
		}



		/*public Object getStack() {
			// TODO Auto-generated method stub
			return null;
		}*/
}
