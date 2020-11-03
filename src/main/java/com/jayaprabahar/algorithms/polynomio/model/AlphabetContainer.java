/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.model </p>
 * <p> Title : Container.java </p>
 * <p> Description: This class represents a container or board or a box where polynomios has to be filled, but with polynomio alphabets.</p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Getter
@Setter
public class AlphabetContainer {

	private int width;
	private int height;
	private String[][] containerPlacements;

	/**
	 * 
	 */
	public AlphabetContainer(int width, int height, int totalCoordinatesCount) {
		this.width = width;
		this.height = height;
		this.containerPlacements = new String[totalCoordinatesCount][width * height];

	}

	/**
	 * @return 
	 * 
	 */
	public int getPositionBasedOnCoordinates(Coordinates coordinates) {
		return (width * coordinates.getYAxis()) + coordinates.getXAxis();
	}

}
