package Manufacturers;
import code.Ent;

public class ManufacturerEnt extends Ent {
    private int id_manufacturer;
    private String name_manufacturer;
    private String address;
    private String contacts;

    public ManufacturerEnt(){}

    public int getId_manufacturer (){return id_manufacturer;}
    public void setId_manufacturer (int id_manufacturer){this.id_manufacturer=id_manufacturer;}

    public String getName_manufacturer (){return name_manufacturer;}
    public void setName_manufacturer (String name_manufacturer){this.name_manufacturer=name_manufacturer;}

    public String getAddress (){return address;}
    public void setAddress (String address){this.address=address;}

    public String getContacts (){return contacts;}
    public void setContacts (String contacts){this.contacts=contacts;}
}
