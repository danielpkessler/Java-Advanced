/*

Cette classe correspond a une Base de Donnees (BDD) pour les maneges et les parcs.
Celle-ci implemente l'interface Signature, les methodes de cette derniere sont implementees. 
La classe contient deux maps.
La premiere map (parcs) associe le nom d.un parc a la liste de maneges qui lui sont associes.
La deuxieme map associe un manege a un TreeSet de parcs qui contient ce manege.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Bdd implements Signature {
	
	// Map qui enregistre les parc avec une liste de ses manèges
    private Map<String, List<Manege>> parcs;
    
    // Map qui enregistre chaque manege avec une liste des parcs où il se retrouve
    private Map<Manege, TreeSet<String>> manegeToParcs;

	// Constructeur qui initialise les deux maps
    public Bdd() {
        parcs = new LinkedHashMap<>();
        manegeToParcs = new HashMap<>();
    }
    
    
    // Ajoute un manege à un parc dans les deux maps
	@Override
	public void addManege(Manege m, String parc) {
		// Ajouter la manege a la liste associee avec le parc - 1er map
		parcs.putIfAbsent(parc, new ArrayList<>());
	    parcs.get(parc).add(m);
		
		// Ajouter le nom du parc au TreeSet associe avec la manege - 2eme map
		manegeToParcs.putIfAbsent(m, new TreeSet<>());
        manegeToParcs.get(m).add(parc);
	}

	
	// Fonction qui retourne la liste des manèges dans un parc donné
	@Override
	public List<Manege> listeDuParc(String parc) {
		List<Manege> manegeList = parcs.get(parc);
		if (manegeList == null) {
			return Collections.emptyList();
		} else {
			return manegeList;
		}
	}

	
	// Fonction qui retourne le parc lequel se trouve le manege
	@Override
	public Set<String> emplacementsManege(Manege m) {
		Set<String> emplacements = new HashSet<>();
		for (Map.Entry<String, List<Manege>> entry : parcs.entrySet()) {
			
			for (Manege man : entry.getValue()) {
				if (man.equals(m)) {
					emplacements.add(entry.getKey());
				}
			}
			
		}
		return emplacements;
	}

	
	/* Fonctio pour chercher et retourner un manege voulu. 
	Dans le cas contraire, on retourne null si on ne trouve pas le manege. */
	@Override
	public Manege getManege(Manege m) {
		for (List<Manege> l : parcs.values()) {
			for (Manege m2 : l) {
				if (m2.equals(m)) {
					return m2;
				}
			}
		}
		
		for (TreeSet<String> l : manegeToParcs.values()) {
			for (String m2 : l) {
				if (m2.equals(m.getNom())) {
					
					Manege mTemp = null;
					
					for (Manege m3 : manegeToParcs.keySet()) {
						if (m3.equals(m)) {
							mTemp = m;
						}
					}
					
					return mTemp;
					
				}
			}
		}
		
		return null;
	}

	
	// Fonction qui calcule et retourne la fréquence d'apparition de chaque manege dans le document txt
	@Override
	public Map<Manege, Integer> frequence() {
	    Map<Manege, Integer> freqMap = new HashMap<>();
	    for (List<Manege> manegeList : parcs.values()) {
	        for (Manege m : manegeList) {
	            freqMap.put(m, freqMap.getOrDefault(m, 0) + 1);
	        }
	    }
	    
	    return freqMap;
	}
	
	
	@Override
    public String toString() {
        String result = "";

        for (Map.Entry<String, List<Manege>> entry : parcs.entrySet()) {
            result += "Parc : " + entry.getKey() + "\n";
            for (Manege m : entry.getValue()) {
                result += "\tManege : " + m.getNom() + ", Hauteur : " + m.getHauteur() + ", Vitesse : " + m.getVitesse() + "\n";
            }
        }

        return result;
    }
}
