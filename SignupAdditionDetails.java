package KumaranATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignupAdditionDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pantf;
	private JTextField aadhaartf;
	private String religion, category, income, education, occupation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupAdditionDetails frame = new SignupAdditionDetails();
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
	public SignupAdditionDetails() {
		setTitle("New Account Application Form - Page : 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPage = new JLabel("Page : 2 Additional Details");
		lblPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPage.setBounds(164, 11, 237, 34);
		contentPane.add(lblPage);

		JLabel lblRelation = new JLabel("Religion :");
		lblRelation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRelation.setBounds(42, 78, 98, 34);
		contentPane.add(lblRelation);

		JLabel lblCategory = new JLabel("Category : ");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(42, 121, 98, 34);
		contentPane.add(lblCategory);

		JLabel lblIncome = new JLabel("Income : ");
		lblIncome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIncome.setBounds(42, 166, 98, 34);
		contentPane.add(lblIncome);

		JLabel lblEducationQualification = new JLabel("Education");
		lblEducationQualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEducationQualification.setBounds(42, 211, 98, 34);
		contentPane.add(lblEducationQualification);

		JLabel lblOccpation = new JLabel("Occupation : ");
		lblOccpation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOccpation.setBounds(42, 286, 98, 34);
		contentPane.add(lblOccpation);

		JLabel lblPanNumber = new JLabel("Pan Number : ");
		lblPanNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPanNumber.setBounds(42, 331, 115, 34);
		contentPane.add(lblPanNumber);

		JLabel lblAadhaarNumber = new JLabel("Aadhaar Number : ");
		lblAadhaarNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAadhaarNumber.setBounds(42, 376, 148, 34);
		contentPane.add(lblAadhaarNumber);

		JLabel lblSeniorCitizen = new JLabel("Senior Citizen : ");
		lblSeniorCitizen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeniorCitizen.setBounds(42, 426, 148, 34);
		contentPane.add(lblSeniorCitizen);

		JLabel lblExisting = new JLabel("Existing Account : ");
		lblExisting.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExisting.setBounds(42, 471, 148, 34);
		contentPane.add(lblExisting);

		JLabel lblQualification = new JLabel("Qualification : ");
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQualification.setBounds(42, 231, 110, 47);
		contentPane.add(lblQualification);

		JComboBox<String> religioncb = new JComboBox<String>();
		religioncb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		religioncb.setModel(
				new DefaultComboBoxModel(new String[] { "Select ", "Hindu", "Muslim", "Sikh", "Christian", "Others" }));
		religioncb.setBounds(200, 87, 275, 25);
		contentPane.add(religioncb);

		JComboBox<String> categorycb = new JComboBox<String>();
		categorycb
				.setModel(new DefaultComboBoxModel(new String[] { "Select", "General", "OBC", "SC", "ST", "Others" }));
		categorycb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		categorycb.setBounds(200, 130, 275, 25);
		contentPane.add(categorycb);

		JComboBox<String> incomecb = new JComboBox<String>();
		incomecb.setModel(new DefaultComboBoxModel(new String[] { "Select", "Below > 1,00,000 ", "1,50,000 - 2,00,000",
				"2,00,000 - 4,00,000", "Above < 4,00,000" }));
		incomecb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		incomecb.setBounds(200, 175, 275, 25);
		contentPane.add(incomecb);

		JComboBox<String> educationcb = new JComboBox<String>();
		educationcb.setModel(new DefaultComboBoxModel(new String[] { "Select", "Student", "Non-Graduate", "Graduate",
				"Post-Graduate", "Doctrate", "Others" }));
		educationcb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		educationcb.setBounds(200, 231, 275, 25);
		contentPane.add(educationcb);

		JComboBox<String> occupationcb = new JComboBox<String>();
		occupationcb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		occupationcb.setModel(new DefaultComboBoxModel(
				new String[] { "Select", "Salaried ", "Business", "Student", "Self-Employee", "Others" }));
		occupationcb.setBounds(200, 295, 275, 25);
		contentPane.add(occupationcb);

		pantf = new JTextField();
		pantf.setBounds(200, 340, 275, 25);
		contentPane.add(pantf);
		pantf.setColumns(10);

		aadhaartf = new JTextField();
		aadhaartf.setColumns(10);
		aadhaartf.setBounds(200, 385, 275, 25);
		contentPane.add(aadhaartf);

		ButtonGroup seniorGroup = new ButtonGroup();

		JRadioButton rdbtnSeniorYes = new JRadioButton("Yes");
		rdbtnSeniorYes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSeniorYes.setBounds(196, 434, 109, 23);
		contentPane.add(rdbtnSeniorYes);

		JRadioButton rdbtnSeniorNo = new JRadioButton("No");
		rdbtnSeniorNo.setSelected(true);
		rdbtnSeniorNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSeniorNo.setBounds(307, 434, 109, 23);
		contentPane.add(rdbtnSeniorNo);

		seniorGroup.add(rdbtnSeniorYes);
		seniorGroup.add(rdbtnSeniorNo);

		ButtonGroup accGroup = new ButtonGroup();

		JRadioButton rdbtnAccYes = new JRadioButton("Yes");
		rdbtnAccYes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAccYes.setBounds(196, 479, 109, 23);
		contentPane.add(rdbtnAccYes);

		JRadioButton rdbtnAccNo = new JRadioButton("No");
		rdbtnAccNo.setSelected(true);
		rdbtnAccNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAccNo.setBounds(307, 479, 109, 23);
		contentPane.add(rdbtnAccNo);

		accGroup.add(rdbtnAccYes);
		accGroup.add(rdbtnAccNo);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = ATMDataBaseConnection.JAVAConnection();
				try {
					String insertQuery = "Insert into adetails (religion,category,income,education,occupation,pan_number,aadhar_number,senior,existing_acc) values (?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(insertQuery);

					religion = religioncb.getSelectedItem().toString();
					category = categorycb.getSelectedItem().toString();
					income = incomecb.getSelectedItem().toString();
					education = educationcb.getSelectedItem().toString();
					occupation = occupationcb.getSelectedItem().toString();

					pst.setString(1, religion);
					pst.setString(2, category);
					pst.setString(3, income);
					pst.setString(4, education);
					pst.setString(5, occupation);
					pst.setString(6, pantf.getText());
					pst.setString(7, aadhaartf.getText());

					String senior = "", existing_acc = "";
					if (rdbtnSeniorYes.isSelected()) {
						senior = "Yes";
					} else {
						senior = "No";
					}

					pst.setString(8, senior);

					if (rdbtnAccYes.isSelected()) {
						existing_acc = "Yes";
					} else {
						existing_acc = "No";
					}

					pst.setString(9, existing_acc);

					if (checkAuthenticationAdd()) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Page 2 successfully completed");
						dispose();
						SignupAccountDetails signAcc = new SignupAccountDetails();
						signAcc.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Please, Fill the form correctly");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNext.setBounds(395, 527, 80, 34);
		contentPane.add(btnNext);
		setLocationRelativeTo(null);
	}

	boolean checkAuthenticationAdd() {

		if (religion.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Please, Select your religion");
			return false;
		}
		if (category.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Please, Select your category");
			return false;
		}
		if (income.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Please, Select your income");
			return false;
		}
		if (education.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Please, Select your education Qualification");
			return false;
		}
		if (occupation.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Please, Select your occupation");
			return false;
		}
		if (pantf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your pan number");
			return false;
		}
		if (aadhaartf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please, Enter your aadhaar number");
			return false;
		}
		return true;
	}
}
