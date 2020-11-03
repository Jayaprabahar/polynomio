/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayaprabahar.algorithms.polynomio.algorithm.FastPlacementAlgorithm;

/**
 * <p> Project : polynomio </p>
 * <p> Title : PolynomioController.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@RestController
@RequestMapping("/polynomios")
public class PolynomioController {

	FastPlacementAlgorithm fastPlacementAlgorithm;

	/**
	 * 
	 */
	@Autowired
	public PolynomioController(FastPlacementAlgorithm fastPlacementAlgorithm) {
		this.fastPlacementAlgorithm = fastPlacementAlgorithm;
	}

	/**
	 * @param polynomioSize
	 * @param containerWidth
	 * @param containerHeight
	 * @return 
	 */
	@GetMapping("/fastPlacementAlgorithm")
	/* @GetMapping("/fastPlacementAlgorithm/{polynomioSize}") */
	public String getSolutionFastPlacementAlgorithm(@RequestParam("boxWidth") int containerWidth, @RequestParam("boxHeight") int containerHeight,
			@RequestParam(name = "showAllCombinations", defaultValue = "false", required = false) boolean showAllCombinations,
			@RequestParam(name = "showRandom", defaultValue = "false", required = false) boolean randomOutput) {
		return fastPlacementAlgorithm.getFastPlacementSolution(containerWidth, containerHeight, showAllCombinations, randomOutput);
	}

}
