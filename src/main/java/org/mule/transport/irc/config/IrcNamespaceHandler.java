package org.mule.transport.irc.config;

import org.mule.config.spring.handlers.AbstractMuleNamespaceHandler;
import org.mule.transport.irc.IrcConnector;
import org.mule.endpoint.URIBuilder;

/**
 * Registers a Bean Definition Parser for handling <code><irc:connector></code> elements
 * and supporting endpoint elements.
 */
public class IrcNamespaceHandler extends AbstractMuleNamespaceHandler
{
    public void init()
    {
        /* This creates handlers for 'endpoint', 'outbound-endpoint' and 'inbound-endpoint' elements.
           The defaults are sufficient unless you have endpoint styles different from the Mule standard ones
           The URIBuilder as constants for common required attributes, but you can also pass in a user-defined String[].
         */
        registerStandardTransportEndpoints(IrcConnector.IRC, new String[] { "channel" }).addAlias("channel", URIBuilder.PATH);

        /* This will create the handler for your custom 'connector' element.  You will need to add handlers for any other
           xml elements you define.  For more information see:
           http://www.mulesoft.org/documentation/display/MULE3USER/Creating+a+Custom+XML+Namespace
        */
        registerConnectorDefinitionParser(IrcConnector.class);
    }
}
