package com.jayaprabahar.algorithms.polynomio.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.model </p>
 * <p> Title : Polynomio.java </p>
 * <p> Description: A value object representation of Polynomio </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Polynomio {

	private String polynomioLetter;
	private List<CoordinatesSet> coordinatesSets;

	/**
	 * @return 
	 * 
	 */
	public List<Coordinates> getAllCoordinates() {
		return this.coordinatesSets.stream().map(CoordinatesSet::getCoordinateSet).flatMap(List::stream).collect(Collectors.toList());
	}
}
