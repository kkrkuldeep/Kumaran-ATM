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
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class FastCash extends JFrame {

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
					FastCash frame = new FastCash();
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
	public FastCash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelectWithrdawalAmount = new JLabel("SELECT WITHRDAWAL AMOUNT");
		lblSelectWithrdawalAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSelectWithrdawalAmount.setBounds(64, 45, 417, 57);
		contentPane.add(lblSelectWithrdawalAmount);

		JButton button = new JButton("\u20B9 100");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(100);
			}
		});
		button.setForeground(new Color(0, 102, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(64, 156, 151, 51);
		contentPane.add(button);

		JButton button_1 = new JButton("\u20B9 1500");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(1500);
			}
		});
		button_1.setForeground(new Color(0, 102, 255));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(308, 156, 151, 51);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u20B9 500");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(500);
			}
		});
		button_2.setForeground(new Color(0, 102, 255));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(64, 242, 151, 51);
		contentPane.add(button_2);

		JButton button_3 = new JButton("\u20B9 5000");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(5000);
			}
		});
		button_3.setForeground(new Color(0, 102, 255));
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBounds(308, 242, 151, 51);
		contentPane.add(button_3);

		JButton button_4 = new JButton("\u20B9 1000");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(1000);
			}
		});
		button_4.setForeground(new Color(0, 102, 255));
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_4.setBounds(64, 332, 151, 51);
		contentPane.add(button_4);

		JButton button_5 = new JButton("\u20B9 10,000");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawMoneyFromAccount(10000);
			}
		});
		button_5.setForeground(new Color(0, 102, 255));
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_5.setBounds(308, 332, 151, 51);
		contentPane.add(button_5);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(new Color(0, 102, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(322, 468, 123, 51);
		contentPane.add(btnExit);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 102, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(79, 468, 123, 51);
		contentPane.add(btnBack);
		setLocationRelativeTo(null);
	}

	public void withdrawMoneyFromAccount(int withdrawAmount) {

		String checkBalance = "Select balance from customerdata where cardNum = ?";

		Connection con = ATMDataBaseConnection.JAVAConnection();

		try {
			String cardNumber = Index.getCardtf();

			PreparedStatement pst = con.prepareStatement(checkBalance);
			pst.setString(1, cardNumber);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int balance = Integer.valueOf(rs.getString(1));

				if (balance < 100) {
					JOptionPane.showMessageDialog(null, "Insufficient Amount : Your current balance is " + balance);
					return;
				}
				if (withdrawAmount < balance) {
					balance = balance - withdrawAmount;
					String updateBalance = "UPDATE customerdata SET balance=?,withdrawAmt=?,depositAmt=? WHERE cardNum=?";
					pst = con.prepareStatement(updateBalance);
					pst.setInt(1, balance);
					pst.setInt(2, withdrawAmount);
					pst.setInt(3, 0);
					pst.setString(4, cardNumber);
					pst.executeUpdate();

					// made a statement

					String[] recepit = new String[4];
					recepit[0] = String.valueOf(withdrawAmount);
					recepit[1] = "----";
					LocalDateTime date = LocalDateTime.now();
					recepit[2] = date.toString();
					recepit[3] = "----";

					JOptionPane.showMessageDialog(null,
							"Rs. " + withdrawAmount + " successfully withdrawl from your account");

					System.out.println("Withdraw Amount :\t" + withdrawAmount);

					dispose();
					Mailer.sendMail(withdrawAmount, 0);
					Estatement es = new Estatement(withdrawAmount);
					es.setVisible(true);
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
	}
}
