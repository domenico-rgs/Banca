package lab.model.banca.conti;

/**
 * Il conto deposito è come il conto corrente ma è possibile solo effettuare depositi e non prelievi
 * @author Domenico
 * @version 1.0
 */
public class ContoDeposito extends ContoCorrente {
	
	public ContoDeposito(int numeroConto, String cf, String radiceIban) {
		super(numeroConto, cf, radiceIban);
	}

	/**
	 * Override di operazione di conto corrente per non permettere prelievi
	 * @param denaro ammontare di denaro da depositare (positivo), negativo indica prelievo
	 * @return true se il deposito viene effettuato, false altrimenti
	 */
	@Override
	public boolean operazione(double denaro) {
		if(denaro<0) { //prelievi non possibili
			return false;
		}else {
			return deposita(denaro);
		}
	}
	
	public String toString() {
		return getIban()+", saldo: "+getSaldo()+", tipo: Conto Deposito";
	}

}
