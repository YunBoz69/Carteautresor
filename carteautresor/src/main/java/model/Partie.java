package model;

import java.util.HashMap;
import java.util.Map;

public class Partie {
	private HashMap<String, Aventurier> aventuriers;
	private Carte carte;

	private int nbTours = 0;
	
	
	public Partie(HashMap<String, Aventurier> aventuriers, Carte carte) {
		super();
		this.aventuriers = aventuriers;
		this.carte = carte;
	}
	
	public void perform(Action action, String nom){
		Aventurier a = aventuriers.get(nom);
		if(action.check(a, carte)){
			a.perform(action, carte);
		}
	}
	
	public void run(){
        this.nbTours = 0;
        Boolean fin = false;
        while (!fin){
            fin = true;
            for (String nom: aventuriers.keySet()){
            	try {
            		Action action = aventuriers.get(nom).getListAction().get(nbTours);
	            	perform(action, nom);
	            	fin = fin && false;
            	}catch (IndexOutOfBoundsException e){
                  fin = fin && true;
            	}
            }
            nbTours++;
        }
	}
	
	public HashMap<String, Aventurier> getAventuriers() {
		return aventuriers;
	}


	public Carte getCarte() {
		return carte;
	}

	public String toString() {
		String ret = "";
		ret = ret + "C - " + this.carte.getDim().getX() + " - " + this.carte.getDim().getY() + "\n";
		for (Map.Entry<String, Aventurier> m : this.aventuriers.entrySet()) {
			if(m.getValue() instanceof Aventurier){
				ret = ret + m.getKey() + " - " + ((m.getValue()).getOrientation())
						+ " - " + (m.getValue()).getPosition().getX() + " - "
						+ (m.getValue()).getPosition().getY() + " - "
						+ (m.getValue()).getNbTresor() + "\n";
			}

		}
		return ret;
	}
	
}
