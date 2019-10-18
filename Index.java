//9708-3823-7477-2945
//1234

package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Index extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField cardtf;
	private static JPasswordField pintf;

	public static String getCardtf() {
		return cardtf.getText();
	}

	@SuppressWarnings("deprecation")
	public static String getPintf() {
		return pintf.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {

		System.out.println("Welcome to Kumaran Bank");

		setTitle("Welcome to Kumaran Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToKumaran = new JLabel("Welcome To Kumaran Bank");
		lblWelcomeToKumaran.setForeground(new Color(30, 144, 255));
		lblWelcomeToKumaran.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWelcomeToKumaran.setBounds(218, 68, 325, 52);
		contentPane.add(lblWelcomeToKumaran);

		JLabel lblCardNumber = new JLabel("Card number : ");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardNumber.setBounds(75, 174, 120, 38);
		contentPane.add(lblCardNumber);

		JLabel lblPin = new JLabel("PIN : ");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPin.setBounds(75, 227, 106, 32);
		contentPane.add(lblPin);

		cardtf = new JTextField();
		cardtf.setBounds(205, 185, 233, 27);
		contentPane.add(cardtf);
		cardtf.setColumns(10);

		pintf = new JPasswordField();
		pintf.setBounds(205, 232, 233, 27);
		contentPane.add(pintf);
		pintf.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(173, 255, 47));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if (cardtf.getText().isEmpty() || pintf.getText().isEmpty()) {
					cardtf.setText(null);
					pintf.setText(null);
					JOptionPane.showMessageDialog(null, "Enter valid Card number and Pin number");
					return;
				}

				// Check query executed

				String checkQuery = "select card_number,pin from accdetails where card_number=? and pin=?";
				Connection con = ATMDataBaseConnection.JAVAConnection();
				try {
					PreparedStatement pst = con.prepareStatement(checkQuery);
					pst.setString(1, cardtf.getText());
					pst.setString(2, pintf.getText());

					ResultSet rs = pst.executeQuery();

					String registeredEmail = rs.getString(1);
					String registeredPassword = rs.getString(2);

					if (rs.next() == true) {
						if (registeredEmail.equals(cardtf.getText()) && registeredPassword.equals(pintf.getText())) {
							dispose();
							getCardtf();
							getPintf();
							Login log = new Login();
							log.setVisible(true);
						} else {
							cardtf.setText(null);
							pintf.setText(null);
							JOptionPane.showMessageDialog(null, "Please enter valid card number and pin");
							return;
						}
					}
				} catch (Exception e) {
					cardtf.setText(null);
					pintf.setText(null);
					JOptionPane.showMessageDialog(null, "Please enter valid card number and pin");
				}
			}
		});

		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(205, 283, 89, 38);
		contentPane.add(btnLogin);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardtf.setText(null);
				pintf.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(311, 285, 89, 36);
		contentPane.add(btnClear);

		JButton btnSign = new JButton("Signup");
		btnSign.setBackground(new Color(0, 255, 255));
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please fill the registration form carefully");
				dispose();
				SignupPersonalDetails spd = new SignupPersonalDetails();
				spd.setVisible(true);
			}
		});
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSign.setBounds(311, 332, 89, 38);
		contentPane.add(btnSign);

		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(
				new ImageIcon("Bank-icon.png").getImage().getScaledInstance(156, 109, java.awt.Image.SCALE_SMOOTH));
		label.setIcon(image);
		label.setBounds(28, 41, 180, 122);
		contentPane.add(label);

		JLabel lblPleaseEnterCard = new JLabel("Please enter card number xxxx-xxxx-xxxx-xxxx");
		lblPleaseEnterCard.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPleaseEnterCard.setBounds(205, 212, 192, 17);
		contentPane.add(lblPleaseEnterCard);
		setLocationRelativeTo(null);

	}
}
