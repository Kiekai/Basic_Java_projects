package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberB = new JButton[10];
	JButton[] functionB = new JButton[9];
	JButton addB, subB, mulB, divB;
	JButton decB, equB, delB, clrB, negaB;
	JPanel panel;
	
	Font font = new Font("Cascadia", Font.PLAIN, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator()
	{
		frame = new JFrame("MY CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);;
		textfield.setFont(font);
		textfield.setEditable(false);
		textfield.setBackground(Color.WHITE);
		
		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("*");
		divB = new JButton("/");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("DEL");
		clrB = new JButton("CLR");
		negaB = new JButton("*-1");
		
		functionB[0] = addB;
		functionB[1] = subB;
		functionB[2] = mulB;
		functionB[3] = divB;
		functionB[4] = decB;
		functionB[5] = equB;
		functionB[6] = delB;
		functionB[7] = clrB;
		functionB[8] = negaB;
		
		for(int i = 0; i < 9; i++)
		{
			functionB[i].addActionListener(this);
			functionB[i].setFont(font);
			functionB[i].setFocusable(false);
			functionB[i].setBackground(Color.ORANGE);
			functionB[i].setForeground(Color.DARK_GRAY);
		}
		
		for(int i = 0; i < 10; i++)
		{
			numberB[i] =  new JButton(String.valueOf(i));
			numberB[i].addActionListener(this);
			numberB[i].setFont(font);
			numberB[i].setFocusable(false);
			numberB[i].setBackground(Color.CYAN);
			numberB[i].setForeground(Color.BLACK);
		}
		
		delB.setBounds(50, 430, 100, 50);
		clrB.setBounds(150, 430, 100, 50);
		negaB.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		
		panel.add(numberB[1]);
		panel.add(numberB[2]);
		panel.add(numberB[3]);
		panel.add(addB);
		panel.add(numberB[4]);
		panel.add(numberB[5]);
		panel.add(numberB[6]);
		panel.add(subB);
		panel.add(numberB[7]);
		panel.add(numberB[8]);
		panel.add(numberB[9]);
		panel.add(mulB);
		panel.add(decB);
		panel.add(numberB[0]);
		panel.add(equB);
		panel.add(divB);
		
		frame.add(panel);
		frame.add(negaB);
		frame.add(delB);
		frame.add(clrB);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent action)
	{
		for(int i = 0; i < 10; i++)
		{
			if(action.getSource() == numberB[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(action.getSource() == decB)
		{
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(action.getSource() == addB)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(action.getSource() == subB)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(action.getSource() == mulB)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(action.getSource() == divB)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(action.getSource() == equB)
		{
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator)
			{
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;
			}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(action.getSource() == clrB)
		{
			textfield.setText("");
		}
		
		if(action.getSource() == delB)
		{
			String text = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < text.length() - 1;i++)
			{
				textfield.setText(textfield.getText()+text.charAt(i));
			}
		}
		
		if(action.getSource() == negaB)
		{
			Double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		
	}
}
