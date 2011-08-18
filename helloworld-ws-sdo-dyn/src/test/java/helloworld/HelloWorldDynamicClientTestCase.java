/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.Assert;

import org.apache.tuscany.sca.host.embedded.SCADomain;
import org.apache.tuscany.sca.host.embedded.SCATestCaseRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;

/**
 * Test case for helloworld web service client 
 */
public class HelloWorldDynamicClientTestCase {

    private HelloWorldService helloWorldService;
    private SCADomain scaDomain;
    
    private SCATestCaseRunner server;

    @Before
    public void startClient() throws Throwable {
        try {
            scaDomain = SCADomain.newInstance("helloworlddynwsclient.composite");
            helloWorldService = scaDomain.getService(HelloWorldService.class, "HelloWorldServiceComponent");
    
            server =  new SCATestCaseRunner(HelloWorldTestServer.class);
            server.before();

        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Test
    public void testDynamicWSClient() throws Exception {
    	// Name name = HelloworldFactory.INSTANCE.createName();
    	DataObject name = DataFactory.INSTANCE.create("http://helloworld", "Name");
    	// name.setFirst("John");
    	name.setString("first", "John");
    	// name.setLast("Smith");
    	name.setString("last", "Smith");
    	String msg = helloWorldService.getGreetings(null /* ??? name */);
    	Assert.assertEquals("Hello John Smith", msg);
    }

    @Test
    public void testHasWSDL() throws Exception {
        // test that has exposed an HTTP endpoint that works as expected
        // to keep this test simple just do ?wsdl on the endpoint  
        URL url = new URL("http://localhost:8085/HelloworldComponent/Helloworld?wsdl");
        Assert.assertTrue(read(url.openStream()).contains("address location="));    	
    }

    @After
    public void stopClient() throws Exception {
    	server.after();
        scaDomain.close();
    }

    private static String read(InputStream is) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}
