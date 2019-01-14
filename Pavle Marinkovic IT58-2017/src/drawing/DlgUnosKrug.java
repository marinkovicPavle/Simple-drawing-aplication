package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dialog.ModalityType;

public class DlgUnosKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;

	private boolean isOK;
	
	
	
	public JTextField getTxtPoluprecnik() {
		return txtPoluprecnik;
	}

	public void setTxtPoluprecnik(JTextField txtPoluprecnik) {
		this.txtPoluprecnik = txtPoluprecnik;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosKrug dialog = new DlgUnosKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosKrug() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Krug");
		setBounds(100, 100, 246, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[]"));
		{
			JLabel lblPoluprecnik = new JLabel("Unesite poluprecnik:");
			contentPanel.add(lblPoluprecnik, "cell 0 0,alignx trailing");
		}
		{
			txtPoluprecnik = new JTextField();
			txtPoluprecnik.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtPoluprecnik.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			contentPanel.add(txtPoluprecnik, "cell 1 0,alignx left");
			txtPoluprecnik.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtPoluprecnik.getText().isEmpty()) {
							isOK = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "Morate uneti poluprecnik!","Greska", JOptionPane.WARNING_MESSAGE);
						} else {
							isOK = true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
