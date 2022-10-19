package models;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitData {
    private String name_unit;
    private String parents_unit;
    public String getName_unit() {
        return name_unit;
    }
    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }
    public String getParents_unit() {
        return parents_unit;
    }
    public void setParents_unit(String parents_unit) {
        this.parents_unit = parents_unit;
    }

    public static List<UnitData> setData(DataTable dataTable){
        List<UnitData> dates= new ArrayList<>();
        List<Map<String,String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map: mapIfo){
            dates.add(new ObjectMapper().convertValue(map, UnitData.class));
        }
        return dates;
    }

}
