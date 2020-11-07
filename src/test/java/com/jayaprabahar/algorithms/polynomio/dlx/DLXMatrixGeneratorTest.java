/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.dlx;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.jayaprabahar.algorithms.polynomio.algorithm.dlx.DLXMatrixGenerator;
import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixSupporter;
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.algorithm </p>
 * <p> Title : PentominoSolution.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public class DLXMatrixGeneratorTest {

	/**
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testDLXSolution() throws IOException {
		DLXMatrixGenerator dlxSolution = new DLXMatrixGenerator(6, 10, PentominoBaseModel.PENTOMINO_APHABET);
		int[][] containerPlacements = new SparseMatrixSupporter().createPolynomioMatrix(6, 10, PentominoBaseModel.PENTOMINO_APHABET);

		String expected = new String(getClass().getClassLoader().getResourceAsStream("MatrixForDlx.txt").readAllBytes());
		String actual = Arrays.stream(containerPlacements).map(s -> Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" "))).collect(Collectors.joining("\n"));
		// assertEquals(expected.trim(), actual.trim());
	}

}
