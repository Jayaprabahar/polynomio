# polynomio
Solving polynomios, in this case I chose pentomino

Run the Springboot application (main class "PolynomioApplication.java")

The solution is running as an API.

I am implementing 3 algorithms:-
1) Fast Placement Algorithm (I named like this). It does not take more time. It generates output by placing the values randomly.

Just hit the URL with the following value
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10

You'll see the output in this format.



 F   T 
F F   T 
 F F T T T
I I I I I Y
L L L L  Y
N  P L Y Y
N N P P  Y
 N P P  
 N U U U 
  U  U 

------------

I I I I I 
 F   T 
F F   T 
 F F T T T
L L L L  Y
N  P L  Y
N N P P Y Y
 N P P  Y
 N U U U 
  U  U 

------------
