package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class SignupAccountDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static StringBuilder pinNumber, textBoxCardNumber, cardNumber;
	private JPanel contentPane;
	private JTextField cardnumtf;
	private JTextField pintf;
	private String[] args;
	private JCheckBox chckbxDeclare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupAccountDetails frame = new SignupAccountDetails();
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
	public SignupAccountDetails() {
		setTitle("New Account Application Form - Page : 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPage = new JLabel("Page : 3 Accout Type");
		lblPage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPage.setBounds(148, 11, 219, 31);
		contentPane.add(lblPage);

		JLabel lblAccountType = new JLabel("Account Type : ");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccountType.setBounds(45, 53, 136, 37);
		contentPane.add(lblAccountType);

		ButtonGroup AccountTypeGroup = new ButtonGroup();

		JRadioButton rdbtnSavingAccount = new JRadioButton("Saving Account");
		rdbtnSavingAccount.setSelected(true);
		rdbtnSavingAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSavingAccount.setBounds(45, 97, 136, 23);
		contentPane.add(rdbtnSavingAccount);

		JRadioButton rdbtnFixedDepositeAccount = new JRadioButton("Fixed Deposit Account");
		rdbtnFixedDepositeAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFixedDepositeAccount.setBounds(238, 97, 170, 23);
		contentPane.add(rdbtnFixedDepositeAccount);

		JRadioButton rdbtnCurrentaccount = new JRadioButton("Current Account");
		rdbtnCurrentaccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnCurrentaccount.setBounds(45, 137, 136, 23);
		contentPane.add(rdbtnCurrentaccount);

		JRadioButton rdbtnRecurringDepositeAccount = new JRadioButton("Recurring Deposit Account");
		rdbtnRecurringDepositeAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnRecurringDepositeAccount.setBounds(238, 137, 184, 23);
		contentPane.add(rdbtnRecurringDepositeAccount);

		AccountTypeGroup.add(rdbtnSavingAccount);
		AccountTypeGroup.add(rdbtnCurrentaccount);
		AccountTypeGroup.add(rdbtnFixedDepositeAccount);
		AccountTypeGroup.add(rdbtnRecurringDepositeAccount);

		JLabel lblCardNumber = new JLabel("Card Number : ");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardNumber.setBounds(45, 188, 136, 37);
		contentPane.add(lblCardNumber);

		CardAcountNumberGenerator.main(args);

		cardnumtf = new JTextField("XXXX-XXXX-XXXX-" + CardAcountNumberGenerator.gettextBoxCardNumber().toString());
		cardnumtf.setEditable(false);
		cardnumtf.setBackground(SystemColor.menu);
		cardnumtf.setFont(new Font("Tahoma", Font.BOLD, 14));
		cardnumtf.setBounds(183, 195, 225, 27);
		contentPane.add(cardnumtf);
		cardnumtf.setColumns(10);

		JLabel lblNewLabel = new JLabel("(Your 16-digit card number)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(45, 221, 119, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("It would appear on ATM card/Cheque Book and Statements");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(183, 221, 250, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblPin = new JLabel("PIN : ");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPin.setBounds(45, 264, 119, 37);
		contentPane.add(lblPin);

		pintf = new JTextField("XXXX");
		pintf.setEditable(false);
		pintf.setForeground(Color.BLACK);
		pintf.setBackground(SystemColor.menu);
		pintf.setFont(new Font("Tahoma", Font.BOLD, 14));
		pintf.setBounds(183, 274, 61, 27);
		contentPane.add(pintf);
		pintf.setColumns(10);

		JLabel lblyourdigitPin = new JLabel("(Your 4-digit Pin number)");
		lblyourdigitPin.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblyourdigitPin.setBounds(45, 306, 119, 14);
		contentPane.add(lblyourdigitPin);

		JLabel lblServiceRequired = new JLabel("Service Required : ");
		lblServiceRequired.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblServiceRequired.setBounds(45, 345, 136, 37);
		contentPane.add(lblServiceRequired);

		JCheckBox chckbxAtmCard = new JCheckBox("ATM Card");
		chckbxAtmCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxAtmCard.setBounds(45, 389, 97, 23);
		contentPane.add(chckbxAtmCard);

		JCheckBox chckbxInternetBanking = new JCheckBox("Internet Banking");
		chckbxInternetBanking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxInternetBanking.setBounds(183, 389, 136, 23);
		contentPane.add(chckbxInternetBanking);

		JCheckBox chckbxMobileBanking = new JCheckBox("Mobile Banking");
		chckbxMobileBanking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxMobileBanking.setBounds(45, 430, 119, 23);
		contentPane.add(chckbxMobileBanking);

		JCheckBox chckbxEmailAlerts = new JCheckBox("Email Alerts");
		chckbxEmailAlerts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxEmailAlerts.setBounds(183, 430, 119, 23);
		contentPane.add(chckbxEmailAlerts);

		JCheckBox chckbxChequeBook = new JCheckBox("Cheque Book");
		chckbxChequeBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxChequeBook.setBounds(45, 472, 119, 23);
		contentPane.add(chckbxChequeBook);

		JCheckBox chckbxEstatements = new JCheckBox("E-Statements");
		chckbxEstatements.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxEstatements.setBounds(183, 472, 119, 23);
		contentPane.add(chckbxEstatements);

		chckbxDeclare = new JCheckBox("I hereby declare that the above entered details are");
		chckbxDeclare.setForeground(Color.DARK_GRAY);
		chckbxDeclare.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxDeclare.setBounds(99, 529, 309, 31);
		contentPane.add(chckbxDeclare);

		JLabel lblCorrectToThe = new JLabel("correct to the best of my knowledge.");
		lblCorrectToThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorrectToThe.setForeground(Color.DARK_GRAY);
		lblCorrectToThe.setBounds(123, 555, 274, 23);
		contentPane.add(lblCorrectToThe);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection con = ATMDataBaseConnection.JAVAConnection();
				String insertQuery = "Insert into accdetails (Account_type,card_number,pin,services) values (?,?,?,?)";
				try {
					PreparedStatement pst = con.prepareStatement(insertQuery);

					String accoutn_type = "";
					Enumeration<AbstractButton> allRadioButtons = AccountTypeGroup.getElements();
					while (allRadioButtons.hasMoreElements()) {
						JRadioButton temp = (JRadioButton) allRadioButtons.nextElement();
						if (temp.isSelected()) {
							accoutn_type = temp.getText();
						}
					}

					pst.setString(1, accoutn_type);
					pst.setString(2, CardAcountNumberGenerator.getcardNumber().toString());
					pst.setString(3, CardAcountNumberGenerator.getpinNumber().toString());

					StringBuilder services = new StringBuilder();
					if (chckbxAtmCard.isSelected())
						services.append(chckbxAtmCard.getText());
					if (chckbxInternetBanking.isSelected())
						services.append(", " + chckbxInternetBanking.getText());
					if (chckbxMobileBanking.isSelected())
						services.append(", " + chckbxMobileBanking.getText());
					if (chckbxEmailAlerts.isSelected())
						services.append(", " + chckbxEmailAlerts.getText());
					if (chckbxChequeBook.isSelected())
						services.append(", " + chckbxChequeBook.getText());
					if (chckbxEstatements.isSelected())
						services.append(", " + chckbxEstatements.getText());

					pst.setString(4, services.toString());

					if (checkAuthenticationAcc()) {
						pst.executeUpdate();

						String insertCustomerdata = "INSERT into customerdata  (cardNum,depositAmt,withdrawAmt,balance) VALUES (?,?,?,?);";
						pst = con.prepareStatement(insertCustomerdata);
						pst.setString(1, CardAcountNumberGenerator.getcardNumber().toString());
						pst.setInt(2, 0);
						pst.setInt(3, 0);
						pst.setInt(4, 0);

						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Thank you for choosing us.");
						JOptionPane.showMessageDialog(null, "Please collect your belongings from the Bank");
						dispose();
						Index index = new Index();
						index.setVisible(true);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(170, 589, 97, 31);
		contentPane.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(289, 589, 97, 31);
		contentPane.add(btnCancel);
		setLocationRelativeTo(null);

	} // Contrutor Ends here

	boolean checkAuthenticationAcc() {
		if (chckbxDeclare.isSelected()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Please, Select the declration message");
			return false;
		}
	}

} // class ends here
