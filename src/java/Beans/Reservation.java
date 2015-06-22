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
public class Reservation {
    
    private int id;
    private int room_id;
    private int client_id;
    private int user_id;
    private int check_out_id;
    private int check_in_id;

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCheck_out_id() {
        return check_out_id;
    }

    public void setCheck_out_id(int check_out_id) {
        this.check_out_id = check_out_id;
    }

    public int getCheck_in_id() {
        return check_in_id;
    }

    public void setCheck_in_id(int check_in_id) {
        this.check_in_id = check_in_id;
    }
       
}
