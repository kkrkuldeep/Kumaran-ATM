package KumaranATM;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignupPersonalDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField countertf;
	private JTextField nametf;
	private JTextField fnametf;
	private JTextField emailtf;
	private JTextField addresstf;
	private JTextField citytf;
	private JTextField pintf;
	private JTextField statetf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupPersonalDetails frame = new SignupPersonalDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SignupPersonalDetails() {
		setBackground(SystemColor.controlHighlight);
		setTitle("New Account Application Form - Page : 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblApplicationForm = new JLabel("APPLICATION FORM NUMBER : ");
		lblApplicationForm.setBackground(Color.WHITE);
		lblApplicationForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApplicationForm.setBounds(72, 11, 468, 37);
		contentPane.add(lblApplicationForm);

		countertf = new JTextField();
		countertf.setEditable(false);
		countertf.setBackground(Color.WHITE);
		countertf.setBounds(394, 23, 86, 20);
		contentPane.add(countertf);
		countertf.setColumns(10);

		countertf.setText("1");

		JLabel lblPage = new JLabel("Page 1 : Personal Details");
		lblPage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPage.setBounds(183, 59, 297, 37);
		contentPane.add(lblPage);

		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(36, 113, 80, 37);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("Father's name : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 161, 99, 37);
		contentPane.add(lblNewLabel);

		JLabel lblDateOfBirth = new JLabel("Date of Birth : ");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(36, 211, 99, 39);
		contentPane.add(lblDateOfBirth);

		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(35, 261, 100, 37);
		contentPane.add(lblGender);

		JLabel lblEmailid = new JLabel("Email-Id : ");
		lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailid.setBounds(36, 309, 99, 35);
		contentPane.add(lblEmailid);

		JLabel lblMartialStatus = new JLabel("Martial Status : ");
		lblMartialStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMartialStatus.setBounds(36, 355, 99, 37);
		contentPane.add(lblMartialStatus);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(36, 403, 99, 37);
		contentPane.add(lblAddress);

		JLabel lblCity = new JLabel("City : ");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(36, 451, 99, 37);
		contentPane.add(lblCity);

		JLabel lblPin = new JLabel("Pin : ");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPin.setBounds(36, 499, 99, 37);
		contentPane.add(lblPin);

		JLabel lblState = new JLabel("State : ");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(36, 547, 99, 37);
		contentPane.add(lblState);

		nametf = new JTextField();
		nametf.setBounds(183, 123, 312, 27);
		contentPane.add(nametf);
		nametf.setColumns(10);

		fnametf = new JTextField();
		fnametf.setColumns(10);
		fnametf.setBounds(183, 171, 312, 27);
		contentPane.add(fnametf);

		emailtf = new JTextField();
		emailtf.setColumns(10);
		emailtf.setBounds(183, 318, 312, 27);
		contentPane.add(emailtf);

		addresstf = new JTextField();
		addresstf.setColumns(10);
		addresstf.setBounds(183, 413, 312, 27);
		contentPane.add(addresstf);

		citytf = new JTextField();
		citytf.setColumns(10);
		citytf.setBounds(183, 461, 312, 27);
		contentPane.add(citytf);

		pintf = new JTextField();
		pintf.setColumns(10);
		pintf.setBounds(183, 509, 312, 27);
		contentPane.add(pintf);

		statetf = new JTextField();
		statetf.setColumns(10);
		statetf.setBounds(183, 557, 312, 27);
		contentPane.add(statetf);

		ButtonGroup genderGroup = new ButtonGroup();

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnMale.setBounds(183, 270, 79, 23);
		contentPane.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(277, 270, 107, 23);
		contentPane.add(rdbtnFemale);

		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(386, 270, 109, 23);
		contentPane.add(rdbtnOther);

		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		genderGroup.add(rdbtnOther);

		JComboBox<Integer> daycb = new JComboBox<Integer>();
		daycb.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		daycb.setBounds(213, 222, 49, 20);
		contentPane.add(daycb);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(183, 225, 46, 14);
		contentPane.add(lblDate);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(277, 225, 46, 14);
		contentPane.add(lblMonth);

		JComboBox<String> monthcb = new JComboBox<String>();
		monthcb.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December" }));
		monthcb.setBounds(313, 222, 86, 20);
		contentPane.add(monthcb);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(409, 225, 46, 14);
		contentPane.add(lblYear);

		JComboBox<Integer> yearcb = new JComboBox<Integer>();
		yearcb.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986",
				"1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
		yearcb.setBounds(436, 222, 59, 20);
		contentPane.add(yearcb);

		ButtonGroup martial = new ButtonGroup();

		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setBounds(183, 364, 80, 23);
		contentPane.add(rdbtnMarried);

		JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setBounds(277, 364, 109, 23);
		contentPane.add(rdbtnUnmarried);
		setLocationRelativeTo(null);

		martial.add(rdbtnMarried);
		martial.add(rdbtnUnmarried);

		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = ATMDataBaseConnection.JAVAConnection();
				try {

					String query = "Insert into pdetails (name,fname,dob,gender,email,martialstatus,address,city,pincode,state) values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, nametf.getText());
					pst.setString(2, fnametf.getText());
					pst.setString(3, daycb.getSelectedItem().toString() + "-" + monthcb.getSelectedItem().toString()
							+ "-" + yearcb.getSelectedItem().toString());

					String gender = "";
					if (rdbtnMale.isSelected())
						gender = "Male";
					else if (rdbtnFemale.isSelected())
						gender = "Female";
					else if (rdbtnOther.isSelected())
						gender = "Other";
					else
						JOptionPane.showMessageDialog(null, "Please, Enter gender");

					pst.setString(4, gender);
					pst.setString(5, emailtf.getText());

					String martial = "";
					if (rdbtnMarried.isSelected())
						martial = "Married";
					else if (rdbtnUnmarried.isSelected())
						martial = "Unmarried";
					else
						JOptionPane.showMessageDialog(null, "Please, Select martial status");

					pst.setString(6, martial);
					pst.setString(7, addresstf.getText());
					pst.setString(8, citytf.getText());
					pst.setString(9, pintf.getText());
					pst.setString(10, statetf.getText());

					if (checkAuthentications()) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Page 1 successfully completed");
						dispose();
						SignupAdditionDetails signAdd = new SignupAdditionDetails();
						signAdd.setVisible(true);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(396, 601, 99, 38);
		contentPane.add(btnNewButton);

	}

	boolean checkAuthentications() {
		if (nametf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your name");
			return false;
		}
		if (fnametf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your father's name");
			return false;
		}
		if (emailtf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your E-Mail id");
			return false;
		}
		if (addresstf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your address");
			return false;
		}
		if (citytf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your city");
			return false;
		}
		if (pintf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter your pin");
			return false;
		}
		if (statetf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your state");
			return false;
		}
		return true;
	}
}
