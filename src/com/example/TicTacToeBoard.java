package com.example;

public class TicTacToeBoard {
  public static Evaluation evaluateBoard(String board) {
    // board length check
    board = board.toLowerCase();
    if(board.length() != 9)
      return Evaluation.InvalidInput;
    
    // x-o difference
    int xcount = 0;
    int ocount = 0;
    for(int i=0; i<board.length(); i++) {
      if(board.charAt(i) == 'x')
        xcount++;
      else if(board.charAt(i) == 'o')
        ocount++;
    }
    if(Math.abs(xcount - ocount) > 1)
      return Evaluation.UnreachableState;
    
    // win condition check
    boolean xwins = winConditions('x', board);
    boolean owins = winConditions('o', board);
    if(xwins && owins)
      return Evaluation.UnreachableState;
    else if(xwins)
      return Evaluation.Xwins;
    else if(owins)
      return Evaluation.Owins;
    else
      return Evaluation.NoWinner;
  }

  public static boolean winConditions(char checker, String board) {
    // rows check
    for(int i=0; i<=6; i+=3) {
      if(board.charAt(i) == checker && board.charAt(i+1) == checker && board.charAt(i+2) == checker)
        return true;
    }

    // columns check
    for(int i=0; i<=2; i++) {
      if(board.charAt(i) == checker && board.charAt(i+3) == checker && board.charAt(i+6) == checker)
        return true;
    }

    // diagonals check
    if(board.charAt(0) == checker && board.charAt(4) == checker && board.charAt(8) == checker) return true;
    if(board.charAt(2) == checker && board.charAt(4) == checker && board.charAt(6) == checker) return true;

    return false;
  }

  public static void main(String[] args) {
    System.out.println(evaluateBoard("x.xoxoxo."));
  }
}