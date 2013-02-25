package minimaxAlgorithm;

import es.deusto.ingenieria.aike.formulation.Operator;
import es.deusto.ingenieria.aike.formulation.State;

public class MoverFicha extends Operator {
	

	public MoverFicha(int puntuacionDado)
	{
		
	}
	
	protected State effect(State arg0)
	{
		return null;
	}

	protected boolean isApplicable(State arg0)
	{
		//si la ficha no esta en casa y el dado no ha sacado 6
		return false;
	}

}
