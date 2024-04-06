import java.awt.Color;

/*
 *
 * Plots a Sierpinski Square of order n to standard drawing.
 *
 * Compilation:  javac SierpinskiSquare.java
 * Execution:    java SierpinskiSquare 3
 *
 * @author Jeremy Hui
 */
public class SierpinskiSquare {

    /**
     * Calculates half the length of the diagonal of a square of
     * a specified length.
     * @param length the side length of the square
     * @return the half diagonal length
     */
  public static double halfDiagLength(double length) {
      return length * Math.sqrt(2) / 2.0;
  }

    /**
     * 1. Sets the pen color to be black.
     *    - Use StdDraw.setPenColor(Color.black);
     *
     * 2. Draws a filled polygon at the four points at a distance
     *    of diagHeight(length) from the center (0.5, 0.5).
     *    - Uset StdDraw.filledPolygon(x, y) where x and y are double[] with x and y coordinates.
     * @param length the side length of the square.
     */
    public static void drawDarkSquare(double length) {

      StdDraw.setPenColor(Color.black);
      double [] x = {0.5-halfDiagLength(length),0.5, 0.5+halfDiagLength(length), 0.5};
      double [] y = {0.5,0.5+halfDiagLength(length),0.5,0.5-halfDiagLength(length)};
      StdDraw.filledPolygon(x, y);      
    }

    /**
     * 1. Sets the pen color to be white.
     *    - Use StdDraw.setPenColor(Color.white);
     *
     * 2. Draws a filled square at the center of a specified length.
     *    - Use StdDraw.filledSquare(x, y, r) to draw a square of side length 2r centered at (x,y)
     *
     * @param length the side length of the square
     */
  public static void drawLightSquare(double length) {
      StdDraw.setPenColor(Color.WHITE);
      StdDraw.filledSquare(0.5, 0.5, length / 2); // 중심을 기준으로 사각형 그리기
  }

    /**
     * Draws a Sierpinski square of order n, such that the largest filled
     * square fits in a screen of size 1 x 1, alternating between a dark
     * square and light square (starting with a dark square).
     * @param curr the current order
     * @param n the highest order to draw
     * @param length the side length of the square
     */
  public static void sierpinski(int curr, int n, double length) {
      if (curr > n) return;

      if (curr % 2 == 0) { // 짝수일 때는 회색 사각형 그리기
          drawDarkSquare(length);
      } else { // 홀수일 때는 흰색 사각형 그리기
          drawLightSquare(length);
      }

      // 다음 순서의 사각형을 그릴 크기 계산 (대각선의 절반으로 줄어듦)
      double newLength = length / Math.sqrt(2);

      sierpinski(curr + 1, n, newLength); // 재귀 호출
  }

    /**
     * Takes an integer command-line argument n,
     * and draws a Sierpinski square of order n in a 1 x 1 canvas.
     *
     * This method is called by Autolab. ASSUME n >= 0
     *
     * @param args command-line arguments
     */
  public static void main(String[] args) {
      int n = Integer.parseInt(args[0]); // 순서 `n`을 명령행 인자로부터 읽기
      StdDraw.setXscale(0, 1); // X 축 범위 설정
      StdDraw.setYscale(0, 1); // Y 축 범위 설정

      double initialLength = 0.5 * Math.sqrt(2); // 초기 사각형의 한 변의 길이 계산
      sierpinski(0, n, initialLength); // Sierpinski Square 그리기
  }
}
