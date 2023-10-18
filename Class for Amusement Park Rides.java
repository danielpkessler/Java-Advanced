/*

Cette classe a trois attributs : le nom, la hauteur et la vitesse d'un manege.
On implemente l'interface Comparable et on utilise les methodes HashCode et Equals.
Pour ceci, nous pouvons comparer les maneges, ainsi que creer du HashCode unique.

 */

import java.util.*;

class Manege implements Comparable<Manege> {
	private String nom;
	private double hauteur;
	private double vitesse;

	// Constructeurs
	public Manege(String nom, double hauteur, double vitesse) {
		this.nom = nom;
		this.hauteur = hauteur;
		this.vitesse = vitesse;
	}

	public Manege(String n) {
		this.nom = n;
	}

	// Methodes d'acces
	public String getNom() {
		return nom;
	}

	public double getHauteur() {
		return hauteur;
	}

	public double getVitesse() {
		return vitesse;
	}

    // Implémentation de la méthode compareTo pour permettre de comparer deux manèges en fonction de leur nom
	public int compareTo(Manege other) {
		return this.nom.compareTo(other.nom);
	}

    // Implémentation de la méthode equals pour déterminer si deux manèges sont égaux (ils le sont si leurs noms sont identiques)
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Manege other = (Manege) obj;
		return nom.equals(other.nom);
	}

    // Implémentation de la méthode hashCode pour fournir un code de hachage unique à chaque manège (basé sur son nom)
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public String toString() {
	    return "Nom : " + nom + ", Hauteur : " + hauteur + ", Vitesse : " + vitesse;
	}


}
