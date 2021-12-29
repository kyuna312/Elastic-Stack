package mn.demo.appservice.controller;

import java.io.Serializable;

public class TestUnauthorizedRequest implements Serializable {
    private static final long serialVersionUID = 5336271959207953437L;
    private String bb1;
    private String bb2;

    public TestUnauthorizedRequest() {
        super();
    }

    public String getBb1() {
        return bb1;
    }

    public void setBb1(String bb1) {
        this.bb1 = bb1;
    }

    public String getBb2() {
        return bb2;
    }

    public void setBb2(String bb2) {
        this.bb2 = bb2;
    }
}