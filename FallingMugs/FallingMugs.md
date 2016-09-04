#Falling Mugs

Susan is making high-speed videos of falling coffee mugs. When analyzing the videos she wants to know how big the mugs are, but unfortunately they all got destroyed during filming. Susan knows some physics though, so she has figured out how far they moved between different video frames. The camera was filming at a speed of 70 frames per second, which means that at frame n, counted from when the mug was released, the number of millimeters it has moved is d=n^2. The counting of the frames starts at 0.

Susan thinks a certain mug is D
millimeters high, but to verify this she needs to find two frames between which the mug has moved exactly this distance. Can you help her do this?

#Input

The input file contains the single positive integer D≤200000, the distance to be measured.


#Output

Output two non-negative integers n1 and n2, the numbers of the frames that Susan should compare. They should fulfill n2^2−n1^2 = D. If no two such integers exist, instead output “impossible”.

<b>Sample input</b>

88

<b>Sample output</b>

9 13

#Additional info

<b>Time limit: </b> 2 seconds

<b>Memory limit: </b> 1024 MB

<b>Author(s): </b> Ulf Lundström 

<b>Source: </b> KTH Challenge 2014 
