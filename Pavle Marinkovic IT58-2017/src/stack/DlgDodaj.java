package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Dialog.ModalityType;

public class DlgDodaj extends JDialog {

	private final JPanel pnlGlavni = new JPanel();
	private boolean isOK;
	private boolean isUneseno;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtVisina;
	private JTextField txtSirina;
	private JButton btnOk;
	private JButton btnDodaj;
	private JButton btnOdustani;
	
	public boolean isUneseno() {
		return isUneseno;
	}

	public void setUneseno(boolean isUneseno) {
		this.isUneseno = isUneseno;
	}
	
	public JButton getBtnOk() {
		return btnOk;
	}
	
	public JButton getBtnDodaj() {
		return btnDodaj;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
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

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public JPanel getPnlGlavni() {
		return pnlGlavni;
	}
	
	public JPanel getContentPanel() {
		return pnlGlavni;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public boolean isOK() {
		return isOK;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDodaj dialog = new DlgDodaj();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodaj() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Dodavanje");
		setModal(true);
		setBounds(100, 100, 264, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		pnlGlavni.setLayout(new MigLayout("", "[66px][115px,grow]", "[50px][50][50][50]"));
		
		JLabel lblX = new JLabel("X:");
		pnlGlavni.add(lblX, "cell 0 0,alignx left,aligny center");
		
		txtX = new JTextField();
		txtX.setColumns(10);
		pnlGlavni.add(txtX, "cell 1 0,growx,aligny center");
		
		JLabel lblY = new JLabel("Y:");
		pnlGlavni.add(lblY, "cell 0 1,alignx left,aligny center");
		
		txtY = new JTextField();
		txtY.setColumns(10);
		pnlGlavni.add(txtY, "cell 1 1,growx,aligny center");
		
		JLabel lblVisina = new JLabel("Visina:");
		pnlGlavni.add(lblVisina, "cell 0 2,alignx left,aligny center");
		
		txtVisina = new JTextField();
		txtVisina.setColumns(10);
		pnlGlavni.add(txtVisina, "cell 1 2,growx,aligny center");
		
		JLabel lblSirina = new JLabel("Sirina:");
		pnlGlavni.add(lblSirina, "cell 0 3,alignx left,aligny center");
		
		txtSirina = new JTextField();
		txtSirina.setColumns(10);
		pnlGlavni.add(txtSirina, "cell 1 3,growx,aligny center");
		
		{
			JPanel pnlDugmici = new JPanel();
			pnlDugmici.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlDugmici, BorderLayout.SOUTH);
			{
			    btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOK = true;
						dispose();
					}
				});
				
			    btnOk = new JButton("OK");
			    btnOk.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		dispose();
			    	}
			    });
				btnOk.setVisible(false);
				pnlDugmici.add(btnOk);
				btnDodaj.setActionCommand("OK");
				pnlDugmici.add(btnDodaj);
				getRootPane().setDefaultButton(btnDodaj);
			}
			{
				btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOK = false;
						txtX.setText("");
						txtY.setText("");
						txtSirina.setText("");
						txtVisina.setText("");
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
				pnlDugmici.add(btnOdustani);
			}
		}
	}
}
