import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AddressObject {
    @JsonProperty("ADDRESSOBJECTS")
private Map<String, ArrayList<ObjectInfo>> objectInfo;

}





