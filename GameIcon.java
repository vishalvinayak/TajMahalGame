import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class Gamer extends JFrame implements ActionListener
{
	JButton b1[]=new JButton[16];
	ImageIcon im[]=new ImageIcon[16];
	int i,j,chk,chk1;
	int num[]=new int[16];
	int pos=16;
	int count=1,flag;
	MenuBar mbar;
	Menu file,help;
	MenuItem item1,item2,item3,item4,item5;
	Container c =this.getContentPane();
	Color coo=new Color(255,200,200);
	Gamer()
	{
		setTitle("Ziz-Zag Puzzle By- Vishal Vinayak");
		c.setLayout(null);
		c.setBackground(Color.white);	

		
		mbar=new MenuBar();
		setMenuBar(mbar);
		file=new Menu("File");
		help=new Menu("Help");

		file.add(item1=new MenuItem("New Game"));
		file.add(item2=new MenuItem("Colour Chooser"));
		file.add(item3=new MenuItem("Exit"));
		mbar.add(file);	

		help.add(item4=new MenuItem("About"));
		help.add(item5=new MenuItem("Instructions"));
		mbar.add(help);

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);


		Panel p1=new Panel(new GridLayout(4,4));
		p1.setBackground(coo);
		p1.setBounds(0,0,300,300);
				
		Random r=new Random();
		do
		{
			go:
			{
				chk1=r.nextInt(15);
				chk=chk1+1;
				for(j=1;j<=count;j++)
				{
					if(chk==num[j])
					{
						flag=0;
						break;
					}
					else
					{
						flag=1;	
					}
				}
				if(flag==0)
				{
					break go;					
				}
				if(flag==1)
				{
						num[count]=chk;
						count++;
				}
			}
		}
		while(count!=16);
		
		im[0]=new ImageIcon("16.jpg");
		im[1]=new ImageIcon("1.jpg");
		im[2]=new ImageIcon("2.jpg");
		im[3]=new ImageIcon("3.jpg");
		im[4]=new ImageIcon("4.jpg");
		im[5]=new ImageIcon("5.jpg");
		im[6]=new ImageIcon("6.jpg");
		im[7]=new ImageIcon("7.jpg");
		im[8]=new ImageIcon("8.jpg");
		im[9]=new ImageIcon("9.jpg");
		im[10]=new ImageIcon("10.jpg");
		im[11]=new ImageIcon("11.jpg");
		im[12]=new ImageIcon("12.jpg");
		im[13]=new ImageIcon("13.jpg");
		im[14]=new ImageIcon("14.jpg");
		im[15]=new ImageIcon("15.jpg");
		
		for(i=1;i<=15;i++)
		{
			b1[i-1]=new JButton(String.valueOf(num[i]),im[num[i]]);
			b1[i-1].setForeground(Color.red);
			b1[i-1].setBackground(Color.white);
		}
		
		b1[15]=new JButton("");
		b1[15].setBackground(coo);
		b1[15].setForeground(Color.red);
		
		for(i=0;i<=15;i++)
		{
			b1[i].addActionListener(this);
		}
		
		for(i=0;i<=15;i++)
		{
			p1.add(b1[i]);
		}
		
		c.add(p1);
	}

	void winner()
	{
		for(i=0;i<=15;i++)
		{
			if(b1[i].getText()=="")
			{
				num[i]=16;
			}
			else
			{
				num[i]=Integer.parseInt(b1[i].getText());
			}
		}
		if(num[0]==1&&num[1]==2&&num[2]==3&&num[3]==4&&num[4]==5&&num[5]==6&&num[6]==7&&num[7]==8&&num[8]==9&&num[9]==10&&num[10]==11&&num[11]==12&&num[12]==13&&num[13]==14&&num[14]==15&&num[15]==16)
		{
			ImageIcon imgicn1=new ImageIcon("16.jpg");
			b1[15].setIcon(imgicn1);
			JOptionPane.showMessageDialog(this,"You Win The Game");
			System.exit(0);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int q;
		String s1=(String) e.getActionCommand();
//		System.out.println(s1);
		for(q=0;q<15;q++)
		{
			if(b1[q].getText()==s1)
			break;
		}
		int q1=q+1;
		if(q1==pos-4)
		{
			String label1=b1[q].getText();
			ImageIcon imgicn=new ImageIcon("test.jpg");
			imgicn=(ImageIcon) b1[q].getIcon();
			b1[q].setBackground(coo);
			b1[q].setText("");
			b1[q].setIcon(null);
			b1[pos-1].setBackground(Color.white);
			b1[pos-1].setText(label1);
			b1[pos-1].setIcon(imgicn);
			pos=q1;
		}
		if(q1==pos-1)
		{
			if(pos==5 || pos==9 || pos==13)
			{	
			}
			else
			{
				String label1=b1[q].getText();
				ImageIcon imgicn=new ImageIcon("test.jpg");
				imgicn=(ImageIcon) b1[q].getIcon();
				b1[q].setBackground(coo);
				b1[q].setText("");
				b1[q].setIcon(null);
				b1[pos-1].setBackground(Color.white);
				b1[pos-1].setText(label1);
				b1[pos-1].setIcon(imgicn);
				pos=q1;
			}	
		}
		if(q1==pos+1)
		{
			if(pos==4||pos==8||pos==12)
			{	
			}
			else
			{
				String label1=b1[q].getText();
				ImageIcon imgicn=new ImageIcon("test.jpg");
				imgicn=(ImageIcon) b1[q].getIcon();
				b1[q].setBackground(coo);
				b1[q].setText("");
				b1[q].setIcon(null);
				b1[pos-1].setBackground(Color.white);
				b1[pos-1].setText(label1);
				b1[pos-1].setIcon(imgicn);
				pos=q1;				
			}
		}
		if(q1==pos+4)
		{
			String label1=b1[q].getText();
			ImageIcon imgicn=new ImageIcon("test.jpg");
			imgicn=(ImageIcon) b1[q].getIcon();
			b1[q].setBackground(coo);
			b1[q].setText("");
			b1[q].setIcon(null);
			b1[pos-1].setBackground(Color.white);
			b1[pos-1].setText(label1);
			b1[pos-1].setIcon(imgicn);
			pos=q1;
		}
		if(s1.equals("New Game"))
		{
			dispose();
			Gamer g=new Gamer();
			g.setSize(310,355);
			g.setVisible(true);	
		}
		if(s1.equals("Colour Chooser"))
		{
			coo=JColorChooser.showDialog(Gamer.this,"Select Color",coo);
		}
		if(s1.equals("Exit"))
		{
			System.exit(0);
		}
		if(s1.equals("About"))
		{
			JOptionPane.showMessageDialog(this," Ziz-Zaz Puzzle \n\n\t Made By :  \n Vishal Vinayak \n C.S.E.       '03 \n S.B.S.C.E.T. Ferozepur \n Punjab, India. \n\n http://vishal.says.it \n vishalvinayak@rediffmail.com ");
	
		}
		if(s1.equals("Instructions"))
		{
			JOptionPane.showMessageDialog(this," Ziz-Zag Puzzle \n Copyrights Protected \n\n Arrange The Majestic 'Taj-Mahal' in proper order by using \n the empty box. You can move only one box at a time. \n The Empty Box should be at the last (no. 16) when U finish. ");
	
		}
		winner();
	}
}

public class GameIcon
{
	public static void main(String args[])
	{
		Gamer g=new Gamer();
		g.setSize(310,355);
		g.setVisible(true);		
	}
}