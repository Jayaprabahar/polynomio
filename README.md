# polynomio
Solving polynomios, in this case I chose pentomino

It is implemented as a REST API with differnet URL for each algorithm.

Expected algorithms
1) Fast Placement Algorithm. A simple algorithm that tries to iteratively fill the sparse matrix entries in sequential way
2) DLX Algorithm
3) Backtrack Algorithm

Run the Springboot application (main class "PolynomioApplication.java")

The solution is running as an API.

I am implementing 3 algorithms:-
1) Fast Placement Algorithm (I named like this). It does not take more time. It generates output by placing the values in itreative manner.

Just hit the URL with the following value
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10

 Query parameter:-

	boxWidth		| Number	|	Mandatory
	boxHeight		| Number	|	Mandatory
	showRandom		| Boolean	|	Optional (Default value=false)
	showAllCombinations	| Boolean	|	Optional (Default value=false)
	allowedPolynomio	| String	|	Optional (Default value="F-I-L-N-P-T-U-V-W-X-Y-Z-FF-FL-FN-FP-FY-FZ")

 * http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10&showRandom=true
 * http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10&showAllCombinations=true
 
You'll see the output in this format. (If you are using browser, then the output is wrapped. In that case, Click on view page source, to see in the expected format)

 	- F FZ FZ N - P - - FP
 	F F - FZ N N P P FP FP
 	- F F FZ FZ N P P FP FP
 	I I I I I N T U U U
 	L L L L - - T U - U
 	- - - L - T T T - -

	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10&showRandom=true

	--------------------
	
	- F - P - - N - - -
	F F - P P - N N - -
	- F F P P - FN N T -
	I I I I I FN FN N T -
	L L L L - FN - T T T
	- - - L - FN - - - -

	--------------------
	
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=10&boxHeight=6&allowedPolynomio=F-FF

	--------------------
	
	- F - - - - - - - -
	F F - - - - - - - -
	- F F - - - - - - -
	- FF - - - - - - - -
	- FF FF - - - - - - -
	FF FF - - - - - - - -
	
	--------------------
	
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=10&boxHeight=6&showAllCombinations=true
	
	--------------------
	- F FZ FZ N - P - - FP
	F F - FZ N N P P FP FP
	- F F FZ FZ N P P FP FP
	I I I I I N T U U U
	L L L L - - T U - U
	- - - L - T T T - -
	
	------------
	
	I I I I I P - V V V
	- F - N - P P V - -
	F F - N N P P V - -
	- F F - N T U U U -
	L L L L N T U - U -
	- - - L T T T - - -
	
	------------
	
	I I I I I U U U - -
	L L L L P U - U W W
	- F N L P P T W W Y
	......


