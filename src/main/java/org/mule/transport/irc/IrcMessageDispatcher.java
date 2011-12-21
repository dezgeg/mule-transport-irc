package org.mule.transport.irc;

import org.apache.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.transport.AbstractMessageDispatcher;

public class IrcMessageDispatcher extends AbstractMessageDispatcher
{
	private static Logger logger = Logger.getLogger(IrcMessageDispatcher.class);
    protected IrcConnection getConnection()
    {
    	return ((IrcConnector)connector).getConnection();
    }
    public String getChannel()
    {
    	return "#" + this.getEndpoint().getEndpointURI().getUri().getFragment();
    }
    public IrcMessageDispatcher(OutboundEndpoint endpoint)
    {
        super(endpoint);
    }

    @Override
    public void doConnect() throws Exception
    {
    	this.getConnection().joinChannel(this.getChannel());
    }

    @Override
    public void doDisconnect() throws Exception
    {
        this.getConnection().partChannel(this.getChannel());
    }
    @Override
    public void doDispatch(MuleEvent event) throws Exception
    {
    	logger.error(event);
    	logger.error(event.getMessage());
    	logger.error(event.getMessageAsString());
    	this.getConnection().sendMessage(this.getChannel(), event.getMessageAsString());
    }

    @Override
    public MuleMessage doSend(MuleEvent event) throws Exception
    {
    	// Is this or doDispatch needed?
        /* IMPLEMENTATION NOTE: Should send the event payload over the
           transport. If there is a response from the transport it shuold be
           returned from this method. The sendEvent method is called when the
           endpoint is running synchronously and any response returned will
           ultimately be passed back to the callee. This method is executed in
           the same thread as the request thread. */

        /* IMPLEMENTATION NOTE: The event message needs to be transformed for the outbound transformers to take effect. This
           isn't done automatically in case the dispatcher needs to modify the message before apllying transformers.  To
           get the transformed outbound message call -
           event.transformMessage(); */

        // TODO Write the client code here to send the event over this
        // transport (or to dispatch the event to a store or repository)

        // TODO Once the event has been sent, return the result (if any)
        // wrapped in a MuleMessage object

        throw new UnsupportedOperationException("doSend");
    }
}

