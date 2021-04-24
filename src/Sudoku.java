import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sudoku implements ISpecifics{
	
	private static JFrame frame;
	
	public Sudoku() {
		
	}
	
	public static void main(String args[]) {
		
		int[][] grid =	{ { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
       		 			  { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
       		 			  { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
       		 			  { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
       		 			  { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
       		 			  { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
       		 			  { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
       		 			  { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
       		 			  { 7, 0, 3, 0, 1, 8, 0, 0, 0 } };
		
		EventQueue.invokeLater(() ->
		{
			// Create the Frame
			frame = new JFrame("Sudoku");
			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setLocation((int) SCREEN_SIZE.getWidth() / 2 - FRAME_WIDTH / 2, (int) SCREEN_SIZE.getHeight() / 2 - FRAME_HEIGHT / 2);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, FRAME_HEIGHT, FRAME_HEIGHT - 50);
			panel.setPreferredSize(new Dimension(panel.getBounds().width, panel.getBounds().height));
			panel.setBackground(Color.BLACK);
			frame.add(panel, BorderLayout.CENTER);
			
			JPanel panel2 = new JPanel();
			panel2.setBounds(panel.getBounds());
			panel2.setPreferredSize(panel.getSize());
			panel2.setBackground(Color.WHITE);
			panel.add(panel2);
		});
	}
}
