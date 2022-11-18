package seleccionPlana;

import javax.swing.AbstractListModel;


public class ControladorParaLaListaDeConcursantes extends AbstractListModel<Concursante> {

	private FuenteDeDatos datos;
	
	public ControladorParaLaListaDeConcursantes()
	{
		datos = new FuenteDeDatos();
	}
	
	@Override
	public int getSize() {
		return datos.getConcursantes().size();
	}

	@Override
	public Concursante getElementAt(int index) {
		return datos.getConcursantes().get(index);
	}
	
	

}
