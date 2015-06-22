/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package Beans;

/**
 *
 * @author Arthur
 */
public class CheckOut_has_Item {
    
    private int Check_out_id;
    private int Item_id;

    public CheckOut_has_Item() {
    }

    public int getCheck_out_id() {
        return Check_out_id;
    }

    public void setCheck_out_id(int Check_out_id) {
        this.Check_out_id = Check_out_id;
    }

    public int getItem_id() {
        return Item_id;
    }

    public void setItem_id(int Item_id) {
        this.Item_id = Item_id;
    }
            
}
