/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.generator;

import java.util.List;

import com.jayaprabahar.algorithms.polynomio.model.Coordinates;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : CoordinatesGenerator.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public final class CoordinatesGenerator {

	/**
	 * @return 
	 * 
	 */
	public static List<Coordinates> generatePentominoCoordinates(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
		return List.of(new Coordinates(x1, y1), new Coordinates(x2, y2), new Coordinates(x3, y3), new Coordinates(x4, y4), new Coordinates(x5, y5));
	}

}
