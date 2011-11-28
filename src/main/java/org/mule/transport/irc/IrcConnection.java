package org.mule.transport.irc;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jibble.pircbot.*;
import org.mule.api.MuleMessage;
import org.mule.api.transport.MessageReceiver;

public class IrcConnection extends PircBot
{
	protected Logger logger = Logger.getLogger(getClass());
	private IrcConnector connector;
	public IrcConnection(IrcConnector connector)
	{
		super();
		this.connector = connector;
	}
	public void connect(String host, int port, String nickname, String username, String password)
	{
		this.setLogin(username);
		this.setName(nickname);
		this.setAutoNickChange(true);
		try
		{
			this.connect(host, port, password);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e); // XXX deal with this crap later
		}
	}
	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		logger.error("Received message: " + message);
		try
		{
			MuleMessage muleMessage = this.connector.getMuleMessageFactory().create(message, "utf-8"); // XXX figure out encoding?
			logger.error("Created message: " + muleMessage);
			Map<Object, MessageReceiver> receivers = ((IrcConnector)this.connector).getReceivers();
			logger.error("Message receivers: " + receivers.toString());
			for(MessageReceiver recv : receivers.values())
			{
				try {
					IrcMessageReceiver imr = (IrcMessageReceiver)recv;
					if(imr.getChannel().equals(channel))
					{
						logger.error("Found receiver: " + imr.toString());
						imr.routeMessage(muleMessage);
					}
				}
				catch (ClassCastException cce)
				{
					continue;
				}
			}
			logger.error("Routed message");
		}
		catch(Exception e)
		{
			logger.error(e);
			e.printStackTrace();
			throw new RuntimeException(e); // XXX deal with this crap later
		}
	}
}
