package org.mule.transport.irc;

import java.net.URI;
import java.net.URISyntaxException;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.transport.AbstractConnector;

public class IrcConnector extends AbstractConnector
{
    public static final String IRC = "irc";
    public static final int IRC_DEFAULT_PORT = 6667;
    protected IrcConnection connection;
    protected URI server;
    protected String nickname;
    
	public IrcConnector(MuleContext context)
    {
        super(context);
    }
    
    public String getNickname() {
		return nickname;
	}

	public String getServer() {
		return server.toString();
	}
	public URI getServerURI()
	{
		return server;
	}

	public void setServer(String server) throws URISyntaxException {
		this.server = new URI(server);
	}

	public IrcConnection getConnection() {
		return connection;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
       
    @Override
    public void doInitialise() throws InitialisationException
    {
    }

    @Override
    public void doConnect() throws Exception
    {
    	logger.error("IrcConnector connecting");
    	connection = new IrcConnection(this);
    	URI uri = this.getServerURI();
    	int port = uri.getPort();
    	if(port < 0)
    		port = IRC_DEFAULT_PORT;
    	
    	String userInfo = uri.getUserInfo();
    	if(userInfo.contains(":"))
    	{
    		String[] parts = userInfo.split(":");
    		connection.connect(uri.getHost(), port, this.getNickname(), parts[0], parts[1]);
    	}
    	else
    	{
    		connection.connect(uri.getHost(), port, this.getNickname(), userInfo, "");
    	}
    	logger.error("IrcConnector connected");
    }
    @Override
    public void doDisconnect() throws Exception
    {
    	connection.disconnect();
    }
    @Override
    public void doStart() throws MuleException
    {
       // no-op I think
    	logger.error("IrcConnector starting");
    }
    @Override
    public void doStop() throws MuleException
    {
    }
    @Override
    public void doDispose()
    {
        connection.dispose();
    }
    public String getProtocol()
    {
        return IRC;
    }
}
