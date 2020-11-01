package com.jayaprabahar.algorithms.polynomio.model.pentomino;

import java.util.List;

import com.jayaprabahar.algorithms.polynomio.generator.CoordinatesGenerator;
import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;
import com.jayaprabahar.algorithms.polynomio.model.Polynomio;

import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;

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
@Value
@NoArgsConstructor
public class PentominoBaseModel {

	Polynomio pentominoF = new Polynomio("F", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 1, 1, 1, 1, 2, 2, 2, 1, 0))));
	Polynomio pentominoI = new Polynomio("I", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 0, 1, 0, 2, 0, 3, 0, 4, 0))));
	Polynomio pentominoL = new Polynomio("L", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 0, 1, 0, 2, 0, 3, 0, 3, 1))));
	Polynomio pentominoN = new Polynomio("N", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 0, 0, 1, 1, 1, 1, 2, 1, 3))));
	Polynomio pentominoP = new Polynomio("P", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 0, 0, 1, 0, 2, 1, 1, 1, 2))));
	Polynomio pentominoT = new Polynomio("T", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(1, 0, 1, 1, 0, 2, 1, 2, 2, 2))));
	Polynomio pentominoU = new Polynomio("U", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 0, 1, 0, 2, 0, 0, 1, 2, 1))));
	Polynomio pentominoV = new Polynomio("V", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 2, 0, 1, 0, 0, 1, 0, 2, 0))));
	Polynomio pentominoW = new Polynomio("W", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 2, 0, 1, 1, 1, 1, 0, 2, 0))));
	Polynomio pentominoX = new Polynomio("X", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 1, 1, 1, 2, 1, 1, 0, 1, 2))));
	Polynomio pentominoY = new Polynomio("Y", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(1, 0, 1, 1, 1, 2, 1, 3, 0, 2))));
	Polynomio pentominoZ = new Polynomio("Z", List.of(new CoordinatesSet(CoordinatesGenerator.generatePentominoCoordinates(0, 2, 1, 2, 1, 1, 1, 0, 2, 0))));

	@NonFinal
	List<Polynomio> pentomios = List.of(pentominoF, pentominoI, pentominoL, pentominoN, pentominoP, pentominoT, pentominoU, pentominoV, pentominoW, pentominoX, pentominoY, pentominoZ);

}
