/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.solution.pentomino;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.solution.pentomino </p>
 * <p> Title : PentominoSolution.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public class DLXSolutionTest {

	/**
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testDLXSolution() throws IOException {
		DLXSolution dlxSolution = new DLXSolution(6, 10);
		int[][] containerPlacements = dlxSolution.createPolynoimioMatrix();

		String expected = new String(getClass().getClassLoader().getResourceAsStream("MatrixForDlx.txt").readAllBytes());
		String actual = Arrays.stream(containerPlacements).map(s -> Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" "))).collect(Collectors.joining("\n"));
//		assertEquals(expected.trim(), actual.trim());
	}

}
