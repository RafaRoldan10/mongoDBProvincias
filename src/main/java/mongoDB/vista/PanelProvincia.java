package mongoDB.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;


import mongoDB.controladores.ControladorComunidad;
import mongoDB.controladores.ControladorProvincia;
import mongoDB.model.Ccaa;
import mongoDB.model.Provincia;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelProvincia extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfLabel;
	private JTextField jtfCode;
	private JComboBox<Ccaa> jcbCCAA;
	private List<Ccaa> lista = ControladorComunidad.getAllCcaa(ControladorComunidad.getMongoCollectionCCAA());

	/**
	 * Create the panel.
	 */
	public PanelProvincia() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_3 = new JLabel("Gestión De Provincias");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 9;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Code:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfCode = new JTextField();
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.gridwidth = 8;
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 3;
		gbc_jtfCode.gridy = 2;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		jtfCode.setEditable(false);
		JLabel lblNewLabel_1 = new JLabel("Label:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.gridwidth = 8;
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 3;
		gbc_jtfLabel.gridy = 3;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CCAA:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbCCAA = new JComboBox();
		GridBagConstraints gbc_jcbCCAA = new GridBagConstraints();
		gbc_jcbCCAA.gridwidth = 8;
		gbc_jcbCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCCAA.gridx = 3;
		gbc_jcbCCAA.gridy = 4;
		add(jcbCCAA, gbc_jcbCCAA);
		
		JButton btnComunidad = new JButton("Gestion CCAA");
		btnComunidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Título");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelComunidad((Ccaa)jcbCCAA.getSelectedItem(),jcbCCAA));
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);  
			}
		});
		GridBagConstraints gbc_btnComunidad = new GridBagConstraints();
		gbc_btnComunidad.insets = new Insets(0, 0, 5, 0);
		gbc_btnComunidad.gridx = 11;
		gbc_btnComunidad.gridy = 4;
		add(btnComunidad, gbc_btnComunidad);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 5;
		add(btnGuardar, gbc_btnGuardar);
		
		cargaComunidades();

	}
	
	public void cargaComunidades() {
		for(Ccaa c : lista) {
			this.jcbCCAA.addItem(c);
		}
	}
	
	public void muestraProvincia(Provincia c) {
		this.jtfCode.setText(c.getCode());
		this.jtfLabel.setText(c.getLabel());
		for(int i=0 ; i< jcbCCAA.getItemCount(); i++) {
			if(jcbCCAA.getItemAt(i).getCode().equals(c.getParent_code())) {
				jcbCCAA.setSelectedIndex(i);
			}
		}
	}
	
	private void guardar() {
		ControladorProvincia.updateDocument(ControladorProvincia.getMongoCollectionProvincia(), this.jtfCode.getText(), this.jtfLabel.getText(),((Ccaa)jcbCCAA.getSelectedItem()).getCode());
	}

}
