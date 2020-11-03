/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.generator.pentomino;

import com.jayaprabahar.algorithms.polynomio.generator.CoordinatesGenerator;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : CoordinatesGenerator.java </p>
 * <p> Description: Coordinates Generator for Pentominos</p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public class PentominoCoordinatesGenerator extends CoordinatesGenerator {

	public static final int POLYNOMIO_SIZE = 5;

	/**
	 * @param polynomioSize
	 */
	public PentominoCoordinatesGenerator() {
		super(POLYNOMIO_SIZE);
	}

}
