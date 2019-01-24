package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.micronaut.security.token.basicauth.BasicAuthTokenReaderConfigurationProperties;
import io.micronaut.security.token.basicauth.BasicAuthTokenValidator;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
	System.out.println(BasicAuthTokenReaderConfigurationProperties.PREFIX);
        ApplicationContext ctx = Micronaut.run(Application.class);

        String propName = "micronaut.security.token.basic-auth.enabled";
        Optional<Boolean> property = ctx.getProperty(propName, Boolean.class);
        System.out.print("Property " + propName + " is ");
        if (property.isPresent()) {

            System.out.println(property.get());

        } else {
            System.out.println("not set");
        }


        System.out.println("Context contains bean BasicAuthTokenValidator: " + ctx.containsBean(BasicAuthTokenValidator.class));
    }
}
