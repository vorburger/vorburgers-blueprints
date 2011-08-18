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

import java.io.IOException;
import java.net.Socket;

import org.apache.tuscany.sca.host.embedded.SCADomain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Starts up the SCA runtime which starts listening for service requests
 */
public class HelloWorldTestServer {

    private SCADomain scaDomain;

        @Before
	public void startServer() throws Exception {
            try {
                scaDomain = SCADomain.newInstance("helloworldws.composite");
            } catch (Exception e) {
                e.printStackTrace();
            }
	}

	@Test
	public void testPing() throws IOException {
		new Socket("127.0.0.1", 8085);
	}

	@After
	public void stopServer() throws Exception {
            scaDomain.close();
	}

}
