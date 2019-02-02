package Delivery;
import code.Ent;
public class DeliveryEnt extends Ent {
    private int id_delivery;
    private String name_delivery;
    private String cost_delivery;

    public DeliveryEnt(){}

    public int getId_delivery (){return id_delivery;}
    public void setId_delivery (int id_delivery){this.id_delivery=id_delivery;}

    public String getName_delivery (){return name_delivery;}
    public void setName_delivery (String name_delivery){this.name_delivery=name_delivery;}

    public String getCost_delivery (){return cost_delivery;}
    public void setCost_delivery (String cost_delivery){this.cost_delivery=cost_delivery;}


}
