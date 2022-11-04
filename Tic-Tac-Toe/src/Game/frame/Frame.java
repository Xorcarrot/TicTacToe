package Game.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	
	private JFrame frame = new JFrame("Tic-Tac-Toe");
	
	private JPanel topPanel = new JPanel();
	private JPanel gameBoard = new JPanel();
	
	private JLabel turnCaller = new JLabel();
	
	private JButton[] button = new JButton[9];
	private JButton resetButton = new JButton();
	
	private boolean turn = false;
	private boolean done = false;
	
	private int turns = 0;
	
	private Font f = new Font("serif", Font.BOLD, 150);
	private Font header = new Font("serif", Font.PLAIN, 80);
	
	public Frame() {
		
		frame.setSize(614, 737);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel.setBounds(0, 0, 600, 100);
		topPanel.setBackground(Color.RED);
		topPanel.setLayout(new BorderLayout());
		
		turnCaller.setText("O turn");
		turnCaller.setFont(header);
		turnCaller.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(turnCaller);
		
		resetButton.setText("Again?");
		resetButton.setBounds(10, 10, 80, 30);
		resetButton.setVisible(false);
		resetButton.addActionListener(e -> {
			this.newGame();
		});
		
		gameBoard.setBounds(0, 100, 600, 600);
		gameBoard.setBackground(Color.DARK_GRAY);
		gameBoard.setLayout(new GridLayout(3, 3));
		
		frame.getContentPane().add(topPanel);
		frame.getContentPane().add(gameBoard);
		frame.getContentPane().add(resetButton);
		
		this.generateGameButtons();
	}
	
	public void generateGameButtons() {
		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setBackground(null);
			gameBoard.add(button[i]);
			button[i].addActionListener(e -> {
				
				
				this.someoneWon((JButton) e.getSource());
				
			});
		}
	}

	public void someoneWon(JButton b) {
		
		if(turn) {
			b.setText("X");
		} else {
			b.setText("O");
		}
		
		b.setFont(f);
		b.setEnabled(false);
		turn = !turn;
		
		String winner = "";
		
		if(button[0].getText() == button[1].getText() && button[0].getText() == button[2].getText() && (button[0].getText() == "X" || button[0].getText() =="O")) {
			button[0].setBackground(Color.GREEN);
			button[1].setBackground(Color.GREEN);
			button[2].setBackground(Color.GREEN);
			done = true;
			winner = button[0].getText();
		} else if(button[0].getText() == button[3].getText() && button[0].getText() == button[6].getText() && (button[0].getText() == "X" || button[0].getText() =="O")) {
			button[0].setBackground(Color.GREEN);
			button[3].setBackground(Color.GREEN);
			button[6].setBackground(Color.GREEN);
			done = true;
			winner = button[0].getText();
		} else if(button[0].getText() == button[4].getText() && button[0].getText() == button[8].getText() && (button[0].getText() == "X" || button[0].getText() =="O")) {
			button[0].setBackground(Color.GREEN);
			button[4].setBackground(Color.GREEN);
			button[8].setBackground(Color.GREEN);
			done = true;
			winner = button[0].getText();
		} else if(button[1].getText() == button[4].getText() && button[1].getText() == button[7].getText() && (button[1].getText() == "X" || button[1].getText() =="O")) {
			button[1].setBackground(Color.GREEN);
			button[4].setBackground(Color.GREEN);
			button[7].setBackground(Color.GREEN);
			done = true;
			winner = button[1].getText();
		} else if(button[2].getText() == button[4].getText() && button[2].getText() == button[6].getText() && (button[2].getText() == "X" || button[2].getText() =="O")) {
			button[2].setBackground(Color.GREEN);
			button[4].setBackground(Color.GREEN);
			button[6].setBackground(Color.GREEN);
			done = true;
			winner = button[2].getText();
		} else if(button[2].getText() == button[5].getText() && button[2].getText() == button[8].getText() && (button[2].getText() == "X" || button[2].getText() =="O")) {
			button[2].setBackground(Color.GREEN);
			button[5].setBackground(Color.GREEN);
			button[8].setBackground(Color.GREEN);
			done = true;
			winner = button[2].getText();
		} else if(button[3].getText() == button[4].getText() && button[3].getText() == button[5].getText() && (button[3].getText() == "X" || button[3].getText() =="O")) {
			button[3].setBackground(Color.GREEN);
			button[4].setBackground(Color.GREEN);
			button[5].setBackground(Color.GREEN);
			done = true;
			winner = button[3].getText();
		} else if(button[6].getText() == button[7].getText() && button[6].getText() == button[8].getText() && (button[6].getText() == "X" || button[6].getText() =="O")) {
			button[6].setBackground(Color.GREEN);
			button[7].setBackground(Color.GREEN);
			button[8].setBackground(Color.GREEN);
			done = true;
			winner = button[6].getText();
		} 
		
		
		
		this.turnCalling();
		
		if(done) {
			this.completed(winner);
		} else if (turns == 9) {
			turnCaller.setText("Draw");
			resetButton.setVisible(true);
		}
		
	}
	
	private void completed(String winner) {
		for(JButton e : button) {
			e.setEnabled(false);
		} 
		turnCaller.setText(winner + " won!");
		resetButton.setVisible(true);
	}
	
	private void turnCalling() {
		if(turn) {
			turnCaller.setText("X turn");
		} else {
			turnCaller.setText("O turn");
		}
		turns++;
	}
	
	private void newGame() {
		for(JButton e : button) {
			e.setText("");
			e.setBackground(null);
			e.setEnabled(true);
		}
		turnCaller.setText("O turn");
		done = false;
		turn = false;
		turns = 0;
		resetButton.setVisible(false);
	}
	
}
