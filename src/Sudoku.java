import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Sudoku implements ISpecifics{
	
	private static JFrame frame;
	private static BoardDisplay boardDisplay;
	
	public static void addComponentListener(JFrame frame) {
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	boardDisplay.setPreferredSize(new Dimension(frame.getHeight() - CORRECTION_HEIGHT, frame.getHeight() - CORRECTION_HEIGHT));
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
			
			boardDisplay = new BoardDisplay(grid);
			//boardDisplay.setBounds(0, 0, frame.getHeight(), frame.getHeight());
			boardDisplay.setPreferredSize(new Dimension(frame.getHeight() - CORRECTION_HEIGHT, frame.getHeight() - CORRECTION_HEIGHT));
			boardDisplay.setBackground(Color.WHITE);

			addComponentListener(frame);
			frame.add(boardDisplay);
			
			// Menu
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JMenu menu = new JMenu("Actions");
			menu.setMnemonic(KeyEvent.VK_A);
			menuBar.add(menu);
			
			JMenuItem solve = new JMenuItem("Solve");
			solve.setMnemonic(KeyEvent.VK_S);
			solve.addActionListener((ActionEvent event) ->
			{
				boardDisplay.setDelay(100);
				boardDisplay.solveSudoku();
			});
			menu.add(solve);
			
			JMenuItem solveFast = new JMenuItem("Solve Fast");
			solveFast.setMnemonic(KeyEvent.VK_F);
			solveFast.addActionListener((ActionEvent event) ->
			{
				boardDisplay.setDelay(0);
				boardDisplay.solveSudoku();
			});
			menu.add(solveFast);
		});
	}
}
