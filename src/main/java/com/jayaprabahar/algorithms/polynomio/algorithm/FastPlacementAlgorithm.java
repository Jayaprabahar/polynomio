/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixSupporter;
import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixToVisualGenerator;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : polynomio </p>
 * <p> Title : FastPlacementAlgorithm.java </p>
 * <p> Description: A simple algorithm that tries to iteratively fill the sparse matrix entries in sequential way, wherever the space is filled at the first sight</p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Service
@Slf4j
public class FastPlacementAlgorithm implements Algorithm {

	private SparseMatrixSupporter sparseMatrixSupporter;
	private SparseMatrixToVisualGenerator sparseMatrixToVisualGenerator;

	/**
	 * 
	 */
	@Autowired
	public FastPlacementAlgorithm(SparseMatrixSupporter sparseMatrixSupporter, SparseMatrixToVisualGenerator sparseMatrixToVisualGenerator) {
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
		List<List<Integer>> listOfPolynomioPositions = sparseMatrixSupporter.createPolynomioCombinationList(containerWidth, containerHeight, allowedPolynomio);
		List<List<Integer>> results = new ArrayList<>();
		log.info("Poly Solutions {}", listOfPolynomioPositions);

		for (int i = 0; i < listOfPolynomioPositions.size(); i++) {
			results.add(findCovering(listOfPolynomioPositions, listOfPolynomioPositions.get(i)));
		}
		log.info("Solutions {}", results);

		return sparseMatrixToVisualGenerator.getVisualMatrix(results, containerWidth, containerHeight, allowedPolynomio, showAllCombinations, randomOutput);
	}

	/**
	 * @param listOfPolynomioPositions 
	 * @return 
	 * 
	 */
	private List<Integer> findCovering(List<List<Integer>> listOfPolynomioPositions, List<Integer> listOfInsertedPositions) {
		for (int i = 0; i < listOfPolynomioPositions.size(); i++) {
			if (CollectionUtils.isEmpty(ListUtils.intersection(listOfInsertedPositions, listOfPolynomioPositions.get(i)))) {
				listOfInsertedPositions = ListUtils.union(listOfInsertedPositions, listOfPolynomioPositions.get(i));
			}
		}
		return listOfInsertedPositions;
	}

}
