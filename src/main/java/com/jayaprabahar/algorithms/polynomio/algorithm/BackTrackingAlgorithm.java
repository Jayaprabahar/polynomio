/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixSupporter;
import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixToVisualGenerator;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : polynomio </p>
 * <p> Title : BackTrackingAlgorithm.java </p>
 * <p> Description: Backtracking algorithm that tries to iteratively fill the sparse matrix entries in sequential way, wherever the space is filled at the first sight</p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Service
@Slf4j
public class BackTrackingAlgorithm implements Algorithm {

	private SparseMatrixSupporter sparseMatrixSupporter;
	private SparseMatrixToVisualGenerator sparseMatrixToVisualGenerator;

	private Map<Integer, Integer> levelPosMap = new TreeMap<>();

	/**
	 * 
	 */
	@Autowired
	public BackTrackingAlgorithm(SparseMatrixSupporter sparseMatrixSupporter, SparseMatrixToVisualGenerator sparseMatrixToVisualGenerator) {
		this.sparseMatrixSupporter = sparseMatrixSupporter;
		this.sparseMatrixToVisualGenerator = sparseMatrixToVisualGenerator;
	}

	/**
	 * @param containerWidth
	 * @param containerHeight
	 * @param basePolynomioTobeIncluded 
	 * @param showAllCombinations
	 * @param randomOutput 
	 * @return
	 */
	@Override
	public String getSolution(int containerWidth, int containerHeight, String allowedPolynomio, boolean showAllCombinations, boolean randomOutput) {
		Map<Integer, List<List<Integer>>> polynomioCombinations = sparseMatrixSupporter.getPolynomioCombinationsByAlphabets(containerWidth, containerHeight, allowedPolynomio);
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> output = new ArrayList<Integer>();
		List<List<Integer>> finalOutput = new ArrayList<>();
		int passedIndex = 0;

		for (int level = 0; level < polynomioCombinations.size(); level++) {

			int indexOfFirstSuccess = findCovering(polynomioCombinations.get(level), results, level, passedIndex);
			if (indexOfFirstSuccess < 0) {
				--level;
				if (level >= 0) {
					results.remove(level);
					passedIndex = levelPosMap.get(level);
					levelPosMap.remove(level);
					--level;
				}
			} else {
				passedIndex = 0;
			}
			if (levelPosMap.size() > 10) {
				break;
			}
		}
		for (int i = 0; i < results.size(); i++) {
			output.add(i);
			output.addAll(results.get(i));
		}
		finalOutput.add(output);

		log.info("Solutions {}" + System.lineSeparator(), finalOutput);

		return sparseMatrixToVisualGenerator.getVisualMatrix(finalOutput, containerWidth, containerHeight, allowedPolynomio, showAllCombinations, randomOutput);
	}

	private int findCovering(List<List<Integer>> listOfSinglePositions, List<List<Integer>> results, int level, int previousIndex) {
		List<Integer> flatList = results.stream().flatMap(List::stream).collect(Collectors.toList());

		for (int i = previousIndex + 1; i < listOfSinglePositions.size(); i++) {
			List<Integer> eachEntry = listOfSinglePositions.get(i);
			if (CollectionUtils.isEmpty(ListUtils.intersection(flatList, eachEntry))) {
				results.add(eachEntry);
				levelPosMap.put(level, i);
				return i;
			}
		}
		return -1;
	}

}
