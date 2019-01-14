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
import java.awt.Dialog.ModalityType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgUnos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnos;
	private JTextField txtUnos1;
	private JLabel lblUnesite;
	private JLabel lblUnesite1;
	
	private boolean isOK;
	
	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public JTextField getTxtUnos() {
		return txtUnos;
	}

	public void setTxtUnos(JTextField txtUnos) {
		this.txtUnos = txtUnos;
	}

	public JTextField getTxtUnos1() {
		return txtUnos1;
	}

	public void setTxtUnos1(JTextField txtUnos1) {
		this.txtUnos1 = txtUnos1;
	}

	public JLabel getLblUnesite() {
		return lblUnesite;
	}

	public void setLblUnesite(JLabel lblUnesite) {
		this.lblUnesite = lblUnesite;
	}

	public JLabel getLblUnesite1() {
		return lblUnesite1;
	}

	public void setLblUnesite1(JLabel lblUnesite1) {
		this.lblUnesite1 = lblUnesite1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnos dialog = new DlgUnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnos() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 234, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		{
			lblUnesite = new JLabel("Unesite sirinu:");
			contentPanel.add(lblUnesite, "cell 0 0,alignx trailing");
		}
		{
			txtUnos = new JTextField();
			txtUnos.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtUnos.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(txtUnos, "cell 1 0,alignx left");
			txtUnos.setColumns(10);
		}
		{
			lblUnesite1 = new JLabel("Unesite visinu:");
			contentPanel.add(lblUnesite1, "cell 0 3,alignx trailing");
		}
		{
			txtUnos1 = new JTextField();
			txtUnos1.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtUnos1.addKeyListener(new KeyAdapter() {
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
			contentPanel.add(txtUnos1, "cell 1 3,alignx left");
			txtUnos1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*FrmAppDrawing f = new FrmAppDrawing();
						if(f.getIsKrug()) {
							if (txtUnos.getText().isEmpty()) {
								isOK = false;
								setVisible(true);
								JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!","Greska", JOptionPane.WARNING_MESSAGE);
							} else {
								f.setIsKrug(false);
								isOK = true;
								dispose();
							}
						} else {*/
						if (txtUnos.getText().isEmpty() || txtUnos1.getText().isEmpty()) {
							isOK = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!","Greska", JOptionPane.WARNING_MESSAGE);
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
