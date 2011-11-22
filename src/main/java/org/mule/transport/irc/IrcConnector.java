package org.mule.transport.irc;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.transport.AbstractConnector;

public class IrcConnector extends AbstractConnector
{
    public static final String IRC = "irc";
    protected String nickname;

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public IrcConnector(MuleContext context)
    {
        super(context);
    }
       
    @Override
    public void doInitialise() throws InitialisationException
    {

    }

    @Override
    public void doConnect() throws Exception
    {

    }
    @Override
    public void doDisconnect() throws Exception
    {

    }
    @Override
    public void doStart() throws MuleException
    {
       // no-op I think
    }
    @Override
    public void doStop() throws MuleException
    {
    }
    @Override
    public void doDispose()
    {
        // TODO: dispose connection
    }
    public String getProtocol()
    {
        return IRC;
    }
}
