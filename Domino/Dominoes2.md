#Dominoes 2

Dominoes are lots of fun. Children like to stand the tiles on their side in long lines. When one domino falls, it knocks down the next one, which knocks down the one after that, all the way down the line. However, sometimes a domino fails to knock the next one down. In that case, we have to knock it down by hand to get the dominoes falling again.

Given a set of dominoes that are knocked down by hand, your task is to determine the total number of dominoes that fall.

#Input

The first line of input contains one integer specifying the number of test cases to follow. Each test case begins with a line containing three integers n,m,l no larger than 10000, followed by m+l additional lines. The first integer n is the number of domino tiles. The domino tiles are numbered from 1 to n

.

Each of the m
lines after the first line contains two integers x and y indicating that if domino number x falls, it will cause domino number y to fall as well. Each of the following l lines contains a single integer z indicating that the domino numbered z is knocked over by hand.

#Output

For each test case, output a line containing one integer, the total number of dominoes that fall over.

<b>Sample input</b>

1

3 2 1

1 2

2 3

2

<b>Sample output</b>

2

#Additional info

<b>Time limit: </b> 1 second

<b>Memory limit: </b> 1024 MB

<b>Author(s): </b> Ondřej Lhoták 

<b>Source: </b> Waterloo ACM Programming Contest, October 04, 2008 
