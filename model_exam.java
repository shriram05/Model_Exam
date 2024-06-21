import java.awt.*;  
     import java.awt.event.*;  
     import javax.swing.*;  
     class Project extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1;
    JButton b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Project(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,4000,20);  
        jb[0].setBounds(50,80,1000,20);  
        jb[1].setBounds(50,110,1000,20);  
        jb[2].setBounds(50,140,4000,20);  
        jb[3].setBounds(50,170,1000,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(350,200);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())
		{ 
                count=count+1;
		}  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)
		{
                b2.setText("Result");
		}  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())
		{  
                count=count+1;
		}  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())
		{ 
                count=count+1;
		}  
            current++;  
            JOptionPane.showMessageDialog(this,"You  scored : "+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Q1: How is an array initialized in C language?");  
            jb[0].setText("int a = {1,2,3};");
	      jb[1].setText("int a[3] = {1,2,3};");
	      jb[2].setText("int a[]=new int[3]");
	      jb[3].setText("int a(3)= [1,2,3];");   
        }  
        if(current==1)  
        {  
            l.setText("Q2: How are String represented in memory in C?");  
            jb[0].setText("An array of characters.");
	      jb[1].setText("The object of some class.");
	      jb[2].setText("Same as primitive datatypes.");
	      jb[3].setText("LinkedList of characters.");  
        }  
        if(current==2)  
        {  
            l.setText("Q3: How is a code block indicated in Python?");  
            jb[0].setText("Brackets.");
	      jb[1].setText("Key.");
	      jb[2].setText("Indentation.");
	      jb[3].setText("None of the above.");  
        }  
        if(current==3)  
        {  
            l.setText("Q4: Which of the following concepts is not a part of Python?");  
            jb[0].setText("Pointers.");
	      jb[1].setText("Loops.");
	      jb[2].setText("Dynamic Typing.");
	      jb[3].setText("All of the above.");  
        }  
        if(current==4)  
        {  
            l.setText("Q5: Which of the following is a linear data structure?");  
            jb[0].setText("AVL Trees.");
	      jb[1].setText("Binary Trees.");
	      jb[2].setText("Graphs.");
	      jb[3].setText("Array.");  
        }  
        if(current==5)  
        {  
            l.setText("Q6: Which of the following is not the type of queue?");  
            jb[0].setText("Priority Queue");
	      jb[1].setText("Single-ended queue");
	      jb[2].setText("Circular Queue");
	      jb[3].setText("Ordinary Queue");  
        }  
        if(current==6)  
        {  
            l.setText("Q7: When is the object created with new keyword?");  
            jb[0].setText("At compile time");
	      jb[1].setText("Depends on the code");
	      jb[2].setText("At run time");  
            jb[3].setText("None");  
        }  
        if(current==7)  
        {  
            l.setText("Q8: What is Runnable?");  
            jb[0].setText("Abstract class");
	      jb[1].setText("Class");
	      jb[2].setText("Method");  
            jb[3].setText("Interface");         
        }  
        if(current==8)  
        {  
            l.setText("Q9: compareTo() returns __________");  
            jb[0].setText("True");
	      jb[1].setText("False");
	      jb[2].setText("An int value");
	      jb[3].setText("None");  
        }  
        if(current==9)  
        {  
            l.setText("Q10: Which of the exception is thrown when divided by zero executed?");  
            jb[0].setText("ArithmeticException");
	      jb[1].setText("NullPointerException");
	      jb[2].setText("NumberFormatException");  
            jb[3].setText("None");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)
	  {
            jb[j].setBounds(50,80+i,200,20);  
	  }
    }  
    boolean check()  
    {  
        if(current==0)
	  {
            return(jb[1].isSelected());  
	  }
        if(current==1)  
	  {
            return(jb[0].isSelected());  
	  }
        if(current==2)
	  {  
            return(jb[2].isSelected());  
	  }
        if(current==3)  
        {
		return(jb[0].isSelected());  
	  }
        if(current==4)  	
	  {
            return(jb[3].isSelected());  
	  }
        if(current==5)
	  {  
            return(jb[1].isSelected());
	  }  
        if(current==6) 
	  { 
            return(jb[2].isSelected());  
	  }
        if(current==7)
	  {  
            return(jb[3].isSelected());
	  }  
        if(current==8)  
	  {
            return(jb[2].isSelected());   
 	  }
        if(current==9)  
	  {
            return(jb[0].isSelected());  
	  }
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Project("Model exam");  
    }  }
