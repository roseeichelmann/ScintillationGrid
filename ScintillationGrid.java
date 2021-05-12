import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

/**
 * CS312 Assignment 3.
 *
 * Replace <NAME> with your name, stating on your honor you completed this
 * assignment on your own and that you didn't share your code with other
 * students.
 * 
 * On my honor, Rose Eichelmann, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to print out various scintillation grids and a student designed drawing. 
 *
 *  email address: rose.eichelmann@gmail.com
 *  UTEID: ree585
 *  Number of slip days I am using on this assignment: 0
 */

public class ScintillationGrid {

    // Main method that creates the DrawingPanel with scintillation grids.
	public static void main(String[] args) {
		final int WIDTH = 900;
        final int HEIGHT = 650;
        DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
        dp.setBackground(Color.CYAN);
        Graphics pen = dp.getGraphics();
        // CS312 Students add your four methods calls to draw the four
        // required scintillation grids here.
        drawGrid(pen, 0, 0, 348, 348, 75, 3, 16);
        drawGrid(pen, 400, 50, 422, 422, 50, 6, 12);
       	drawGrid(pen, 50, 400, 220, 220, 100, 1, 20);
        drawGrid(pen, 500, 500, 148, 148, 15, 7, 4);
        // CS312 students, do not alter the following line of code.
        saveDrawingPanel(dp, "grid.png");
    }
	
	// Draws a scintillation grid
	public static void drawGrid(Graphics pen, int x, int y, int width, 
								int height, int sizeSmSqr, 
								int numLines, int sizeLines) {
		pen.setColor(Color.BLACK);
		pen.fillRect(x, y, width, height);
		// Calls method to draw vertical lines
		drawVertLines(pen, x, y, height, sizeSmSqr, numLines, sizeLines);
		// Calls method to draw horizontal lines
		drawHorizLines(pen, x, y, width, sizeSmSqr, numLines, sizeLines);
		// Calls method to draw circles
		drawCircles(pen, x, y, sizeSmSqr, numLines, sizeLines);
	}
	
	// Draws the vertical lines in the grid
	public static void drawVertLines(Graphics pen, int x, int y, int height, int sizeSmSqr, 
										int numLines, int sizeLines) {
		// Draws a rectangle for each vertical line in grid
		for (int line = 0; line < numLines; line++) {
			final int Y_CORD = y;
			final int LINE_HEIGHT = height;
			final int LINE_WIDTH = sizeLines;
			// Finds the starting x coordinate of current line
			int xCord = x + sizeSmSqr * (line + 1) + (sizeLines * line);
			pen.setColor(Color.GRAY);
			pen.fillRect(xCord, Y_CORD, LINE_WIDTH, LINE_HEIGHT);
		}
	}
	
	// Draws the horizontal lines in the grid
	public static void drawHorizLines(Graphics pen, int x, int y, int width, int sizeSmSqr, 
										int numLines, int sizeLines) {
		// Draws a rectangle for each horizontal line in grid
		for (int line = 0; line < numLines; line++) {
			// Finds the starting y coordinate of current line
			int yCord = y + sizeSmSqr * (line + 1) + (sizeLines * line);
			final int X_CORD = x;
			final int LINE_HEIGHT = sizeLines;
			final int LINE_WIDTH = width;
			pen.setColor(Color.GRAY);
			pen.fillRect(X_CORD, yCord, LINE_WIDTH, LINE_HEIGHT);
		}
	}
	
	// Draws the white circles in grid
	public static void drawCircles(Graphics pen, int x, int y, int sizeSmSqr, 
									int numLines, int sizeLines) {
		// Iterates through number of circles going vertically
		for (int vertCircles = 0; vertCircles < numLines; vertCircles++) {
			// Iterates through number of circles going horizontally and draws circles
			for (int horizCircles = 0; horizCircles < numLines; horizCircles++) {
				/* Checks if sizeLines + 2 or sizeLines * 40% + sizeLines is bigger and 
				 assigns that to circle size */
				int circleSize = Math.max((sizeLines + 2), ((sizeLines*2)/5 + sizeLines));
				// Finds the starting x coordinate of line beneath circle
				int xCord = x + sizeSmSqr * (vertCircles + 1) + (sizeLines * vertCircles); 
				// Finds the starting y coordinate of line beneath circle
				int yCord = y + sizeSmSqr * (horizCircles + 1) + (sizeLines * horizCircles);
				// Subtracts difference in circle size and line size / 2 from line x coordinate
				int circleX_Cord = (xCord-((circleSize-sizeLines)/2));
				// Subtracts difference in circle size and line size / 2 from line y coordinate
				int circleY_Cord = (yCord-((circleSize-sizeLines)/2));
				pen.setColor(Color.WHITE);
				pen.fillOval(circleX_Cord, circleY_Cord, circleSize, circleSize);
			}
		}
	}

    // Method for the student designed drawing
	public static void drawingOne() {
        final int WIDTH = 400;
        final int HEIGHT = 200;
        DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = dp.getGraphics();
        dp.setBackground(Color.GREEN);
        g.setColor(Color.RED);
        g.fillOval(0, 0, 200, 100);
        g.fillOval(200, 100, 200, 100);
        g.setColor(Color.BLACK);
        g.drawLine(200, 0, 200, 200);
        g.drawLine(0, 100, 400, 100);
        g.drawLine(100, 0, 100, 100);
        g.drawLine(0, 50, 200, 50);
        g.drawLine(300,  100, 300, 200);
        g.drawLine(200, 150, 400, 150);
        // Do not alter this line of code. It saves the panel to a file for later viewing
        saveDrawingPanel(dp, "drawing_one.png");
    }
    
    // Save the current drawing panel to the given file. 
    public static void saveDrawingPanel(DrawingPanel dp, String fileName) {
        try {
            dp.save(fileName);
        } catch (IOException e) {
            System.out.println("Unable to save DrawingPanel");
        }
    }
}