# Weighted-interval-Schedule-using-memoization
The Weighted Interval Scheduling problem is this: Given a set of weighted intervals, choose a set of non-overlapping intervals such that the total weight is maximal.  You may think of the “weight” as the profit for doing the work in the given interval
A weighted interval x can be represented by a triple 
	x = (s, f, v), 
where 
	s = start time of x,    f = finish time of x,   v = weight or profit of this job
For example, consider the test case for Weighted Interval Scheduling problem depicted below:  
 
These weighted intervals can be represented by the triples for our case
	(0,3,3)  (1,4,2)  (0,5,4)  (3,6,1)  (4,7,2)  (3,9,5)  (5,10,2)  (8,10,1)
Each interval are  entered as 3 integers.  The intervals are given in a textfile and with an option of both. 
The program print out the value of the total weight or profit of the optimum solution.
