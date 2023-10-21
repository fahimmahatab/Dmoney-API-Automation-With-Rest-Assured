import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTestRunner extends Setup {
    User user;

    public UserTestRunner() throws IOException {
        initConfig();
        user = new User(prop.getProperty("baseUrl"));
    }

    @Test(priority = 1, description = "Admin can login")
    public void login() throws ConfigurationException {
        UserModel model = new UserModel();
        model.setEmail("salman@roadtocareer.net");
        model.setPassword("1234");
        String token = user.callingLoginAPI(model);
        Utils.setEnvVar("token", token);

        Allure.description("Admin Login Successfully");
    }

    @Test(priority = 2, description = "Create Agent by Admin")
    public void createAgent() throws IOException, ParseException, ConfigurationException {
        initConfig();
        UserModel userModel = new UserModel();
        Faker faker = new Faker();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress());
        userModel.setPassword("1234");
        userModel.setPhone_number("01750" + Utils.generateRandomId(100000, 999999));
        userModel.setNid("1234567890");
        userModel.setRole("Agent");

        JsonPath jsonPath = user.createUser(prop.getProperty("token"), prop.getProperty("partnerKey"), userModel);
        String messageActual = jsonPath.get("message");
        String phone_number = jsonPath.get("user.phone_number");
        int id = jsonPath.get("user.id");
        if (messageActual.contains("User created")) {
            Utils.setEnvVar("agentPhoneNo", phone_number);
            userModel.setId(id);
            Utils.saveInfo(userModel);
        }
        Allure.description("Create Agent by Admin Successfully");
    }

    @Test(priority = 3, description = "Create Customer by Admin")
    public void createCustomer01() throws IOException, ParseException, ConfigurationException {
        initConfig();
        UserModel userModel = new UserModel();
        Faker faker = new Faker();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress());
        userModel.setPassword("1234");
        userModel.setPhone_number("01750" + Utils.generateRandomId(100000, 999999));
        userModel.setNid("1234567890");
        userModel.setRole("Customer");

        JsonPath jsonPath = user.createUser(prop.getProperty("token"), prop.getProperty("partnerKey"), userModel);
        String messageActual = jsonPath.get("message");
        String phone_number = jsonPath.get("user.phone_number");
        int id = jsonPath.get("user.id");
        if (messageActual.contains("User created")) {
            Utils.setEnvVar("customer01PhoneNo", phone_number);
            userModel.setId(id);
            Utils.saveInfo(userModel);
        }
        Allure.description("Create Customer by Admin Successfully");
    }

    @Test(priority = 4, description = "Create 2nd Customer by Admin")
    public void createCustomer2() throws IOException, ParseException, ConfigurationException {
        initConfig();
        UserModel userModel = new UserModel();
        Faker faker = new Faker();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress());
        userModel.setPassword("1234");
        userModel.setPhone_number("01750" + Utils.generateRandomId(100000, 999999));
        userModel.setNid("1234567890");
        userModel.setRole("Customer");

        JsonPath jsonPath = user.createUser(prop.getProperty("token"), prop.getProperty("partnerKey"), userModel);
        String messageActual = jsonPath.get("message");
        String phone_number = jsonPath.get("user.phone_number");
        int id = jsonPath.get("user.id");
        if (messageActual.contains("User created")) {
            Utils.setEnvVar("customer02PhoneNo", phone_number);
            userModel.setId(id);
            Utils.saveInfo(userModel);
        }
        Allure.description("Create 2nd Customer by Admin Successfully");
    }
}
