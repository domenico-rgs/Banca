package lab.model.banca;
import java.util.Comparator;

import lab.model.banca.conti.Conto;

//Usato per le operazioni di ordinamento dei conti in base all'iban
public class ContoComparator implements Comparator<Conto>{
	public int compare(Conto c1, Conto c2) {
		if(c1.getSaldo()>c2.getSaldo())
			return 1;
		else if(c1.getSaldo()<c2.getSaldo())
			return -1;
		else
			return 0;
	}

}
