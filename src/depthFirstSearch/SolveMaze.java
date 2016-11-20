package depthFirstSearch;

/* package whatever; // don't place package name! */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        String s = "**********\n*        *\n* ** * *S*\n* *  * ***\n* ** * *F*\n**** *** *\n*      * *\n* ****** *\n*        *\n**********";
        String[] splitted = s.split("\n");
        char[][] maze = new char[splitted.length][splitted[0].length()];
        for ( int i = 0; i < splitted.length; i++ )
        {
            for ( int j = 0; j < splitted[0].length(); j++ )
            {
                maze[i][j] = splitted[i].charAt( j );
            }
        }
        
        solveMaze( maze );
        for ( int i = 0; i < splitted.length; i++ )
        {
            for ( int j = 0; j < splitted[0].length(); j++ )
            {
                System.out.print( maze[i][j]);
            }
            System.out.println();
        }
        
    }
    
    public static void solveMaze( char[][] maze )
    {
        int startX = 0;
        int startY = 0;
        for ( int i = 0; i < maze.length; i++ )
        {
            for ( int j = 0; j < maze[0].length; j++ )
            {
                if ( maze[i][j] == 'S' )
                {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        depthFirstSearch( maze, startX, startY );


    }

    private static boolean depthFirstSearch( char[][] maze, int startX, int startY )
    {
        if ( startX < 0 || startX >= maze.length || startY < 0 || startY >= maze[0].length 
            || (maze[startX][startY] != ' ' && maze[startX][startY] != 'S'))
        {
            return false;
        }
        if ( maze[startX][startY] != 'S' )
        {
            maze[startX][startY] = '@';
        }
        if ( maze[startX][startY] == 'F'||
            depthFirstSearch( maze, startX + 1, startY )
           || depthFirstSearch( maze, startX - 1, startY )
           || depthFirstSearch( maze, startX, startY + 1 )
           || depthFirstSearch( maze, startX, startY - 1 ) )

        {
            return true;
        }
        if ( maze[startX][startY] == '@' )
        {
            maze[startX][startY] = ' ';
        }
        return false;
    }
}
/*

# 
# Your previous Plain Text content is preserved below:
# 
# Write a function that solves ASCII mazes. An ASCII maze is stored as a
# string, each character of which represents a space on the maze. Rows in
# the maze are delimited by newline characters. All mazes will take the
# same format:
# 
# '*' == wall
# 'S' == start position
# 'F' == end position
# ' ' == walkable square
# 
# You can assume that all mazes will be valid and solvable, though if we
# have extra time feel free to handle those edge cases.
# 
# Your function should take a maze as a single argument and return the
# solved maze, with your solution path drawn using the character of your
# choice. For example:
# 
# Input:
# **********
# *        *
# * ** * *S*
# * *  * ***
# * ** * *F*
# **** *** *
# *      * *
# * ****** *
# *        *
# **********
# 
# String format:
# "**********\n*        *\n* ** * *S*\n* *  * ***\n* ** * *F*\n**** *** *\n*      * *\n* ****** *\n*        *\n**********"
# 
# Output:
# **********
# *   @@@@@*
# * **@* *S*
# * * @* ***
# * **@* *F*
# ****@***@*
# *@@@@  *@*
# *@******@*
# *@@@@@@@@*
# **********
*/
    
