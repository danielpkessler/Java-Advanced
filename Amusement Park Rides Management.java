/*

FICHIER : TP1
AUTEURS : DANIEL KESSLER & YASSINE BELADEL

La methode main est contenue dans ce fichier.

 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Tp1 {

	public static void main(String[] args) {
		Signature donnees = (Signature) new Bdd();
		Manege unManege;
		String nom, parc, affichage = "";
		double hauteur, vitesse;
		
		unManege = new Manege("Kingda Ka",437, 121);
		
		donnees.addManege(unManege, "Great Adventure");
		
		lireFichier(donnees);
		parc = "Great Adventure";
		List<Manege> l = donnees.listeDuParc(parc);
		for(Manege m : l) {
			affichage += m.toString() + "\n";
		}
		
		JOptionPane.showConfirmDialog(null, affichage, "Les manèges de " + parc, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		unManege = donnees.getManege(new Manege("Condor"));
		if (unManege != null)
			System.out.println(unManege);
		System.out.println("\n\nLa table de fréquence des manèges");
		// System.out.println(donnees.frequence());
		
		for (Map.Entry<Manege, Integer> entry : donnees.frequence().entrySet()) {
	        System.out.println(entry.getKey().toString().trim() + ", frequence : " + entry.getValue() + " observation(s).");
	    }
		
		System.out.println("\n\nLa Bdd:");
		System.out.println(donnees);
		
		unManege = new Manege("Condor");
		System.out.println("\nLes parcs ou l'on retrouve le Condor sont :\n" + donnees.emplacementsManege(unManege));
	}
	
	public static void lireFichier(Signature donnees) {
		FileReader fr = null;
		boolean existeFile = true;
		boolean finFichier = false;
		String nomFile;
		Manege m;
		String nom, parc;
		double hauteur, vitesse;
		String[] valeurs;
		JFileChooser choixFichier;
		
		choixFichier = new JFileChooser();
		if(choixFichier.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
		{	nomFile = choixFichier.getSelectedFile().getName();
			File f = choixFichier.getCurrentDirectory();
			nomFile = f.getAbsolutePath()+File.separator + nomFile;
			try {
			
				fr = new FileReader(nomFile);
			} catch (java.io.FileNotFoundException e) {
				System.out.println("Probleme d'ouvrir le fichier " + nomFile);
		   		existeFile = false;
			}

			if (existeFile) {
				try{

		  			BufferedReader entree = new BufferedReader (fr);

		  			while (!finFichier) {
			  			String ligne = entree.readLine();
			  			if (ligne != null){
			  				valeurs = ligne.split(";");
			  				nom = valeurs[0];
			  				hauteur = Double.parseDouble(valeurs[1].trim());
			  				vitesse = Double.parseDouble(valeurs[2].trim());
			  				m = new Manege(nom, hauteur, vitesse);
			  				donnees.addManege(m, valeurs[3].trim());
			  			}
			  			else
			  				finFichier = true;
		  				}
		  			entree.close();
				}catch(IOException e){
					System.out.println("Problème lors de la lecture du fichier");
				}
			}
		}	
	}
}


/*

EXECUTION :

Nom : Condor, Hauteur : 112.0, Vitesse : 30.0


La table de fréquence des manèges
Nom : Condor, Hauteur : 112.0, Vitesse : 30.0, frequence : 3 observation(s).
Nom : Batman the ride, Hauteur : 109.0, Vitesse : 50.0, frequence : 6 observation(s).
Nom : Superman Krypton Coaster, Hauteur : 168.0, Vitesse : 70.0, frequence : 1 observation(s).
Nom : Superman ultimate flight, Hauteur : 115.0, Vitesse : 60.0, frequence : 3 observation(s).
Nom : Deja vu, Hauteur : 178.0, Vitesse : 65.0, frequence : 2 observation(s).
Nom : Superman Ride of Steel, Hauteur : 208.0, Vitesse : 73.0, frequence : 3 observation(s).
Nom : Kingda Ka, Hauteur : 437.0, Vitesse : 121.0, frequence : 1 observation(s).
Nom : SpongeBob SquarePants 3-D, Hauteur : 3.0, Vitesse : 0.0, frequence : 3 observation(s).
Nom : Mantis, Hauteur : 145.0, Vitesse : 60.0, frequence : 1 observation(s).
Nom : Raptor, Hauteur : 137.0, Vitesse : 57.0, frequence : 1 observation(s).
Nom : Dragon Mountain, Hauteur : 187.0, Vitesse : 50.0, frequence : 1 observation(s).
Nom : Le Monstre, Hauteur : 131.0, Vitesse : 60.0, frequence : 1 observation(s).
Nom : Mind Eraser, Hauteur : 115.0, Vitesse : 64.0, frequence : 4 observation(s).
Nom : Boomerang, Hauteur : 125.0, Vitesse : 50.0, frequence : 6 observation(s).
Nom : Test Track, Hauteur : 65.0, Vitesse : 65.0, frequence : 1 observation(s).


La Bdd:
Parc : Great Adventure
	Manege : Kingda Ka, Hauteur : 437.0, Vitesse : 121.0
	Manege : SpongeBob SquarePants 3-D, Hauteur : 3.0, Vitesse : 0.0
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
	Manege : Superman ultimate flight, Hauteur : 115.0, Vitesse : 60.0
Parc : Magic mountain
	Manege : Deja vu, Hauteur : 178.0, Vitesse : 65.0
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
Parc : Great America
	Manege : Deja vu, Hauteur : 178.0, Vitesse : 65.0
	Manege : Superman ultimate flight, Hauteur : 115.0, Vitesse : 60.0
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
	Manege : Condor, Hauteur : 112.0, Vitesse : 30.0
Parc : Six Flags over Georgia
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
	Manege : Superman ultimate flight, Hauteur : 115.0, Vitesse : 60.0
Parc : La Ronde
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
	Manege : Condor, Hauteur : 112.0, Vitesse : 30.0
	Manege : SpongeBob SquarePants 3-D, Hauteur : 3.0, Vitesse : 0.0
	Manege : Le Monstre, Hauteur : 131.0, Vitesse : 60.0
Parc : Darien Lake
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
	Manege : Superman Ride of Steel, Hauteur : 208.0, Vitesse : 73.0
	Manege : Mind Eraser, Hauteur : 115.0, Vitesse : 64.0
Parc : The Great Escape
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
	Manege : Condor, Hauteur : 112.0, Vitesse : 30.0
Parc : Six Flags New Orleans
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
	Manege : SpongeBob SquarePants 3-D, Hauteur : 3.0, Vitesse : 0.0
Parc : Elitch Gardens
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
	Manege : Mind Eraser, Hauteur : 115.0, Vitesse : 64.0
Parc : Six Flags over Texas
	Manege : Batman the ride, Hauteur : 109.0, Vitesse : 50.0
Parc : Six Flags New England
	Manege : Superman Ride of Steel, Hauteur : 208.0, Vitesse : 73.0
	Manege : Mind Eraser, Hauteur : 115.0, Vitesse : 64.0
Parc : Six Flags America
	Manege : Superman Ride of Steel, Hauteur : 208.0, Vitesse : 73.0
	Manege : Mind Eraser, Hauteur : 115.0, Vitesse : 64.0
Parc : Fiesta Texas
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
	Manege : Superman Krypton Coaster, Hauteur : 168.0, Vitesse : 70.0
Parc : Marineland
	Manege : Dragon Mountain, Hauteur : 187.0, Vitesse : 50.0
Parc : Wild Adventures
	Manege : Boomerang, Hauteur : 125.0, Vitesse : 50.0
Parc : Epcot
	Manege : Test Track, Hauteur : 65.0, Vitesse : 65.0
Parc : Cedar Point
	Manege : Mantis, Hauteur : 145.0, Vitesse : 60.0
	Manege : Raptor, Hauteur : 137.0, Vitesse : 57.0


Les parcs ou l'on retrouve le Condor sont :
[The Great Escape, Great America, La Ronde]

*/
