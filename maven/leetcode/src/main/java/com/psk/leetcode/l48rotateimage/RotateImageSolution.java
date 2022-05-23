package com.psk.leetcode.l48rotateimage;

public class RotateImageSolution {

  /*
  y==2
  0,2 -> 2,2  x:+2, y:+0
  1,2 -> 2,1  x:+1, y:-1
  2,2 -> 2,0  x:+0, y:-2

  --> x = y - x - 2

  y==1
  0,1 -> 1,2  x:+1, y:+1
  1,1 -> 1,1  x:+0, y:+0
  2,1 -> 1,0  x:-1, y:-1

  --> x = 1 - x
  ==> x = y - x

  y==0
  0,0 -> 0,2
  1,0 -> 0,1
  2,0 -> 0,0

  --> x = max(0, y - x)
   */
  public void rotate(int[][] matrix) {
    if (matrix.length == 1) {
      return;
    }


  }
}
