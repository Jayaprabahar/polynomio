/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.algorithm.dlx;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> Project : polynomio </p>
 * <p> Title : DLXNode.java </p>
 * <p> Description: TODO </p>
 * <p> Created: Nov 2, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Data
@NoArgsConstructor
public class DLXNode {

	public int headerNo;
	public DLXNode header;
	public DLXNode left;
	public DLXNode right;
	public DLXNode up;
	public DLXNode down;

	public DLXNode(int headerNo) {
		this.headerNo = headerNo;
	}

	@Override
	public String toString() {
		return String.valueOf(headerNo);
	}

}
