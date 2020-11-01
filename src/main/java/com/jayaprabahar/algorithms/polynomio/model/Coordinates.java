package com.jayaprabahar.algorithms.polynomio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.model </p>
 * <p> Title : Container.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Data
@AllArgsConstructor
public class Coordinates {

	private int xAxis;
	private int yAxis;

	@Override
	public String toString() {
		return "[" + xAxis + ", " + yAxis + "]";
	}
}
