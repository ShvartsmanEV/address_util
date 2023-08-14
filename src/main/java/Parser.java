import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Parser {
    ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public void getObjectsInfo(String date, String ids) {
        Date param = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        AddressObject info = mapper.reader()
                .forType(AddressObject.class)
                .readValue(getJsonString());

        info.getObjectInfo().values().parallelStream().flatMap(Collection::stream).
                filter(o->(o.getStartDate().before(param)&&o.getEndDate().after(param))).filter(o->ids.contains(o.getObjectId().toString()))
                .forEach(o-> System.out.println(o.getObjectId()+": "+o.getTypeName()+" "+o.getName()));
    }

    public String getJsonString() {
        String xmlContent;
        {
            try {
                xmlContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\Spark\\Desktop\\AS_ADDR_OBJ.XML")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return convertXmlToJson(xmlContent);
    }

    private static String convertXmlToJson(String xml) {
        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(4);
    }

}

