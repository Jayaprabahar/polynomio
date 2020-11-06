/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayaprabahar.algorithms.polynomio.algorithm.BackTrackingAlgorithm;
import com.jayaprabahar.algorithms.polynomio.algorithm.FastPlacementAlgorithm;
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : polynomio </p>
 * <p> Title : PolynomioController.java </p>
 * <p> Description: Controller class for Polynomio</p>
 * <p> Created: Nov 3, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@RestController
@RequestMapping("/polynomios")
@Slf4j
public class PolynomioController {

	FastPlacementAlgorithm fastPlacementAlgorithm;
	BackTrackingAlgorithm backTrackingAlgorithm;

	/**
	 * 
	 */
	@Autowired
	public PolynomioController(FastPlacementAlgorithm fastPlacementAlgorithm, BackTrackingAlgorithm backTrackingAlgorithm) {
		this.fastPlacementAlgorithm = fastPlacementAlgorithm;
		this.backTrackingAlgorithm = backTrackingAlgorithm;
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
			@RequestParam(name = "allowedPolynomio", defaultValue = PentominoBaseModel.PENTOMINO_APHABET, required = false) String allowedPolynomio,
			@RequestParam(name = "showAllCombinations", defaultValue = "false", required = false) boolean showAllCombinations,
			@RequestParam(name = "showRandom", defaultValue = "false", required = false) boolean showRandom) {
		log.info("API Call made with containerWidth {}, containerHeight {}, basePolynomioTobeIncluded {}, showAllCombinations {}, randomOutput {}", containerWidth, containerHeight, allowedPolynomio,
				showAllCombinations, showRandom);
		return fastPlacementAlgorithm.getSolution(containerWidth, containerHeight, allowedPolynomio, showAllCombinations, showRandom);
	}

	@GetMapping("/backTrackingAlgorithm")
	public String getSolutionBackTrackingAlgorithm(@RequestParam("boxWidth") int containerWidth, @RequestParam("boxHeight") int containerHeight,
			@RequestParam(name = "allowedPolynomio", defaultValue = PentominoBaseModel.PENTOMINO_APHABET, required = false) String allowedPolynomio,
			@RequestParam(name = "showAllCombinations", defaultValue = "false", required = false) boolean showAllCombinations,
			@RequestParam(name = "showRandom", defaultValue = "false", required = false) boolean showRandom) {
		log.info("API Call made with containerWidth {}, containerHeight {}, basePolynomioTobeIncluded {}, showAllCombinations {}, randomOutput {}", containerWidth, containerHeight, allowedPolynomio,
				showAllCombinations, showRandom);
		return backTrackingAlgorithm.getSolution(containerWidth, containerHeight, allowedPolynomio, showAllCombinations, showRandom);
	}

	@GetMapping("/dlxAlgorithm")
	public ResponseEntity<String> getSolutionDlxAlgorithm() {
		return new ResponseEntity<>("Functionality under development", HttpStatus.NOT_IMPLEMENTED);
	}

}
