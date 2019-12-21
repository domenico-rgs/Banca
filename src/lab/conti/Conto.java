package lab.conti;

public interface Conto {
	double getSaldo();
	boolean operazione(double amount); //amount positivo per deposito, negativo per prelievo
	String getIban();
	String getCf();
	void setSaldo(double newSaldo);
}
