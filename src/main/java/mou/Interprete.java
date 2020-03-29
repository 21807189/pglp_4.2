package mou;


import java.util.HashMap;
import java.util.Map;

import interpreteur.Interpreteurgeneric;
import interpreteur.Quit;
import interpreteur.Undo;


public class Interprete {

 
public final static class Interpreteur {
	 
	private Map<String, Interpreteurgeneric> commands;
	 
	private Interpreteur() {
		
		commands = new HashMap<String, Interpreteurgeneric>();
	}
	
	public void addCommand(final String sof,
	final Interpreteurgeneric command) {
		this.commands.put(sof, command);
	}
	
	public void executeCommand(final String sof) throws Exception {
		if (commands.containsKey(sof)) {
			try {
				commands.get(sof).apply();
			} catch (Exception e) {
				System.err.println("erreur de saisie");
			}
		} else {
			throw new Exception();
		}
	}
	
	public static  Interpreteur init(final Undo u) {
		Interpreteur h = new Interpreteur();
		h.addCommand("undo", u);
		h.addCommand("exit", new Quit());
		return h;
	}
}
}