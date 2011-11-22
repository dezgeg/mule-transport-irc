/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transport.irc.config;

import org.mule.tck.FunctionalTestCase;
import org.mule.transport.irc.IrcConnector;

/**
 * TODO
 */
public class IrcNamespaceHandlerTestCase extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        //TODO You'll need to edit this file to configure the properties specific to your transport
        return "irc-namespace-config.xml";
    }

    public void testIrcConfig() throws Exception
    {
        IrcConnector c = (IrcConnector) muleContext.getRegistry().lookupConnector("ircConnector");
        assertNotNull(c);
        assertTrue(c.isConnected());
        assertTrue(c.isStarted());

        //TODO Assert specific properties are configured correctly
    }
}
