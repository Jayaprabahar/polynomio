package com.jayaprabahar.algorithms.polynomio.feeder.pentomino;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.jayaprabahar.algorithms.polynomio.model.Coordinates;
import com.jayaprabahar.algorithms.polynomio.model.CoordinatesSet;
import com.jayaprabahar.algorithms.polynomio.model.Polynomio;
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.generator </p>
 * <p> Title : PentominoModelFeeder.java </p>
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
@ToString
public class PentominoModelFeeder {

	List<Polynomio> polynomioList;
	int width;
	int height;

	@Getter(value = AccessLevel.NONE)
	private Predicate<? super Coordinates> inTheBoxPredicate = e -> e.getXAxis() >= 0 && e.getXAxis() < width && e.getYAxis() >= 0 && e.getYAxis() < height;

	/**
	 * 
	 */
	public PentominoModelFeeder(int width, int height) {
		this.width = width;
		this.height = height;
		this.polynomioList = PentominoBaseModel.getPentominoBaseModels();

		generateAllPentominoCombinations();
	}

	/**
	 * 
	 */
	private void generateAllPentominoCombinations() {
		polynomioList.stream().forEach(polynomio -> {
			List<CoordinatesSet> newCoordinates = new ArrayList<>();

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					newCoordinates.addAll(shift(polynomio, i, j));
				}
			}
			polynomio.setCoordinatesSets(newCoordinates);
		});
	}

	private List<CoordinatesSet> shift(Polynomio polynomio, int xIncrement, int yIncrement) {
		Function<Coordinates, Coordinates> shiftFunction = coordinate -> new Coordinates(coordinate.getXAxis() + xIncrement, coordinate.getYAxis() + yIncrement);

		List<CoordinatesSet> newCoordinates = new ArrayList<>();
		polynomio.getCoordinatesSets().forEach(coSet -> {
			List<Coordinates> tempCoordinateSet = coSet.getCoordinateSet().stream().map(shiftFunction).collect(Collectors.toList());

			if (tempCoordinateSet.stream().allMatch(inTheBoxPredicate)) {
				newCoordinates.add(new CoordinatesSet(tempCoordinateSet));
			}
		});
		return newCoordinates;
	}

	/**
	 * @return 
	 * 
	 */
	public List<CoordinatesSet> getCoordinatesSetForPolynomioLetter(String polynomioLetter) {
		return polynomioList.stream().filter(e -> StringUtils.equalsIgnoreCase(polynomioLetter, e.getPolynomioLetter())).findFirst().orElse(new Polynomio()).getCoordinatesSets();
	}

	/**
	 * @return 
	 * 
	 */
	public List<CoordinatesSet> getCoordinates() {
		return polynomioList.stream().map(Polynomio::getCoordinatesSets).flatMap(List::stream).collect(Collectors.toList());
	}

	/**
	 * @return 
	 * 
	 */
	public List<Coordinates> getCoordinatesForPolynomioLetter(String polynomioLetter) {
		return getCoordinatesSetForPolynomioLetter(polynomioLetter).stream().map(CoordinatesSet::getCoordinateSet).flatMap(List::stream).collect(Collectors.toList());
	}

	/**
	 * @return 
	 * 
	 */
	public int getCoordinatesCount() {
		return (int) polynomioList.stream().map(Polynomio::getCoordinatesSets).flatMap(List::stream).count();
	}
	
}
