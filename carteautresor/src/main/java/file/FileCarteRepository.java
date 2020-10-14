package file;

import model.*;
import model.Action;
import model.Orientation;
import model.Aventurier;
import exception.InitialisationException;
import facade.CarteRepository;
import facade.Ressource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCarteRepository extends FileRepository implements CarteRepository {
	
	@Override
	public Carte get(Ressource ressource) throws InitialisationException {
		
		if (ressource instanceof FileRessource) {
			FileRessource fileRessource = (FileRessource) ressource;
			String carteFileName = fileRessource.getFileName();
			Stream<String> stream = filePathToStream(carteFileName);
			
			List<String> carteLigne = stream
	                .filter(line -> line.startsWith("C"))
	                .collect(Collectors.toList());
			
			if(carteLigne==null || carteLigne.isEmpty()) {
	            throw new InitialisationException();
	        }

			String line = carteLigne.get(0);
	        Position limit =initialiseLimite(line);

			stream = filePathToStream(carteFileName);
	        List<String> lines = stream
	                .collect(Collectors.toList());
	        stream.close();
	        
	        HashMap<Position, Case> mapCase = initialiseMapCase(lines);

			return new Carte(mapCase, limit);
		}
		throw new InitialisationException();
	}
	
	private  Position initialiseLimite(String line){
		String linetmp = line.replaceAll(" ", "");
		String[] splitLine =linetmp.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
 
        return new Position(x, y);
    }
	
	private HashMap<Position, Case> initialiseMapCase(List<String> lines) throws InitialisationException {
		HashMap<Position, Case> mapCase = new HashMap<Position, Case>();
		
		for (String line: lines){
            if(line.startsWith("T")){
                initialiseTresor(line, mapCase);
            }else if(line.startsWith("M")){
            	initialiseMontagne(line, mapCase);
            } else if(line.startsWith("A")){
				initialiseAventurier(line, mapCase);
			}
        }
 
        return mapCase;
    }
	
	private void initialiseTresor(String line, HashMap<Position, Case> mapCase){
		String linetmp = line.replaceAll(" ", "");
		String[] splitLine = linetmp.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
        int numTresor = Integer.parseInt(splitLine[2]);
        
        Position position = new Position(x, y);
        Tresor tresor = new Tresor(position, numTresor);
        
        mapCase.put(position, tresor);
	}
	
	private void initialiseMontagne(String line, HashMap<Position, Case> mapCase){
		String linetmp = line.replaceAll(" ", "");
		String[] splitLine =linetmp.split("-");
        int x = Integer.parseInt(splitLine[1]);
        int y = Integer.parseInt(splitLine[2]);
        
        Position position = new Position(x, y);
        Montagne montagne = new Montagne(position);
        
        mapCase.put(position, montagne);
	}

	private void initialiseAventurier(String line, HashMap<Position, Case> mapCase) throws InitialisationException {
		String linetmp = line.replaceAll(" ", "");
		String[] splitLine = linetmp.split("-");

		String name = splitLine[1];
		int x = Integer.parseInt(splitLine[2]);
		int y = Integer.parseInt(splitLine[3]);

		Position position = new Position(x, y);

		// l'aventurier ne peux pas commencer sur une montagne
		try {
			Case xCase = mapCase.get(position);
			if (xCase instanceof Montagne) {
				throw new InitialisationException();
			}
		} finally {

		}

		Orientation orientation;
		String o = splitLine[4];
		if(o.equals("E")){
			orientation = Orientation.EST;
		}else if(o.equals("N")){
			orientation = Orientation.NORD;
		}else if(o.equals("S")){
			orientation = Orientation.SUD;
		}else if(o.equals("O")){
			orientation = Orientation.OUEST;
		}else{
			throw new InitialisationException();
		}

		List<String> stringAction = new ArrayList(Arrays.asList(splitLine[5].split("")));
		List<Action> actions = initialiseActions(stringAction);
		Aventurier tmp =  new Aventurier(name, position, orientation, actions);
		mapCase.put(position, tmp);
	}

	private List<Action> initialiseActions(List<String> stringAction){
		List<Action> actions = new ArrayList<>();
		for(String s : stringAction)
			if(s.equals("A"))
				actions.add(Action.AVANCE);
			else if(s.equals("D"))
				actions.add(Action.DROITE);
			else if(s.equals("G"))
				actions.add(Action.GAUCHE);
		return actions;
	}
}
