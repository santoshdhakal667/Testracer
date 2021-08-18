package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Which of the following option leads to the portability and security of Java?");
			radioButton[0].setText("Use of exception handling");
			radioButton[1].setText("Bytecode is executed by JVM");
			radioButton[2].setText("The applet makes the Java code secure and portable");
			radioButton[3].setText("Dynamic binding between objects");
		}
		if (current == 1) {
			label.setText("Que2:  Which of the following is not a Java features?");
			radioButton[0].setText("Dynamic");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("Architecture Neutral");
			radioButton[3].setText("Object-oriented");
		}
		if (current == 2) {
			label.setText("Que3: _____ is used to find and fix bugs in the Java programs.");
			radioButton[0].setText("JDB");
			radioButton[1].setText("JDK");
			radioButton[2].setText("JRE");
			radioButton[3].setText("JVM");
		}
		if (current == 3) {
			label.setText("Que4: Which of the following is a valid declaration of a char?");
			radioButton[0].setText("char cc = '\itea';");
			radioButton[1].setText("char cr = \u0223;");
			radioButton[2].setText("char ch = '\utea';");
			radioButton[3].setText("char ca = 'tea';");
		}
		if (current == 4) {
			label.setText("Que5:  What does the expression float a = 35 / 0 return?");
			radioButton[0].setText(" Infinity");
			radioButton[1].setText("Not a Number");
			radioButton[2].setText("Run time exception");
			radioButton[3].setText("0");
		}
		if (current == 5) {
			label.setText("Que6:  Which of the following creates a List of 3 visible items and multiple selections abled?");
			radioButton[0].setText("new List(3, true)");
			radioButton[1].setText("new List(true, 3)");
			radioButton[2].setText("new List(false, 3)");
			radioButton[3].setText("new List(3, false)");
		}
		if (current == 6) {
			label.setText("Que7: In which process, a local variable has the same name as one of the instance variables?");
			radioButton[0].setText("Serialization");
			radioButton[1].setText("Variable Shadowing");
			radioButton[2].setText("Abstraction");
			radioButton[3].setText("Multi-threading");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
			radioButton[0].setText("Configuration");
			radioButton[1].setText("Criteria");
			radioButton[2].setText("SessionManagement");
			radioButton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Que9: Which package contains the Random class?");
			radioButton[0].setText("java.util package");
			radioButton[1].setText("java.lang package");
			radioButton[2].setText("java.awt package");
			radioButton[3].setText("java.io package");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radioButton[0].setText("Attached()");
			radioButton[1].setText("Detached()");
			radioButton[2].setText("Persistent()");
			radioButton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test Racer");
	}

}
