package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField deptf;
	private JTextField cardnumtf;

	public static String getDepositf() {
		return deptf.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterAmountYou = new JLabel("ENTER AMOUNT YOU WANT");
		lblEnterAmountYou.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterAmountYou.setBounds(106, 98, 359, 73);
		contentPane.add(lblEnterAmountYou);

		JLabel lblToDeposit = new JLabel("TO DEPOSIT");
		lblToDeposit.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblToDeposit.setBounds(194, 156, 153, 36);
		contentPane.add(lblToDeposit);

		deptf = new JTextField();
		deptf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deptf.setBounds(246, 349, 250, 46);
		contentPane.add(deptf);
		deptf.setColumns(10);

		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Index.getCardtf().toString().equals(cardnumtf.getText())) {

					getDepositf();
					Connection con = ATMDataBaseConnection.JAVAConnection();
					String getbalance = "SELECT balance FROM customerdata WHERE cardNum=?";

					try {

						// check current balance

						PreparedStatement pst = con.prepareStatement(getbalance);
						pst.setString(1, cardnumtf.getText());
						ResultSet rs = pst.executeQuery();
						rs.next();
						int currentBalance = rs.getInt(1);

						// Update deposit and balance

						String updateBalance = "UPDATE customerdata SET depositAmt=?,balance=?,withdrawAmt=? WHERE cardNum=?";
						pst = con.prepareStatement(updateBalance);
						pst.setInt(1, Integer.parseInt(deptf.getText()));
						pst.setInt(2, currentBalance + Integer.parseInt(deptf.getText()));
						pst.setInt(3, 0);
						pst.setString(4, cardnumtf.getText());
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null,
								"Rs. " + deptf.getText() + " has been added to your account successfully");

						System.out.println("Deposit Amount :\t" + deptf.getText());

						Mailer.sendMail(0, Integer.valueOf(deptf.getText()));
						cardnumtf.setText(null);
						deptf.setText(null);

					} catch (Exception e2) {
						// TODO: handle exception
					}
				} else {
					JOptionPane.showMessageDialog(null, "Query Failed");
				}
			}
		});
		btnDeposit.setForeground(new Color(0, 102, 255));
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeposit.setBounds(248, 430, 114, 46);
		contentPane.add(btnDeposit);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 102, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(382, 430, 114, 46);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(new Color(0, 102, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(305, 506, 114, 46);
		contentPane.add(btnExit);

		cardnumtf = new JTextField();
		cardnumtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cardnumtf.setBounds(246, 269, 250, 47);
		contentPane.add(cardnumtf);
		cardnumtf.setColumns(10);

		JLabel lblCardNumber = new JLabel("CARD NUMBER :");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCardNumber.setBounds(106, 269, 130, 47);
		contentPane.add(lblCardNumber);

		JLabel lblDepositAmount = new JLabel("DEPOSIT AMOUNT :");
		lblDepositAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepositAmount.setBounds(106, 349, 130, 46);
		contentPane.add(lblDepositAmount);
		setLocationRelativeTo(null);
	}
}
