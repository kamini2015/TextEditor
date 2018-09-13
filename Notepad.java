import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class MyMenu extends JFrame implements ActionListener
{
	//variables
	JMenuBar mb;
	JMenu file,edit,frmt,help,view;
	JMenuItem nw,op,sa,sa1,pgs,pr,ex,f1,f2 , un,ct,cp,pt,dl,fnd,fnd1,rep,gt,sla,td, ww,fn, sb, vh,abt;
	//JCheckBoxMenuItem pr;
	
	MyMenu()
	{
		//create container
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//create a menu bar
		mb = new JMenuBar();
		//add menubar to container
		c.add("North",mb);
		//create the file,edit menus and attach them to menubar
		file = new JMenu("File");
		edit = new JMenu("Edit");
		frmt = new JMenu("Format");
		view = new JMenu("View");
		help = new JMenu("Help");
		
		mb.add(file);
		mb.add(edit);
		mb.add(frmt);
		mb.add(view);
		mb.add(help);
		
		//create menu items of File
		nw = new JMenuItem("New");
		op = new JMenuItem("Open...");
		sa = new JMenuItem("Save");
		sa1 = new JMenuItem("Save As...");
		pgs = new JMenuItem("Page Setup...");
		pr = new JMenuItem("Print...");
		ex = new JMenuItem("Exit");
		
		//create menu items of Edit
		un = new JMenuItem("Undo");
		ct = new JMenuItem("Cut");
		cp = new JMenuItem("Copy");
		pt = new JMenuItem("Paste");
		dl = new JMenuItem("Delete");
		fnd = new JMenuItem("Find..");
		fnd1 = new JMenuItem("Find Next..");
		rep = new JMenuItem("Replace");
		gt = new JMenuItem("Go to...");
		sla = new JMenuItem("Select All");
		td = new JMenuItem("Time/Date");

		//create menu items of Format
		ww = new JMenuItem("Word Wrap");
		fn = new JMenuItem("Font..");

		//create menu items of View
		sb = new JMenuItem("Status Bar");
		
		//create menu items of Help
		vh = new JMenuItem("View help");
		abt = new JMenuItem("About");


		//File menu
		file.add(nw);
		file.add(op);
		file.add(sa);
		file.add(sa1);
		file.addSeparator(); //add a separator to file menu		
		file.add(pgs);
		file.add(pr);
		file.addSeparator();
		file.add(ex);
	
    	//Edit menu
		edit.add(un);
		edit.addSeparator();
		edit.add(ct);
		edit.add(cp);
		edit.add(pt);
		edit.add(dl);
		edit.addSeparator();
		edit.add(fnd);
		edit.add(fnd1);
		edit.add(rep);
		edit.add(gt);
		edit.addSeparator();
		edit.add(sla);
		edit.add(td);
		
		//Format menu
        frmt.add(ww);
		//frmt.add(fn);
		
		//View menu	
		view.add(sb);
		
		//Help menu
		help.add(vh);
		help.addSeparator();
		help.add(abt);
			
		//make items disabled
		un.setEnabled(false);
		ct.setEnabled(false);
		cp.setEnabled(false);
		dl.setEnabled(false);
		fnd.setEnabled(false);
		fnd1.setEnabled(false);
				
		
		//create a Font submenu and add it to file menu
		fn = new JMenu("Font..");
		frmt.add(fn);
		//create menu items
		f1 = new JMenuItem("Arial");
		f2 = new JMenuItem("Times new Roman");
		//add menu items to sub menu
		fn.add(f1);
		fn.add(f2);
		
		//attach listeners to all menu items
		op.addActionListener(this);
		sa.addActionListener(this);
		ex.addActionListener(this);
		cp.addActionListener(this);
		pt.addActionListener(this);
		pr.addActionListener(this);
		f1.addActionListener(this);
		f2.addActionListener(this);
        
		//close frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//this method is executed when a menu item is clicked 
    public void actionPerformed(ActionEvent ae)
	{
		//know which menu item is clicked
		if(op.isArmed()) this.openFile();
		if(sa.isArmed()) this.saveFile();
		if(ex.isArmed()) System.out.println("Exit is selected");
		if(cp.isArmed()) System.out.println("Copy is selected");
		if(pt.isArmed()) System.out.println("paste is selected");
		if(pr.getModel().isSelected()) System.out.println("Printing on...");
		else
			System.out.println("Printing off...");
		if(f1.isArmed()) System.out.println("Arial font is selected");
		if(f2.isArmed()) System.out.println("Times new roman is selected");
	}
	//this method is called when File-> open is selected
	
	void openFile()
	{
		//create an object to JFileChooser class
		JFileChooser fc = new JFileChooser();
		//display file open dialog box
		int i = fc.showOpenDialog(this);
		
		//if user selected a file name then
		if(i == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile(); //get the selected file into file object
			String fname = f.getPath();
			OpenFrame of = new OpenFrame(fname);
			of.setSize(500,400);
			of.setVisible(true);
		}
	}

	void saveFile()
	{
		
	}
	
	public static void main(String args[])
	{
		//create the frame
		MyMenu mm = new MyMenu();
		mm.setTitle("Text Editor");
		mm.setSize(500,400);
		mm.setVisible(true);
	}
	}

	class OpenFrame extends JFrame
	{
	OpenFrame(String fname)
	{
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	
	TextArea ta = new TextArea(90,90);
	c.add(ta);
	
	String str="";
	String str1="";
	try{
		BufferedReader br = new BufferedReader(new FileReader(fname));
		while((str = br.readLine()) != null)
			str1+= str+"\n";
		ta.setText(str1);
		br.close();
	}
	catch(Exception e){}
}	
}