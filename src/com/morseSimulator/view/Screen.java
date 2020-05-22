package com.morseSimulator.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class Screen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JLabel rightLanguageLabel = new JLabel(), leftLanguageLabel = new JLabel();
	private JButton switchTranslation = new JButton(), alphabet = new JButton();
	private JTextArea inputText = new JTextArea(), outputText = new JTextArea(), userMessage = new JTextArea();
	private GridBagLayout gridLayout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	
	
	
	
	
	public Screen() {
		this.setTitle("Traducteur Morse");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setLayout(gridLayout);
		container.setBackground(Color.white);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		leftLanguageLabel.setFont(font);
		rightLanguageLabel.setFont(font);
		leftLanguageLabel.setText("Alphabet latin");
		rightLanguageLabel.setText("Morse");
		
		inputText.setWrapStyleWord(true);
		inputText.setLineWrap(true);
		inputText.setBackground(new Color(230,230,230));
		outputText.setWrapStyleWord(true);
		outputText.setLineWrap(true);
		outputText.setBackground(new Color(230,230,230));
		outputText.setEditable(false);
		
		JScrollPane scrollPaneInput = new JScrollPane(inputText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scrollPaneOutput = new JScrollPane(outputText);
		
		scrollPaneInput.setPreferredSize(new Dimension(300,200));
		scrollPaneOutput.setPreferredSize(new Dimension(300,200));
		
		gc.insets = new Insets(40,40,40,40);
		gc.ipadx = 10;
		gc.ipady = 10;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridheight = 1 ;
		gc.gridwidth = 1 ;
		gc.fill = GridBagConstraints.NONE;
		container.add(leftLanguageLabel, gc);
		
		switchTranslation.setPreferredSize(new Dimension(50,50));
		gc.gridx = 2;
		Icon switchIcon = new ImageIcon("images/arrow.png");
	    switchTranslation.setIcon(switchIcon);
	    switchTranslation.setContentAreaFilled(false);
	    switchTranslation.setVisible(false);
	    container.add(switchTranslation, gc);
		
		gc.gridx = 3;
		container.add(rightLanguageLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		container.add(scrollPaneInput, gc);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.PAGE_START;
		alphabet.setPreferredSize(new Dimension(80,80));
		alphabet.setText("<html>Afficher l'alphabet morse</html>");
		alphabet.setContentAreaFilled(false);
		container.add(alphabet, gc);
		
		//gc.anchor = GridBagConstraints.PAGE_END;
		gc.gridx = 3;
		container.add(scrollPaneOutput, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		userMessage.setFont(new Font("Arial", Font.BOLD, 12));
		userMessage.setPreferredSize(new Dimension(300,100));
		userMessage.setEditable(false);
		userMessage.setWrapStyleWord(true);
		userMessage.setOpaque(false);
		userMessage.setLineWrap(true);
		container.add(userMessage, gc);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.getContentPane().add(container);
		this.setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
