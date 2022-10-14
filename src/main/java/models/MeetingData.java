package models;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeetingData {
    private String meeting_name;
    private String meeting_type;
    private String start_date;
    private String start_hour;
    private String location;
    private String organized_by;
    private String meeting_number;
    private String end_date;
    private String end_hour;
    private String name_unit;
    private String reporter;

    public String getMeeting_name() {
        return meeting_name;
    }
    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public String getMeeting_type() {
        return meeting_type;
    }
    public void setMeeting_type(String meeting_type) {
        this.meeting_type = meeting_type;
    }

    public String getStart_date() {
        return start_date;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_hour() {
        return start_hour;
    }
    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganized_by() {
        return organized_by;
    }
    public void setOrganized_by(String organized_by) {
        this.organized_by = organized_by;
    }

    public String getMeeting_number() {
        return meeting_number;
    }
    public void setMeeting_number(String meeting_number) {
        this.meeting_number = meeting_number;
    }

    public String getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_hour() {
        return end_hour;
    }
    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }

    public String getName_unit() {
        return name_unit;
    }
    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }

    public String getReporter() {
        return reporter;
    }
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public static List<MeetingData> setData(DataTable dataTable){
        List<MeetingData> dates= new ArrayList<>();
        List<Map<String,String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map: mapIfo){
            dates.add(new ObjectMapper().convertValue(map,MeetingData.class));
        }
        return dates;
    }
}
