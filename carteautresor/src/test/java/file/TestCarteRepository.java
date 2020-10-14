package file;

import model.*;
import exception.InitialisationException;
import facade.Ressource;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static model.Action.*;


public class TestCarteRepository implements facade.CarteRepository {
    @Override
    public Carte get(Ressource ressource) throws InitialisationException {
        List<Case> list = new ArrayList<Case>();
        list.add(new Montagne(new Position(5,3)));
        list.add(new Tresor(new Position(4,2), 1));
        list.add(new Tresor(new Position(1,4), 3));

        List<Action>listAction1 =
                Arrays.asList(new Action[]{AVANCE, AVANCE, DROITE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
        Aventurier a1 = new Aventurier("Yunus",new Position(1,1), Orientation.EST, listAction1 );

        List<Action> listAction2 =
                Arrays.asList(new Action[]{AVANCE, AVANCE, AVANCE, GAUCHE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
        Aventurier a2 = new Aventurier("CarbonIT", new Position(4,3), Orientation.OUEST, listAction2 );
        list.add(a1);
        list.add(a2);
        HashMap<Position, Case> mapCase = Util.listCaseToMapCase(list);

        return new Carte(mapCase, new Position(6,5));
    }
}
