package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class DlgIzmenaTacka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtY;
	private JTextField txtX;
	private boolean isOK;
	
	private Color c;
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
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
			DlgIzmenaTacka dialog = new DlgIzmenaTacka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIzmenaTacka() {
		setTitle("Tacka");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 288, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[30px][214px]", "[20px][20px][25]"));
		{
			JLabel label = new JLabel("Y:");
			contentPanel.add(label, "flowy,cell 0 1,alignx left,aligny center");
		}
		{
			txtY = new JTextField();
			txtY.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtY.addKeyListener(new KeyAdapter() {
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
			txtY.setColumns(10);
			contentPanel.add(txtY, "cell 1 1,growx,aligny top");
		}
		{
			txtX = new JTextField();
			txtX.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtX.addKeyListener(new KeyAdapter() {
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
			txtX.setColumns(10);
			contentPanel.add(txtX, "cell 1 0,growx,aligny top");
		}
		{
			JLabel label = new JLabel("X:");
			contentPanel.add(label, "cell 0 0,alignx left,aligny center");
		}
		{
			JLabel lblIzaberiBoju = new JLabel("Izaberi boju:");
			contentPanel.add(lblIzaberiBoju, "cell 0 2");
		}
		{
			JButton btnBoja = new JButton("Boja");
			btnBoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c = JColorChooser.showDialog(null, "Izaberite boju", Color.RED);
				}
			});
			contentPanel.add(btnBoja, "cell 1 2,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
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
