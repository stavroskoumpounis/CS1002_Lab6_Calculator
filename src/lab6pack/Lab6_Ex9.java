package lab6pack;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
public class Lab6_Ex9 extends JFrame implements ActionListener {
	static JButton[] buttons=new JButton[18];
	static JTextField tfield;
	static String save;
	static String operand1,operator,operand2;
	static double calc;

	Lab6_Ex9(){
		operand1 =operator=operand2="";
	}
	public static void addComponentsToPane(Container pane){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Lab6_Ex9 al=new Lab6_Ex9();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth=1;
		c.weightx=0.5;
		c.weighty=0.5;

		buttons[0] = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,2,0,0);
		pane.add(buttons[0],c);

		buttons[1]= new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[1],c);

		buttons[2]= new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[2],c);

		buttons[3]= new JButton("/");
		c.gridx = 3;
		c.gridy = 1;
		c.ipadx = 5;
		c.insets = new Insets(0,0,0,2);
		pane.add(buttons[3],c);

		buttons[4]= new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0,2,0,0);
		pane.add(buttons[4],c);

		buttons[5]= new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[5],c);

		buttons[6]= new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[6],c);

		buttons[7]= new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		c.ipadx = 5;
		c.insets = new Insets(0,0,0,2);
		pane.add(buttons[7],c);

		buttons[8]= new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(0,2,0,0);
		pane.add(buttons[8],c);

		buttons[9]= new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[9],c);

		buttons[10]= new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[10],c);

		buttons[11]= new JButton("-");
		c.gridx = 3;
		c.gridy = 3;
		c.ipadx = 5;
		c.insets = new Insets(0,0,0,2);
		pane.add(buttons[11],c);

		buttons[12]= new JButton("C");
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(0,2,0,0);
		pane.add(buttons[12],c);

		buttons[13]= new JButton("0");
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[13],c);

		buttons[14]= new JButton("=");
		c.gridx = 2;
		c.gridy = 4;
		c.insets = new Insets(0,0,0,0);
		pane.add(buttons[14],c);

		buttons[15]= new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		c.insets = new Insets(0,0,0,2);
		pane.add(buttons[15],c);

		buttons[16]= new JButton("Save");
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(5,20,10,5);
		c.gridwidth = 2;
		pane.add(buttons[16],c);

		buttons[17]= new JButton("Recall");
		c.gridx = 2;
		c.gridy = 5;
		c.insets = new Insets(5,5,10,20);
		c.gridwidth = 2;
		pane.add(buttons[17],c);

		tfield = new JTextField();
		tfield.setEditable(false);
		//tfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfield.setHorizontalAlignment(JTextField.RIGHT);
		tfield.setFont(new Font("Roboto",Font.BOLD,30));
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20,10,20,10);
		c.gridwidth = 4;
		pane.add(tfield,c);

		for (int i = 0; i < 18; i++) {
			buttons[i].setFont(new Font("Roboto",Font.PLAIN,18));
			buttons[i].addActionListener(al);
		}
		tfield.addActionListener(al);

	}
	private static void createAndShowGUI() {
		JFrame calcframe = new JFrame("Calculator");
		calcframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcframe.setBounds(800, 400, 336, 430);
		calcframe.setMinimumSize(new Dimension(336, 430));
		addComponentsToPane(calcframe.getContentPane());
		//		calcframe.pack();
		calcframe.setVisible(true);
	}
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	public void actionPerformed(ActionEvent g){

		String event=g.getActionCommand(); //returns a String description of the event

		if (event.equals("Save"))
		{
			try 
			{
				save();
			} 
			catch (IOException g1) 
			{
				g1.printStackTrace();
			}
		}

		else if (event.equals("Recall"))
		{
			try 
			{
				recall();
			} 
			catch (IOException g1) 
			{
				g1.printStackTrace();
			}
		}

		else{
/*Number*/ 		if (event.charAt(0) >= '0' && event.charAt(0) <= '9'){

				//if a number is selected after '=' ,clear everything first
				if (tfield.getText().contains("=")){
					clear();
				}

				//if there is an operator present add to operand2
				if (!operator.equals("")){
					operand2+=event;
				}
				else{
					operand1+=event;
				}
				//update the textfield
				tfield.setText(dubfilter(operand1)+operator+operand2);
			}
/*C*/			else if (event.charAt(0)=='C'){
				clear(); //method that clears all values and text field
			}
/*=*/			else if (event.charAt(0) == '='){

				//if '=' is pressed consecutively display just the result of the calculation
				if (tfield.getText().contains("=")||tfield.getText().equals(dubfilter(operand1))){
					tfield.setText(dubfilter(operand1));
				}
				else{	
					calculation(); //method that does the calculation according to the operator and gives calc(result)

					tfield.setText(dubfilter(operand1)+operator+operand2 + "=" +dubfilter((String.valueOf(calc))));

					//set string value of calculation to operand1 if needed to continue
					operand1=calc+"";

					//clear operator&operand2
					operator=operand2="";
				}

			}
/*operator*/	else{
				// else the event is an operator
				//if there's no operator, store it or if there's an operator but no operand2 overwrite the operator 
				if(operator.equals("") || operand2.equals("")){
					operator = event; 
				}
				else{
					calculation(); //method that does the calculation according to the operator

					//set string value of calculation to operand1
					operand1=calc+"";

					//set operator
					operator=event;

					//clear operand2
					operand2="";
				}
				tfield.setText(dubfilter(operand1)+operator);
			}
		}	
	}
	private static void clear(){
		//clear all values
		operand1=operator=operand2="";

		//update the textfield
		tfield.setText("");
	}
	public static String dubfilter(String num){
		//removes decimal point if the result is of this form "50.0" for better display
		if(!(num.isEmpty()) && num.contains(".")){

			String[] number=num.split("\\.");

			if (number[1].length()==1 && number[1].contentEquals("0")){
				return number[0];
			}
		}
		return num;
	}
	private static void calculation(){
		switch (operator){
		case "+":calc=(Double.valueOf(operand1) + Double.valueOf(operand2));break;
		case "-":calc=(Double.valueOf(operand1) - Double.valueOf(operand2));break;
		case "*":calc=(Double.valueOf(operand1) * Double.valueOf(operand2));break;
		default :calc=(Double.valueOf(operand1) / Double.valueOf(operand2));break;
		}
	}
	public void save() throws IOException 
	{
		save = tfield.getText();

		FileWriter writehandle = new FileWriter("C:\\Users\\STAV\\Desktop\\saves.txt");
		BufferedWriter bw =  new BufferedWriter(writehandle);
		bw.write(save+","+operand1+","+operator+","+operand2);
		bw.close();
		writehandle.close();
	}
	public void recall() throws IOException 
	{
		FileReader readhandle = new FileReader("C:\\Users\\STAV\\Desktop\\saves.txt");
		BufferedReader br = new BufferedReader(readhandle);

		/*split saves.txt(textfield,operand1,operator,operand2) by comma and assign for Calculator to continue*/
		String[] recline=br.readLine().split(",",-1);/*split by default removes empty strings ,
		 											*to avoid this we use the overloaded version by placing -1 as the limit*/
		operand1=recline[1];
		operator=recline[2];
		operand2=recline[3];
		tfield.setText(recline[0]);
		br.close();
		readhandle.close(); 
	}
}
