/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixGenerator;
import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixToVisualGenerator;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : polynomio </p>
 * <p> Title : FastPlacementAlgorithm.java </p>
 * <p> Description: A simple algorithm that tries to iteratively fill the sparse matrix entries in sequential way</p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Service
@Slf4j
public class FastPlacementAlgorithm {

	private SparseMatrixGenerator sparseMatrixGenerator;
	private SparseMatrixToVisualGenerator sparseMatrixToVisualGenerator;

	/**
	 * 
	 */
	@Autowired
	public FastPlacementAlgorithm(SparseMatrixGenerator sparseMatrixGenerator, SparseMatrixToVisualGenerator SparseMatrixToVisualGenerator) {
		this.sparseMatrixGenerator = sparseMatrixGenerator;
		this.sparseMatrixToVisualGenerator = SparseMatrixToVisualGenerator;
	}

	/**
	 * @param containerWidth
	 * @param containerHeight
	 * @param showAllCombinations
	 * @param randomOutput 
	 * @return
	 */
	public String getFastPlacementSolution(int containerWidth, int containerHeight, boolean showAllCombinations, boolean randomOutput) {
		int[][] polynomioAlphabetMatrix = sparseMatrixGenerator.createPolynomioMatrix(containerWidth, containerHeight);
		List<List<String>> listOfPolynomioPositions = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();

		for (int[] perRowEntry : polynomioAlphabetMatrix) {
			listOfPolynomioPositions.add(Arrays.asList(StringUtils.strip(ArrayUtils.indexesOf(perRowEntry, 1).toString(), "{}").split(",")));
		}

		for (int i = 0; i < listOfPolynomioPositions.size(); i++) {
			results.add(findCovering(listOfPolynomioPositions, listOfPolynomioPositions.get(i)));
			log.debug("Solutions {}", results);
		}

		return sparseMatrixToVisualGenerator.getVisualMatrix(results, containerWidth, containerHeight, showAllCombinations, randomOutput);
	}

	/**
	 * @param listOfPolynomioPositions 
	 * @return 
	 * 
	 */
	private List<Integer> findCovering(List<List<String>> listOfPolynomioPositions, List<String> listOfInsertedPositions) {
		for (int i = 0; i < listOfPolynomioPositions.size(); i++) {
			if (CollectionUtils.isEmpty(ListUtils.intersection(listOfInsertedPositions, listOfPolynomioPositions.get(i)))) {
				listOfInsertedPositions = ListUtils.union(listOfInsertedPositions, listOfPolynomioPositions.get(i));
			}
		}
		return listOfInsertedPositions.stream().map(e -> NumberUtils.createInteger(e.trim())).collect(Collectors.toList());
	}

}
