import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ObjectInfo {

    @JsonProperty("OBJECTGUID")
    private String objectGuid;
    @JsonProperty("NEXTID")
    private Long nextId;
    @JsonProperty("TYPENAME")
    private String typeName;
    @JsonProperty("STARTDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonProperty("ISACTUAL")
    private Integer isActual;
    @JsonProperty("PREVID")
    private Long prevId;
    @JsonProperty("LEVEL")
    private Integer level;
    @JsonProperty("CHANGEID")
    private Long changeId;
    @JsonProperty("ISACTIVE")
    private Integer isActive;
    @JsonProperty("NAME")
    private String name;
    @JsonProperty("ENDDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    @JsonProperty("OBJECTID")
    private Long objectId;
    @JsonProperty("UPDATEDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updateDate;
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("OPERTYPEID")
    private Integer operTypeId;
}
