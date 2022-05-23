import java.util.Scanner;

/**
* The Swan program implements code that prints a modified
* version of The Swan by Hilma af Klint using for loops and
* StdDraw functions. Users may select the x and y coordinates
* of the center of the swan circle as well as its total
* area. The program then prints a "swan" to the user's
* specifications. Enjoy!
*
* @author: Jiashu Yang
* @JHED: jyang166
* @date: 01/28/2022
*/

public class Proj1 {
   public static void main(String[] args) {
   
      //  Configuring scanner to get user inputs later
      Scanner scnr = new Scanner(System.in);
   
      System.out.println("This program will recreate The Swan");
      System.out.println("by Hilma af Klint");
      
      //  Asking for user input for painting dimensions 
      System.out.println("Input a total area for the swan portion");
      System.out.println("of the painting:");
      System.out.println("(Total area of painting shown will be 1 x 1)");
      double totalArea = scnr.nextDouble();
      
      System.out.println("Input the x value of the center between 0 and 1");
      System.out.println("(1 is the rightmost edge of the image):");
      double centerX = scnr.nextDouble();
      
      System.out.println("Input the y value of the center between 0 and 1");
      System.out.println("(1 is the top of the image):");
      double centerY = scnr.nextDouble(); 
      
      /*  Calculating radius and setting temporary value for 
      the for loops to run off of.                        */
      double swanRadius = Math.sqrt(totalArea / Math.PI);
      double tempSwanRadius = swanRadius;
      
      //  Creating static background
      StdDraw.setPenRadius(0.01);
      StdDraw.setPenColor(StdDraw.BOOK_RED);
      StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
      
      StdDraw.setPenRadius(0.0035);
            
      /*  Draws many white arcs and blue arcs on the left/right halves
      respectively for 1/3 of the radius (outer edge of painting)   */
      for (; swanRadius * 2 / 3 <= tempSwanRadius; tempSwanRadius -= 0.0015) {
         StdDraw.setPenColor(StdDraw.WHITE);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 90, 270);
      
         StdDraw.setPenColor(StdDraw.BLUE);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 270, 90);
      }
      
      //  Draws the middle 1/3 of the painting's radius (black and orange)
      for (; swanRadius * 1 / 3 <= tempSwanRadius; tempSwanRadius -= 0.0015) {
         StdDraw.setPenColor(StdDraw.BLACK);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 90, 270);
      
         StdDraw.setPenColor(StdDraw.ORANGE);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 270, 90);
      }
      
      /*  Draws the last 1/3 of the painting's radius, completing a filled 
      circle (black and pink)                                           */     
      for (; 0 <= tempSwanRadius; tempSwanRadius -= 0.0015) {
         StdDraw.setPenColor(StdDraw.BLACK);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 90, 270);
         
         StdDraw.setPenColor(StdDraw.PINK);
         StdDraw.arc(centerX, centerY, tempSwanRadius, 270, 90);
      }
      
      // Scaling the beak size to the swan radius
      double beakSizeX = swanRadius / 30;
      double beakSizeY = swanRadius / 30;
      
      // Drawing the pink triangle on the left of the beak in the center
      StdDraw.setPenColor(StdDraw.PINK);
      double[] beakPinkX = {centerX - beakSizeX, centerX, centerX};
      double[] beakPinkY = {centerY - beakSizeX, centerY + beakSizeY, 
                              centerY - beakSizeX};
      StdDraw.filledPolygon(beakPinkX, beakPinkY);
      
      // Drawing the black triangle on the right side to complete the beak
      StdDraw.setPenColor(StdDraw.BLACK);
      double[] beakBlackX = {centerX + beakSizeX, centerX, centerX};
      double[] beakBlackY = {centerY - beakSizeX, centerY + beakSizeY,
                               centerY - beakSizeX};
      StdDraw.filledPolygon(beakBlackX, beakBlackY);
      
      System.out.println("Thank you for using the Swan program!");
      
   }
}