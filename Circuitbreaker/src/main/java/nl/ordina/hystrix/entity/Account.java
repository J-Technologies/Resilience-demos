package nl.ordina.hystrix.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
    private String iban;
    private String bic;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "Account{" + "iban=" + iban + ", bic=" + bic + '}';
    }   
}