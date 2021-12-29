package mn.demo.appservice.controller;

import java.io.Serializable;

public class TestUnauthorizedResponse implements Serializable {
    private static final long serialVersionUID = 53362719207953437L;
    private String aa1;
    private String aa2;

    public TestUnauthorizedResponse(
            String aa1, String aa2
    ) {
        this.aa1 = aa1;
        this.aa2 = aa2;
    }

    public String getAa1() {
        return aa1;
    }

    public void setAa1(String aa1) {
        this.aa1 = aa1;
    }

    public String getAa2() {
        return aa2;
    }

    public void setAa2(String aa2) {
        this.aa2 = aa2;
    }
}
