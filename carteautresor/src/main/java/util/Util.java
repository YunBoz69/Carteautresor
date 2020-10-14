package util;

import model.Aventurier;
import model.Case;
import model.Position;
import model.Action;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {
	public static HashMap<Position, Case> listCaseToMapCase(List<Case> list) {
		return (HashMap<Position, Case>) list
			.stream()
			.collect(Collectors.toMap(Case::getPosition, Function.identity()));
	}

	public static HashMap<String, Aventurier> listAventurierToMapAventurier(List<Aventurier> list) {
		return (HashMap<String, Aventurier>) list
			.stream()
			.collect(Collectors.toMap(Aventurier::getNom, Function.identity()));
	}
}
