package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AddANewPetResponseBody {

    private int id;
    private Pet category;
    private String name, status;
    private List<String> photoUrls;
    private List<Tags> tags;
}
