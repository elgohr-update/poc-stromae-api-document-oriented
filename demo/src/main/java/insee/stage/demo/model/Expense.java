package insee.stage.demo.model;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
/**import org.springframework.data.mongodb.core.index.Indexed;**/
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.awt.*;


@Document("survey-units")
public class Expense {


    @Id
    private String id;
    @Field(name = "comment")
    private String comment;
    @Field(name = "personalization")
    private Personalization personalization;
    @Field(name = "state-data")
    private Statedata stateData;
    @Field(name = "data")
    private  JSONObject data;




    public Expense(String id, String comment, Personalization personalization, Statedata stateData, JSONObject data) {
        this.id = id;
        this.comment = comment;
        this.personalization = personalization;
        this.stateData = stateData;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Personalization getPersonalization() {
        return personalization;
    }

    public void setPersonalization(Personalization personalization) {
        this.personalization = personalization;
    }

    public Statedata getStateData() {
        return stateData;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public void setParadata(JSONObject paradata, List list) {
        paradata.put("idSU", this.id);
        paradata.put("events",list);
    }


    public void setStateData(Statedata stateData) {
    }
}
