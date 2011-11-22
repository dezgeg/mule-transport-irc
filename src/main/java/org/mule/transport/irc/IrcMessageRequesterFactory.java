package org.mule.transport.irc;

import org.mule.api.MuleException;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.transport.MessageRequester;
import org.mule.transport.AbstractMessageRequesterFactory;

public class IrcMessageRequesterFactory extends AbstractMessageRequesterFactory
{

    public MessageRequester create(InboundEndpoint endpoint) throws MuleException
    {
        return new IrcMessageRequester(endpoint);
    }

}
