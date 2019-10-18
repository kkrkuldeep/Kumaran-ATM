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
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class Withdrawn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField withdrawtf;

	public static String getWithdraw() {
		final String amt = withdrawtf.getText();
		return amt;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawn frame = new Withdrawn();
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
	public Withdrawn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaximumDailyWithdrawal = new JLabel("MAXIMUM DAILY WITHDRAWAL");
		lblMaximumDailyWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMaximumDailyWithdrawal.setBounds(65, 46, 406, 59);
		contentPane.add(lblMaximumDailyWithdrawal);

		JLabel lblIs = new JLabel("IS \u20B9 10,000");
		lblIs.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblIs.setBounds(179, 99, 173, 31);
		contentPane.add(lblIs);

		JLabel lblPleaseEnetrThe = new JLabel("PLEASE ENTER YOUR AMOUNT");
		lblPleaseEnetrThe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPleaseEnetrThe.setBounds(86, 200, 385, 47);
		contentPane.add(lblPleaseEnetrThe);

		withdrawtf = new JTextField();
		withdrawtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawtf.setBounds(147, 281, 257, 38);
		contentPane.add(withdrawtf);
		withdrawtf.setColumns(10);

		JButton btnWithdraw = new JButton("WITHDRAWAL");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String withdrawAmtFromBox = getWithdraw();
				int withdrawAmount = Integer.parseInt(withdrawAmtFromBox);

				// Check withdrawal amount

				if (withdrawAmount < 99 || (withdrawAmount % 100 != 0)) {
					JOptionPane.showMessageDialog(null, "The Amount must be a multiple of 100");
					return;
				}

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
							JOptionPane.showMessageDialog(null,
									"Insufficient Amount : Your current balance is " + balance);
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
							System.out.println("Withdrawal Amount :\t" + withdrawAmount);
							dispose();
							Mailer.sendMail(withdrawAmount, 0);
							Estatement es = new Estatement(withdrawAmount);
							es.setVisible(true);
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}

				// try ends here

			}
		});
		btnWithdraw.setForeground(new Color(0, 102, 255));
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWithdraw.setBounds(147, 362, 133, 36);
		contentPane.add(btnWithdraw);

		JButton bntback = new JButton("CLEAR");
		bntback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawtf.setText(null);
			}
		});
		bntback.setForeground(new Color(0, 102, 255));
		bntback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntback.setBounds(290, 362, 114, 36);
		contentPane.add(bntback);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(new Color(0, 102, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(215, 508, 138, 36);
		contentPane.add(btnExit);

		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		button.setForeground(new Color(0, 102, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(215, 424, 114, 36);
		contentPane.add(button);
		setLocationRelativeTo(null);
	}
}
