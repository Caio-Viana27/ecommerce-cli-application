package ecommerce.application.views;

import ecommerce.application.controllers.LoginMethod;
import ecommerce.application.interfaces.Menu;

public class SignIn extends Menu implements LoginMethod {

    public SignIn() {}

    @Override
    public void draw() {
        signIn();
    }

    public void signIn() {

    }
}
