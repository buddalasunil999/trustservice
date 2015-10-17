package nz.ac.aut.sa.services.domain;

public interface UserTrust {
	public void setTruster(int truster);
	public void setTrustee(int trustee);
	public void setValue(int value);
	public int getTruster();//truster(id) is the person who trusts the trustee
	public int getTrustee();//trustee(id) is the person being trusted
	public int getValue();//get trust level value
}
