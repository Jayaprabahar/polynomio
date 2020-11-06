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
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

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
		PolynomioModelFeeder feeder = new PolynomioModelFeeder(6, 10, PentominoBaseModel.PENTOMINO_APHABET);
		assertEquals(12, feeder.getPolynomioList().size());

		// Tests there is no duplicates
		List<CoordinatesSet> totalCoordinates = feeder.getPolynomioList().stream().map(Polynomio::getCoordinatesSets).flatMap(List::stream).collect(Collectors.toList());
		assertEquals(totalCoordinates.size(), totalCoordinates.stream().distinct().count());

		assertEquals(389, totalCoordinates.size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("F").size());
		assertEquals(20, feeder.getCoordinatesSetForPolynomioLetter("I").size());
		assertEquals(35, feeder.getCoordinatesSetForPolynomioLetter("L").size());
		assertEquals(35, feeder.getCoordinatesSetForPolynomioLetter("N").size());
		assertEquals(36, feeder.getCoordinatesSetForPolynomioLetter("P").size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("T").size());
		assertEquals(36, feeder.getCoordinatesSetForPolynomioLetter("U").size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("V").size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("W").size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("X").size());
		assertEquals(35, feeder.getCoordinatesSetForPolynomioLetter("Y").size());
		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("Z").size());
		
//		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("FF").size());
//		assertEquals(27, feeder.getCoordinatesSetForPolynomioLetter("FL").size());
//		assertEquals(35, feeder.getCoordinatesSetForPolynomioLetter("FN").size());
//		assertEquals(40, feeder.getCoordinatesSetForPolynomioLetter("FP").size());
//		assertEquals(35, feeder.getCoordinatesSetForPolynomioLetter("FY").size());
//		assertEquals(32, feeder.getCoordinatesSetForPolynomioLetter("FZ").size());
		
	}

}
