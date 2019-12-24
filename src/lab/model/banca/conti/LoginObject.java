package lab.model.banca.conti;

public interface LoginObject {
	public boolean setPassword(String oldPassword, String newPassword);
	public boolean isLogged();
	public boolean login(String password);
}
