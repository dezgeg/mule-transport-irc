package org.mule.transport.irc;

import org.mule.transport.ConnectException;
import org.mule.transport.AbstractMessageReceiver;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.lifecycle.CreateException;
import org.mule.api.transport.Connector;


public class IrcMessageReceiver extends AbstractMessageReceiver
{
    public IrcMessageReceiver(Connector connector, FlowConstruct flowConstruct,
                              InboundEndpoint endpoint)
            throws CreateException
    {
        super(connector, flowConstruct, endpoint);
    	logger.error("IrcMessageReceiver created");
    }
    protected IrcConnection getConnection()
    {
    	logger.error("IrcMessageReceiver connecting");
    	return ((IrcConnector)connector).getConnection();
    }
    public String getChannel()
    {
    	return "#" + this.getEndpointURI().getUri().getFragment();
    }
    @Override
    public void doInitialise()
    {
        this.setReceiverKey(this.getChannel());
    }
    @Override
    public void doConnect() throws ConnectException
    {
    }
    @Override
    public void doDisconnect() throws ConnectException
    {
    }

    @Override
    public void doStart()
    {
        String channel = this.getChannel();
    	logger.error("IrcMessageReceiver joining channel: " + channel);
        this.getConnection().joinChannel(channel);        
    }

    @Override
    public void doStop()
    {
        String channel = this.getChannel();
        this.getConnection().partChannel(channel);
    }

    @Override
    public void doDispose()
    {
    }

}
