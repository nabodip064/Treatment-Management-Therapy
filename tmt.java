import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class tmt extends JFrame implements ActionListener{
	JTextField search;
	Button homeBtn,regBtn,updateBtn,deleteBtn,addAdmnBtn,searchBtn;
	JLabel ljl,tjl,heallthTipsLbl,imageLbl,aboutLbl;
	ImageIcon lii;
	Connection con=null;
	Statement st=null;
	String idS,s,nameS,companyS,ratingS,descriptionS;
	Font fnt;
	tmt(){
		homeBtn=new Button("Home");
		regBtn=new Button("Registration");
		updateBtn=new Button("Update");
		deleteBtn=new Button("Delete");
		addAdmnBtn=new Button("Add Admin");
		searchBtn=new Button("Search");
		lii=new ImageIcon(((new ImageIcon("images.png")).getImage()).getScaledInstance(80,70,java.awt.Image.SCALE_SMOOTH));
		ljl=new JLabel(lii,JLabel.CENTER);
		tjl=new JLabel("<html>Treatment Management Therapy<br>	A Drug Monitoring Company</html>");
		heallthTipsLbl=new JLabel("Health Tips");
		imageLbl=new JLabel("Image");
		aboutLbl=new JLabel("About TMT company");
		fnt=new Font("Courier",Font.BOLD,24);
		search=new JTextField();
		add(ljl);
		add(tjl);
		add(homeBtn);
		add(regBtn);
		add(updateBtn);
		add(deleteBtn);
		add(addAdmnBtn);
		add(searchBtn);
		add(search);
		add(heallthTipsLbl);
		add(imageLbl);
		add(aboutLbl);
		addAdmnBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		regBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		setLayout(null);
		ljl.setBounds(10,10,80,70);
		tjl.setBounds(105,10,400,70);
		tjl.setFont(fnt);
		search.setBounds(395,85,90,30);
		searchBtn.setBounds(485,85,45,30);
		addAdmnBtn.setBounds(10,85,85,30);
		homeBtn.setBounds(10,120,125,40);
		regBtn.setBounds(140,120,130,40);
		updateBtn.setBounds(275,120,125,40);
		deleteBtn.setBounds(405,120,125,40);
		imageLbl.setBounds(10,170,530,370);
		heallthTipsLbl.setBounds(10,550,300,150);
		aboutLbl.setBounds(300,550,530,230);
		setSize(550,730);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==addAdmnBtn){
			admnMsgWnd nobj = new admnMsgWnd();
		}
		else if(ae.getSource()==regBtn){
			regMsgWnd obj = new regMsgWnd();
		}
		else if(ae.getSource()==updateBtn){
			updateMsgWnd updateOb = new updateMsgWnd();
		}
		else if(ae.getSource()==deleteBtn){
			deleteMsgWnd deleteOb = new deleteMsgWnd();
		}
		/*else if(ae.getSource()==searchBtn){
			idS=search.getText();
			System.out.println("Connection has started..........");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Has passed step 1...............");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			System.out.println("Has passed step 2...............");
			st=con.createStatement();
			System.out.println("Has passed step 3...............");
			ResultSet rs=st.executeQuery("SELECT * FROM drug WHERE id=idS");
			System.out.println("Connection has completed........");
			s=rs.getString("id");
			nameS=rs.getString("name");
			companyS=rs.getString("company");
			ratingS=rs.getString("rating");
			descriptionS=rs.getString("description");
			System.out.println("Id:"+idS+" Name:"+nameS+" Company:"+companyS+" Rating:"+ratingS+" Description:"+descriptionS);
			srhWnd obj = new srhWnd();
		}*/     
	}
	public static void main(String cp[]){
		tmt obj = new tmt();
	}
}

class admnMsgWnd{
	Connection con=null;
	Statement st=null;
	admnMsgWnd(){
		String userNamme = JOptionPane.showInputDialog(null, "Enter User Name");
		String password = JOptionPane.showInputDialog(null,"Enter Password");
		int val=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select userN,password from admin");
			while(rs.next()){
				if(userNamme.equals(rs.getString("userN")) && password.equals(rs.getString("password"))){
					nwd obj =new nwd();
					break;
				}
				else{
					val++;
				}
			}
			 if(val>0){
				 JOptionPane.showMessageDialog(null,"Wrong UserName/Password......");
			 }
		}
		catch(Exception e){
			System.out.println(e);
		}
	}	
}

class regMsgWnd{
	Connection con=null;
	Statement st=null;
	regMsgWnd(){
		String userName = JOptionPane.showInputDialog(null, "Enter User Name");
		String password = JOptionPane.showInputDialog(null,"Enter Password");
		int val=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			st=con.createStatement();
			ResultSet rs= st.executeQuery("select userN,password from admin");
			while(rs.next()){
				if(userName.equals(rs.getString("userN")) && password.equals(rs.getString("password"))){
					regWnd obj = new regWnd();
					break;
				}
				else{
					val++;
				}
			}
			if(val>0){
				JOptionPane.showMessageDialog(null,"Wrong UserName/Password..........");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}	
}

class updateMsgWnd{
	Connection con=null;
	Statement st=null;
	updateMsgWnd(){
		String userNamme = JOptionPane.showInputDialog(null, "Enter User Name");
		String password = JOptionPane.showInputDialog(null,"Enter Password");
		int val=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select userN,password from admin");
			while(rs.next()){
				if(userNamme.equals(rs.getString("userN")) && password.equals(rs.getString("password"))){
					updatewnd obj = new updatewnd();
					break;
				}
				else{
					val++;
				}
			}
			if(val>0){
				JOptionPane.showMessageDialog(null,"Wrong UserName/Password.......");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}	
}

class deleteMsgWnd{
	Connection con=null;
	Statement st=null;
	deleteMsgWnd(){
		String userNamme = JOptionPane.showInputDialog(null, "Enter User Name");
		String password = JOptionPane.showInputDialog(null,"Enter Password");
		int val=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select userN,password from admin");
			while(rs.next()){
				if(userNamme.equals(rs.getString("userN")) && password.equals(rs.getString("password"))){
					deletewnd obj=new deletewnd();
					break;
				}
				else{
					val++;
				}
			}
			if(val>0){
				JOptionPane.showMessageDialog(null,"Wrong UserName/Password......");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}	
}

class nwd extends JFrame implements ActionListener{
	JLabel fulfilLbl,idLbl,nameLbl,fatherLbl,motherLbl,ageLbl,sexLbl,addressLbl,drugLbl,improveLbl,suggestionLbl;
	JTextField idTxt,nameTxt,fatherTxt,motherTxt,ageTxt,sexTxt,addressTxt,drugTxt,improveTxt,suggestionTxt;
	Button submitBtn;
	Connection con=null;
	Statement st=null;
	String idS,ageS,nameS,fatherS,motherS,sexS,addressS,userS,passwordS;
	nwd(){
		fulfilLbl=new JLabel("Fullfill all the textfield.");
		idLbl=new JLabel("Admin ID");
		nameLbl=new JLabel("Admin Name");
		fatherLbl=new JLabel("Father's/Husband's Name");
		motherLbl=new JLabel("Mother's Name");
		ageLbl=new JLabel("Age");
		sexLbl=new JLabel("Sex");
		addressLbl=new JLabel("Address");
		drugLbl=new JLabel("User Name");
		improveLbl=new JLabel("Password");
		idTxt=new JTextField();
		nameTxt=new JTextField();
		fatherTxt=new JTextField();
		motherTxt=new JTextField();
		ageTxt=new JTextField();
		sexTxt=new JTextField();
		addressTxt=new JTextField();
		drugTxt=new JTextField();
		improveTxt=new JTextField();
		submitBtn=new Button("Submit");
		
		add(fulfilLbl);
		add(idLbl);
		add(idTxt);
		add(nameLbl);
		add(nameTxt);
		add(fatherLbl);
		add(fatherTxt);
		add(motherLbl);
		add(motherTxt);
		add(ageLbl);
		add(ageTxt);
		add(sexLbl);
		add(sexTxt);
		add(addressLbl);
		add(addressTxt);
		add(drugLbl);
		add(drugTxt);
		add(improveLbl);
		add(improveTxt);
		add(submitBtn);
		
		fulfilLbl.setBounds(20,10,360,30);
		idLbl.setBounds(20,60,180,30);
		nameLbl.setBounds(20,100,180,30);
		fatherLbl.setBounds(20,140,180,30);
		motherLbl.setBounds(20,180,180,30);
		ageLbl.setBounds(20,220,180,30);
		sexLbl.setBounds(20,260,180,30);
		addressLbl.setBounds(20,300,180,30);
		drugLbl.setBounds(20,340,180,30);
		improveLbl.setBounds(20,380,180,30);
		idTxt.setBounds(180,60,180,30);
		nameTxt.setBounds(180,100,180,30);
		fatherTxt.setBounds(180,140,180,30);
		motherTxt.setBounds(180,180,180,30);
		ageTxt.setBounds(180,220,180,30);
		sexTxt.setBounds(180,260,180,30);
		addressTxt.setBounds(180,300,180,30);
		drugTxt.setBounds(180,340,180,30);
		improveTxt.setBounds(180,380,180,30);
		
		submitBtn.setBounds(300,500,70,30);
		submitBtn.addActionListener(this);
		setLayout(null);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==submitBtn){
			
			try{
			idS=idTxt.getText();
			nameS=nameTxt.getText();
			fatherS=fatherTxt.getText();
			motherS=motherTxt.getText();
			ageS=ageTxt.getText();
			sexS=sexTxt.getText();
			addressS=addressTxt.getText();
			userS=drugTxt.getText();
			passwordS=improveTxt.getText();
			System.out.println("Connection Start.........");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Has conected.............");
			con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
			System.out.println("It is step 3.............");
			st=con.createStatement();
			System.out.println("It is step 4.............");
			st.executeUpdate("insert into admin values('"+idS+"','"+nameS+"','"+fatherS+"','"+motherS+"','"+ageS+"','"+sexS+"','"+addressS+"','"+userS+"','"+passwordS+"')");
			System.out.println("Connection Complete......");
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb= new tmt();
		}
	}
}

class regWnd extends JFrame implements ActionListener{
	JLabel fulfilLbl,idLbl,nameLbl,fatherLbl,motherLbl,ageLbl,sexLbl,addressLbl,drugLbl,improveLbl,suggestionLbl,ptLbl,drgLbl;
	JTextField idTxt,nameTxt,fatherTxt,motherTxt,ageTxt,sexTxt,addressTxt,drugTxt,improveTxt,suggestionTxt;
	Button submitBtn,patientBtn,drugBtn;
	Connection con=null;
	Statement st=null;
	String idS,nameS,fatherS,motherS,ageS,sexS,addressS,drugS,improvementS,suggestionS;
	regWnd(){
		idLbl=new JLabel("Patient ID");
		nameLbl=new JLabel("Patient Name");
		fatherLbl=new JLabel("Father's/Husband's Name");
		motherLbl=new JLabel("Mother's Name");
		ageLbl=new JLabel("Age");
		sexLbl=new JLabel("Sex");
		addressLbl=new JLabel("Address");
		drugLbl=new JLabel("Drug Name");
		improveLbl=new JLabel("Patient Improvement");
		suggestionLbl=new JLabel("Suggestion Drug");
		idTxt=new JTextField();
		nameTxt=new JTextField();
		fatherTxt=new JTextField();
		motherTxt=new JTextField();
		ageTxt=new JTextField();
		sexTxt=new JTextField();
		addressTxt=new JTextField();
		drugTxt=new JTextField();
		improveTxt=new JTextField();
		suggestionTxt=new JTextField();
		submitBtn=new Button("Submit");
		patientBtn=new Button("Patient Registration");
		drugBtn=new Button("Drug Registration");
		
		add(idLbl);
		add(idTxt);
		add(nameLbl);
		add(nameTxt);
		add(fatherLbl);
		add(fatherTxt);
		add(motherLbl);
		add(motherTxt);
		add(ageLbl);
		add(ageTxt);
		add(sexLbl);
		add(sexTxt);
		add(addressLbl);
		add(addressTxt);
		add(drugLbl);
		add(drugTxt);
		add(improveLbl);
		add(improveTxt);
		add(suggestionLbl);
		add(suggestionTxt);
		add(submitBtn);
		add(patientBtn);
		add(drugBtn);
		
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		idLbl.setBounds(20,60,180,30);
		nameLbl.setBounds(20,100,180,30);
		fatherLbl.setBounds(20,140,180,30);
		motherLbl.setBounds(20,180,180,30);
		ageLbl.setBounds(20,220,180,30);
		sexLbl.setBounds(20,260,180,30);
		addressLbl.setBounds(20,300,180,30);
		drugLbl.setBounds(20,340,180,30);
		improveLbl.setBounds(20,380,180,30);
		suggestionLbl.setBounds(20,420,180,30);
		idTxt.setBounds(180,60,180,30);
		nameTxt.setBounds(180,100,180,30);
		fatherTxt.setBounds(180,140,180,30);
		motherTxt.setBounds(180,180,180,30);
		ageTxt.setBounds(180,220,180,30);
		sexTxt.setBounds(180,260,180,30);
		addressTxt.setBounds(180,300,180,30);
		drugTxt.setBounds(180,340,180,30);
		improveTxt.setBounds(180,380,180,30);
		suggestionTxt.setBounds(180,420,180,30);
		
		submitBtn.setBounds(300,500,70,30);
		submitBtn.addActionListener(this);
		drugBtn.addActionListener(this);
		setLayout(null);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==submitBtn){
			try{
				idS=idTxt.getText();
				nameS=nameTxt.getText();
				fatherS=fatherTxt.getText();
				motherS=motherTxt.getText();
				ageS=ageTxt.getText();
				sexS=sexTxt.getText();
				addressS=addressTxt.getText();
				drugS=drugTxt.getText();
				improvementS=improveTxt.getText();
				suggestionS=suggestionTxt.getText();
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				st.executeUpdate("insert into patient values ('"+idS+"','"+nameS+"','"+fatherS+"','"+motherS+"','"+ageS+"','"+sexS+"','"+addressS+"','"+drugS+"','"+improvementS+"','"+suggestionS+"')");
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb= new tmt();
		}
		else if(ae.getSource()==drugBtn){
			drugWnd obj = new drugWnd();
		}
	}
}

class drugWnd extends JFrame implements ActionListener{
	JLabel fulfilLbl,idLbl,nameLbl,fatherLbl,motherLbl,ageLbl,sexLbl,addressLbl,drugLbl,improveLbl,suggestionLbl,ptLbl,drgLbl;
	JTextField idTxt,nameTxt,fatherTxt,motherTxt,ageTxt,sexTxt,addressTxt,drugTxt,improveTxt,suggestionTxt;
	Button submitBtn,patientBtn,drugBtn;
	Connection con=null;
	Statement st=null;
	String idS,nameS,companyS,ratingS,descriptionS;
	drugWnd(){
		idLbl=new JLabel("Drug ID");
		nameLbl=new JLabel("Drug Name");
		fatherLbl=new JLabel("Drug's Company");
		motherLbl=new JLabel("Drug Rating");
		suggestionLbl=new JLabel("Description");
		idTxt=new JTextField();
		nameTxt=new JTextField();
		fatherTxt=new JTextField();
		motherTxt=new JTextField();
		suggestionTxt=new JTextField();
		submitBtn=new Button("Submit");
		patientBtn=new Button("Patient Registration");
		drugBtn=new Button("Drug Registration");
		
		add(idLbl);
		add(idTxt);
		add(nameLbl);
		add(nameTxt);
		add(fatherLbl);
		add(fatherTxt);
		add(motherLbl);
		add(motherTxt);
		add(suggestionLbl);
		add(suggestionTxt);
		add(submitBtn);
		add(patientBtn);
		add(drugBtn);
		
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		idLbl.setBounds(20,60,180,30);
		nameLbl.setBounds(20,100,180,30);
		fatherLbl.setBounds(20,140,180,30);
		motherLbl.setBounds(20,180,180,30);
		suggestionLbl.setBounds(20,220,180,30);
		idTxt.setBounds(180,60,180,30);
		nameTxt.setBounds(180,100,180,30);
		fatherTxt.setBounds(180,140,180,30);
		motherTxt.setBounds(180,180,180,30);
		suggestionTxt.setBounds(180,220,180,30);
		
		submitBtn.setBounds(300,500,70,30);
		submitBtn.addActionListener(this);
		patientBtn.addActionListener(this);
		setLayout(null);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==submitBtn){
			try{
				idS=idTxt.getText();
				nameS=nameTxt.getText();
				companyS=fatherTxt.getText();
				ratingS=motherTxt.getText();
				descriptionS=suggestionTxt.getText();
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				st.executeUpdate("insert into drug values('"+idS+"','"+nameS+"','"+companyS+"','"+ratingS+"','"+descriptionS+"')");
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb= new tmt();
		}
		else if(ae.getSource()==patientBtn){
			regWnd obj = new regWnd();
		}
	}
}

class updatewnd extends JFrame implements ActionListener{
	JLabel fulfilLbl,idLbl,nameLbl,fatherLbl,motherLbl,ageLbl,sexLbl,addressLbl,drugLbl,improveLbl,suggestionLbl;
	JTextField idTxt,nameTxt,fatherTxt,motherTxt,ageTxt,sexTxt,addressTxt,drugTxt,improveTxt,suggestionTxt;
	Button submitBtn,patientBtn,drugBtn;
	updatewnd(){
		idLbl=new JLabel("Patient ID");
		nameLbl=new JLabel("Patient Name");
		fatherLbl=new JLabel("Father's/Husband's Name");
		motherLbl=new JLabel("Mother's Name");
		ageLbl=new JLabel("Age");
		sexLbl=new JLabel("Sex");
		addressLbl=new JLabel("Address");
		drugLbl=new JLabel("Drug Name");
		improveLbl=new JLabel("Patient Improvement");
		suggestionLbl=new JLabel("Suggestion Drug");
		idTxt=new JTextField();
		nameTxt=new JTextField();
		fatherTxt=new JTextField();
		motherTxt=new JTextField();
		ageTxt=new JTextField();
		sexTxt=new JTextField();
		addressTxt=new JTextField();
		drugTxt=new JTextField();
		improveTxt=new JTextField();
		suggestionTxt=new JTextField();
		submitBtn=new Button("Update");
		patientBtn=new Button("Patient Update");
		drugBtn=new Button("Drug Update");
		
		add(idLbl);
		add(idTxt);
		add(nameLbl);
		add(nameTxt);
		add(fatherLbl);
		add(fatherTxt);
		add(motherLbl);
		add(motherTxt);
		add(ageLbl);
		add(ageTxt);
		add(sexLbl);
		add(sexTxt);
		add(addressLbl);
		add(addressTxt);
		add(drugLbl);
		add(drugTxt);
		add(improveLbl);
		add(improveTxt);
		add(suggestionLbl);
		add(suggestionTxt);
		add(submitBtn);
		add(patientBtn);
		add(drugBtn);
		
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		idLbl.setBounds(20,50,180,30);
		nameLbl.setBounds(20,100,180,30);
		fatherLbl.setBounds(20,140,180,30);
		motherLbl.setBounds(20,180,180,30);
		ageLbl.setBounds(20,220,180,30);
		sexLbl.setBounds(20,260,180,30);
		addressLbl.setBounds(20,300,180,30);
		drugLbl.setBounds(20,340,180,30);
		improveLbl.setBounds(20,380,180,30);
		suggestionLbl.setBounds(20,420,180,30);
		idTxt.setBounds(180,60,180,30);
		nameTxt.setBounds(180,100,180,30);
		fatherTxt.setBounds(180,140,180,30);
		motherTxt.setBounds(180,180,180,30);
		ageTxt.setBounds(180,220,180,30);
		sexTxt.setBounds(180,260,180,30);
		addressTxt.setBounds(180,300,180,30);
		drugTxt.setBounds(180,340,180,30);
		improveTxt.setBounds(180,380,180,30);
		suggestionTxt.setBounds(180,420,180,30);
		
		submitBtn.setBounds(300,500,70,30);
		submitBtn.addActionListener(this);
		drugBtn.addActionListener(this);
		setLayout(null);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		Connection con=null;
		Statement st=null;
		if(ae.getSource()==submitBtn){
			String idS=idTxt.getText();
			String nameS=nameTxt.getText();
			String fatherS=fatherTxt.getText();
			String motherS=motherTxt.getText();
			String ageS=ageTxt.getText();
			String sexS=sexTxt.getText();
			String addressS=addressTxt.getText();
			String drugS=drugTxt.getText();
			String improveS=improveTxt.getText();
			String suggestionS=suggestionTxt.getText();
			try{
				Class.forName("com.mysql,jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				st.executeUpdate("update patient set name='"+nameS+"', fatherN='"+fatherS+"', motherN='"+motherS+"', age='"+ageS+"', sex='"+sexS+"', address='"+addressS+"', drugName='"+drugS+"', improvement='"+improveS+"', suggestion='"+suggestionS+"' where id='"+idS+"'");
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb = new tmt();
		}
		else if(ae.getSource()==drugBtn){
			drugUpdateWnd obj = new drugUpdateWnd();
		}
	}
}

class drugUpdateWnd extends JFrame implements ActionListener{
	JLabel fulfilLbl,idLbl,nameLbl,fatherLbl,motherLbl,ageLbl,sexLbl,addressLbl,drugLbl,improveLbl,suggestionLbl;
	JTextField idTxt,nameTxt,fatherTxt,motherTxt,ageTxt,sexTxt,addressTxt,drugTxt,improveTxt,suggestionTxt;
	Button submitBtn,patientBtn,drugBtn;
	drugUpdateWnd(){
		idLbl=new JLabel("Drug ID");
		nameLbl=new JLabel("Drug Name");
		fatherLbl=new JLabel("Drug's Name");
		motherLbl=new JLabel("Drug Rating");
		suggestionLbl=new JLabel("Description");
		idTxt=new JTextField();
		nameTxt=new JTextField();
		fatherTxt=new JTextField();
		motherTxt=new JTextField();
		suggestionTxt=new JTextField();
		submitBtn=new Button("Update");
		patientBtn=new Button("Patient Update");
		drugBtn=new Button("Drug Update");
		
		add(idLbl);
		add(idTxt);
		add(nameLbl);
		add(nameTxt);
		add(fatherLbl);
		add(fatherTxt);
		add(motherLbl);
		add(motherTxt);
		add(suggestionLbl);
		add(suggestionTxt);
		add(submitBtn);
		add(patientBtn);
		add(drugBtn);
		
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		idLbl.setBounds(20,50,180,30);
		nameLbl.setBounds(20,100,180,30);
		fatherLbl.setBounds(20,140,180,30);
		motherLbl.setBounds(20,180,180,30);
		suggestionLbl.setBounds(20,220,180,30);
		idTxt.setBounds(180,60,180,30);
		nameTxt.setBounds(180,100,180,30);
		fatherTxt.setBounds(180,140,180,30);
		motherTxt.setBounds(180,180,180,30);
		suggestionTxt.setBounds(180,220,180,30);
		
		submitBtn.setBounds(300,500,70,30);
		submitBtn.addActionListener(this);
		patientBtn.addActionListener(this);
		setLayout(null);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		Connection con=null;
		Statement st=null;
		if(ae.getSource()==submitBtn){
			String idS=idTxt.getText();
			String nameS=nameTxt.getText();
			String fatherS=fatherTxt.getText();
			String motherS=motherTxt.getText();
			String suggestionS=suggestionTxt.getText();
			try{
				Class.forName("com.mysql,jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				st.executeUpdate("update patient set name='"+nameS+"', company='"+fatherS+"', rating='"+motherS+"', description='"+suggestionS+"' where id='"+idS+"'");
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb = new tmt();
		}
		else if(ae.getSource()==patientBtn){
			updatewnd obj = new updatewnd();
		}
	}
}

class deletewnd extends JFrame implements ActionListener{
	JLabel dltLbl;
	JTextField idTxt;
	Button bttn,patientBtn,drugBtn;
	deletewnd(){
		dltLbl=new JLabel("Enter Patient ID");
		idTxt=new JTextField();
		bttn=new Button("Delete");
		patientBtn=new Button("Patient Delete");
		drugBtn=new Button("Drug Delete");
		
		dltLbl.setBounds(20,70,180,30);
		idTxt.setBounds(180,120,180,30);
		bttn.setBounds(300,300,70,30);
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		
		add(dltLbl);
		add(idTxt);
		add(bttn);
		add(patientBtn);
		add(drugBtn);
		
		bttn.addActionListener(this);
		drugBtn.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		Connection con=null;
		Statement st=null;
		String idS;
		int val=0;
		if(ae.getSource()==bttn){
			idS=idTxt.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				ResultSet rs=st.executeQuery("select id from patient");
				while(rs.next()){
					if(idS.equals(rs.getString("id"))){
						st.execute("delete from patient where id='"+idS+"'");
						JOptionPane.showMessageDialog(null,"Id no: "+idS+" has been deleted successfully");
						break;
					}
					else{
						val++;
					}
				}
				if(val>0){
					JOptionPane.showMessageDialog(null,"Id no: "+idS+" has not found");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb = new tmt();
		}
		else if(ae.getSource()==drugBtn){
			drugDeleteWnd obj = new drugDeleteWnd();
		}
	}
}

class drugDeleteWnd extends JFrame implements ActionListener{
	JLabel dltLbl;
	JTextField idTxt;
	Button bttn,patientBtn,drugBtn;
	drugDeleteWnd(){
		dltLbl=new JLabel("Enter Drug ID");
		idTxt=new JTextField();
		bttn=new Button("Delete");
		patientBtn=new Button("Patient Delete");
		drugBtn=new Button("Drug Delete");
		
		dltLbl.setBounds(20,70,180,30);
		idTxt.setBounds(180,120,180,30);
		bttn.setBounds(300,300,70,30);
		patientBtn.setBounds(20,10,180,40);
		drugBtn.setBounds(180,10,180,40);
		
		add(dltLbl);
		add(idTxt);
		add(bttn);
		add(patientBtn);
		add(drugBtn);
		
		bttn.addActionListener(this);
		patientBtn.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		Connection con=null;
		Statement st=null;
		String idS;
		int val=0;
		if(ae.getSource()==bttn){
			idS=idTxt.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/tmt","root","12345");
				st=con.createStatement();
				ResultSet rs=st.executeQuery("select id from drug");
				while(rs.next()){
					if(idS.equals(rs.getString("id"))){
						st.execute("delete from drug where id='"+idS+"'");
						JOptionPane.showMessageDialog(null,"Id no: "+idS+" has been deleted");
						break;
					}
					else{
						val++;
					}
				}
				if(val>0){
					JOptionPane.showMessageDialog(null,"Id no: "+idS+" has not found");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			tmt tmtOb = new tmt();
		}
		else if(ae.getSource()==patientBtn){
			deletewnd obj = new deletewnd();
		}
	}
}

class srhWnd extends JFrame implements ActionListener{
	Button okBtn;
	JLabel txtLbl;
	srhWnd(){
		txtLbl=new JLabel();
		okBtn=new Button("Ok");
		add(txtLbl);
		add(okBtn);
		txtLbl.setBounds(20,80,360,220);
		okBtn.setBounds(300,310,40,30);
		okBtn.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==okBtn){
			tmt obj = new tmt();
		}
	}
}