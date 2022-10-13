package models;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnswerData {
    private String name_unit;
    public String getName_unit() {
        return name_unit;
    }
    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }

    public static List<AnswerData> setData(DataTable dataTable){
        List<AnswerData> dates= new ArrayList<>();
        List<Map<String,String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map: mapIfo){
            dates.add(new ObjectMapper().convertValue(map,AnswerData.class));
        }
        return dates;
    }

}
