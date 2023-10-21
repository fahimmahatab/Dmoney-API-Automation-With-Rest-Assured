import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransactionTestRunner extends Setup {
    Transaction transaction;

    public TransactionTestRunner() throws IOException {
        initConfig();
        transaction = new Transaction(prop.getProperty("baseUrl"));
    }

    @Test(priority = 1, description = "Deposit Money System account to Agent account")
    public void depositToAgent() {
        TransactionModel model = new TransactionModel();
        model.setFrom_account("SYSTEM");
        model.setTo_account(prop.getProperty("agentPhoneNo"));
        model.setAmount(2000);

        JsonPath jsonPath = transaction.deposit(prop.getProperty("token"), prop.getProperty("partnerKey"), model);
        String messageActual = jsonPath.get("message");
        Assert.assertTrue(messageActual.contains("Deposit successful"));
        Allure.description("Deposit Money System account to Agent account Successfully");
    }

    @Test(priority = 2, description = "Deposit Money Agent account to Customer account")
    public void depositToCustomer() {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(prop.getProperty("agentPhoneNo"));
        model.setTo_account(prop.getProperty("customer01PhoneNo"));
        model.setAmount(1500);

        JsonPath jsonPath = transaction.deposit(prop.getProperty("token"), prop.getProperty("partnerKey"), model);
        String messageActual = jsonPath.get("message");
        Assert.assertTrue(messageActual.contains("Deposit successful"));
        Allure.description("Deposit Money Agent account to Customer account Successfully");
    }

    @Test(priority = 3, description = "Withdraw Money by Customer account to Agent")
    public void withdrawByCustomer() {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(prop.getProperty("customer01PhoneNo"));
        model.setTo_account(prop.getProperty("agentPhoneNo"));
        model.setAmount(500);

        JsonPath jsonPath = transaction.withdraw(prop.getProperty("token"), prop.getProperty("partnerKey"), model);
        String messageActual = jsonPath.get("message");
        Assert.assertTrue(messageActual.contains("Withdraw successful"));
        Allure.description("Withdraw Money by Customer account to Agent Successfully");
    }

    @Test(priority = 4, description = "Send Money Customer to Another Customer")
    public void sendMoneyToCustomer() {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(prop.getProperty("customer01PhoneNo"));
        model.setTo_account(prop.getProperty("customer02PhoneNo"));
        model.setAmount(500);

        JsonPath jsonPath = transaction.sendMoney(prop.getProperty("token"), prop.getProperty("partnerKey"), model);
        String messageActual = jsonPath.get("message");
        Assert.assertTrue(messageActual.contains("Send money successful"));
        Allure.description("Send Money Customer to Another Customer Successfully");
    }

    @Test(priority = 5, description = "Payment to Merchant")
    public void paymentToMerchant() {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(prop.getProperty("customer02PhoneNo"));
        model.setTo_account(prop.getProperty("merchantPhoneNo"));
        model.setAmount(100);

        JsonPath jsonPath = transaction.payment(prop.getProperty("token"), prop.getProperty("partnerKey"), model);
        String messageActual = jsonPath.get("message");
        Assert.assertTrue(messageActual.contains("Payment successful"));
        Allure.description("Payment to Merchant by Customer02 Successfully");
    }

    @Test(priority = 6, description = "Check Balance of 2nd Customer")
    public void checkBalance() {
        String phone = prop.getProperty("customer02PhoneNo");
        transaction.checkBalance(prop.getProperty("token"), prop.getProperty("partnerKey"), phone);
        Allure.description("Check Balance of 2nd Customer");
    }
}
