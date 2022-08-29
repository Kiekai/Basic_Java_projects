package Clock;
import java.util.*;
import java.awt.*;
import java.text.*;
import javax.swing.*; 

public class MyCLock extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Calendar calendar;
	SimpleDateFormat timeFormat; 
	SimpleDateFormat DayFormat; 
	JLabel timeLabel;
	JLabel DayLabel;
	String time;
	String day;
	
	MyCLock()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("YOUR CLOCK");
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setResizable(false);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		DayFormat = new SimpleDateFormat(" E, d / M / y");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Cascadia", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(255, 255, 0));
		timeLabel.setBackground(Color.BLUE);
		timeLabel.setOpaque(true);
		
		DayLabel = new JLabel();
		DayLabel.setFont(new Font("Cascadia", Font.PLAIN, 30));
		
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);	
		
		this.add(timeLabel);
		this.add(DayLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	public void setTime()
	{
		while(true)
		{
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = DayFormat.format(Calendar.getInstance().getTime());
			DayLabel.setText(day);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
