package mongoDB.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import mongoDB.controladores.ControladorComunidad;
import mongoDB.model.Ccaa;
import mongoDB.model.Provincia;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelComunidad extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCode;
	private JTextField jtfLabel;
	private Ccaa comunidad;
	private JComboBox<Ccaa> combo;
	/**
	 * Create the panel.
	 */
	public PanelComunidad(Ccaa c, JComboBox<Ccaa> p) {
		this.comunidad = c;
		this.combo = p;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Gestión De Comunidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Code:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfCode = new JTextField();
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
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
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 3;
		gbc_jtfLabel.gridy = 3;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 4;
		add(btnGuardar, gbc_btnGuardar);
		
		muestraEnPantalla();

	}
	
	private void muestraEnPantalla() {
		jtfCode.setText(this.comunidad.getCode());
		this.jtfLabel.setText(this.comunidad.getLabel());
	}
	
	private void guardar() {
		ControladorComunidad.updateDocument(ControladorComunidad.getMongoCollectionCCAA(), this.jtfCode.getText(), this.jtfLabel.getText());
		
		combo.removeAllItems(); // Elimina todos los elementos actuales del JComboBox
	    List<Ccaa> nuevaLista = ControladorComunidad.getAllCcaa(ControladorComunidad.getMongoCollectionCCAA()); // Obtiene una nueva lista actualizada
	    for (Ccaa c : nuevaLista) {
	        combo.addItem(c); // Agrega los elementos actualizados al JComboBox
	    }
	}

}
