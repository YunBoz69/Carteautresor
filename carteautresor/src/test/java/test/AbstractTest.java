package test;

import model.*;
import model.Action;
import model.Orientation;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static model.Action.*;

public abstract class AbstractTest {
    protected HashMap<Position, Case> mapTresorsMontages(){
        List<Case> list = new ArrayList<Case>();
        list.add(new Montagne(new Position(5,3)));
        list.add(new Tresor(new Position(4,2),1));
        list.add(new Tresor(new Position(1,4),3));
        
        
        HashMap<Position, Case> mapCase = Util.listCaseToMapCase(list);
        return mapCase;
    }
    
    protected Carte getCarteSimple(){
        return new Carte(mapTresorsMontages(), new Position(6,5));
    }
    
    protected  Aventurier getAventurier(){
    	List<Action> listAction1 =
                Arrays.asList(new Action[]{AVANCE, AVANCE, DROITE, AVANCE, DROITE, AVANCE, GAUCHE, AVANCE});
    	return new Aventurier("Yunus",new Position(3,2), Orientation.EST, listAction1 );
    }
}
