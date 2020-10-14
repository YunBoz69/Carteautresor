package model;

public enum Orientation {
	NORD {
		@Override
		public void gauche(Aventurier a) {
			a.setOrientation(Orientation.OUEST);
		}

		@Override
		public void droite(Aventurier a) {
			a.setOrientation(Orientation.EST);
		}

		@Override
		public void avance(Aventurier a) {
			a.setPosition(new Position(
							a.getPosition().getX(),
							a.getPosition().getY()-1 ));
		}
	},
	SUD {
		@Override
		public void gauche(Aventurier a) {
			a.setOrientation(Orientation.EST);
		}

		@Override
		public void droite(Aventurier a) {
			a.setOrientation(Orientation.OUEST);
		}

		@Override
		public void avance(Aventurier a) {
			a.setPosition(new Position(
					a.getPosition().getX(),
					a.getPosition().getY()+1 ));
		}
	},
	EST {
		@Override
		public void gauche(Aventurier a) {
			a.setOrientation(Orientation.NORD);
		}

		@Override
		public void droite(Aventurier a) {
			a.setOrientation(Orientation.SUD);
		}

		@Override
		public void avance(Aventurier a) {
			a.setPosition(new Position(
					a.getPosition().getX()+1,
					a.getPosition().getY()));
		}
	},
	OUEST {
		@Override
		public void gauche(Aventurier a) {
			a.setOrientation(Orientation.SUD);
		}

		@Override
		public void droite(Aventurier a) {
			a.setOrientation(Orientation.NORD);
		}

		@Override
		public void avance(Aventurier a) {
			a.setPosition(new Position(
					a.getPosition().getX()-1,
					a.getPosition().getY()));
		}
	};
	
	public abstract void gauche(Aventurier a);
	public abstract void droite(Aventurier a);
	public abstract void avance(Aventurier a);
}
