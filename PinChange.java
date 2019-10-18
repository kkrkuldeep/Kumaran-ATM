package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class PinChange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField reEnterPinTf;
	private JPasswordField newPinTf;
	private JPasswordField currentPinTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
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
	public PinChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChangeYourPin = new JLabel("CHANGE YOUR PIN");
		lblChangeYourPin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChangeYourPin.setBounds(151, 112, 255, 40);
		contentPane.add(lblChangeYourPin);

		JLabel lblCurrentPin = new JLabel("Current Pin :");
		lblCurrentPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentPin.setBounds(93, 198, 85, 31);
		contentPane.add(lblCurrentPin);

		currentPinTf = new JPasswordField();
		currentPinTf.setColumns(10);
		currentPinTf.setBounds(225, 205, 181, 24);
		contentPane.add(currentPinTf);

		JLabel lblNewPin = new JLabel("New Pin : ");
		lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPin.setBounds(93, 240, 85, 31);
		contentPane.add(lblNewPin);

		newPinTf = new JPasswordField();
		newPinTf.setColumns(10);
		newPinTf.setBounds(225, 247, 181, 24);
		contentPane.add(newPinTf);

		JLabel lblReenterNewPin = new JLabel("Re-Enter New PIN : ");
		lblReenterNewPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReenterNewPin.setBounds(93, 282, 122, 31);
		contentPane.add(lblReenterNewPin);

		reEnterPinTf = new JPasswordField();
		reEnterPinTf.setBounds(225, 287, 181, 24);
		contentPane.add(reEnterPinTf);
		reEnterPinTf.setColumns(10);

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (currentPinTf.getText().equals(Index.getPintf())
						&& newPinTf.getText().equals(reEnterPinTf.getText())) {

					System.out.println(Index.getPintf());
					Connection con = ATMDataBaseConnection.JAVAConnection();
					String query = "UPDATE accdetails SET pin=? WHERE pin=?";
					try {
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1, newPinTf.getText());
						pst.setString(2, currentPinTf.getText());
						pst.executeUpdate();
						
						currentPinTf.setText(null);
						newPinTf.setText(null);
						reEnterPinTf.setText(null);
						JOptionPane.showMessageDialog(null, "PIN has been successfully changed");

					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e1);
					}
				} else {
					if (!currentPinTf.getText().equals(Index.getPintf()))
						JOptionPane.showMessageDialog(null, "Current pin is incorrect");
					if (!newPinTf.getText().equals(reEnterPinTf.getText()))
						JOptionPane.showMessageDialog(newPinTf, "New pin and Re-Enter pin is not same");
				}
			}
		});
		btnSave.setForeground(new Color(0, 102, 255));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(163, 372, 103, 36);
		contentPane.add(btnSave);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 102, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(303, 372, 103, 36);
		contentPane.add(btnBack);
		setLocationRelativeTo(null);
	}

}
