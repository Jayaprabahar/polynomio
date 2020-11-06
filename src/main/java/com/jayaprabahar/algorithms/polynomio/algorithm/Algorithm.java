/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm;

/**
 * <p> Project : polynomio </p>
 * <p> Title : Algorithm.java </p>
 * <p> Description: Algorithm interface. Will be implemented for each algorithm solution </p>
 * <p> Created: Nov 5, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
public interface Algorithm {

	public String getSolution(int containerWidth, int containerHeight, String allowedPolynomio, boolean showAllCombinations, boolean randomOutput);

}
