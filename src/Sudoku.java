import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sudoku implements ISpecifics{
	
	private static JFrame frame;
	private static Board board;
	
	public static void addComponentListener(JFrame frame) {
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	board.setPreferredSize(new Dimension(frame.getHeight(), frame.getHeight()));
            }
        });
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
			frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			frame.getContentPane().setBackground(Color.BLACK);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			board = new Board(grid);
			//panel.setBounds(0, 0, frame.getHeight(), frame.getHeight());
			board.setPreferredSize(new Dimension(frame.getHeight(), frame.getHeight()));
			board.setBackground(Color.WHITE);
			
			addComponentListener(frame);
			frame.add(board);
		});
	}
}
