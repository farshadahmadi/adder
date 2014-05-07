package com.arvue.apps.adder;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Component;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@PreserveOnRefresh
@SuppressWarnings("serial")
public class App extends UI {
	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout mainLAyout = new VerticalLayout();
		setContent(mainLAyout);
		mainLAyout.setSizeFull();
		
		Panel panel = new Panel("Add Panel");
		panel.setHeight("200px");
		panel.setWidth("400px");
		mainLAyout.addComponent(panel);
		mainLAyout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		VerticalLayout v = new VerticalLayout();
		v.setMargin(true);
		panel.setContent(v);
		v.setSizeFull();
		
		HorizontalLayout h = new HorizontalLayout();
		h.setSpacing(true);
		v.addComponent(h);
		
		final TextField firstNumberTextField = new TextField("First number: ");
		firstNumberTextField.setConversionError("Please only insert integers");
		firstNumberTextField.setImmediate(true);
		h.addComponent(firstNumberTextField);
		
		final TextField secondNumberTextField = new TextField("Second number: ");
		secondNumberTextField.setConversionError("Please only insert integers");
		secondNumberTextField.setImmediate(true);
		h.addComponent(secondNumberTextField);
		
		final Button addButton = new Button("Add");
		v.addComponent(addButton);
		v.setComponentAlignment(addButton, Alignment.MIDDLE_RIGHT);
		
		addButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					Integer num1 = (Integer) firstNumberTextField.getConvertedValue();
					Integer num2 = (Integer) secondNumberTextField.getConvertedValue();
					Integer result = num1 + num2;
					//System.out.println(a);
					Notification.show(result.toString());
				}
				catch (ConversionException e) {}
			}
		});
		
		ObjectProperty<Integer> firstNumberProperty = new ObjectProperty<Integer>(0);
		firstNumberTextField.setPropertyDataSource(firstNumberProperty);
		
		ObjectProperty<Integer> secondNumberProperty = new ObjectProperty<Integer>(0);
		secondNumberTextField.setPropertyDataSource(secondNumberProperty);
		
	}
}
