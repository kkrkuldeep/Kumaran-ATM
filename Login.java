package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Transaction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Transaction");
		lblPleaseSelectYour.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPleaseSelectYour.setBounds(72, 71, 414, 74);
		contentPane.add(lblPleaseSelectYour);

		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit deposit = new Deposit();
				deposit.setVisible(true);
				dispose();
			}
		});
		btnDeposit.setForeground(new Color(0, 102, 255));
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeposit.setBounds(54, 183, 192, 52);
		contentPane.add(btnDeposit);

		JButton btnCashWithdrawn = new JButton("CASH WITHDRAWAL");
		btnCashWithdrawn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawn withdraw = new Withdrawn();
				withdraw.setVisible(true);
				dispose();
			}
		});
		btnCashWithdrawn.setForeground(new Color(0, 102, 255));
		btnCashWithdrawn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCashWithdrawn.setBounds(282, 183, 204, 52);
		contentPane.add(btnCashWithdrawn);

		JButton btnFastCash = new JButton("FAST CASH");
		btnFastCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FastCash fastcash = new FastCash();
				fastcash.setVisible(true);
				dispose();
			}
		});
		btnFastCash.setForeground(new Color(0, 102, 255));
		btnFastCash.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFastCash.setBounds(54, 271, 192, 52);
		contentPane.add(btnFastCash);

		JButton btnMiniStatement = new JButton("MINI STATEMENT");
		btnMiniStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// MINI_Statement mini = new MINI_Statement();
				// mini.setVisible(true);

				Estatement es = new Estatement(0);
				es.setVisible(true);
				dispose();
			}
		});

		btnMiniStatement.setForeground(new Color(0, 102, 255));
		btnMiniStatement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMiniStatement.setBounds(282, 271, 204, 52);
		contentPane.add(btnMiniStatement);

		JButton btnPinChange = new JButton("PIN CHANGE");
		btnPinChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PinChange pin = new PinChange();
				pin.setVisible(true);
				dispose();
			}
		});
		btnPinChange.setForeground(new Color(0, 102, 255));
		btnPinChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPinChange.setBounds(54, 361, 192, 52);
		contentPane.add(btnPinChange);

		JButton btnBalanceEnquiry = new JButton("BALANCE ENQUIRY");
		btnBalanceEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = ATMDataBaseConnection.JAVAConnection();
				String checkBalanceQuery = "select balance from customerdata where cardNum =?";
				try {
					PreparedStatement pst = con.prepareStatement(checkBalanceQuery);
					pst.setString(1, Index.getCardtf());
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Your current balance : " + rs.getInt(1));
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnBalanceEnquiry.setForeground(new Color(0, 102, 255));
		btnBalanceEnquiry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBalanceEnquiry.setBounds(282, 361, 204, 52);
		contentPane.add(btnBalanceEnquiry);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(new Color(0, 102, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(170, 493, 163, 52);
		contentPane.add(btnExit);
		setLocationRelativeTo(null);
	}
}
