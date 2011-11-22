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

import org.mule.transformer.AbstractTransformerTestCase;
import org.mule.api.transformer.Transformer;
import org.mule.transformer.types.DataTypeFactory;

public class IrcTransformersTestCase extends AbstractTransformerTestCase
{
    /* For general guidelines on writing transports see
       http://www.mulesoft.org/documentation/display/MULE3USER/Creating+Transports */

    @Override
    public Object getTestData()
    {
        // TODO create a test data object that will be passed into the
        // transformer
        throw new UnsupportedOperationException("getTestData");
    }

    @Override
    public Object getResultData()
    {
        // TODO Return the result data expected once the getTestData()
        // value has been transformed
        throw new UnsupportedOperationException("getResultData");
    }

    @Override
    public Transformer getTransformer()
    {
        Transformer transformer = new IrcMessageToObject();
        // Set the correct return class for this roundtrip test
        transformer.setReturnDataType(DataTypeFactory.create(this.getResultData().getClass()));
        return transformer;
    }

    @Override
    public Transformer getRoundTripTransformer()
    {
        Transformer transformer = new ObjectToIrcMessage();
        // Set the correct return class for this roundtrip test
        transformer.setReturnDataType(DataTypeFactory.create(this.getTestData().getClass()));
        return transformer;
    }
}
