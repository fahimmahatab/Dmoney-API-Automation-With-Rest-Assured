import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }

    public static int generateRandomId(int min, int max) {
        double randId = Math.random() * (max - min) + min;
        return (int) randId;
    }

    public static void saveInfo(UserModel model) throws IOException, ParseException {
        String file = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray userArray = (JSONArray) jsonParser.parse(new FileReader(file));
        JSONObject object = new JSONObject();
        object.put("id", model.getId());
        object.put("name", model.getName());
        object.put("email", model.getEmail());
        object.put("password", model.getPassword());
        object.put("phone_number", model.getPhone_number());
        object.put("nid", model.getNid());
        object.put("role", model.getRole());
        userArray.add(object);
        FileWriter writer = new FileWriter(file);
        writer.write(userArray.toJSONString());
        writer.flush();
        writer.close();
    }
}
