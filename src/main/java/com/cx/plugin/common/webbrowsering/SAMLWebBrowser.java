package com.cx.plugin.common.webbrowsering;


import com.cx.plugin.common.events.EventBus;
import com.cx.plugin.common.events.ISubscriber;
import com.cx.plugin.common.exception.SamlException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.UUID;

/**
 * Created by eranb on 07/11/2016.
 */
public class SAMLWebBrowser extends Application implements ISubscriber, ISAMLWebBrowser {

    private static final String ERROR_QUERY_KEY = "Error",
            SUCCESS_EVENT_NAME = "Success",
            FAILURE_EVENT_NAME = "Failure";

    WebEngine webEngine;
    String url, content, ott, error;


    public String BrowseForOtt(String samlURL, String clientName) throws SamlException {
        UUID key = UUID.randomUUID();
        EventBus.subscribe(key, this);
        launch(getClass(), samlURL, key.toString(), clientName);
        EventBus.unsubsribe(key);
        if (hasErrors())
            throw new SamlException(error);
        return ott;
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<String> params = getParameters().getRaw();
        if (params.size() == 0) {
            return;
        }

        WebView browser = new WebView();
        webEngine = browser.getEngine();
        webEngine.setUserAgent(params.get(2));
        webEngine.load(params.get(0));
        webEngine.getLoadWorker().stateProperty().addListener(createChangeListener());
        stage.setScene(new Scene(browser));
        stage.show();
    }

    private ChangeListener<Worker.State> createChangeListener() {
        return new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                if (newState == Worker.State.SUCCEEDED) {
                    url = webEngine.getDocument().getDocumentURI();
                    content = GetDocumentBody();
                    CheckForErrors();
                    if (!hasErrors())
                        Extractott();
                } else if (newState == Worker.State.FAILED) {

                    error = webEngine.getLoadWorker().getException().toString();
                }

                if (hasOtt() || hasErrors())
                    Exit();
            }
        };
    }

    private void Extractott() {
        if (!url.toLowerCase().contains("samlacs")) return;
        ott = content;
    }

    private String GetDocumentBody() {
        try {
            return webEngine.getDocument().getElementsByTagName("body").item(0).getTextContent();
        } catch (Exception exc) {
            return "";
        }
    }

    private void CheckForErrors() {
        checkForUrlQueryErrors();
        if (hasErrors()) return;
        checkForBodyErrors();
    }

    private void checkForUrlQueryErrors() {
        String query = getQuery();
        if (query == null || query.isEmpty() || !query.contains(ERROR_QUERY_KEY)) return;

        String[] parameters = query.split("&");

        for (String param : parameters) {
            if (param.contains(ERROR_QUERY_KEY)) {
                String[] keyValue = param.split("=");
                error = keyValue.length > 1 ? keyValue[1] : "Internal server error";
            }
        }
    }

    private String getQuery() {
        try {
            return new URL(url).getQuery();
        } catch (Exception e) {
            return "";
        }

    }


    private void checkForBodyErrors() {
        if (content.contains("HTTP 500")) {
            error = "Internal server error";
        }
        if (hasErrors() || !content.contains("messageDetails")) return;
        String[] contentComponents = content.split("\\r?\\n");
        for (String component : contentComponents) {
            if (component.contains("messageDetails")) {
                error = component.split(":")[1];
                break;
            }
        }

    }

    private boolean hasErrors() {
        return error != null && !error.isEmpty();
    }

    private boolean hasOtt() {
        return ott != null && !ott.isEmpty();
    }

    private void Exit() {
        UUID callerKey = UUID.fromString(getParameters().getRaw().get(1));
        if (hasErrors())
            EventBus.publish(FAILURE_EVENT_NAME, callerKey, error);
        if (hasOtt())
            EventBus.publish(SUCCESS_EVENT_NAME, callerKey, ott);
        Platform.exit();
    }

    @Override
    public void eventPublished(String eventName, String parameter) {
        switch (eventName) {
            case SUCCESS_EVENT_NAME:
                ott = parameter;
                break;
            case FAILURE_EVENT_NAME:
                error = parameter;
                break;
        }
    }
}
