import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class Connect
{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://db-315.cse.tamu.edu/hnpatel97_db";
   static final String USER = "hnpatel97";
   static final String PASS = "studentpwd";
   
   public static void main(String[] args) 
   {
	   Connection conn = null;
	   Statement stmt = null;
	   String sql = "";
	   try
	   {
		   //Open a connection
		   Class.forName("org.postgresql.Driver");
		   System.out.println("Connecting to database...");
		   conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		   //Creates the Window
		   mainFrame mainWindow = new mainFrame();

		   String search = mainWindow.getSearch();
		   String category = mainWindow.getCategory();
		   
		   conn.close();
		
	   }
	   catch(SQLException se)
	   {
		  //Handle errors for JDBC
		  se.printStackTrace();
	   }catch(Exception e){
		  //Handle errors for Class.forName
		  e.printStackTrace();
	   }
	   finally //finally block used to close resources
	   {
		  try
		  {
			 if(stmt!=null)
				stmt.close();
		  }
		  catch(SQLException se2)
		  {
			  // nothing to do
		  }
		  try
		  {
			 if(conn!=null)
			 {
				conn.close();
			 }
		  }catch(SQLException se)
		  {
			 se.printStackTrace();
		  }
	   }//end try
	}
}

class mainFrame implements ActionListener
{
	private JFrame frame;
	private String searchFromBar = "";
	private String searchCategory = "";
    mainFrame() 
    {   
        // creating instance of JFrame with name "Main Window" 
        frame=new JFrame("Main Window");
        
        //creates instance of search bar
        JTextField searchBar = new JTextField();
        searchBar.setBounds(300, 50, 200, 20); 
        searchBar.addActionListener(this);
        System.out.println(searchBar.getText());
        frame.add(searchBar);
        
        //creates instance of combo box
        String category[] = {"Movies", "TV Shows", "People","Ratings"};
        JComboBox sCategory = new JComboBox(category);
        sCategory.setBounds(200,50, 100, 20);
        frame.add(sCategory);
        
        // creates instance of JButton 
        JButton searchButton = new JButton("Search"); 
        searchButton.setBounds(500, 50, 100, 20);
        searchButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String s = e.getActionCommand(); 
                if (s.equals("Search")) 
                {
                	searchFromBar = searchBar.getText();
                	searchCategory = (String)sCategory.getItemAt(sCategory.getSelectedIndex());
                	System.out.println(searchFromBar); // PRINTS THE STRING FROM SEARCH BAR
                	System.out.println(searchCategory); // PRINTS THE CATEGORY
                }
            }
        });
        frame.add(searchButton);
        
        //creates instance of text
        JLabel label = new JLabel("Search: ");
        label.setBounds(150, 10, 90, 100);
        frame.add(label);

        // sets 800 width and 600 height 
        frame.setSize(800, 600);
          
        // uses no layout managers 
        frame.setLayout(null); 
        
        // This is the closing condition
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // makes the frame visible 
        frame.setVisible(true); 
    }
    public void actionPerformed(ActionEvent e) 
    { 
    	//Nothing here yet
    } 
    public String getSearch() //RETURNS STRING FROM SEARCH BAR
    {
        return searchFromBar;
    }
    public String getCategory() //RETURNS THE CATEGORY
    {
        return searchCategory;
    }
}
