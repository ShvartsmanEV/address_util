import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Info {
    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    private AddressObject getAddressObjectFromString() {
        return mapper.reader()
                .forType(AddressObject.class)
                .readValue(getJsonString());

    }

    @SneakyThrows
    public void getAddressObjectInfoByDateAndId(String date, String ids) {
        Date param = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        getAddressObjectFromString().getObjectInfo().values().parallelStream().flatMap(Collection::parallelStream).
                filter(o -> (o.getStartDate().before(param) && o.getEndDate().after(param))).filter(o -> ids.contains(o.getObjectId().toString()))
                .forEach(o -> System.out.println(o.getObjectId() + ": " + o.getTypeName() + " " + o.getName()));
    }


    public void getFullAddressByType(String type) {
        getAddressObjectFromString().getObjectInfo().values().parallelStream().flatMap(Collection::parallelStream)
                .filter(o->o.getTypeName().equals(type)).forEach(o -> System.out.println( o.getTypeName() + " " + o.getName()));

    }

    @SneakyThrows
    private static String getJsonString() {
        String xmlContent;
        xmlContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\Spark\\Desktop\\AS_ADDR_OBJ.XML")));
        return convertXmlToJson(xmlContent);
    }

    private static String convertXmlToJson(String xml) {
        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(4);
    }

}

