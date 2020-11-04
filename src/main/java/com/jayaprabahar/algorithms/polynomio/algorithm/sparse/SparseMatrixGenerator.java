/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.sparse;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.jayaprabahar.algorithms.polynomio.feeder.PolynomioModelFeeder;
import com.jayaprabahar.algorithms.polynomio.model.AlphabetContainer;
import com.jayaprabahar.algorithms.polynomio.model.Container;

import lombok.Data;

/**
 * <p> Project : polynomio </p>
 * <p> Title : SparseMatrixGenerator.java </p>
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
public class SparseMatrixGenerator {

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
		return containerPlacements;
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
