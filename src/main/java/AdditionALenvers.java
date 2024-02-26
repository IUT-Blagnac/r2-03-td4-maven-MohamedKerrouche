package main;

import pile.Pile;

class AdditionALEnvers {

	/*
	 * Programme pour faire des additions " a l'envers".
	 * Ex : si on lui donne 12 45 56,  il affichera : 
	 * 45 + 56 = 101 
	 * 12 + 101 = 113 
	 * Le resultat est : 113 
	 * Les operandes sont fournis par la methode statique donneesInitiales()
	 * 
	 * @throws exception si on cherche à dépiler ou accéder au somme si la pile est vide ou si on cherche à empiler 
	 */
	public static void main(String args[]) throws Exception{

		Pile pileOperandes; // Pile des operandes durant le calcul
		int operande; // operande lue dans l'expression
		int res; // resultats intermediaires de calculs
		int resPrev; // resultat du calcul precedentt
		int[] tabValeurs;
		
		tabValeurs = AdditionALEnvers.donneesInitiales();
		
		// Valeurs initiales
		System.out.println("Valeurs initiales");
		AdditionALEnvers.afficherTableau(tabValeurs);
		
		// Mettre les operandes dans pileOperandes pour faire les additions "a l'envers"
		pileOperandes = new Pile(tabValeurs.length);
		for (int i=0; i<tabValeurs.length; i++) {
			if(! pileOperandes.estPleine()) {
				pileOperandes.empiler(tabValeurs[i]);
			}
			else {
				throw new Exception("La pile est pleine");
			}
		}

		// Caluls a partir de pileOperandes
		if(! pileOperandes.estVide()) {
			res = pileOperandes.sommet();
			pileOperandes.depiler();
		}
		else {
			throw new Exception("La pile est vide");
		}
		resPrev = res;
		while (!pileOperandes.estVide()) {
			operande = pileOperandes.sommet();
			pileOperandes.depiler();
			res = operande + resPrev;
			System.out.println("" + operande + " + " + resPrev + " = " + res);
			resPrev = res;
		}

		System.out.println("Le r�sultat est : " + res);

	}

	/*
	 * Convertit une chaine contenant une liste d'entiers separes par des espace en
	 * tableau.
	 * Modifier la valeur de expr dans le code pour une autre execution
	 * 
	 * @return le tableau contenant une liste d'entiers. 
	 * Si une erreur de conversion de chaine en nombre a lieu au runtime : le programme est arrete
	 * 
	 * 
	 */
	public static int[] donneesInitiales() {
		int[] data; // liste finale des valeurs entieres
		String expr; // expression initiale (liste de valeurs separees par des espaces)
		String[] exprEclatee; // expr "eclatee"en sur separateur espace

		expr = "12 4 98 56 78";

		exprEclatee = expr.split(" ");
		data = new int[exprEclatee.length];
		for (int i = 0; i < exprEclatee.length; i++) {
			try {
				data[i] = Integer.parseInt(exprEclatee[i]);
			} catch (NumberFormatException nfe) { // echec de parseInt()
				System.out.println("Erreur de format");
				System.exit(1);
			}
		}
		return data;
	}
	
	/*
	 * Affiche les valeurs d'un tableau d'entier
	 * 
	 * @param pfTableauDeValeurs tableau a afficher
	 */
	public static void afficherTableau (int[] pfTableauDeValeurs) {
		String resultatAAfficher;
		resultatAAfficher = "";
		for (int i = 0; i < pfTableauDeValeurs.length; i++) {
			resultatAAfficher = resultatAAfficher + pfTableauDeValeurs[i] + ", ";
		}
		resultatAAfficher = resultatAAfficher.substring(0, resultatAAfficher.length() - 2);
		System.out.println(resultatAAfficher);
	}
}
