/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.feeder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;
import com.jayaprabahar.algorithms.polynomio.model.Polynomio;

/**
 * <p> Project : polynomio </p>
 * <p> Title : PolynomioModelFeederTest.java </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.feeder </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 2, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
class PolynomioModelFeederTest {

	@Test
	void testPentominoModelFeeder() {
		PolynomioModelFeeder feeder = new PolynomioModelFeeder(6, 10);
		assertEquals(12, feeder.getPolynomioList().size());

		// Tests there is no duplicates
		List<CoordinatesSet> totalCoordinates = feeder.getPolynomioList().stream().map(Polynomio::getCoordinatesSets).flatMap(List::stream).collect(Collectors.toList());
		assertEquals(totalCoordinates.size(), totalCoordinates.stream().distinct().count());

		assertEquals(385, totalCoordinates.size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("F").size());
		assertEquals(20, feeder.getCoordinatesForPolynomioLetter("I").size());
		assertEquals(27, feeder.getCoordinatesForPolynomioLetter("L").size());
		assertEquals(35, feeder.getCoordinatesForPolynomioLetter("N").size());
		assertEquals(40, feeder.getCoordinatesForPolynomioLetter("P").size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("T").size());
		assertEquals(36, feeder.getCoordinatesForPolynomioLetter("U").size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("V").size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("W").size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("X").size());
		assertEquals(35, feeder.getCoordinatesForPolynomioLetter("Y").size());
		assertEquals(32, feeder.getCoordinatesForPolynomioLetter("Z").size());

	}

}
