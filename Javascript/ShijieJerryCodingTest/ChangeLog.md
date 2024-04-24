# ChangeLog
* For the feedback from interviewer "What if neighboring segments have the same value", implement the following changes:
  1. For multiple neighboring segments with same value, change the behavior of merging them to maintaining separately. 
    * The main change happens inside the private method cleanSkyline().
  2. Restructure the two test suite (add() and set()) to following:  
    * Add() operation for single existing interval 
    * Add() operation involving multiple existing intervals. And this contains dedicated unit tests for neighboring elements with same values.
    * Set() operation for single existing interval 
    * Set() operation involving multiple existing intervals. And this contains dedicated unit tests for neighboring elements with same values. 
  3. Fix a minor bug in handleTo() function when "to" endpoints already exist. 