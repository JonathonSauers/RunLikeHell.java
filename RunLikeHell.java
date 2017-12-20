// Jonathon Sauers
// jo046326
// COP 3503, Fall 2017
// RunLikeHell.java

import java.util.*;

public class RunLikeHell
{
  //===========================================================================
  // // Recursive solution used to help me figure out the dynamic
  // // programming solution.
  // public static int maxGain_Recursive(int [] blocks)
  // {
  //   // Some quick base cases.
  //   if(blocks.length == 0) return 0;
  //   if(blocks.length == 1) return blocks[0];
  //
  //   // Determines whether it is better to take the first or second block.
  //   return Math.max(maxGain_Recursive_Helper(blocks, 0),
  //                   maxGain_Recursive_Helper(blocks, 1));
  // }
  //
  // private static int maxGain_Recursive_Helper(int [] blocks, int k)
  // {
  //   // Fail states. Also, determines whether to take the very last block
  //   // or not depending on which condition fails.
  //   if((k + 3) >= blocks.length)
  //     if((k + 2) >= blocks.length)
  //       return blocks[k];
  //     else
  //       return blocks[k] + blocks[k + 2];
  //
  //   // Add up the knowledge blocks and return which one has more knowledge.
  //   return Math.max(blocks[k] + maxGain_Recursive_Helper(blocks, k + 2),
  //                   blocks[k] + maxGain_Recursive_Helper(blocks, k + 3));
  // }
  //===========================================================================

  // Dynamic programming solution with an optimized space complexity.
  // Given an array of integers, this will find the maximum value that can
  // be obtained with the restriction that if a block is chosen, the next
  // one must be skipped.
  public static int maxGain(int [] blocks)
  {
    int matrix[] = new int[2];
    int size = blocks.length;

    // Loop through blocks and decide whether or not to take it based on
    // which value is bigger.
    // The answer will either be at index 0 or 1.
    for(int i = 0; i < size; i++)
      matrix[i % 2] = Math.max(blocks[i] + matrix[i % 2], matrix[(i + 1) % 2]);

    // If the size is even the final answer is at 0.
    // If the size is odd the final answer is at 1.
    return (size % 2 == 0) ? matrix[1] : matrix[0];
  }

  // How difficult I found this assignment.
  public static double difficultyRating()
  {
    return 3.0;
  }

  // How many hours I spent on this assignment.
  public static double hoursSpent()
  {
    return 6.0;
  }
}
