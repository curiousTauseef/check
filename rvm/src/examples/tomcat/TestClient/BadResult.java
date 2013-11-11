/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: BadResult.java,v 1.4 2003/12/05 23:45:07 augart-oss Exp $
/**
 * @author Julian Dolby
 */

package TestClient;

class BadResult extends Exception {
    
    BadResult(Request req, String detail) {
        super(req.toString() + ": " + detail);
    }

}
