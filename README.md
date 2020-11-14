# Brief

Solving polynomios, in this case I chose pentomino

It is implemented as a REST API with different URL for each algorithm.


## Expected algorithms
1. Fast Placement Algorithm (I named like this). It does not take more time. It generates output by placing the values in iterative manner.  A simple algorithm that tries to iteratively fill the sparse matrix entries in sequential way
2. Back tracking Algorithm. It places the boxes in sequential pentomino alphabet way and if xth box is not able to be placed, then it performs backtracking and change the position of previous box
3. DLX Algorithm. Considered to be the best algorithm. It is in progress.

## Technical Stack

This application is developed as an API.
It is developed using SpringBoot
It can be tested via browser or PostMan tool

1. OpenJDK 11
2. SpringBoot 2.3.5.RELEASE
3. AOP for time taken calculation
4. Java libraries such as commons-math3
4. And few other. Please refer pom.xml

Run the SpringBoot application (main class "PolynomioApplication.java")
The solution is running as an API.


# OpenApi 3 Specification

This application automatically generated the OpenApi 3 Specification at the "http://localhost:8080/api-docs".
Please put them in the swagger editor to play with it.

# Dockers

## Run on local docker engine
 
A simple working dockerfile implementation is added as part of this source code. All you need is to run your local Docker engine (Eg:- docker desktop) and execute the following commands sequentially.
*	docker build -t polynomio .
*	docker run -p 8080:8080 polynomio

If you feel it is working smooth, then
*	docker tag polynomio jayaprabahar/polynomio:latest
*	docker push jayaprabahar/polynomio:latest

## 	Pull image from my/your Dockerhub

I already pushed the image into my dockerhub. Its a public one. You can pull from three or you can pull from your own docker registry (acr/dockerhub), and run it
*	docker pull jayaprabahar/polynomio:latest
*	docker run -p 8080:8080 jayaprabahar/polynomio

## 	Push image into your Dockerhub

Incase if you want to push into your own dockerhub registry, follow the below comments

*	docker tag polynomio jayaprabahar/polynomio:latest
*	docker push jayaprabahar/polynomio:latest
The push refers to repository [docker.io/jayaprabahar/polynomio]
latest: digest: sha256:6847213ec5e98ce26c0f5247f44db356147a2e48e38bff4b9c8619d482d625bf size: 1166

# Kubernetes & Cloud

I added k8s configuration for deployment & service. 

This configuration will work seemlessly in Azure, if you already tagged the image with you AzureContainerRegistry
*	az acr list --resource-group VotingAppResourceGroup --query "[].{acrLoginServer:loginServer}" --output table
*	docker tag polynomio <Your_ACR_Login_server>/polynomio:latest

Example
*	docker tag polynomio jpvotingappacr.azurecr.io/polynomio:latest


## Usage
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

* BackTracking Algorithm


	http://localhost:8080/polynomios/backTrackingAlgorithm?boxWidth=6&boxHeight=10
	
	- I I I I I
	P P P - X -
	T P P X X X
	T T T U X U
	T N F U U U
	N N F F Y -
	N F F Y Y L
	N W W V Y L
	W W - V Y L
	W V V V L L


* Fast Placement Algorithm (Whichever is available first, those will be placed)

	--------------------
	- F FZ FZ N - P - - FP
	F F - FZ N N P P FP FP
	- F F FZ FZ N P P FP FP
	I I I I I N T U U U
	L L L L - - T U - U
	- - - L - T T T - -

	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=6&boxHeight=10&showRandom=true
	
	- F - P - - N - - -
	F F - P P - N N - -
	- F F P P - FN N T -
	I I I I I FN FN N T -
	L L L L - FN - T T T
	- - - L - FN - - - -	
	
	--------------------
	
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=10&boxHeight=6&allowedPolynomio=F-FF
	
	- F - - - - - - - -
	F F - - - - - - - -
	- F F - - - - - - -
	- FF - - - - - - - -
	- FF FF - - - - - - -
	FF FF - - - - - - - -
	
	--------------------
	
	http://localhost:8080/polynomios/fastPlacementAlgorithm?boxWidth=10&boxHeight=6&showAllCombinations=true
	
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