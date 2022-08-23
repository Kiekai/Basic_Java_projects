package StopWatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startB = new JButton("START");
	JButton resetB = new JButton("RESET");
	//JLabel ActionB = new JLabel("YEU EM");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0; //thoi gian troi qua
	int second = 0;
	int minutes = 0;
	int hours = 0;
	boolean check = false;
	boolean check_2 = true;
	String seconds_string = String.format("%02d", second);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener(){
		public void actionPerformed(ActionEvent action)
		{
			elapsedTime += 1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			second = (elapsedTime / 1000) % 60;
			seconds_string = String.format("%02d", second);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + " : " + minutes_string + " : " + seconds_string);
		}
	});
	
	StopWatch()
	{
		timeLabel.setText(hours_string + " : " + minutes_string + " : " + seconds_string);
		timeLabel.setBounds(350, 160, 800, 500);
		timeLabel.setFont(new Font("Cascadia", Font.PLAIN,100));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startB.setBounds(350, 660, 400, 200);
		startB.setFont(new Font("Cascadia", Font.PLAIN,50));
		startB.setFocusable(false);
		startB.addActionListener(this);
		
		resetB.setBounds(750, 660, 400, 200);
		resetB.setFont(new Font("Cascadia", Font.PLAIN,50));
		resetB.setFocusable(false);
		resetB.addActionListener(this);
		
		/*ActionB.setBounds(350, 160, 800, 500);
		ActionB.setFont(new Font("Cascadia", Font.PLAIN,100));
		ActionB.setBorder(BorderFactory.createBevelBorder(1));
		ActionB.setOpaque(true);
		ActionB.setHorizontalAlignment(JTextField.CENTER);*/     
		
		frame.add(startB);
		frame.add(resetB);
		frame.add(timeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == startB)
		{
			if(check == false)
			{
				check = true;
				startB.setText("STOP");
				Start();
			}
			else 
			{
				check = false;
				startB.setText("START");
				Stop();
			}
		}
		
		if(e.getSource() == resetB)
		{
			check = false;
			startB.setText("START");
			reset();
		}
		/*if(e.getSource() == resetB && check_2 == false)
		{
			Timer pause = new Timer(1, new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent action)
				{
					print();
				}
			});
			pause.setRepeats(false);
			pause.start();
		}*/
	}
	
	public void Start()
	{
		timer.start();
	}
	
	public void Stop()
	{
		timer.stop();
	}
	
	public void reset()
	{
		timer.stop();
		elapsedTime = 0;
		second = 0;
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", second);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + " : " + minutes_string + " : " + seconds_string);
	}
	
	/*public void print()
	{
		Container parent = startB.getParent();
        parent.remove(startB);
        parent.revalidate();
        parent.repaint();
        Container parent_2 = resetB.getParent();
        parent_2.remove(resetB);
        parent_2.revalidate();
        parent_2.repaint();
        Container parent_3 = timeLabel.getParent();
        parent_3.remove(timeLabel);
        parent_3.revalidate();
        parent_3.repaint();
		frame.add(ActionB);
	}*/
}
