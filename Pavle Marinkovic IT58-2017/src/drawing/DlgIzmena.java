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

public class DlgIzmena extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnos;
	private JTextField txtUnos1;
	private JTextField txtX;
	private JTextField txtY;
	private JLabel lblUnesite;
	private JLabel lblUnesite1;
	private JLabel lblX;
	private JLabel lblY;
	private boolean isOK;
	private JLabel lblIzaberiteBoju;
	private JButton btnBoja;
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

	
	
	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblY() {
		return lblY;
	}

	public void setLblY(JLabel lblY) {
		this.lblY = lblY;
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
			DlgIzmena dialog = new DlgIzmena();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIzmena() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 366, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("", "[68px][86px,grow][1px][1px]", "[][][20px][][]"));
		{
			lblX = new JLabel("X:");
			contentPanel.add(lblX, "cell 0 0,alignx center");
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
			contentPanel.add(txtX, "cell 1 0,growx");
			txtX.setColumns(10);
		}
		{
			lblY = new JLabel("Y:");
			contentPanel.add(lblY, "cell 0 1,alignx center");
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
			contentPanel.add(txtY, "cell 1 1,growx");
			txtY.setColumns(10);
		}
		{
			lblUnesite = new JLabel("Unesite sirinu:");
			contentPanel.add(lblUnesite, "cell 0 2,alignx center,aligny center");
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
			txtUnos.setColumns(10);
			contentPanel.add(txtUnos, "cell 1 2,growx,aligny top");
		}
		{
			lblUnesite1 = new JLabel("Unesite visinu:");
			contentPanel.add(lblUnesite1, "cell 0 3,alignx center,aligny center");
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
			txtUnos1.setColumns(10);
			contentPanel.add(txtUnos1, "cell 1 3,growx,aligny top");
		}
		{
			lblIzaberiteBoju = new JLabel("Izaberite boju:");
			contentPanel.add(lblIzaberiteBoju, "cell 0 4");
		}
		{
			btnBoja = new JButton("Boja");
			btnBoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c = JColorChooser.showDialog(null, "Izaberite boju", Color.RED);
				}
			});
			contentPanel.add(btnBoja, "cell 1 4,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtUnos.getText().isEmpty() || txtUnos1.getText().isEmpty() || txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
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
