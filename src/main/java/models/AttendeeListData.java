package models;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AttendeeListData {
    private String attendee_name;
    private String attendee_type;
    private String attendee2_name;
    private String attendee2_type;
    private String attendee3_name;
    private String attendee3_type;

    public String getAttendee_name() {
        return attendee_name;
    }
    public void setAttendee_name(String attendee_name) {
        this.attendee_name = attendee_name;
    }

    public String getAttendee_type() {
        return attendee_type;
    }
    public void setAttendee_type(String attendee_type) {
        this.attendee_type = attendee_type;
    }

    public String getAttendee2_name() {
        return attendee2_name;
    }
    public void setAttendee2_name(String attendee2_name) {
        this.attendee2_name = attendee2_name;
    }

    public String getAttendee2_type() {
        return attendee2_type;
    }
    public void setAttendee2_type(String attendee2_type) {
        this.attendee2_type = attendee2_type;
    }

    public String getAttendee3_name() {
        return attendee3_name;
    }
    public void setAttendee3_name(String attendee3_name) {
        this.attendee3_name = attendee3_name;
    }

    public String getAttendee3_type() {
        return attendee3_type;
    }
    public void setAttendee3_type(String attendee3_type) {
        this.attendee3_type = attendee3_type;
    }

    public static List<AttendeeListData> setData(DataTable dataTable){
        List<AttendeeListData> dates= new ArrayList<>();
        List<Map<String,String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map: mapIfo){
            dates.add(new ObjectMapper().convertValue(map,AttendeeListData.class));
        }
        return dates;
    }
}
