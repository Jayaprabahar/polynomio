package com.jayaprabahar.algorithms.polynomio.model.pentomino;

import java.util.List;

import com.jayaprabahar.algorithms.polynomio.generator.pentomino.PentominoCoordinatesGenerator;
import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;
import com.jayaprabahar.algorithms.polynomio.model.Polynomio;

import lombok.Getter;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : PentominoBaseModel.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Getter
public class PentominoBaseModel {

	private PentominoBaseModel() {
		throw new IllegalStateException("Utility class");
	}

	static PentominoCoordinatesGenerator coordinatesGenerator = new PentominoCoordinatesGenerator();

	static Polynomio pentominoF = new Polynomio("F", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 1, 1, 1, 1, 2, 2, 2, 1, 0))));
	static Polynomio pentominoI = new Polynomio("I", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 0, 2, 0, 3, 0, 4, 0))));
	static Polynomio pentominoL = new Polynomio("L", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 0, 2, 0, 3, 0, 3, 1))));
	static Polynomio pentominoN = new Polynomio("N", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 0, 1, 1, 1, 1, 2, 1, 3))));
	static Polynomio pentominoP = new Polynomio("P", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 0, 1, 0, 2, 1, 1, 1, 2))));
	static Polynomio pentominoT = new Polynomio("T", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 0, 2, 1, 2, 2, 2))));
	static Polynomio pentominoU = new Polynomio("U", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 0, 2, 0, 0, 1, 2, 1))));
	static Polynomio pentominoV = new Polynomio("V", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 0, 1, 0, 0, 1, 0, 2, 0))));
	static Polynomio pentominoW = new Polynomio("W", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 0, 1, 1, 1, 1, 0, 2, 0))));
	static Polynomio pentominoX = new Polynomio("X", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 1, 1, 1, 2, 1, 1, 0, 1, 2))));
	static Polynomio pentominoY = new Polynomio("Y", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 1, 2, 1, 3, 0, 2))));
	static Polynomio pentominoZ = new Polynomio("Z", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 1, 2, 1, 1, 1, 0, 2, 0))));

	/**
	 * @return 
	 * 
	 */
	public static List<Polynomio> getPentominoBaseModels() {
		return List.of(pentominoF, pentominoI, pentominoL, pentominoN, pentominoP, pentominoT, pentominoU, pentominoV, pentominoW, pentominoX, pentominoY, pentominoZ);
	}

}
