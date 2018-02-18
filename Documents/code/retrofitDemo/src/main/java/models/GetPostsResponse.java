package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPostsResponse {
    public Integer userId;
    public Integer id;
    public String title;
    @JsonProperty("body") //This is needed only when the parameter name has to be mapped to a different Java variable name)
    public String body;
}
