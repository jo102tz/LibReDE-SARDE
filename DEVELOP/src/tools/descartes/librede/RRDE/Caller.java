package tools.descartes.librede.RRDE;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.configuration.LibredeConfiguration;


public class Caller {

	public static void main(String[] args){
		
	}
	
	public static LibredeResults executeLibrede(LibredeConfiguration conf){
		return Librede.execute(conf);
	}
}
