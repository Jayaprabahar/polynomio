/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.model </p>
 * <p> Title : CoordinatesSet.java </p>
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
@ToString(includeFieldNames = false)
public class CoordinatesSet {

	List<Coordinates> coordinateSet;
}
