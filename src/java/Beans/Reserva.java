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
public class Reserva {
    
    private int id;
    private int data_check_in;
    private int quarto_id;
    private int cliente_id;
    private int usuario_id;
    private int check_out_id;

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData_check_in() {
        return data_check_in;
    }

    public void setData_check_in(int data_check_in) {
        this.data_check_in = data_check_in;
    }

    public int getQuarto_id() {
        return quarto_id;
    }

    public void setQuarto_id(int quarto_id) {
        this.quarto_id = quarto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getCheck_out_id() {
        return check_out_id;
    }

    public void setCheck_out_id(int check_out_id) {
        this.check_out_id = check_out_id;
    }
            
}
