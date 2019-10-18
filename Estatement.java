package KumaranATM;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estatement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea reciptta;
	private String[] args;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estatement frame = new Estatement(0);
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
	public Estatement(int amount) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel bankLogo = new JLabel("");
		bankLogo.setBounds(27, 37, 489, 143);

		ImageIcon image = new ImageIcon(
				new ImageIcon("receiptLogo.jpg").getImage().getScaledInstance(489, 143, java.awt.Image.SCALE_SMOOTH));
		bankLogo.setIcon(image);

		contentPane.add(bankLogo);

		reciptta = new JTextArea();
		reciptta.setEditable(false);
		reciptta.setBounds(27, 223, 489, 327);
		reciptDetails(amount);
		contentPane.add(reciptta);

		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		back.setForeground(new Color(0, 102, 255));
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setBounds(134, 581, 103, 36);
		contentPane.add(back);

		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setForeground(new Color(0, 102, 255));
		exit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exit.setBounds(282, 581, 103, 36);
		contentPane.add(exit);

	}

	public void reciptDetails(int withAmt) {
		int balance = 0;

		Connection con = ATMDataBaseConnection.JAVAConnection();
		String checkBalanceQuery = "select balance from customerdata where cardNum =?";
		try {
			PreparedStatement pst = con.prepareStatement(checkBalanceQuery);
			pst.setString(1, Index.getCardtf());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				balance = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		CardAcountNumberGenerator.main(args);

		reciptta.setText(receiptBegin() + "Account Number   :      " + CardAcountNumberGenerator.getcardNumber()
				+ "\n\n" + "Withdraw Amount  :     " + withAmt + "\n\n" + "Balance                   :     " + balance
				+ "\n\n" + receiptEnd());
	}

	String receiptBegin() {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-LL-yyyy");
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter tf = DateTimeFormatter.ofPattern("KK:mm a");
		String begin = "=====================================================================\n\n"
				+ "Date	                 Time                                              ATMID\n\n"
				+ localDate.format(df) + "	                 " + localTime.format(tf)
				+ "                                 " + "KUMAR125\n\n" + "TXN Number          :     1100451258\n\n";
		return begin;
	}

	String receiptEnd() {
		String end = "PURCHASE GOODS AND SERVICES WITH DEBIT CARD AND ENJOY FABULOUS \n\n "
				+ "LOYALITY REAWRD PAIRS. FREE ACCIDENTAL INSURANCE FOR KUMARAN \n\n"
				+ "ACTIVE DEBIT CARD HOLDER USE YOUR DEBIT CARD ON REGULAR BASES.";
		return end;
	}
}
