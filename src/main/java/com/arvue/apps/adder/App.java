package com.arvue.apps.adder;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Component;
import com.vaadin.annotations.PreserveOnRefresh;

@PreserveOnRefresh
@SuppressWarnings("serial")
public class App extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Component c = new Main();
        int a = 0;
        c.setSizeFull();
        setContent(c);
    }

}
