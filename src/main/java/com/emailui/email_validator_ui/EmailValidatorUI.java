package com.emailui.email_validator_ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class EmailValidatorUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final VerticalLayout layout = new VerticalLayout();
        final TextField email = new TextField();
        email.setCaption("Enter an email address");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
        	String valid;
            if(Validator.validate(email.getValue()) == 4){
            	valid = "Email is valid";
            }
            else{
            	valid = "Email is invalid";
            }
            Notification notif = new Notification(valid);
            notif.setDelayMsec(2000);
            notif.show(Page.getCurrent());
            
        });
        
        layout.addComponents(email, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "EmailValidatorUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = EmailValidatorUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
