package examen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.vistas.PanelGestionContrato;

import java.awt.BorderLayout;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private DefaultTableModel dtm = null;
//	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
//	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private PanelGestionContrato panelContrato = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
//		dtm = getDefaultTableModelNoEditable();
		panelContrato = new PanelGestionContrato();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelContrato);
	}
	
//	@SuppressWarnings("serial")
//	private DefaultTableModel getDefaultTableModelNoEditable () {
//		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
//			/**
//			 * Se conocer� el dato en cada celda, es uno de los m�todos fundamentales del abstractTableModel
//			 */
//			@Override
//			public Object getValueAt(int rowIndex, int columnIndex) {
//				return datosEnTabla[rowIndex][columnIndex];
//			}
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//				datosEnTabla[rowIndex][columnIndex] = aValue;
//				fireTableCellUpdated(rowIndex, columnIndex);
//			}
//			
//		};
//		return dtm;
//	}

}
