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
 * <p> Description: This class represents a container or board or a box where polynomios has to be filled. Represented in a integer matrices with 0s and 1s. Mostly this matrix is a sparse matrix </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Getter
@Setter
public class Container {

	private int width;
	private int height;
	private int polynomioAlphabetCount;
	private int[][] containerPlacements;

	/**
	 * 
	 */
	public Container(int width, int height, int polynomioAlphabetCount, int totalCoordinatesCount) {
		this.width = width;
		this.height = height;
		this.polynomioAlphabetCount = polynomioAlphabetCount;
		this.containerPlacements = new int[totalCoordinatesCount][width * height + polynomioAlphabetCount];
	}

	public Container(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * @return 
	 * 
	 */
	public int getPositionBasedOnCoordinates(Coordinates coordinates) {
		return polynomioAlphabetCount + (width * coordinates.getYAxis()) + coordinates.getXAxis();
	}

	/**
	 * @return 
	 * 
	 */
	public Coordinates getCoordinatesBasedOnPosition(int position) {
		return new Coordinates(position % width, position / width);
	}

}
