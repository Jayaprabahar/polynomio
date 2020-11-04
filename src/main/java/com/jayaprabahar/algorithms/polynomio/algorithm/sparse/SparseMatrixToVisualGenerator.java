/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.sparse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.RandomUtils;
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

	public static final String SPACE_FILLING_CHAR = "-";

	/**
	 * @param allowedPolynomio 
	 * @param randomOutput 
	 * @return 
	 * 
	 */
	public String getVisualMatrix(List<List<Integer>> sparsePosition, int width, int height, String allowedPolynomio, boolean showAllCombinations, boolean randomOutput) {
		List<String[][]> fullOutput = convertSparseMatrixToVisualMatrix(sparsePosition, width, height, allowedPolynomio);
		String[][] finalPlacement = null;
		int highestPlacementCount = 0;

		if (randomOutput) {
			finalPlacement = fullOutput.get(RandomUtils.nextInt(0, fullOutput.size()));
			fullOutput = new ArrayList<>();
			fullOutput.add(finalPlacement);
		}

		if (!showAllCombinations) {
			for (String[][] strings : fullOutput) {
				ArrayList<String> listOfPlacements = new ArrayList<>(Arrays.asList(StringUtils.split(Arrays.deepToString(transposeMatrix(strings)), ",")));
				listOfPlacements.removeAll(Collections.singleton(null));
				listOfPlacements.removeAll(Collections.singleton(" "));

				if (highestPlacementCount < listOfPlacements.size()) {
					highestPlacementCount = listOfPlacements.size();
					finalPlacement = strings;
				}
			}
			fullOutput = new ArrayList<>();
			fullOutput.add(finalPlacement);
		}

		return getStringFromVisualMatrix(fullOutput);
	}

	/**
	 * @param sparsePosition
	 * @param width
	 * @param height
	 * @param allowedPolynomio 
	 * @param showAllCombinations 
	 * @param randomOutput 
	 * @return
	 */
	public List<String[][]> convertSparseMatrixToVisualMatrix(List<List<Integer>> sparsePosition, int width, int height, String allowedPolynomio) {
		Container container = new Container(width, height);
		PentominoBaseModel baseModel = new PentominoBaseModel();
		Map<Integer, String> pentominoAlphabetPositionMap = baseModel.getPentominoAlphabetPositionMap(allowedPolynomio);
		String polynomioChar = SPACE_FILLING_CHAR;
		Coordinates coordinates = null;

		List<String[][]> listOfPossibleOutputs = new ArrayList<>();

		for (List<Integer> eachCombination : sparsePosition) {
			String[][] containerVisual = new String[width][height];
			for (String[] strings : containerVisual) {
				Arrays.fill(strings, SPACE_FILLING_CHAR);
			}

			for (List<Integer> intList : ListUtils.partition(eachCombination, 6)) {
				for (int j = 0; j < intList.size(); j++) {
					if (j == 0) {
						polynomioChar = pentominoAlphabetPositionMap.get(intList.get(j));
					} else {
						coordinates = container.getCoordinatesBasedOnPosition(intList.get(j) - baseModel.getPentominoBaseModels(allowedPolynomio).size());
						if(coordinates.getXAxis() < 0 || coordinates.getXAxis() < 0) {
							System.out.println();
						}
						containerVisual[coordinates.getXAxis()][coordinates.getYAxis()] = polynomioChar;
					}
				}
				polynomioChar = SPACE_FILLING_CHAR;
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
			Arrays.fill(strings, SPACE_FILLING_CHAR);
		}

		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[i].length; j++) {
				outputMatrix[j][i] = inputMatrix[i][j];
			}

		}
		return outputMatrix;
	}

}
