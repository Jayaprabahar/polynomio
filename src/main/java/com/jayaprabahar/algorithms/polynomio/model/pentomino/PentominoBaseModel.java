package com.jayaprabahar.algorithms.polynomio.model.pentomino;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.jayaprabahar.algorithms.polynomio.generator.pentomino.PentominoCoordinatesGenerator;
import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;
import com.jayaprabahar.algorithms.polynomio.model.Polynomio;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : PentominoBaseModel.java </p>
 * <p> Description: Holds base model for Pentomino </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public class PentominoBaseModel {
	
	public static final String PENTOMINO_APHABET = "F-I-L-N-P-T-U-V-W-X-Y-Z";

	PentominoCoordinatesGenerator coordinatesGenerator = new PentominoCoordinatesGenerator();

	Polynomio pentominoF = new Polynomio("F", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 1, 2, 1, 1, 1, 0, 2, 1))));
	Polynomio pentominoI = new Polynomio("I", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 0, 2, 0, 3, 0, 4, 0))));
	Polynomio pentominoL = new Polynomio("L", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 1, 2, 1, 3, 0, 3))));
	Polynomio pentominoN = new Polynomio("N", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 0, 1, 0, 2, 0, 3))));
	Polynomio pentominoP = new Polynomio("P", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 0, 2, 0, 1, 1, 2, 1))));
	Polynomio pentominoT = new Polynomio("T", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 0, 1, 0, 2, 1, 1, 2, 1))));
	Polynomio pentominoU = new Polynomio("U", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 2, 0, 0, 1, 1, 1, 2, 1))));
	Polynomio pentominoV = new Polynomio("V", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 1, 2, 2, 2, 2, 1, 2, 0))));
	Polynomio pentominoW = new Polynomio("W", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 0, 1, 1, 1, 1, 0, 2, 0))));
	Polynomio pentominoX = new Polynomio("X", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 1, 1, 1, 2, 1, 1, 0, 1, 2))));
	Polynomio pentominoY = new Polynomio("Y", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 1, 2, 1, 3, 0, 1))));
	Polynomio pentominoZ = new Polynomio("Z", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 2, 0, 1, 1, 1, 2, 1, 2, 0))));
	
//	Polynomio pentominoFlippedF = new Polynomio("FF", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 1, 2, 0, 2, 2, 1))));
//	Polynomio pentominoFlippedL = new Polynomio("FL", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 1, 1, 1, 2, 1, 3, 1, 3, 0))));
//	Polynomio pentominoFlippedN = new Polynomio("FN", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 1, 1, 0, 1, 0, 2, 0, 3))));
//	Polynomio pentominoFlippedP = new Polynomio("FP", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(1, 0, 0, 1, 0, 2, 1, 1, 1, 2))));
//	Polynomio pentominoFlippedY = new Polynomio("FY", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 0, 1, 0, 2, 0, 3, 1, 2))));
//	Polynomio pentominoFlippedZ = new Polynomio("FZ", List.of(new CoordinatesSet(coordinatesGenerator.generateCoordinates(0, 0, 1, 2, 1, 1, 1, 0, 2, 2))));
	
	/**
	 * @param allowedPolynomio 
	 * @return 
	 * 
	 */
	public List<Polynomio> getPentominoBaseModels(String allowedPolynomio) {
		return List
				.of(pentominoF, pentominoI, pentominoL, pentominoN, pentominoP, pentominoT, pentominoU, pentominoV, pentominoW, pentominoX, pentominoY, pentominoZ
//						, pentominoFlippedF, pentominoFlippedL, pentominoFlippedN, pentominoFlippedP, pentominoFlippedY, pentominoFlippedZ
						)
				.stream().filter(e -> ArrayUtils.contains(StringUtils.split(allowedPolynomio, '-'), e.getPolynomioLetter())).collect(Collectors.toList());
	}

	/**
	 * @return 
	 * 
	 */
	public Map<Integer, String> getPentominoAlphabetPositionMap(String allowedPolynomio) {
		AtomicInteger index = new AtomicInteger(0);
		return getPentominoBaseModels(allowedPolynomio).stream().map(Polynomio::getPolynomioLetter).collect(Collectors.toMap(c -> index.getAndIncrement(), c -> c));
	}

}
