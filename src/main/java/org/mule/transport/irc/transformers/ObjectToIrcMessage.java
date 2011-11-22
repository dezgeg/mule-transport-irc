/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.irc.transformers;

import org.mule.transformer.AbstractMessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.MuleMessage;

/**
 * <code>ObjectToIrcMessage</code> TODO Document
 */
public class ObjectToIrcMessage extends AbstractMessageTransformer
{

    /* For general guidelines on writing transports see
       http://www.mulesoft.org/documentation/display/MULE3USER/Creating+Transports */

    public ObjectToIrcMessage()
    {
        /* IMPLEMENTATION NOTE: Here you can set default types that the
           transformer will accept at runtime.  Mule will then validate the
           transformer at runtime. You can register one or more source types.

             registerSourceType(XXX.class.getName());
        */

        /* IMPLEMENTATION NOTE: It's good practice to set the expected return
           type for this transformer here This helps Mule validate event flows
           and Transformer chains

             setReturnDataType(DataTypeFactory.create(YYY.class);
        */
    }

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException
    {
        // TODO Transformer the message here. See comments in {@link AbstractMessageAwareTransformer}

        // Make sure you return a transformed object that matches the
        // returnClass type

        throw new UnsupportedOperationException("transform");
    }
}
