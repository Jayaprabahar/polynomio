/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.solution.pentomino;

import java.util.concurrent.atomic.AtomicInteger;

import com.jayaprabahar.algorithms.polynomio.feeder.pentomino.PentominoModelFeeder;
import com.jayaprabahar.algorithms.polynomio.model.Container;

import lombok.Value;

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
@Value
public class DLXSolution {

	int width;
	int height;

	/**
	 * @return 
	 * 
	 */
	public int[][] createPolynoimioMatrix() {
		PentominoModelFeeder feeder = new PentominoModelFeeder(width, height);
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

}
