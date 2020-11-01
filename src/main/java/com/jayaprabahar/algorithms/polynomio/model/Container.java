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
 * <p> Description: TODO </p>
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
	
	private int width = 6;
	private int height = 10;
	private int[][] containerMatrix = new int[width][height];

}
