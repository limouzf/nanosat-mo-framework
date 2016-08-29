/* ----------------------------------------------------------------------------
 * Copyright (C) 2014      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : CCSDS MO HTTP Transport Framework
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package esa.mo.mal.transport.http;

import esa.mo.mal.transport.gen.receivers.GENIncomingByteMessageDecoderFactory;
import esa.mo.mal.transport.http.api.AbstractContextHandler;
import esa.mo.mal.transport.http.api.AbstractHttpRequest;
import esa.mo.mal.transport.http.api.AbstractHttpResponse;
import esa.mo.mal.transport.http.api.HttpApiImplException;

/**
 * The HttpHandler implementation for the MAL HTTP Transport Server.
 * Reads the encoded MAL message from the HTTP request and forwards it to the HTTPTransport.
 */
public class HTTPContextHandlerNoEncoding implements AbstractContextHandler
{
  protected final HTTPTransport transport;
  protected byte[] data;

  /**
   * Constructor.
   *
   * @param transport The parent HTTP transport.
   */
  public HTTPContextHandlerNoEncoding(HTTPTransport transport)
  {
    this.transport = transport;
  }

  @Override
  public void processRequest(AbstractHttpRequest request) throws HttpApiImplException {
    data = request.readFullBody();
  }

  @Override
  public void processResponse(AbstractHttpResponse response) throws HttpApiImplException {
    response.setStatusCode(204);
    response.send();
  }

  @Override
  public void finishHandling()
  {
    transport.receive(null, new GENIncomingByteMessageDecoderFactory.GENIncomingByteMessageDecoder(transport, data));
  }
}