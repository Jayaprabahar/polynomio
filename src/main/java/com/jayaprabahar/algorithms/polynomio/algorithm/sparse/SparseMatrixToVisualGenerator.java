/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.sparse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.jayaprabahar.algorithms.polynomio.model.Container;
import com.jayaprabahar.algorithms.polynomio.model.Coordinates;
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

/**
 * <p> Project : polynomio </p>
 * <p> Title : SparseMatrixToVisualContainerGenerator.java </p>
 * <p> Description: Sparse Matrix to Visual Container Matrix </p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Component
public class SparseMatrixToVisualGenerator {

	/**
	 * @param showAllCombinations 
	 * @return 
	 * 
	 */
	public String getVisualMatrix(List<List<Integer>> sparsePosition, int width, int height, boolean showAllCombinations) {
		return getStringFromVisualMatrix(convertSparseMatrixToVisualMatrix(sparsePosition, width, height, showAllCombinations));
	}

	/**
	 * @param sparsePosition
	 * @param width
	 * @param height
	 * @param showAllCombinations 
	 * @return
	 */
	public List<String[][]> convertSparseMatrixToVisualMatrix(List<List<Integer>> sparsePosition, int width, int height, boolean showAllCombinations) {
		Container container = new Container(width, height);
		PentominoBaseModel baseModel = new PentominoBaseModel();
		Map<Integer, String> pentominoAlphabetPositionMap = baseModel.getPentominoAlphabetPositionMap();
		String polynomioChar = StringUtils.EMPTY;
		Coordinates coordinates = null;

		List<String[][]> listOfPossibleOutputs = new ArrayList<>();

		for (List<Integer> eachCombination : sparsePosition) {
			String[][] containerVisual = new String[width][height];
			for (String[] strings : containerVisual) {
				Arrays.fill(strings, StringUtils.EMPTY);
			}

			for (List<Integer> intList : ListUtils.partition(eachCombination, width)) {
				for (int j = 0; j < intList.size(); j++) {
					if (j == 0) {
						polynomioChar = pentominoAlphabetPositionMap.get(intList.get(j));
					} else {
						coordinates = container.getCoordinatesBasedOnPosition(intList.get(j) - baseModel.getPentominoBaseModels().size());
						containerVisual[coordinates.getXAxis()][coordinates.getYAxis()] = polynomioChar;
					}
				}
				polynomioChar = StringUtils.EMPTY;
			}
			listOfPossibleOutputs.add(transposeMatrix(containerVisual));
		}
		return listOfPossibleOutputs;
	}

	/**
	 * 
	 */
	public String getStringFromVisualMatrix(List<String[][]> listOfVisualMatrix) {
		return listOfVisualMatrix.stream().map(e -> Arrays.stream(e).map(s -> Arrays.stream(s).collect(Collectors.joining(" "))).collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n\n------------\n\n"));
	}

	/**
	 * @return 
	 * 
	 */
	private String[][] transposeMatrix(String[][] inputMatrix) {
		String[][] outputMatrix = new String[inputMatrix[0].length][inputMatrix.length];

		for (String[] strings : outputMatrix) {
			Arrays.fill(strings, StringUtils.EMPTY);
		}

		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[i].length; j++) {
				outputMatrix[j][i] = inputMatrix[i][j];
			}

		}
		return outputMatrix;
	}

}
