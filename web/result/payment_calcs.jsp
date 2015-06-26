<%-- 
    Document   : create_checkIn
    Created on : 21-Jun-2015, 16:51:33
    Author     : Arthur
--%>

<%@page import="dao.ClientDao"%>
<%@page import="Beans.Client"%>
<%@page import="dao.RoomDao"%>
<%@page import="Beans.Room"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.ItemDao"%>
<%@page import="Beans.Item"%>
<%@page import="dao.CheckInDao"%>
<%@page import="Beans.CheckIn"%>
<%@page import="Beans.CheckOut_has_Item"%>
<%@page import="dao.CheckOut_has_Item_Dao"%>
<%@page import="dao.CheckOutDao"%>
<%@page import="Beans.CheckOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ReservationDao"%>
<%@page import="Beans.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>          
<html>
    <head>
        <title>Trip hotel - Make CheckIn</title>
        <%@include file="../config/start_template.jsp" %>        
    </head>
    <body>
        <%@include file="../config/header_adm.jsp" %>
        <%@include file="../config/body_config.jsp" %>
        <div class="friend">
            <div class="container">
                <div class="friend-main">
                    <div class="friend-top">                        
                        <h3>Confirm informations</h3>  
                        <%
                            String string_check_in_date = "1";
                            String string_check_out_date = "1";
                            String string_room_daily_value = "1";
                            String string_consumed_itens_price = "1";
                            String string_total = "1";
                            String string_daily_charges = "1";
                            // Search the reservation

                            // Objects used
                            Reservation reservation = new Reservation();
                            ReservationDao reservationDao = new ReservationDao();
                            ArrayList<Reservation> arrayList = new ArrayList<Reservation>();
                            arrayList = reservationDao.search();
                            boolean result = false;

                            // Recover the object cod 
                            reservation.setId(Integer.parseInt(request.getParameter("code")));

                            // Analyse the results        
                            for (int i = 0; i < arrayList.size(); i++) {
                                if (reservation.getId() == arrayList.get(i).getId()) {
                                    reservation.setId(arrayList.get(i).getId());
                                    reservation.setRoom_id(arrayList.get(i).getRoom_id());
                                    reservation.setClient_id(arrayList.get(i).getClient_id());
                                    reservation.setUser_id(arrayList.get(i).getUser_id());
                                    reservation.setCheck_out_id(arrayList.get(i).getCheck_out_id());
                                    reservation.setCheck_in_id(arrayList.get(i).getCheck_in_id());                                    
                                    result = true;
                                }
                            }

                            // If reservation exists
                            if (result == true) {

                                // Objects used 
                                Client client = new Client();
                                ClientDao clientDao = new ClientDao();
                                ArrayList<Client> clients_list = new ArrayList<Client>();

                                // Recover the object cod
                                client.setId(reservation.getClient_id());

                                // Search in the db
                                clients_list = clientDao.search();

                                // Analyse the results
                                for (int i = 0; i < clients_list.size(); i++) {
                                    if (client.getId() == clients_list.get(i).getId()) {
                                        client.setId(clients_list.get(i).getId());
                                        client.setName(clients_list.get(i).getName());
                                        client.setAddress(clients_list.get(i).getAddress());
                                        client.setCpf(clients_list.get(i).getCpf());
                                        client.setRg(clients_list.get(i).getRg());
                                        client.setPhone(clients_list.get(i).getPhone());
                                        client.setSex(clients_list.get(i).getSex());                                        
                                    }
                                }

                                // Search the checkIn from the reservation
                                // Objects used 
                                CheckIn checkIn = new CheckIn();
                                CheckInDao checkInDao = new CheckInDao();
                                ArrayList<CheckIn> arrayListCheckIn = new ArrayList<CheckIn>();

                                // Recover the object cod
                                checkIn.setId(reservation.getCheck_in_id());

                                // Search in the db
                                arrayListCheckIn = checkInDao.search();

                                // Analyse the results
                                for (int i = 0; i < arrayListCheckIn.size(); i++) {
                                    if (checkIn.getId() == arrayListCheckIn.get(i).getId()) {
                                        checkIn.setId(arrayListCheckIn.get(i).getId());
                                        checkIn.setDate(arrayListCheckIn.get(i).getDate());
                                        checkIn.setStatus(0);
                                    }
                                }

                                // Search the checkOut from the reservation
                                // Objects used 
                                CheckOut checkOut = new CheckOut();
                                CheckOutDao checkOutDao = new CheckOutDao();
                                ArrayList<CheckOut> arrayListCheckOut = new ArrayList<CheckOut>();

                                // Recover the object cod
                                checkOut.setId(reservation.getCheck_out_id());

                                // Search in the db
                                arrayListCheckOut = checkOutDao.search();

                                // Analyse the results
                                for (int i = 0; i < arrayListCheckOut.size(); i++) {
                                    if (checkOut.getId() == arrayListCheckOut.get(i).getId()) {
                                        checkOut.setId(arrayListCheckOut.get(i).getId());
                                        checkOut.setDate(arrayListCheckOut.get(i).getDate());
                                    }
                                }

                                // Search itens
                                // Objects used 
                                Item item = new Item();
                                ItemDao itemDao = new ItemDao();
                                ArrayList<Item> search_item_List = new ArrayList<Item>();

                                // Search in the db
                                search_item_List = itemDao.search();

                                // Search the consumed Itens
                                // Objects used 
                                CheckOut_has_Item checkOut_has_Item = new CheckOut_has_Item();
                                CheckOut_has_Item_Dao checkOut_has_ItemDao = new CheckOut_has_Item_Dao();
                                ArrayList<Item> consumed_item_List = new ArrayList<Item>();
                                ArrayList<CheckOut_has_Item> checkOut_has_Items_List = new ArrayList<CheckOut_has_Item>();
                                double itens_list_price = 0;

                                // Recover the object cod
                                checkOut_has_Item.setCheck_out_id(checkOut.getId());

                                // Search in the db
                                checkOut_has_Items_List = checkOut_has_ItemDao.search();

                                // Analyse the results
                                // in search of the consume item`s by checkOut`s id
                                for (int i = 0; i < checkOut_has_Items_List.size(); i++) {
                                    if (checkOut_has_Item.getCheck_out_id() == checkOut_has_Items_List.get(i).getCheck_out_id()) {
                                        for (int j = 0; j < search_item_List.size(); j++) {
                                            if (checkOut_has_Items_List.get(i).getItem_id() == search_item_List.get(j).getId()) {
                                                Item item_temp = new Item();
                                                item_temp.setId(search_item_List.get(j).getId());
                                                item_temp.setName(search_item_List.get(j).getName());
                                                item_temp.setPrice(search_item_List.get(j).getPrice());
                                                consumed_item_List.add(item_temp);
                                                itens_list_price = itens_list_price + search_item_List.get(j).getPrice();
                                            }
                                        }
                                    }
                                }

                                // Objects used 
                                Room room = new Room();
                                RoomDao roomDao = new RoomDao();
                                ArrayList<Room> arrayListRooms = new ArrayList<Room>();

                                // Recover the object cod
                                room.setId(reservation.getRoom_id());

                                // Search in the db
                                arrayListRooms = roomDao.search();

                                // Analyse the results
                                for (int i = 0; i < arrayListRooms.size(); i++) {
                                    if (room.getId() == arrayListRooms.get(i).getId()) {
                                        room.setId(arrayListRooms.get(i).getId());
                                        room.setNumber(arrayListRooms.get(i).getNumber());
                                        room.setFloor(arrayListRooms.get(i).getFloor());
                                        room.setType(arrayListRooms.get(i).getType());
                                        room.setDaily_value(arrayListRooms.get(i).getDaily_value());
                                    }
                                }

                                // Days count
                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                                Date check_in_date = dateFormat.parse(checkIn.getDate());
                                Date check_out_date = dateFormat.parse(checkOut.getDate());

                                long time_stay_diff = check_out_date.getTime() - check_in_date.getTime();
                                long time_stay_diff_days = time_stay_diff / (24 * 60 * 60 * 1000);

                                // Results
                                double payment_price = 0;
                                payment_price = (time_stay_diff_days * room.getDaily_value())
                                        + itens_list_price;

                                // Strings conversion
                                string_check_in_date = checkIn.getDate();
                                string_check_out_date = checkOut.getDate();
                                string_room_daily_value = String.valueOf(room.getDaily_value());
                                string_consumed_itens_price = String.valueOf(itens_list_price);
                                string_total = String.valueOf(payment_price);
                                string_daily_charges = String.valueOf(time_stay_diff_days);

                            } else {
                                response.sendRedirect("/web_system_hotel_1/config/operation_erro.jsp");
                            }

                        %>             
                        <p>Check in data = <%=string_check_in_date%></p> 
                        <p>Check out data = <%=string_check_out_date%></p> 
                        <p>Days charged = <%=string_daily_charges%></p>                        
                        <p></p><p>Values :</p>
                        <p>Room daily = <%=string_room_daily_value%></p> 
                        <p>All consumed items = <%=string_consumed_itens_price%></p> 
                        <p>Total = <%=string_total%></p>                                                                        
                    </div>                
                    <%@include file="../config/footer.jsp" %>
                    </body>
                    </html>