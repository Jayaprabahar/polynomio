/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.sparse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.jayaprabahar.algorithms.polynomio.feeder.PolynomioModelFeeder;
import com.jayaprabahar.algorithms.polynomio.model.AlphabetContainer;
import com.jayaprabahar.algorithms.polynomio.model.Container;

import lombok.Data;

/**
 * <p> Project : polynomio </p>
 * <p> Title : SparseMatrixSupporter.java </p>
 * <p> Description: Sparse Matrix Generator. Generates a matrix of 1s and lot of 0s for the given width and height </p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Component
@Data
public class SparseMatrixSupporter {

	/**
	 * @param basePolynomioTobeIncluded 
	 * @param containerHeight 
	 * @param containerWidth 
	 * @return
	 */
	public int[][] createPolynomioMatrix(int width, int height, String allowedPolynomio) {
		PolynomioModelFeeder feeder = new PolynomioModelFeeder(width, height, allowedPolynomio);
		Container container = new Container(width, height, feeder.getPolynomioList().size(), feeder.getCoordinatesCount());
		int[][] containerPlacements = container.getContainerPlacements();

		AtomicInteger polynomioAlphabetCounter = new AtomicInteger(0);
		AtomicInteger rowCounter = new AtomicInteger(0);

		feeder.getPolynomioList().forEach(poynomio -> {
			poynomio.getCoordinatesSets().forEach(coorSetOfPolynomio -> {
				coorSetOfPolynomio.getCoordinateSet().forEach(coorSet -> {
					containerPlacements[rowCounter.intValue()][polynomioAlphabetCounter.intValue()] = 1;
					containerPlacements[rowCounter.intValue()][container.getPositionBasedOnCoordinates(coorSet)] = 1;
				});
				rowCounter.incrementAndGet();
			});
			polynomioAlphabetCounter.incrementAndGet();
		});

//		for (int[] is : containerPlacements) {
//			log.info("{}", Arrays.stream(is).boxed().collect(Collectors.toList()));
//		}
		return containerPlacements;
	}

	/**
	 * @param allowedPolynomio 
	 * @param containerHeight 
	 * @param containerWidth 
	 * @return 
	 * 
	 */
	public List<List<Integer>> createPolynomioCombinationList(int containerWidth, int containerHeight, String allowedPolynomio) {
		List<List<Integer>> listOfPolynomioPositions = new ArrayList<>();

		for (int[] perRowEntry : createPolynomioMatrix(containerWidth, containerHeight, allowedPolynomio)) {
			listOfPolynomioPositions.add(Arrays.stream(StringUtils.strip(ArrayUtils.indexesOf(perRowEntry, 1).toString(), "{}").split(",")).map(StringUtils::trim).map(NumberUtils::createInteger)
					.collect(Collectors.toList()));
		}
		return listOfPolynomioPositions;
	}

	/**
	 * @param allowedPolynomio 
	 * @param containerHeight 
	 * @param containerWidth 
	 * 
	 */
	public Map<Integer, List<List<Integer>>> getPolynomioCombinationsByAlphabets(int containerWidth, int containerHeight, String allowedPolynomio) {
		Map<Integer, List<List<Integer>>> alphabetMatching = new HashedMap<>();
		createPolynomioCombinationList(containerWidth, containerHeight, allowedPolynomio)
				.forEach(e -> alphabetMatching.merge(e.get(0), new ArrayList<>(), (v1, v2) -> v1 != null ? v1 : v2).add(e.subList(1, e.size())));
		return alphabetMatching;
	}

	/**
	 * @return
	 */
	public String[][] createPolynomioAlphabetMatrix(int width, int height, String allowedPolynomio) {
		PolynomioModelFeeder feeder = new PolynomioModelFeeder(width, height, allowedPolynomio);
		AlphabetContainer container = new AlphabetContainer(width, height, feeder.getCoordinatesCount());
		String[][] containerPlacements = prefillArray(container.getContainerPlacements(), StringUtils.EMPTY);

		AtomicInteger rowCounter = new AtomicInteger(0);

		feeder.getPolynomioList().forEach(poynomio -> {
			poynomio.getCoordinatesSets().forEach(coorSetOfPolynomio -> {
				coorSetOfPolynomio.getCoordinateSet().forEach(coorSet -> containerPlacements[rowCounter.intValue()][container.getPositionBasedOnCoordinates(coorSet)] = poynomio.getPolynomioLetter());
				rowCounter.incrementAndGet();
			});
		});
		return containerPlacements;
	}

	/**
	 * @return 
	 * 
	 */
	private String[][] prefillArray(String[][] containerPlacements, String prefillValue) {
		Arrays.stream(containerPlacements).forEach(a -> Arrays.fill(a, prefillValue));
		return containerPlacements;
	}

}
