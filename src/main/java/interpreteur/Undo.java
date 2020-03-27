
package interpreteur;

import java.util.Stack;



public class Undo implements Interpreteurgeneric {

	private Stack<Stack<Double>> undo;
	
	private Stack<Double> pile;
	
	public Undo(final Stack<Double> operande) {
		pile = operande;
		undo = new Stack<Stack<Double>>();
	}
	
	public void alertChange() {
		
		@SuppressWarnings("unchecked")
		
		Stack<Double> s = (Stack<Double>) pile.clone();
		undo.push(s);
	}
	
	private void copyLastStack() {
		for (double d : undo.lastElement()) {
			pile.push(d);
		}
	}
	
	    public void apply() {
		while (!pile.isEmpty()) {
			pile.pop();
		}
		
		undo.pop();
		copyLastStack();
	}
}
