/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.dlx;

import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

import com.jayaprabahar.algorithms.polynomio.algorithm.sparse.SparseMatrixSupporter;
import com.jayaprabahar.algorithms.polynomio.model.pentomino.PentominoBaseModel;

import lombok.Data;

/**
 * <p> Project : polynomio </p>
 * <p> Package : com.jayaprabahar.algorithms.polynomio.algorithm </p>
 * <p> Title : PentominoSolution.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 1, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Data
public class DLXMatrixGenerator {

	int width;
	int height;
	int[][] containerPlacements;
	DLXNode dlxNode;
	String allowedPolynomio;

	/**
	 * 
	 */
	public DLXMatrixGenerator(int width, int height, String allowedPolynomio) {
		this.width = width;
		this.height = height;
		createRootDlxNode();
		containerPlacements = new SparseMatrixSupporter().createPolynomioMatrix(width, height, allowedPolynomio);
	}

	/**
	 * 
	 */
	private void createRootDlxNode() {
		dlxNode = new DLXNode();
		dlxNode.left = dlxNode;
		dlxNode.right = dlxNode;
		dlxNode.up = dlxNode;
		dlxNode.down = dlxNode;
		dlxNode.up = dlxNode;
	}

	/**
	 * 
	 */
	private void createDLXNodes() {
		createHeaderDlxLinks();
		createRowDlxNodeLinks();

	}

	private void createHeaderDlxLinks() {
		IntStream.range(0, containerPlacements[0].length).boxed().map(DLXNode::new).forEach(newDlxNode -> {
			newDlxNode.right = dlxNode;
			newDlxNode.left = dlxNode.left;
			dlxNode.left.right = newDlxNode;
			dlxNode.left = newDlxNode;
			newDlxNode.up = newDlxNode;
			newDlxNode.down = newDlxNode;
		});
	}

	/**
	 * 
	 */
	private void createRowDlxNodeLinks() {
		for (int i = 0; i < containerPlacements.length; i++) {
			// Iterate right from the root node, will return the header column node
			DLXNode headerNode = dlxNode.right;

			for (int j = 0; j < containerPlacements[i].length; j++) {
				// Build data objects, attach to column objects
				if (containerPlacements[i][j] != 0) {
					int indexOfTwo = ArrayUtils.indexOf(containerPlacements[j], containerPlacements[i][j]);

					DLXNode tempNode = new DLXNode();
					tempNode.up = headerNode.up;
					tempNode.down = headerNode;
					tempNode.left = tempNode;
					tempNode.right = tempNode;
					tempNode.header = headerNode;
					headerNode.up.down = tempNode;
					headerNode.up = tempNode;
				}
				headerNode = headerNode.right;
			}
		}
	}

	public static void main(String[] args) {
		DLXMatrixGenerator dlxSolution = new DLXMatrixGenerator(6, 10, PentominoBaseModel.PENTOMINO_APHABET);
		dlxSolution.createDLXNodes();
	}

}
