package Customers;
import code.Ent;
import javafx.collections.ObservableList;

public class CustomerEnt extends Ent {
    private int id_customer;
    private String name_customer;
    private String sname_customer;
    private String firm;

    public CustomerEnt(){}

    public int getID_customer (){return id_customer;}
    public void setID_customer (int id_customer){this.id_customer=id_customer;}

    public String getName_customer (){return name_customer;}
    public void setName_customer (String name_customer){this.name_customer=name_customer;}

    public String getSname_customer (){return sname_customer;}
    public void setSname_customer (String sname_customer){this.sname_customer=sname_customer;}

    public String getFirm (){return firm;}
    public void setFirm (String firm){this.firm=firm;}

}
