package model;

import exception.OutOfLimitsException;
import exception.UnauthorizedActionException;

public enum Action {
	AVANCE {
		@Override
		public void perform(Aventurier a, Carte c) {
			a.getOrientation().avance(a);
			try {
				if(c != null){
					Case tresor = c.getCase(a.getPosition());
					if(tresor instanceof Tresor){ //aventurier ramasse tresor
						c.ramasse(a.getPosition());
						a.setNbTresor(a.getNbTresor()+ 1);
					}
				}
			} catch (OutOfLimitsException | UnauthorizedActionException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			Aventurier aFutur = Aventurier.newInstance(a);
			aFutur.getOrientation().avance(aFutur);
			try {
				Case caseCarte = c.getCase(aFutur.getPosition());
				if(caseCarte == null){
					return true;
				}
				if(caseCarte instanceof Montagne){
					return false;
				}
			} catch (OutOfLimitsException e) {
				return false;
			}
			return true;
		}
	},
	DROITE {
		@Override
		public void perform(Aventurier a, Carte c) {
			a.getOrientation().droite(a);
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			return true;
		}
	},
	GAUCHE {
		@Override
		public void perform(Aventurier a, Carte c) {
			a.getOrientation().gauche(a);
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			return true;			
		}
	};
	
	public abstract void perform(Aventurier a, Carte c);
	public abstract boolean check(Aventurier a,Carte c);
}
