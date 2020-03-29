package mou;


import java.util.Scanner;
import java.util.Stack;




import mou.Interprete.Interpreteur;
import interpreteur.Quit;
import interpreteur.Undo;
 

public class saisieRPN {
 
	private MoteurRpn moteur;
	
	private Interpreteur interprete;
	 
	private Stack<Double> pile;
	 
	private Scanner s;
	 
	public saisieRPN() {
		pile = new Stack<Double>();
		Undo u = new Undo(pile);
		Quit q= new Quit();
		u.alertChange();
		moteur = MoteurRpn.init(pile, u);
		interprete = Interpreteur.init(u);
	}
	
	public double calcul() throws Exception {
		s = new Scanner(System.in);
		double d;
		boolean continuer = true;
		String line = "";
		
		System.out.print("              CALCULATRICE RPN: \n \n"
+"*Chaque opérande doit etre saisie séparemment suivi par la touche Entré du clavier \n"
+"**Les opérations possible sont l'addition +, la soustraction -, la multiplication *, la division /. \n"
+"***Saisir \"undo\" pour annulé l'action précedente. \n"
+"****Saisir \"exit\" pour quitté le programme. \n"
+"Saisir votre première opérande:"
				);
		while (continuer) {
			try {  
				d = s.nextDouble();
				moteur.addOperande(d);
			} catch (java.util.InputMismatchException e) {
				line = s.nextLine();
				try {  
					moteur.executeCommand(line);
				} catch (Exception m) {
					try {
						 
						interprete.executeCommand(line);
					} catch (Exception i) {
						System.err.println("saisie incorrecte!!");
					}
				}
			}
			if (line.equalsIgnoreCase("exit")) {
				continuer = false;
			} else {
				System.out.print(
				"\nSaisie: " + pile + "\nSaisir:");
				 
			}
		}
		s.close();
		 
	
		
		System.out.println("resultat : " + pile);
		return pile.pop();
	}
}
