package model;

import exception.OutOfLimitsException;
import exception.UnauthorizedActionException;

import java.util.HashMap;
import java.util.Map;

public class Carte {
    private final Position limit;
    HashMap<Position, Case> mapCase;

    public Carte(HashMap<Position, Case> mapCase, Position limit){
        this.limit = limit;
        this.mapCase = mapCase;
    }

    public Case getCase(Position position) throws OutOfLimitsException {
        Position limitInf = new Position(1,1);
        if(position.isPlusDe(limit)
                || position.isMoinsDe(limitInf)){
            throw new OutOfLimitsException();
        }
        return mapCase.get(position);
    }

    public int ramasse(Position position)
            throws OutOfLimitsException, UnauthorizedActionException {
        Case c = this.getCase(position);
        if(c instanceof Tresor){
            return ((Tresor)c).ramasse();
        }

        throw new UnauthorizedActionException();
    }

    public Position getDim(){
        return limit;
    }

    public HashMap<String, Aventurier> getAventurier(){
        HashMap<String, Aventurier> listAventurier = new HashMap<String, Aventurier>();
        for (Map.Entry m : this.mapCase.entrySet()) {
            if(m.getValue() instanceof Aventurier){
                listAventurier.put(((Aventurier) m.getValue()).getNom(), (Aventurier)m.getValue());
            }
        }
        return listAventurier;
    }
}
