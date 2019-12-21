package lab.banca;
import java.util.Comparator;

import lab.conti.Conto;

public class ContoComparatorSI implements Comparator<Conto>{
	public int compare(Conto c1, Conto c2) {
		if(c1.getSaldo()>c2.getSaldo())
			return 1;
		else if(c1.getSaldo()<c2.getSaldo())
			return -1;
		else
			return c1.getIban().compareTo(c2.getIban());
	}

}
