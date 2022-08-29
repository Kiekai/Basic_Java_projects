package text_editor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

public class TextEditor extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 0;
	
	JTextArea text;
	JScrollPane scroll;
	JSpinner spinner;
	JLabel label;
	JButton ColorB;
	JComboBox box;
	
	JMenuBar menu;
	JMenu Item;
	JMenuItem openItem;
	JMenuItem exitItem;
	JMenuItem saveItem;

	TextEditor()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text Editor By Kiet");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setFont(new Font("Arial", Font.PLAIN, 20));
		
		scroll = new JScrollPane(text);
		scroll.setPreferredSize(new Dimension(450, 450));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		label = new JLabel("Font: ");
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(50, 25));
		spinner.setValue(20);
		spinner.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				text.setFont(new Font(text.getFont().getFamily(), Font.PLAIN,(int) spinner.getValue()));
			}
		});
		
		ColorB = new JButton("COLOR");
		ColorB.addActionListener(this);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		box = new JComboBox(fonts);
		box.addActionListener(this);
		box.setSelectedItem("Arial");
		
		// MENU BAR
		
		menu = new JMenuBar();
		Item = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		Item.add(openItem);
		Item.add(saveItem);
		Item.add(exitItem);
		menu.add(Item);
		
		// MENU BAR
		
		this.setJMenuBar(menu);
		this.add(label);
		this.add(spinner);
		this.add(ColorB);
		this.add(box);
		this.add(scroll);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		
		if(action.getSource() == ColorB)
		{
			JColorChooser colorChooser = new JColorChooser();
			Color color = colorChooser.showDialog(null, "Choose a color", Color.BLACK);
			text.setForeground(color);
			
		}
		
		if(action.getSource() == box)
		{
			text.setFont(new Font((String)box.getSelectedItem(), Font.PLAIN, text.getFont().getSize()));
		}
		
		if(action.getSource() == openItem)
		{
			JFileChooser choice = new JFileChooser();
			choice.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
			choice.setFileFilter(filter);
			
			int respone = choice.showOpenDialog(null);
			if(respone == JFileChooser.APPROVE_OPTION)
			{
				File file = new File(choice.getSelectedFile().getAbsolutePath());
				Scanner Input =  null;
				
				try 
				{
					Input = new Scanner(file);
					if(file.isFile())
					{
						while(Input.hasNextLine())
						{
							String line = Input.nextLine() + "\n";
							text.append(line);
						}
					}
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					Input.close();
				}
			}
			
		}
		
		if(action.getSource() == saveItem)
		{
			JFileChooser choice = new JFileChooser();
			choice.setCurrentDirectory(new File("."));
			
			int response = choice.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION)
			{
				File file;
				PrintWriter fileOut = null;
				
				file = new File(choice.getSelectedFile().getAbsolutePath());
				try 
				{
					fileOut = new PrintWriter(file);
					fileOut.println(text.getText());
				} 
				catch (FileNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					fileOut.close();
				}
			}
		}
		
		if(action.getSource() == exitItem)
		{
			System.exit(0);
		}
	}
	
}
