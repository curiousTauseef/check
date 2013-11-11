/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: BadRequest.java,v 1.5 2003/12/05 23:45:07 augart-oss Exp $
/**
 * @author Julian Dolby
 */

package TestClient;

class BadRequest extends Exception {
    
    private String errorText;

    BadRequest(String msg, String detail) {
        super(msg);
        errorText = detail;
    }

    public String getMessage() {
        return super.getMessage() + errorText;
    }
}
