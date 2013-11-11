/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: GetRequest.java,v 1.4 2003/12/05 23:45:07 augart-oss Exp $
/**
 * @author Julian Dolby
 */

package TestClient;

import java.io.IOException;
import HTTPClient.*;

public class GetRequest extends Request {

    public String toString() {
        return "GET: " + url;
    }

    public void setUrl(String url) {
        super.setUrl( url );
    }
    
    public void setDesired(String fileName) {
        super.setDesired( fileName );
    }

    HTTPResponse doGet(HTTPConnection server) 
        throws IOException, ModuleException
    {
        return server.Get( url.getPath() );
    }

}

