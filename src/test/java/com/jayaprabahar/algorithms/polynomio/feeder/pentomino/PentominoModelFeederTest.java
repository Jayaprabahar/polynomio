/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.feeder.pentomino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;

/**
 * <p> Project : polynomio </p>
 * <p> Title : PentominoModelFeederTest.java </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.feeder.pentomino </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 2, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
class PentominoModelFeederTest {

	@Test
	void testPentominoModelFeeder() {
		PentominoModelFeeder feeder = new PentominoModelFeeder(6, 10);
		assertEquals(12, feeder.getPolynomioList().size());

		// Tests there is no duplicates
		List<CoordinatesSet> totalCoordinates = feeder.getPolynomioList().stream().map(e -> e.getCoordinatesSets()).flatMap(List::stream).collect(Collectors.toList());
		assertEquals(totalCoordinates.size(), totalCoordinates.stream().distinct().count());

		assertEquals(385, totalCoordinates.size());
		assertEquals(32, feeder.getPentominoCoordinates("F").size());
		assertEquals(20, feeder.getPentominoCoordinates("I").size());
		assertEquals(27, feeder.getPentominoCoordinates("L").size());
		assertEquals(35, feeder.getPentominoCoordinates("N").size());
		assertEquals(40, feeder.getPentominoCoordinates("P").size());
		assertEquals(32, feeder.getPentominoCoordinates("T").size());
		assertEquals(36, feeder.getPentominoCoordinates("U").size());
		assertEquals(32, feeder.getPentominoCoordinates("V").size());
		assertEquals(32, feeder.getPentominoCoordinates("W").size());
		assertEquals(32, feeder.getPentominoCoordinates("X").size());
		assertEquals(35, feeder.getPentominoCoordinates("Y").size());
		assertEquals(32, feeder.getPentominoCoordinates("Z").size());

	}

}
