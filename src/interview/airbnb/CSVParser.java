package interview.airbnb;

/*
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""
John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"

Understand the problem:
For this problem, there are several cases need to consider:
1. For comma, transform to |
2. If comma is inside a quote, don't treat the comma as separated. Remove the comma and print the entire token. e.g. "San Francisco, CA" => San Francisco, CA
3. If there are double quotes, remove one. e.g. "Alexandra ""Alex""" => Alexandra "Alex". 
Note that """Alexandra Alex""" becomes "Alexandra Alex" because we first remove the outer-most quote, and then remove one quote of the double quote.


*/

public class CSVParser
{

}
