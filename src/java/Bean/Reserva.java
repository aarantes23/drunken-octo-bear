/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author it008935
 */
public class Reserva {
    private int codigo;
    private int codCliente;
    private int codQuarto;    
    private String dataCheckin;
    private String dataCheckout;
    private int qtdePessoa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodQuarto() {
        return codQuarto;
    }

    public void setCodQuarto(int codQuarto) {
        this.codQuarto = codQuarto;
    }
    
    public String getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(String dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public String getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(String dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public int getQtdePessoa() {
        return qtdePessoa;
    }

    public void setQtdePessoa(int qtdePessoa) {
        this.qtdePessoa = qtdePessoa;
    }    
        
}
