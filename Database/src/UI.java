import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI {

	private JFrame frmEventTicketManagement;
	private JTextField userLoginID;
	private JPasswordField userLoginPassword;
	private JTextField userNameIn;
	private JTextField userIdIn;
	private JTextField userAddressIn;
	private JTextField userPhoneNumberIn;

	private JTextField userPasswordIn;
	private JScrollPane EventScrollPane;
	private JPanel EventPane;
	String userLogin;
	String userLoginPass;
	boolean keyTrue=false;
	static Connection conn;
	static Statement st;
	private JTextField txtSomethingWentWrong;
	private JTextField txtDoYouHave;
	private JTextField ageIn;
	Scanner sc=new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmEventTicketManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test", "test");
			st = conn.createStatement();
//			//st.executeUpdate("select * from customer ");
//			st.executeUpdate("INSERT INTO EVENT VALUEs('Bowlingg','107')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public void menu(String ID) throws SQLException{
		
		
		
	}
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		JPanel signupPanel, loginPanel ;
		CardLayout c1 = new CardLayout();
		frmEventTicketManagement = new JFrame();
		frmEventTicketManagement.setAutoRequestFocus(false);
		frmEventTicketManagement.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		frmEventTicketManagement.setTitle("Event Ticket Management System");
		frmEventTicketManagement.setBounds(100, 100, 450, 300);
		frmEventTicketManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventTicketManagement.getContentPane().setLayout(c1);
		
		loginPanel = new JPanel();
		frmEventTicketManagement.getContentPane().add(loginPanel, "1");
		loginPanel.setLayout(null);
		
		
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(128, 24, 45, 31);
		loginPanel.add(lblUserId);
		
		userLoginID = new JTextField();
		userLoginID.setBounds(183, 29, 96, 20);
		loginPanel.add(userLoginID);
		userLoginID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(115, 89, 58, 14);
		loginPanel.add(lblPassword);
		
		userLoginPassword = new JPasswordField();
		userLoginPassword.setBounds(183, 86, 96, 20);
		loginPanel.add(userLoginPassword);
		userLoginPassword.setColumns(10);
		signupPanel = new JPanel();
		frmEventTicketManagement.getContentPane().add(signupPanel, "2");
		signupPanel.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			ResultSet rs;
			public void mouseClicked(MouseEvent e) {
			
			userLogin=userLoginID.getText();
			userLoginPass=userLoginPassword.getText();
			try {
//					ResultSet rs = st.executeQuery("select CUSTOMERID,CUSTOMERKEY from customer where customer.CUSTOMERID='"+userLogin+"' and customer.CUSTOMERKEY='"+userLoginPassword+"'" );
					rs=st.executeQuery("select * from customer ");
					while(rs.next()) {
					String checkID=rs.getString("customerid");
					String checkPass=rs.getString("customerkey");
					
					if(userLogin.equals(checkID) && userLoginPass.equals(checkPass) ) {
						System.out.println("works");
						System.out.println("Press 1 to update ,2 for delete and 3 to see events");
						String movieName;
						int choice = Integer.parseInt(sc.nextLine());
						String eventToChange="";
						String newEventName="";
						switch(choice){
						
						case  1 :{

							 rs=st.executeQuery("select * from get ");
							 while(rs.next()) {
								movieName=rs.getString("eventname");
								System.out.println(movieName);
								 
							 }
							System.out.println("Enter the event name to be changed");
							eventToChange=sc.nextLine();
							System.out.println("Enter newEvent from only event table");
							newEventName=sc.nextLine();
							st.executeUpdate("UPDATE GET SET EVENTNAME = '"+newEventName+"' WHERE customer_id= '"+userLogin +"' and eventname='"+eventToChange+"'");
							System.out.println("The event"+eventToChange+" is changed to "+newEventName);
							break;

						}
							
						case  2 : {

							System.out.println("Enter the event name  to remove from your chart");
							eventToChange=sc.nextLine();
							System.out.println(eventToChange);
							st.execute("DELETE FROM GET WHERE eventname='"+eventToChange+"' and customer_id='"+userLogin+"'");
							System.out.println("The event "+eventToChange+"deleted from myEvent");
							break;

						}
						
						case 3 :{
							
							c1.show(frmEventTicketManagement.getContentPane(), "3");

						}
						
						
						
						}

					}else {
						c1.show(frmEventTicketManagement.getContentPane(), "5");

					}

					}
					
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			}
		});
		btnLogin.setBounds(183, 151, 89, 23);
		loginPanel.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(frmEventTicketManagement.getContentPane(), "2");
			}
		});
		btnSignup.setBounds(183, 202, 89, 23);
		loginPanel.add(btnSignup);
		
		
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUserName.setBounds(21, 11, 71, 23);
		signupPanel.add(lblUserName);
		
		userNameIn = new JTextField();
		userNameIn.setToolTipText("Please enter your name");
		userNameIn.setBounds(116, 11, 125, 22);
		signupPanel.add(userNameIn);
		userNameIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 57, 71, 17);
		signupPanel.add(lblNewLabel);
		
		userIdIn = new JTextField();
		userIdIn.setBounds(116, 56, 129, 20);
		signupPanel.add(userIdIn);
		userIdIn.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(21, 104, 48, 14);
		signupPanel.add(lblAddress);
		
		userAddressIn = new JTextField();
		userAddressIn.setBounds(116, 87, 249, 50);
		signupPanel.add(userAddressIn);
		userAddressIn.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPhoneNumber.setBounds(21, 163, 92, 17);
		signupPanel.add(lblPhoneNumber);
		
		userPhoneNumberIn = new JTextField();
		userPhoneNumberIn.setBounds(116, 160, 129, 23);
		signupPanel.add(userPhoneNumberIn);
		userPhoneNumberIn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setToolTipText("Pasword must be between 6-10 character");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 210, 71, 14);
		signupPanel.add(lblNewLabel_1);
		
		userPasswordIn = new JTextField();
		userPasswordIn.setBounds(116, 207, 104, 20);
		signupPanel.add(userPasswordIn);
		userPasswordIn.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName;
				String userID;
				String userAddress;
				String phoneNumber;
				String password;
				int age;
				
				phoneNumber=userPhoneNumberIn.getText();
				password=userPasswordIn.getText();
				userName = userNameIn.getText();
				userID=userIdIn.getText();
				userAddress= userAddressIn.getText();
				age=Integer.parseInt(ageIn.getText());			
				
				try {
					st.executeUpdate("INSERT INTO Customer  VALUES ('"+userName+"', '"+userAddress+"', '"+userID+"', '"+phoneNumber+"','"+ password+"','"+ age+"' )");					
					st.executeUpdate("select * from Customer");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c1.show(frmEventTicketManagement.getContentPane(), "1");


			}
		});
		btnRegister.setBounds(316, 17, 89, 23);
		signupPanel.add(btnRegister);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(316, 206, 89, 23);
		signupPanel.add(btnNewButton);
		
		ageIn = new JTextField();
		ageIn.setBounds(299, 161, 96, 20);
		signupPanel.add(ageIn);
		ageIn.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAge.setBounds(266, 164, 34, 14);
		signupPanel.add(lblAge);
		
		JPanel eventTypes = new JPanel();
		frmEventTicketManagement.getContentPane().add(eventTypes, "3");
		eventTypes.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		eventTypes.add(menuBar);
		
		JMenu mnMovies = new JMenu("Movies");
		menuBar.add(mnMovies);
		
		JMenuItem HellBoy = new JMenuItem("HellBoy");
		HellBoy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('HellBoy','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnMovies.add(HellBoy);
		
		JMenuItem Avengers = new JMenuItem("Avengers");
		Avengers.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Avengers','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMovies.add(Avengers);
		
		JMenuItem Ayla = new JMenuItem("Ayla");
		Ayla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Ayla','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMovies.add(Ayla);
		
		JMenuItem DedektifPikachu = new JMenuItem("Dedektif Pikachu");
		DedektifPikachu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values(''Dedektif Pikachu','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMovies.add(DedektifPikachu);
		
		JMenuItem GORA = new JMenuItem("GORA");
		GORA.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values(''GORA','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMovies.add(GORA);
		
		JMenu mnTheater = new JMenu("Theater");
		menuBar.add(mnTheater);
		
		JMenuItem GunesDogarken = new JMenuItem("G\u00FCne\u015F Do\u011Farken");
		GunesDogarken.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Guneþ Dogarken','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnTheater.add(GunesDogarken);
		
		JMenuItem YediKocalýHürmüz = new JMenuItem("Yedi Kocal\u0131 H\u00FCrm\u00FCz");
		YediKocalýHürmüz.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Yedi Kocalý Hürmüz','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnTheater.add(YediKocalýHürmüz);
		
		JMenuItem BirDelininHatýraDefteri = new JMenuItem("Bir Delinin Hat\u0131ra Defteri ");
		BirDelininHatýraDefteri.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Bir Delinin Hatýra Defteri','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnTheater.add(BirDelininHatýraDefteri);
		
		JMenuItem GugukKusu = new JMenuItem("Guguk Ku\u015Fu");
		GugukKusu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Guguk Kuþu','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnTheater.add(GugukKusu);
		
		JMenu mnNewMenu = new JMenu("Basketball Match");
		menuBar.add(mnNewMenu);
		
		JRadioButtonMenuItem FenerbahceEfes = new JRadioButtonMenuItem("Fenerbah\u00E7e \u00DClker-Anadolu Efes");
		FenerbahceEfes.addMouseListener(new MouseAdapter() {
			@Override
			
				public void mousePressed(MouseEvent e) {
					try {
						st.executeUpdate("insert into get values('Fenerbahçe Ülker-Anadolu Efes','"+ userLogin+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		mnNewMenu.add(FenerbahceEfes);
		
		JMenuItem ZalgrisOlympiakos = new JMenuItem("Zalgris Kaunas -Olympiakos");
		ZalgrisOlympiakos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Zalgris Kaunas-Anadolu Efes','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(ZalgrisOlympiakos);
		
		JMenuItem DarusafakaBanvit = new JMenuItem("Daru\u015Fafaka Do\u011Fu\u015F-Banvit");
		DarusafakaBanvit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Daruþafaka Doðuþ-Banvit','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(DarusafakaBanvit);
		
		JMenuItem TurkTelekomBesiktas = new JMenuItem("T\u00FCrk Telekom-Be\u015Fikta\u015F Sompo Japan");
		TurkTelekomBesiktas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Türk Telekom -Beþiktaþ Sompo Japan','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mnNewMenu.add(TurkTelekomBesiktas);
		
		JMenu mnBasketballMatch = new JMenu("Football Match");
		menuBar.add(mnBasketballMatch);
		
		JMenuItem FenerbahceKonyaspor = new JMenuItem("Fenerbah\u00E7e-Atiker Konyaspor");
		FenerbahceKonyaspor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Fenerbahçe-Konyaspor','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnBasketballMatch.add(FenerbahceKonyaspor);
		
		JMenuItem TrabzonsporAnkaragucu = new JMenuItem("Trabzonspor-Ankarag\u00FCc\u00FC");
		TrabzonsporAnkaragucu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Trabzonspor-Ankaragücü','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnBasketballMatch.add(TrabzonsporAnkaragucu);
		
		JMenuItem BursasporKonyaspor = new JMenuItem("Bursaspor-Konyaspor");
		BursasporKonyaspor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Bursaspor-Konyaspor','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnBasketballMatch.add(BursasporKonyaspor);
		
		JMenuItem BesiktasLiverpool = new JMenuItem("Be\u015Fikta\u015F-Liverpool");
		BesiktasLiverpool.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Beþiktaþ-Liverpool','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnBasketballMatch.add(BesiktasLiverpool);
		
		JMenu mnConcert = new JMenu("Concert");
		menuBar.add(mnConcert);
		
		JMenuItem Teoman = new JMenuItem("Teoman");
		Teoman.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Teoman','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConcert.add(Teoman);
		
		JMenuItem Ezhel = new JMenuItem("Ezhel");
		Ezhel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Ezhel','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConcert.add(Ezhel);
		
		JMenuItem HalukLevent = new JMenuItem("Haluk Levent");
		HalukLevent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Haluk Levent','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConcert.add(HalukLevent);
		
		JMenuItem SenaSener = new JMenuItem("Sena \u015Eener");
		SenaSener.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					st.executeUpdate("insert into get values('Sena Þener','"+ userLogin+"')");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConcert.add(SenaSener);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(335, 227, 89, 23);
		eventTypes.add(btnQuit);
		
		JButton btnMyevent = new JButton("MyEvent");
		btnMyevent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(frmEventTicketManagement.getContentPane(), "4");
				EventScrollPane = TableCreator.createPanelWithResultSet(conn, "select eventname from get where customer_ýd="+userLogin);
				EventPane.remove(EventScrollPane);
				EventPane.add(EventScrollPane);
				EventScrollPane.validate();
				System.out.println(EventScrollPane.getComponentCount());
				
				EventPane.validate();
			}
		});
		btnMyevent.setBounds(335, 33, 89, 23);
		eventTypes.add(btnMyevent);
		
		 EventPane = new JPanel();
		frmEventTicketManagement.getContentPane().add(EventPane, "4");
		EventPane.setLayout(null);
		
		EventScrollPane = new JScrollPane();
		EventScrollPane.setBounds(10, 11, 403, 197);
		EventPane.add(EventScrollPane);
		
		JButton btnQuit_1 = new JButton("Quit");
		btnQuit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnQuit_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnQuit_1.setBounds(324, 219, 89, 23);
		EventPane.add(btnQuit_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(frmEventTicketManagement.getContentPane(), "3");

			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBack.setBounds(20, 219, 89, 23);
		EventPane.add(btnBack);
		
		JPanel warningPanel = new JPanel();
		frmEventTicketManagement.getContentPane().add(warningPanel, "5");
		warningPanel.setLayout(null);
		
		txtSomethingWentWrong = new JTextField();
		txtSomethingWentWrong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtSomethingWentWrong.setText("Something went wrong please check you ID and Password again..");
		txtSomethingWentWrong.setBounds(27, 44, 376, 49);
		warningPanel.add(txtSomethingWentWrong);
		txtSomethingWentWrong.setColumns(10);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(frmEventTicketManagement.getContentPane(), "1");

			}
		});
		btnTryAgain.setBounds(47, 205, 89, 23);
		warningPanel.add(btnTryAgain);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(frmEventTicketManagement.getContentPane(), "2");

			}
		});
		btnSignUp.setBounds(276, 205, 89, 23);
		warningPanel.add(btnSignUp);
		
		txtDoYouHave = new JTextField();
		txtDoYouHave.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtDoYouHave.setText("Do you have account?");
		txtDoYouHave.setBounds(249, 164, 128, 30);
		warningPanel.add(txtDoYouHave);
		txtDoYouHave.setColumns(10);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
