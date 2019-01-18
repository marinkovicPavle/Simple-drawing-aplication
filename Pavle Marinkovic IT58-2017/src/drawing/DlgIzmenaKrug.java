package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgIzmenaKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtPoluprecnik;
	private boolean isOK;

	private Color c;
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	
	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtPoluprecnik() {
		return txtPoluprecnik;
	}

	public void setTxtPoluprecnik(JTextField txtPoluprecnik) {
		this.txtPoluprecnik = txtPoluprecnik;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgIzmenaKrug dialog = new DlgIzmenaKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIzmenaKrug() {
		setTitle("Krug");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 366, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[68px][235px]", "[20px][20px][20px][25]"));
		
		JLabel label = new JLabel("X:");
		contentPanel.add(label, "cell 0 0,alignx center,aligny center");
		
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
		
		JLabel label_1 = new JLabel("Y:");
		contentPanel.add(label_1, "cell 0 1,alignx center,aligny center");
		
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
		
		JLabel lblUnesitePoluprecnik = new JLabel("Unesite poluprecnik:");
		contentPanel.add(lblUnesitePoluprecnik, "cell 0 2,alignx left,aligny center");
		
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
		txtPoluprecnik.setColumns(10);
		contentPanel.add(txtPoluprecnik, "cell 1 2,growx,aligny top");
		
		JLabel lblIzaberiteBoju = new JLabel("Izaberite boju:");
		contentPanel.add(lblIzaberiteBoju, "cell 0 3");
		
		JButton btnBoja = new JButton("Boja");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = JColorChooser.showDialog(null, "Izaberite boju", Color.RED);
			}
		});
		contentPanel.add(btnBoja, "cell 1 3,growx");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtPoluprecnik.getText().isEmpty() || txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
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
