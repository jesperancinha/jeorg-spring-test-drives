package org.jesperancinha.std.app1.jdbc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Table
@Entity
public class Boat extends CruiseBase {

    private String name;

    private List<Room> roomList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
