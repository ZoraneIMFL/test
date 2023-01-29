package service;

import junit.framework.TestCase;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.ws.rs.core.Response;


import static org.junit.Assert.assertEquals;


@EnableServices(value = "jaxrs")
@RunWith(ApplicationComposer.class)
public class AccountCreateBeanTests extends TestCase {
    @Module
    @Classes(AccountCreateBean.class)
    public WebApp app() {
        return new WebApp().contextRoot("test");
    }

    @Test
    public void test() throws Exception{
        WebClient client = WebClient.create("http://localhost:4204").path("/test/Register");
        Response response = client.post("slip");
        System.out.println(response.readEntity(String.class));

    }

}
