package com.morseSimulator.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.morseSimulator.controler.Controler;
import com.morseSimulator.model.Model;
import com.morseSimulator.model.TranslationResult;
import com.morseSimulator.observer.Observer;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;


public class Screen extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JLabel rightLanguageLabel = new JLabel(), leftLanguageLabel = new JLabel();
	private JButton switchTranslation = new JButton(), alphabet = new JButton(), manualMode = new JButton();
	private JTextArea inputText = new JTextArea(), outputText = new JTextArea(), userMessage = new JTextArea(), manualMorseMessage = new JTextArea();
	private GridBagLayout gridLayout = new GridBagLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	private Controler controler;
	
	
	
	
	public Screen(Model model) {
		this.setTitle("Traducteur Morse");
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(1000,700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		controler = new Controler(model);
		
		model.addObserver(this);
		
		initComponents();
		
		this.getContentPane().add(container);
		this.setVisible(true);
		
	}
	
	
	
	public void initComponents() {
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
		inputText.getDocument().addDocumentListener(new InputListener());
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
	    switchTranslation.setVisible(true);
	    switchTranslation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.switchTranslation();
			}
	    	
	    });
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
		alphabet.addActionListener(new ActionListener() {
			// TODO make the alphabet non modal
			public void actionPerformed(ActionEvent e) {
				String alphabet = "Lettres :\n"
						+ "a = .-     b = -...     c = -.-.     d = -..     e = .     f = ..-.     g = --.     h = ....     i = ..\n"
						+ "j = .---     k = -.-     l = .-..     m = --     n = -.     o = ---     p = .--.     q = --.-     r = .-.\n"
						+ "s = ...     t = -     u = ..-     v = ...-     w = .--     x = -..-     y = -.--     z = --..\n"
						+"Chiffres :\n"
						+ "1 = .----     2 = ..---     3 = ...--     4 = ....-     5 = .....\n"
						+ "6 = -....     7 = --...     8 = ---..     9 = ----.     0 = -----\n"
						+"Espace :\n"
						+ "\' \' =  / \n"
						+"Ponctuation :\n"
						+ ". = .-.-.-     , = --..--     ? = ..--..     ' = .----.     ! = -.-.--     / = -..-.\n"
						+ "( = -.--.     ) = -.--.-     & = .-...     : = ---...     ; = -.-.-.     = = -...-\n"
						+ "+ = .-.-.     - = -....-     _ = ..--.-     \\\" = .-..-.     $ = ...-..-\n"
						+ "Caractères spéciaux :\n" 
						+ "ch = ----     à = .--.-     ç = -.-..     è = .-..-     é = ..-..     @ = .--.-.     \\n = \\n"
						+ "\n\nL’espacement entre les lettres d’un mot a pour longueur un « taah » (3 « ti »). Il se note par un espace.\n"
						+ "EXEMPLE -.-. --- -.. . / -- --- .-. ... . (CODE MORSE)\n"
						+ "https://fr.wikipedia.org/wiki/Code_Morse_international\n"
						+ "ti = 500ms     ta = 2000ms     "
						+ "2000ms entre chq lettres     5000ms entre chq mots";
				JOptionPane.showMessageDialog(null, alphabet, "Alphabet morse", JOptionPane.PLAIN_MESSAGE);
				
			}		
		});
		container.add(alphabet, gc);
		
		gc.anchor = GridBagConstraints.PAGE_END;
		manualMode.setPreferredSize(new Dimension(80,80));
		manualMode.setContentAreaFilled(false);
		manualMode.setVisible(false);
		manualMode.setText("<html>Lancer le mode manuel</html>");
		manualMode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.switchManualMode();
				//((JButton)e.getSource()).setText("<html>Arrêter le mode manuel</html>");
			}
			
		});
		manualMode.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"none");
		container.add(manualMode, gc);
		
		gc.gridx = 3;
		container.add(scrollPaneOutput, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		userMessage.setFont(new Font("Dialog.plain", Font.BOLD, 12));
		userMessage.setPreferredSize(new Dimension(300,100));
		userMessage.setEditable(false);
		userMessage.setWrapStyleWord(true);
		userMessage.setOpaque(false);
		userMessage.setLineWrap(true);
		setUserMessage("");
		container.add(userMessage, gc);
		
		gc.gridx = 3;
		manualMorseMessage.setText("");
		manualMorseMessage.setFont(new Font("Arial", Font.BOLD, 12));
		manualMorseMessage.setPreferredSize(new Dimension(300,100));
		manualMorseMessage.setEditable(false);
		manualMorseMessage.setWrapStyleWord(true);
		manualMorseMessage.setOpaque(false);
		manualMorseMessage.setLineWrap(true);
		container.add(manualMorseMessage, gc);
	}
	
	
	
	public class InputListener implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			try {
			Document x = e.getDocument();
			String test = x.getText(0, x.getLength());
			controler.control(test);
			}catch(BadLocationException p) {
				p.printStackTrace();
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			try {
			Document x = e.getDocument();
			String test = x.getText(0, x.getLength());
			controler.control(test);
			}catch(BadLocationException p) {
				p.printStackTrace();
			}
		}

		public void changedUpdate(DocumentEvent e) {}
	}

	public void setUserMessage(String errorString){
		switch(errorString.length()) {
		case 0 :
			this.userMessage.setText("En morse, chaque lettre est traduite.\nL'espacement entre deux lettres vaut un espace.\n"
					+ "Un espace entre deux mots vaut \"/\".");
			this.userMessage.setForeground(Color.black);
			break;
		case 1 :
			this.userMessage.setText("L'élément suivant ne peut être traduit : " + errorString + ". Veuillez le retirer pour procéder à la traduction !");
			this.userMessage.setForeground(Color.red);
			break;
		default :
			if(errorString.length()>100) {
				errorString = errorString.substring(0,100);
				this.userMessage.setText("Une multitude d'éléments ne peuvent être traduits, en voici quelques uns : " + errorString
						+ ". Veuillez les retirer pour procéder à la traduction !");
			}else {
				this.userMessage.setText("Les éléments suivants ne peuvent être traduits : " + errorString
						+ ". Veuillez les retirer pour procéder à la traduction !");
				this.userMessage.setForeground(Color.red);
			}
			break;
		}
	}

	@Override
	public void update(TranslationResult result) {
		setUserMessage(result.getErrorString());
		this.outputText.setText(result.getTranslatedString());
		
	}



	@Override
	public void switchTranslation(boolean isMorse) {
		String temp = rightLanguageLabel.getText();
		rightLanguageLabel.setText(leftLanguageLabel.getText());
		leftLanguageLabel.setText(temp);
		
		temp = inputText.getText();
		inputText.setText(outputText.getText());
		outputText.setText(temp);
		
		manualMode.setVisible(!isMorse);
		
		
		
		
	}
	
	public void updateManualMorse(boolean isManualMorseOn) {
		if(isManualMorseOn) {
			manualMode.setText("<html>Arrêter le mode manuel</html>");
			manualMorseMessage.setVisible(true);
		}else {
			manualMode.setText("<html>Lancer le mode manuel</html>");
			manualMorseMessage.setVisible(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
