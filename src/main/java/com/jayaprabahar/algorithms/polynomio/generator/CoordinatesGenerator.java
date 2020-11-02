/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jayaprabahar.algorithms.polynomio.model.Coordinates;

import lombok.AllArgsConstructor;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : CoordinatesGenerator.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@AllArgsConstructor
public class CoordinatesGenerator {

	public int polynomioSize;

	public List<Coordinates> generateCoordinates(int... xyAxis) {
		if (!isValidCoordinates(xyAxis)) {
			return Collections.emptyList();
		}

		List<Coordinates> listOfCoordinates = new ArrayList<>();

		for (int i = 0; i < xyAxis.length; i++, i++) {
			listOfCoordinates.add(new Coordinates(xyAxis[i], xyAxis[i + 1]));
		}
		return listOfCoordinates;
	}

	public boolean isValidCoordinates(int... xyAxis) {
		return polynomioSize * 2 == xyAxis.length;
	}

}
