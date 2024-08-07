/**
 * LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.flare.project.webService.client.requestListClient;
/*
 *  LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub java implementation
 */

public class LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub extends org.apache.axis2.client.Stub {
  protected org.apache.axis2.description.AxisOperation[] _operations;

  // hashmaps to keep the fault mapping
  private java.util.Map<org.apache.axis2.client.FaultMapKey, String>
      faultExceptionNameMap =
          new java.util.HashMap<org.apache.axis2.client.FaultMapKey, String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, String>
      faultExceptionClassNameMap =
          new java.util.HashMap<org.apache.axis2.client.FaultMapKey, String>();
  private java.util.Map<org.apache.axis2.client.FaultMapKey, String> faultMessageMap =
      new java.util.HashMap<org.apache.axis2.client.FaultMapKey, String>();

  private static int counter = 0;

  private static synchronized String getUniqueSuffix() {
    // reset the counter if it is greater than 99999
    if (counter > 99999) {
      counter = 0;
    }
    counter = counter + 1;
    return Long.toString(System.currentTimeMillis()) + "_" + counter;
  }

  private void populateAxisService() throws org.apache.axis2.AxisFault {

    // creating the Service with a unique name
    _service =
        new org.apache.axis2.description.AxisService(
            "LGCY_APRV_EA_TOTALAPRV_04_SOService" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[1];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName(
            "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_04_SO"));
    _service.addOperation(__operation);

    _operations[0] = __operation;
  }

  // populates the faults
  private void populateFaults() {}

  /** Constructor that takes in a configContext */
  public LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      String targetEndpoint,
      boolean useSeparateListener)
      throws org.apache.axis2.AxisFault {
    // To populate AxisService
    populateAxisService();
    populateFaults();

    _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

    _serviceClient
        .getOptions()
        .setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
  }

  /** Default Constructor */
  public LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(
        configurationContext,
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_04_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV");
  }

  /** Default Constructor */
  public LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub() throws org.apache.axis2.AxisFault {

    this(
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_04_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV");
  }

  /** Constructor taking the target endpoint */
  public LGCY_APRV_EA_TOTALAPRV_04_SOServiceStub(String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }


  public MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
      lGCY_APRV_EA_TOTALAPRV_04_SO(
          MT_LGCY_APRV_EA_TOTALAPRV_04_S
              mT_LGCY_APRV_EA_TOTALAPRV_04_S0)
          throws java.rmi.RemoteException {

    org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();
    try {
      org.apache.axis2.client.OperationClient _operationClient =
          _serviceClient.createClient(_operations[0].getName());
      _operationClient.getOptions().setAction("http://sap.com/xi/WebService/soap1.1");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(
          _operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
          "&");

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env =
          toEnvelope(
              getFactory(_operationClient.getOptions().getSoapVersionURI()),
              mT_LGCY_APRV_EA_TOTALAPRV_04_S0,
              optimizeContent(
                  new javax.xml.namespace.QName(
                      "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_04_SO")),
              new javax.xml.namespace.QName(
                  "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S"));

      // adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      // execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext =
          _operationClient.getMessageContext(
              org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
      _returnEnv.buildWithAttachments();

      Object object =
          fromOM(
              _returnEnv.getBody().getFirstElement(),
              MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (MT_LGCY_APRV_EA_TOTALAPRV_04_S_response)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"))) {
          // make the fault by reflection
          try {
            String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"));
            Class exceptionClass = Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(String.class);
            Exception ex = (Exception) constructor.newInstance(f.getMessage());
            // message class
            String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"));
            Class messageClass = Class.forName(messageClassName);
            Object messageObject = fromOM(faultElt, messageClass);
            java.lang.reflect.Method m =
                exceptionClass.getMethod("setFaultMessage", new Class[] {messageClass});
            m.invoke(ex, new Object[] {messageObject});

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          } catch (ClassCastException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (ClassNotFoundException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (NoSuchMethodException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (java.lang.reflect.InvocationTargetException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (IllegalAccessException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          } catch (InstantiationException e) {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        } else {
          throw f;
        }
      } else {
        throw f;
      }
    } finally {
      if (_messageContext.getTransportOut() != null) {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  public void startlGCY_APRV_EA_TOTALAPRV_04_SO(
      MT_LGCY_APRV_EA_TOTALAPRV_04_S
          mT_LGCY_APRV_EA_TOTALAPRV_04_S0,
      final LGCY_APRV_EA_TOTALAPRV_04_SOServiceCallbackHandler callback)
      throws java.rmi.RemoteException {

    org.apache.axis2.client.OperationClient _operationClient =
        _serviceClient.createClient(_operations[0].getName());
    _operationClient.getOptions().setAction("http://sap.com/xi/WebService/soap1.1");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(
        _operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
        "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext =
        new org.apache.axis2.context.MessageContext();

    // Style is Doc.

    env =
        toEnvelope(
            getFactory(_operationClient.getOptions().getSoapVersionURI()),
            mT_LGCY_APRV_EA_TOTALAPRV_04_S0,
            optimizeContent(
                new javax.xml.namespace.QName(
                    "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_04_SO")),
            new javax.xml.namespace.QName(
                "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(
        new org.apache.axis2.client.async.AxisCallback() {
          public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
            try {
              org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

              Object object =
                  fromOM(
                      resultEnv.getBody().getFirstElement(),
                      MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
                          .class);
              callback.receiveResultlGCY_APRV_EA_TOTALAPRV_04_SO(
                  (MT_LGCY_APRV_EA_TOTALAPRV_04_S_response)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(e);
            }
          }

          public void onError(Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"))) {
                  // make the fault by reflection
                  try {
                    String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"));
                    Class exceptionClass = Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(String.class);
                    Exception ex =
                        (Exception) constructor.newInstance(f.getMessage());
                    // message class
                    String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_04_SO"));
                    Class messageClass = Class.forName(messageClassName);
                    Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new Class[] {messageClass});
                    m.invoke(ex, new Object[] {messageObject});

                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                  }
                } else {
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
                }
              } else {
                callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(f);
              }
            } else {
              callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(error);
            }
          }

      public void onFault(org.apache.axis2.context.MessageContext faultContext) {
          org.apache.axis2.AxisFault fault =
              org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
          onError(fault);
        }

        public void onComplete() {
          try {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
          } catch (org.apache.axis2.AxisFault axisFault) {
            callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_04_SO(axisFault);
          }
        }
      });

  org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
  if (_operations[0].getMessageReceiver() == null
      && _operationClient.getOptions().isUseSeparateListener()) {
    _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
    _operations[0].setMessageReceiver(_callbackReceiver);
  }

  // execute the operation client
  _operationClient.execute(false);
}

private javax.xml.namespace.QName[] opNameArray = null;

private boolean optimizeContent(javax.xml.namespace.QName opName) {

  if (opNameArray == null) {
    return false;
  }
  for (int i = 0; i < opNameArray.length; i++) {
    if (opName.equals(opNameArray[i])) {
      return true;
    }
  }
  return false;
}
// http://lchaspeaq01:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_04_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV
public static class MT_LGCY_APRV_EA_TOTALAPRV_04_S
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S", "ns1");

  /** field for MT_LGCY_APRV_EA_TOTALAPRV_04_S */
  protected DT_LGCY_APRV_EA_TOTALAPRV_04_S localMT_LGCY_APRV_EA_TOTALAPRV_04_S;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_APRV_EA_TOTALAPRV_04_S
   */
  public DT_LGCY_APRV_EA_TOTALAPRV_04_S getMT_LGCY_APRV_EA_TOTALAPRV_04_S() {
    return localMT_LGCY_APRV_EA_TOTALAPRV_04_S;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_APRV_EA_TOTALAPRV_04_S
   */
  public void setMT_LGCY_APRV_EA_TOTALAPRV_04_S(DT_LGCY_APRV_EA_TOTALAPRV_04_S param) {

    this.localMT_LGCY_APRV_EA_TOTALAPRV_04_S = param;
  }

  /**
   * @param parentQName
   * @param factory
   * @return org.apache.axiom.om.OMElement
   */
  public org.apache.axiom.om.OMElement getOMElement(
      final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
      throws org.apache.axis2.databinding.ADBException {

    return factory.createOMElement(
        new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
    serialize(parentQName, xmlWriter, false);
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName,
      javax.xml.stream.XMLStreamWriter xmlWriter,
      boolean serializeType)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

    // We can safely assume an element has only one type associated with it

    if (localMT_LGCY_APRV_EA_TOTALAPRV_04_S == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_APRV_EA_TOTALAPRV_04_S cannot be null!");
    }
    localMT_LGCY_APRV_EA_TOTALAPRV_04_S.serialize(MY_QNAME, xmlWriter);
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/APRV")) {
      return "ns1";
    }
    return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
  }

  /** Utility method to write an element start tag. */
  private void writeStartElement(
      String prefix,
      String namespace,
      String localPart,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
    } else {
      if (namespace.length() == 0) {
        prefix = "";
      } else if (prefix == null) {
        prefix = generatePrefix(namespace);
      }

      xmlWriter.writeStartElement(prefix, localPart, namespace);
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
  }

  /** Util method to write an attribute with the ns prefix */
  private void writeAttribute(
      String prefix,
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
    } else {
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
      xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeAttribute(
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attValue);
    } else {
      xmlWriter.writeAttribute(
          registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeQNameAttribute(
      String namespace,
      String attName,
      javax.xml.namespace.QName qname,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    String attributeNamespace = qname.getNamespaceURI();
    String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
    if (attributePrefix == null) {
      attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
    }
    String attributeValue;
    if (attributePrefix.trim().length() > 0) {
      attributeValue = attributePrefix + ":" + qname.getLocalPart();
    } else {
      attributeValue = qname.getLocalPart();
    }

    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attributeValue);
    } else {
      registerPrefix(xmlWriter, namespace);
      xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
    }
  }
  /** method to handle Qnames */
  private void writeQName(
      javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String namespaceURI = qname.getNamespaceURI();
    if (namespaceURI != null) {
      String prefix = xmlWriter.getPrefix(namespaceURI);
      if (prefix == null) {
        prefix = generatePrefix(namespaceURI);
        xmlWriter.writeNamespace(prefix, namespaceURI);
        xmlWriter.setPrefix(prefix, namespaceURI);
      }

      if (prefix.trim().length() > 0) {
        xmlWriter.writeCharacters(
            prefix
                + ":"
                + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      } else {
        // i.e this is the default namespace
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }

    } else {
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }
  }

  private void writeQNames(
      javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    if (qnames != null) {
      // we have to store this data until last moment since it is not possible to write any
      // namespace data after writing the charactor data
      StringBuffer stringToWrite = new StringBuffer();
      String namespaceURI = null;
      String prefix = null;

      for (int i = 0; i < qnames.length; i++) {
        if (i > 0) {
          stringToWrite.append(" ");
        }
        namespaceURI = qnames[i].getNamespaceURI();
        if (namespaceURI != null) {
          prefix = xmlWriter.getPrefix(namespaceURI);
          if ((prefix == null) || (prefix.length() == 0)) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
          }

          if (prefix.trim().length() > 0) {
            stringToWrite
                .append(prefix)
                .append(":")
                .append(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      }
      xmlWriter.writeCharacters(stringToWrite.toString());
    }
  }

  /** Register a namespace prefix */
  private String registerPrefix(
      javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
      throws javax.xml.stream.XMLStreamException {
    String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
      prefix = generatePrefix(namespace);
      javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
      while (true) {
        String uri = nsContext.getNamespaceURI(prefix);
        if (uri == null || uri.length() == 0) {
          break;
        }
        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
      }
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
  }

  /** Factory class that keeps the parse method */
  public static class Factory {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(Factory.class);

    /**
     * static method to create the object Precondition: If this object is an element, the current
     * or next start element starts this object and any intervening reader events are ignorable If
     * this object is not an element, it is a complex type and the reader is at the event just
     * after the outer start element Postcondition: If this object is an element, the reader is
     * positioned at its end element If this object is a complex type, the reader is positioned at
     * the end element of its outer element
     */
    public static MT_LGCY_APRV_EA_TOTALAPRV_04_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      MT_LGCY_APRV_EA_TOTALAPRV_04_S object = new MT_LGCY_APRV_EA_TOTALAPRV_04_S();

      int event;
      javax.xml.namespace.QName currentQName = null;
      String nillableValue = null;
      String prefix = "";
      String namespaceuri = "";
      try {

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        currentQName = reader.getName();

        // Note all attributes that were handled. Used to differ normal attributes
        // from anyAttributes.
        java.util.Vector handledAttributes = new java.util.Vector();

        while (!reader.isEndElement()) {
          if (reader.isStartElement()) {

            if (reader.isStartElement()
                && new javax.xml.namespace.QName(
                        "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S")
                    .equals(reader.getName())) {

              object.setMT_LGCY_APRV_EA_TOTALAPRV_04_S(
                  DT_LGCY_APRV_EA_TOTALAPRV_04_S.Factory.parse(reader));

            } // End of if for expected property start element
            else {
              // 3 - A start element we are not expecting indicates an invalid parameter was
              // passed

              throw new org.apache.axis2.databinding.ADBException(
                  "Unexpected subelement " + reader.getName());
            }

          } else {
            reader.next();
          }
        } // end of while loop

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

public static class ExtensionMapper {

  public static Object getTypeObject(
      String namespaceURI,
      String typeName,
      javax.xml.stream.XMLStreamReader reader)
      throws Exception {

    if ("http://www.lgchem.com/APRV".equals(namespaceURI)
        && "DT_LGCY_APRV_EA_TOTALAPRV_04_S".equals(typeName)) {

      return DT_LGCY_APRV_EA_TOTALAPRV_04_S.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI)
        && "DT_LGCY_APRV_EA_TOTALAPRV_04_S_response".equals(typeName)) {

      return DT_LGCY_APRV_EA_TOTALAPRV_04_S_response.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI)
        && "requestList_type0".equals(typeName)) {

      return RequestList_type0.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI) && "return_type0".equals(typeName)) {

      return Return_type0.Factory.parse(reader);
    }

    throw new org.apache.axis2.databinding.ADBException(
        "Unsupported type " + namespaceURI + " " + typeName);
  }
}

public static class DT_LGCY_APRV_EA_TOTALAPRV_04_S
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_APRV_EA_TOTALAPRV_04_S
  Namespace URI = http://www.lgchem.com/APRV
  Namespace Prefix = ns1
  */

  /** field for RequestList This was an Array! */
  protected RequestList_type0[] localRequestList;

  /**
   * Auto generated getter method
   *
   * @return RequestList_type0[]
   */
  public RequestList_type0[] getRequestList() {
    return localRequestList;
  }

  /** validate the array for RequestList */
  protected void validateRequestList(RequestList_type0[] param) {

    if ((param != null) && (param.length < 1)) {
      throw new RuntimeException("Input values do not follow defined XSD restrictions");
    }
  }

  /**
   * Auto generated setter method
   *
   * @param param RequestList
   */
  public void setRequestList(RequestList_type0[] param) {

    validateRequestList(param);

    this.localRequestList = param;
  }

  /**
   * Auto generated add method for the array for convenience
   *
   * @param param RequestList_type0
   */
  public void addRequestList(RequestList_type0 param) {
    if (localRequestList == null) {
      localRequestList = new RequestList_type0[] {};
    }

    java.util.List list =
        org.apache.axis2.databinding.utils.ConverterUtil.toList(localRequestList);
    list.add(param);
    this.localRequestList =
        (RequestList_type0[]) list.toArray(new RequestList_type0[list.size()]);
  }

  /**
   * @param parentQName
   * @param factory
   * @return org.apache.axiom.om.OMElement
   */
  public org.apache.axiom.om.OMElement getOMElement(
      final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
      throws org.apache.axis2.databinding.ADBException {

    return factory.createOMElement(
        new org.apache.axis2.databinding.ADBDataSource(this, parentQName));
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
    serialize(parentQName, xmlWriter, false);
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName,
      javax.xml.stream.XMLStreamWriter xmlWriter,
      boolean serializeType)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

    String prefix = null;
    String namespace = null;

    prefix = parentQName.getPrefix();
    namespace = parentQName.getNamespaceURI();
    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

    if (serializeType) {

      String namespacePrefix = registerPrefix(xmlWriter, "http://www.lgchem.com/APRV");
      if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            namespacePrefix + ":DT_LGCY_APRV_EA_TOTALAPRV_04_S",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_APRV_EA_TOTALAPRV_04_S",
            xmlWriter);
      }
    }

    if (localRequestList != null) {
      for (int i = 0; i < localRequestList.length; i++) {
        if (localRequestList[i] != null) {
          localRequestList[i].serialize(
              new javax.xml.namespace.QName("", "requestList"), xmlWriter);
        } else {

          throw new org.apache.axis2.databinding.ADBException("requestList cannot be null!!");
        }
      }
    } else {

      throw new org.apache.axis2.databinding.ADBException("requestList cannot be null!!");
    }

    xmlWriter.writeEndElement();
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/APRV")) {
      return "ns1";
    }
    return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
  }

  /** Utility method to write an element start tag. */
  private void writeStartElement(
      String prefix,
      String namespace,
      String localPart,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
    } else {
      if (namespace.length() == 0) {
        prefix = "";
      } else if (prefix == null) {
        prefix = generatePrefix(namespace);
      }

      xmlWriter.writeStartElement(prefix, localPart, namespace);
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
  }

  /** Util method to write an attribute with the ns prefix */
  private void writeAttribute(
      String prefix,
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
    } else {
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
      xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeAttribute(
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attValue);
    } else {
      xmlWriter.writeAttribute(
          registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeQNameAttribute(
      String namespace,
      String attName,
      javax.xml.namespace.QName qname,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    String attributeNamespace = qname.getNamespaceURI();
    String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
    if (attributePrefix == null) {
      attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
    }
    String attributeValue;
    if (attributePrefix.trim().length() > 0) {
      attributeValue = attributePrefix + ":" + qname.getLocalPart();
    } else {
      attributeValue = qname.getLocalPart();
    }

    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attributeValue);
    } else {
      registerPrefix(xmlWriter, namespace);
      xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
    }
  }
  /** method to handle Qnames */
  private void writeQName(
      javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String namespaceURI = qname.getNamespaceURI();
    if (namespaceURI != null) {
      String prefix = xmlWriter.getPrefix(namespaceURI);
      if (prefix == null) {
        prefix = generatePrefix(namespaceURI);
        xmlWriter.writeNamespace(prefix, namespaceURI);
        xmlWriter.setPrefix(prefix, namespaceURI);
      }

      if (prefix.trim().length() > 0) {
        xmlWriter.writeCharacters(
            prefix
                + ":"
                + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      } else {
        // i.e this is the default namespace
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }

    } else {
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }
  }

  private void writeQNames(
      javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    if (qnames != null) {
      // we have to store this data until last moment since it is not possible to write any
      // namespace data after writing the charactor data
      StringBuffer stringToWrite = new StringBuffer();
      String namespaceURI = null;
      String prefix = null;

      for (int i = 0; i < qnames.length; i++) {
        if (i > 0) {
          stringToWrite.append(" ");
        }
        namespaceURI = qnames[i].getNamespaceURI();
        if (namespaceURI != null) {
          prefix = xmlWriter.getPrefix(namespaceURI);
          if ((prefix == null) || (prefix.length() == 0)) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
          }

          if (prefix.trim().length() > 0) {
            stringToWrite
                .append(prefix)
                .append(":")
                .append(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      }
      xmlWriter.writeCharacters(stringToWrite.toString());
    }
  }

  /** Register a namespace prefix */
  private String registerPrefix(
      javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
      throws javax.xml.stream.XMLStreamException {
    String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
      prefix = generatePrefix(namespace);
      javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
      while (true) {
        String uri = nsContext.getNamespaceURI(prefix);
        if (uri == null || uri.length() == 0) {
          break;
        }
        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
      }
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
  }

  /** Factory class that keeps the parse method */
  public static class Factory {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(Factory.class);

    /**
     * static method to create the object Precondition: If this object is an element, the current
     * or next start element starts this object and any intervening reader events are ignorable If
     * this object is not an element, it is a complex type and the reader is at the event just
     * after the outer start element Postcondition: If this object is an element, the reader is
     * positioned at its end element If this object is a complex type, the reader is positioned at
     * the end element of its outer element
     */
    public static DT_LGCY_APRV_EA_TOTALAPRV_04_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      DT_LGCY_APRV_EA_TOTALAPRV_04_S object = new DT_LGCY_APRV_EA_TOTALAPRV_04_S();

      int event;
      javax.xml.namespace.QName currentQName = null;
      String nillableValue = null;
      String prefix = "";
      String namespaceuri = "";
      try {

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        currentQName = reader.getName();

        if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
            != null) {
          String fullTypeName =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
          if (fullTypeName != null) {
            String nsPrefix = null;
            if (fullTypeName.indexOf(":") > -1) {
              nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
            }
            nsPrefix = nsPrefix == null ? "" : nsPrefix;

            String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

            if (!"DT_LGCY_APRV_EA_TOTALAPRV_04_S".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_APRV_EA_TOTALAPRV_04_S)
                  ExtensionMapper.getTypeObject(nsUri, type, reader);
            }
          }
        }

        // Note all attributes that were handled. Used to differ normal attributes
        // from anyAttributes.
        java.util.Vector handledAttributes = new java.util.Vector();

        reader.next();

        java.util.ArrayList list1 = new java.util.ArrayList();

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "requestList").equals(reader.getName())) {

          // Process the array and step past its final element's end.

          list1.add(RequestList_type0.Factory.parse(reader));

          // loop until we find a start element that is not part of this array
          boolean loopDone1 = false;
          while (!loopDone1) {
            // We should be at the end element, but make sure
            while (!reader.isEndElement()) reader.next();
            // Step out of this element
            reader.next();
            // Step to next element event.
            while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
            if (reader.isEndElement()) {
              // two continuous end elements means we are exiting the xml structure
              loopDone1 = true;
            } else {
              if (new javax.xml.namespace.QName("", "requestList").equals(reader.getName())) {
                list1.add(RequestList_type0.Factory.parse(reader));

              } else {
                loopDone1 = true;
              }
            }
          }
          // call the converter utility  to convert and set the array

          object.setRequestList(
              (RequestList_type0[])
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                      RequestList_type0.class, list1));

        } // End of if for expected property start element
        else {
          // 1 - A start element we are not expecting indicates an invalid parameter was passed
          throw new org.apache.axis2.databinding.ADBException(
              "Unexpected subelement " + reader.getName());
        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement())
          // 2 - A start element we are not expecting indicates a trailing invalid property

          throw new org.apache.axis2.databinding.ADBException(
              "Unexpected subelement " + reader.getName());

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

public static class DT_LGCY_APRV_EA_TOTALAPRV_04_S_response
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_APRV_EA_TOTALAPRV_04_S_response
  Namespace URI = http://www.lgchem.com/APRV
  Namespace Prefix = ns1
  */

  /** field for _return */
  protected Return_type0 local_return;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean local_returnTracker = false;

  public boolean is_returnSpecified() {
    return local_returnTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return Return_type0
   */
  public Return_type0 get_return() {
    return local_return;
  }

  /**
   * Auto generated setter method
   *
   * @param param _return
   */
  public void set_return(Return_type0 param) {
    local_returnTracker = param != null;

    this.local_return = param;
  }

  /**
   * @param parentQName
   * @param factory
   * @return org.apache.axiom.om.OMElement
   */
  public org.apache.axiom.om.OMElement getOMElement(
      final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
      throws org.apache.axis2.databinding.ADBException {

    return factory.createOMElement(
        new org.apache.axis2.databinding.ADBDataSource(this, parentQName));
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
    serialize(parentQName, xmlWriter, false);
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName,
      javax.xml.stream.XMLStreamWriter xmlWriter,
      boolean serializeType)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

    String prefix = null;
    String namespace = null;

    prefix = parentQName.getPrefix();
    namespace = parentQName.getNamespaceURI();
    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

    if (serializeType) {

      String namespacePrefix = registerPrefix(xmlWriter, "http://www.lgchem.com/APRV");
      if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            namespacePrefix + ":DT_LGCY_APRV_EA_TOTALAPRV_04_S_response",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_APRV_EA_TOTALAPRV_04_S_response",
            xmlWriter);
      }
    }
    if (local_returnTracker) {
      if (local_return == null) {
        throw new org.apache.axis2.databinding.ADBException("return cannot be null!!");
      }
      local_return.serialize(new javax.xml.namespace.QName("", "return"), xmlWriter);
    }
    xmlWriter.writeEndElement();
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/APRV")) {
      return "ns1";
    }
    return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
  }

  /** Utility method to write an element start tag. */
  private void writeStartElement(
      String prefix,
      String namespace,
      String localPart,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
    } else {
      if (namespace.length() == 0) {
        prefix = "";
      } else if (prefix == null) {
        prefix = generatePrefix(namespace);
      }

      xmlWriter.writeStartElement(prefix, localPart, namespace);
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
  }

  /** Util method to write an attribute with the ns prefix */
  private void writeAttribute(
      String prefix,
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
    } else {
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
      xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeAttribute(
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attValue);
    } else {
      xmlWriter.writeAttribute(
          registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeQNameAttribute(
      String namespace,
      String attName,
      javax.xml.namespace.QName qname,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    String attributeNamespace = qname.getNamespaceURI();
    String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
    if (attributePrefix == null) {
      attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
    }
    String attributeValue;
    if (attributePrefix.trim().length() > 0) {
      attributeValue = attributePrefix + ":" + qname.getLocalPart();
    } else {
      attributeValue = qname.getLocalPart();
    }

    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attributeValue);
    } else {
      registerPrefix(xmlWriter, namespace);
      xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
    }
  }
  /** method to handle Qnames */
  private void writeQName(
      javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String namespaceURI = qname.getNamespaceURI();
    if (namespaceURI != null) {
      String prefix = xmlWriter.getPrefix(namespaceURI);
      if (prefix == null) {
        prefix = generatePrefix(namespaceURI);
        xmlWriter.writeNamespace(prefix, namespaceURI);
        xmlWriter.setPrefix(prefix, namespaceURI);
      }

      if (prefix.trim().length() > 0) {
        xmlWriter.writeCharacters(
            prefix
                + ":"
                + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      } else {
        // i.e this is the default namespace
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }

    } else {
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }
  }

  private void writeQNames(
      javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    if (qnames != null) {
      // we have to store this data until last moment since it is not possible to write any
      // namespace data after writing the charactor data
      StringBuffer stringToWrite = new StringBuffer();
      String namespaceURI = null;
      String prefix = null;

      for (int i = 0; i < qnames.length; i++) {
        if (i > 0) {
          stringToWrite.append(" ");
        }
        namespaceURI = qnames[i].getNamespaceURI();
        if (namespaceURI != null) {
          prefix = xmlWriter.getPrefix(namespaceURI);
          if ((prefix == null) || (prefix.length() == 0)) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
          }

          if (prefix.trim().length() > 0) {
            stringToWrite
                .append(prefix)
                .append(":")
                .append(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      }
      xmlWriter.writeCharacters(stringToWrite.toString());
    }
  }

  /** Register a namespace prefix */
  private String registerPrefix(
      javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
      throws javax.xml.stream.XMLStreamException {
    String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
      prefix = generatePrefix(namespace);
      javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
      while (true) {
        String uri = nsContext.getNamespaceURI(prefix);
        if (uri == null || uri.length() == 0) {
          break;
        }
        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
      }
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
  }

  /** Factory class that keeps the parse method */
  public static class Factory {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(Factory.class);

    /**
     * static method to create the object Precondition: If this object is an element, the current
     * or next start element starts this object and any intervening reader events are ignorable If
     * this object is not an element, it is a complex type and the reader is at the event just
     * after the outer start element Postcondition: If this object is an element, the reader is
     * positioned at its end element If this object is a complex type, the reader is positioned at
     * the end element of its outer element
     */
    public static DT_LGCY_APRV_EA_TOTALAPRV_04_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      DT_LGCY_APRV_EA_TOTALAPRV_04_S_response object =
          new DT_LGCY_APRV_EA_TOTALAPRV_04_S_response();

      int event;
      javax.xml.namespace.QName currentQName = null;
      String nillableValue = null;
      String prefix = "";
      String namespaceuri = "";
      try {

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        currentQName = reader.getName();

        if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
            != null) {
          String fullTypeName =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
          if (fullTypeName != null) {
            String nsPrefix = null;
            if (fullTypeName.indexOf(":") > -1) {
              nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
            }
            nsPrefix = nsPrefix == null ? "" : nsPrefix;

            String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

            if (!"DT_LGCY_APRV_EA_TOTALAPRV_04_S_response".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_APRV_EA_TOTALAPRV_04_S_response)
                  ExtensionMapper.getTypeObject(nsUri, type, reader);
            }
          }
        }

        // Note all attributes that were handled. Used to differ normal attributes
        // from anyAttributes.
        java.util.Vector handledAttributes = new java.util.Vector();

        reader.next();

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "return").equals(reader.getName())) {

          object.set_return(Return_type0.Factory.parse(reader));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement())
          // 2 - A start element we are not expecting indicates a trailing invalid property

          throw new org.apache.axis2.databinding.ADBException(
              "Unexpected subelement " + reader.getName());

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

public static class MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S_response", "ns1");

  /** field for MT_LGCY_APRV_EA_TOTALAPRV_04_S_response */
  protected DT_LGCY_APRV_EA_TOTALAPRV_04_S_response localMT_LGCY_APRV_EA_TOTALAPRV_04_S_response;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_APRV_EA_TOTALAPRV_04_S_response
   */
  public DT_LGCY_APRV_EA_TOTALAPRV_04_S_response getMT_LGCY_APRV_EA_TOTALAPRV_04_S_response() {
    return localMT_LGCY_APRV_EA_TOTALAPRV_04_S_response;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
   */
  public void setMT_LGCY_APRV_EA_TOTALAPRV_04_S_response(
      DT_LGCY_APRV_EA_TOTALAPRV_04_S_response param) {

    this.localMT_LGCY_APRV_EA_TOTALAPRV_04_S_response = param;
  }

  /**
   * @param parentQName
   * @param factory
   * @return org.apache.axiom.om.OMElement
   */
  public org.apache.axiom.om.OMElement getOMElement(
      final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
      throws org.apache.axis2.databinding.ADBException {

    return factory.createOMElement(
        new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
    serialize(parentQName, xmlWriter, false);
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName,
      javax.xml.stream.XMLStreamWriter xmlWriter,
      boolean serializeType)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

    // We can safely assume an element has only one type associated with it

    if (localMT_LGCY_APRV_EA_TOTALAPRV_04_S_response == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_APRV_EA_TOTALAPRV_04_S_response cannot be null!");
    }
    localMT_LGCY_APRV_EA_TOTALAPRV_04_S_response.serialize(MY_QNAME, xmlWriter);
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/APRV")) {
      return "ns1";
    }
    return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
  }

  /** Utility method to write an element start tag. */
  private void writeStartElement(
      String prefix,
      String namespace,
      String localPart,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
    } else {
      if (namespace.length() == 0) {
        prefix = "";
      } else if (prefix == null) {
        prefix = generatePrefix(namespace);
      }

      xmlWriter.writeStartElement(prefix, localPart, namespace);
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
  }

  /** Util method to write an attribute with the ns prefix */
  private void writeAttribute(
      String prefix,
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
    } else {
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
      xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeAttribute(
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attValue);
    } else {
      xmlWriter.writeAttribute(
          registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeQNameAttribute(
      String namespace,
      String attName,
      javax.xml.namespace.QName qname,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    String attributeNamespace = qname.getNamespaceURI();
    String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
    if (attributePrefix == null) {
      attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
    }
    String attributeValue;
    if (attributePrefix.trim().length() > 0) {
      attributeValue = attributePrefix + ":" + qname.getLocalPart();
    } else {
      attributeValue = qname.getLocalPart();
    }

    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attributeValue);
    } else {
      registerPrefix(xmlWriter, namespace);
      xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
    }
  }
  /** method to handle Qnames */
  private void writeQName(
      javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String namespaceURI = qname.getNamespaceURI();
    if (namespaceURI != null) {
      String prefix = xmlWriter.getPrefix(namespaceURI);
      if (prefix == null) {
        prefix = generatePrefix(namespaceURI);
        xmlWriter.writeNamespace(prefix, namespaceURI);
        xmlWriter.setPrefix(prefix, namespaceURI);
      }

      if (prefix.trim().length() > 0) {
        xmlWriter.writeCharacters(
            prefix
                + ":"
                + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      } else {
        // i.e this is the default namespace
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }

    } else {
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }
  }

  private void writeQNames(
      javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    if (qnames != null) {
      // we have to store this data until last moment since it is not possible to write any
      // namespace data after writing the charactor data
      StringBuffer stringToWrite = new StringBuffer();
      String namespaceURI = null;
      String prefix = null;

      for (int i = 0; i < qnames.length; i++) {
        if (i > 0) {
          stringToWrite.append(" ");
        }
        namespaceURI = qnames[i].getNamespaceURI();
        if (namespaceURI != null) {
          prefix = xmlWriter.getPrefix(namespaceURI);
          if ((prefix == null) || (prefix.length() == 0)) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
          }

          if (prefix.trim().length() > 0) {
            stringToWrite
                .append(prefix)
                .append(":")
                .append(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      }
      xmlWriter.writeCharacters(stringToWrite.toString());
    }
  }

  /** Register a namespace prefix */
  private String registerPrefix(
      javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
      throws javax.xml.stream.XMLStreamException {
    String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
      prefix = generatePrefix(namespace);
      javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
      while (true) {
        String uri = nsContext.getNamespaceURI(prefix);
        if (uri == null || uri.length() == 0) {
          break;
        }
        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
      }
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
  }

  /** Factory class that keeps the parse method */
  public static class Factory {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(Factory.class);

    /**
     * static method to create the object Precondition: If this object is an element, the current
     * or next start element starts this object and any intervening reader events are ignorable If
     * this object is not an element, it is a complex type and the reader is at the event just
     * after the outer start element Postcondition: If this object is an element, the reader is
     * positioned at its end element If this object is a complex type, the reader is positioned at
     * the end element of its outer element
     */
    public static MT_LGCY_APRV_EA_TOTALAPRV_04_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      MT_LGCY_APRV_EA_TOTALAPRV_04_S_response object =
          new MT_LGCY_APRV_EA_TOTALAPRV_04_S_response();

      int event;
      javax.xml.namespace.QName currentQName = null;
      String nillableValue = null;
      String prefix = "";
      String namespaceuri = "";
      try {

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        currentQName = reader.getName();

        // Note all attributes that were handled. Used to differ normal attributes
        // from anyAttributes.
        java.util.Vector handledAttributes = new java.util.Vector();

        while (!reader.isEndElement()) {
          if (reader.isStartElement()) {

            if (reader.isStartElement()
                && new javax.xml.namespace.QName(
                        "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_04_S_response")
                    .equals(reader.getName())) {

              object.setMT_LGCY_APRV_EA_TOTALAPRV_04_S_response(
                  DT_LGCY_APRV_EA_TOTALAPRV_04_S_response.Factory.parse(reader));

            } // End of if for expected property start element
            else {
              // 3 - A start element we are not expecting indicates an invalid parameter was
              // passed

              throw new org.apache.axis2.databinding.ADBException(
                  "Unexpected subelement " + reader.getName());
            }

          } else {
            reader.next();
          }
        } // end of while loop

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

public static class Return_type0 implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = return_type0
  Namespace URI = http://www.lgchem.com/APRV
  Namespace Prefix = ns1
  */

  /** field for IF_STATUS */
  protected String localIF_STATUS;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localIF_STATUSTracker = false;

  public boolean isIF_STATUSSpecified() {
    return localIF_STATUSTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getIF_STATUS() {
    return localIF_STATUS;
  }

  /**
   * Auto generated setter method
   *
   * @param param IF_STATUS
   */
  public void setIF_STATUS(String param) {
    localIF_STATUSTracker = param != null;

    this.localIF_STATUS = param;
  }

  /** field for IF_ERRMSG */
  protected String localIF_ERRMSG;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localIF_ERRMSGTracker = false;

  public boolean isIF_ERRMSGSpecified() {
    return localIF_ERRMSGTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getIF_ERRMSG() {
    return localIF_ERRMSG;
  }

  /**
   * Auto generated setter method
   *
   * @param param IF_ERRMSG
   */
  public void setIF_ERRMSG(String param) {
    localIF_ERRMSGTracker = param != null;

    this.localIF_ERRMSG = param;
  }

  /**
   * @param parentQName
   * @param factory
   * @return org.apache.axiom.om.OMElement
   */
  public org.apache.axiom.om.OMElement getOMElement(
      final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
      throws org.apache.axis2.databinding.ADBException {

    return factory.createOMElement(
        new org.apache.axis2.databinding.ADBDataSource(this, parentQName));
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
    serialize(parentQName, xmlWriter, false);
  }

  public void serialize(
      final javax.xml.namespace.QName parentQName,
      javax.xml.stream.XMLStreamWriter xmlWriter,
      boolean serializeType)
      throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

    String prefix = null;
    String namespace = null;

    prefix = parentQName.getPrefix();
    namespace = parentQName.getNamespaceURI();
    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

    if (serializeType) {

      String namespacePrefix = registerPrefix(xmlWriter, "http://www.lgchem.com/APRV");
      if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            namespacePrefix + ":return_type0",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "return_type0",
            xmlWriter);
      }
    }
    if (localIF_STATUSTracker) {
      namespace = "";
      writeStartElement(null, namespace, "IF_STATUS", xmlWriter);

      if (localIF_STATUS == null) {
        // write the nil attribute

        throw new org.apache.axis2.databinding.ADBException("IF_STATUS cannot be null!!");

      } else {

        xmlWriter.writeCharacters(localIF_STATUS);
      }

      xmlWriter.writeEndElement();
    }
    if (localIF_ERRMSGTracker) {
      namespace = "";
      writeStartElement(null, namespace, "IF_ERRMSG", xmlWriter);

      if (localIF_ERRMSG == null) {
        // write the nil attribute

        throw new org.apache.axis2.databinding.ADBException("IF_ERRMSG cannot be null!!");

      } else {

        xmlWriter.writeCharacters(localIF_ERRMSG);
      }

      xmlWriter.writeEndElement();
    }
    xmlWriter.writeEndElement();
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/APRV")) {
      return "ns1";
    }
    return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
  }

  /** Utility method to write an element start tag. */
  private void writeStartElement(
      String prefix,
      String namespace,
      String localPart,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
    } else {
      if (namespace.length() == 0) {
        prefix = "";
      } else if (prefix == null) {
        prefix = generatePrefix(namespace);
      }

      xmlWriter.writeStartElement(prefix, localPart, namespace);
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
  }

  /** Util method to write an attribute with the ns prefix */
  private void writeAttribute(
      String prefix,
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String writerPrefix = xmlWriter.getPrefix(namespace);
    if (writerPrefix != null) {
      xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
    } else {
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
      xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeAttribute(
      String namespace,
      String attName,
      String attValue,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attValue);
    } else {
      xmlWriter.writeAttribute(
          registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
    }
  }

  /** Util method to write an attribute without the ns prefix */
  private void writeQNameAttribute(
      String namespace,
      String attName,
      javax.xml.namespace.QName qname,
      javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    String attributeNamespace = qname.getNamespaceURI();
    String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
    if (attributePrefix == null) {
      attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
    }
    String attributeValue;
    if (attributePrefix.trim().length() > 0) {
      attributeValue = attributePrefix + ":" + qname.getLocalPart();
    } else {
      attributeValue = qname.getLocalPart();
    }

    if (namespace.equals("")) {
      xmlWriter.writeAttribute(attName, attributeValue);
    } else {
      registerPrefix(xmlWriter, namespace);
      xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
    }
  }
  /** method to handle Qnames */
  private void writeQName(
      javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {
    String namespaceURI = qname.getNamespaceURI();
    if (namespaceURI != null) {
      String prefix = xmlWriter.getPrefix(namespaceURI);
      if (prefix == null) {
        prefix = generatePrefix(namespaceURI);
        xmlWriter.writeNamespace(prefix, namespaceURI);
        xmlWriter.setPrefix(prefix, namespaceURI);
      }

      if (prefix.trim().length() > 0) {
        xmlWriter.writeCharacters(
            prefix
                + ":"
                + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      } else {
        // i.e this is the default namespace
        xmlWriter.writeCharacters(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }

    } else {
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }
  }

  private void writeQNames(
      javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
      throws javax.xml.stream.XMLStreamException {

    if (qnames != null) {
      // we have to store this data until last moment since it is not possible to write any
      // namespace data after writing the charactor data
      StringBuffer stringToWrite = new StringBuffer();
      String namespaceURI = null;
      String prefix = null;

      for (int i = 0; i < qnames.length; i++) {
        if (i > 0) {
          stringToWrite.append(" ");
        }
        namespaceURI = qnames[i].getNamespaceURI();
        if (namespaceURI != null) {
          prefix = xmlWriter.getPrefix(namespaceURI);
          if ((prefix == null) || (prefix.length() == 0)) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
          }

          if (prefix.trim().length() > 0) {
            stringToWrite
                .append(prefix)
                .append(":")
                .append(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          } else {
            stringToWrite.append(
                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      }
      xmlWriter.writeCharacters(stringToWrite.toString());
    }
  }

  /** Register a namespace prefix */
  private String registerPrefix(
      javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
      throws javax.xml.stream.XMLStreamException {
    String prefix = xmlWriter.getPrefix(namespace);
    if (prefix == null) {
      prefix = generatePrefix(namespace);
      javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
      while (true) {
        String uri = nsContext.getNamespaceURI(prefix);
        if (uri == null || uri.length() == 0) {
          break;
        }
        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
      }
      xmlWriter.writeNamespace(prefix, namespace);
      xmlWriter.setPrefix(prefix, namespace);
    }
    return prefix;
  }

  /** Factory class that keeps the parse method */
  public static class Factory {
    private static org.apache.commons.logging.Log log =
        org.apache.commons.logging.LogFactory.getLog(Factory.class);

    /**
     * static method to create the object Precondition: If this object is an element, the current
     * or next start element starts this object and any intervening reader events are ignorable If
     * this object is not an element, it is a complex type and the reader is at the event just
     * after the outer start element Postcondition: If this object is an element, the reader is
     * positioned at its end element If this object is a complex type, the reader is positioned at
     * the end element of its outer element
     */
    public static Return_type0 parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      Return_type0 object = new Return_type0();

      int event;
      javax.xml.namespace.QName currentQName = null;
      String nillableValue = null;
      String prefix = "";
      String namespaceuri = "";
      try {

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        currentQName = reader.getName();

        if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
            != null) {
          String fullTypeName =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
          if (fullTypeName != null) {
            String nsPrefix = null;
            if (fullTypeName.indexOf(":") > -1) {
              nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
            }
            nsPrefix = nsPrefix == null ? "" : nsPrefix;

            String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

            if (!"return_type0".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (Return_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
            }
          }
        }

        // Note all attributes that were handled. Used to differ normal attributes
        // from anyAttributes.
        java.util.Vector handledAttributes = new java.util.Vector();

        reader.next();

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "IF_STATUS").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "IF_STATUS" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setIF_STATUS(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "IF_ERRMSG").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "IF_ERRMSG" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setIF_ERRMSG(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement())
          // 2 - A start element we are not expecting indicates a trailing invalid property

          throw new org.apache.axis2.databinding.ADBException(
              "Unexpected subelement " + reader.getName());

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

public static class RequestList_type0 implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = requestList_type0
  Namespace URI = http://www.lgchem.com/APRV
  Namespace Prefix = ns1
  */

  /** field for API_TYPE */
  protected String localAPI_TYPE;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localAPI_TYPETracker = false;

  public boolean isAPI_TYPESpecified() {
    return localAPI_TYPETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getAPI_TYPE() {
    return localAPI_TYPE;
  }

  /**
   * Auto generated setter method
   *
   * @param param API_TYPE
   */
  public void setAPI_TYPE(String param) {
    localAPI_TYPETracker = param != null;

    this.localAPI_TYPE = param;
  }

  /** field for SYSTEM_ID */
protected String localSYSTEM_ID;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSYSTEM_IDTracker = false;

public boolean isSYSTEM_IDSpecified() {
  return localSYSTEM_IDTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSYSTEM_ID() {
  return localSYSTEM_ID;
}

/**
 * Auto generated setter method
 *
 * @param param SYSTEM_ID
 */
public void setSYSTEM_ID(String param) {
  localSYSTEM_IDTracker = param != null;

  this.localSYSTEM_ID = param;
}

/** field for FORM_ID */
protected String localFORM_ID;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localFORM_IDTracker = false;

public boolean isFORM_IDSpecified() {
  return localFORM_IDTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getFORM_ID() {
  return localFORM_ID;
}

/**
 * Auto generated setter method
 *
 * @param param FORM_ID
 */
public void setFORM_ID(String param) {
  localFORM_IDTracker = param != null;

  this.localFORM_ID = param;
}

/** field for APPR_TITLE */
protected String localAPPR_TITLE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_TITLETracker = false;

public boolean isAPPR_TITLESpecified() {
  return localAPPR_TITLETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_TITLE() {
  return localAPPR_TITLE;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_TITLE
 */
public void setAPPR_TITLE(String param) {
  localAPPR_TITLETracker = param != null;

  this.localAPPR_TITLE = param;
}

/** field for REQ_USER */
protected String localREQ_USER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localREQ_USERTracker = false;

public boolean isREQ_USERSpecified() {
  return localREQ_USERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getREQ_USER() {
  return localREQ_USER;
}

/**
 * Auto generated setter method
 *
 * @param param REQ_USER
 */
public void setREQ_USER(String param) {
  localREQ_USERTracker = param != null;

  this.localREQ_USER = param;
}

/** field for APPKEY_01 */
protected String localAPPKEY_01;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPKEY_01Tracker = false;

public boolean isAPPKEY_01Specified() {
  return localAPPKEY_01Tracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPKEY_01() {
  return localAPPKEY_01;
}

/**
 * Auto generated setter method
 *
 * @param param APPKEY_01
 */
public void setAPPKEY_01(String param) {
  localAPPKEY_01Tracker = param != null;

  this.localAPPKEY_01 = param;
}

/** field for APPKEY_02 */
protected String localAPPKEY_02;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPKEY_02Tracker = false;

public boolean isAPPKEY_02Specified() {
  return localAPPKEY_02Tracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPKEY_02() {
  return localAPPKEY_02;
}

/**
 * Auto generated setter method
 *
 * @param param APPKEY_02
 */
public void setAPPKEY_02(String param) {
  localAPPKEY_02Tracker = param != null;

  this.localAPPKEY_02 = param;
}

/** field for APPKEY_03 */
protected String localAPPKEY_03;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPKEY_03Tracker = false;

public boolean isAPPKEY_03Specified() {
  return localAPPKEY_03Tracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPKEY_03() {
  return localAPPKEY_03;
}

/**
 * Auto generated setter method
 *
 * @param param APPKEY_03
 */
public void setAPPKEY_03(String param) {
  localAPPKEY_03Tracker = param != null;

  this.localAPPKEY_03 = param;
}

/** field for APPKEY_04 */
protected String localAPPKEY_04;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPKEY_04Tracker = false;

public boolean isAPPKEY_04Specified() {
  return localAPPKEY_04Tracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPKEY_04() {
  return localAPPKEY_04;
}

/**
 * Auto generated setter method
 *
 * @param param APPKEY_04
 */
public void setAPPKEY_04(String param) {
  localAPPKEY_04Tracker = param != null;

  this.localAPPKEY_04 = param;
}

/** field for APPKEY_05 */
protected String localAPPKEY_05;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPKEY_05Tracker = false;

public boolean isAPPKEY_05Specified() {
  return localAPPKEY_05Tracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPKEY_05() {
  return localAPPKEY_05;
}

/**
 * Auto generated setter method
 *
 * @param param APPKEY_05
 */
public void setAPPKEY_05(String param) {
  localAPPKEY_05Tracker = param != null;

  this.localAPPKEY_05 = param;
}

/** field for FORM_EDITOR_DATA */
protected String localFORM_EDITOR_DATA;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localFORM_EDITOR_DATATracker = false;

public boolean isFORM_EDITOR_DATASpecified() {
  return localFORM_EDITOR_DATATracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getFORM_EDITOR_DATA() {
  return localFORM_EDITOR_DATA;
}

/**
 * Auto generated setter method
 *
 * @param param FORM_EDITOR_DATA
 */
public void setFORM_EDITOR_DATA(String param) {
  localFORM_EDITOR_DATATracker = param != null;

  this.localFORM_EDITOR_DATA = param;
}

/** field for APPR_SECURITY_TYPE */
protected String localAPPR_SECURITY_TYPE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_SECURITY_TYPETracker = false;

public boolean isAPPR_SECURITY_TYPESpecified() {
  return localAPPR_SECURITY_TYPETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_SECURITY_TYPE() {
  return localAPPR_SECURITY_TYPE;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_SECURITY_TYPE
 */
public void setAPPR_SECURITY_TYPE(String param) {
  localAPPR_SECURITY_TYPETracker = param != null;

  this.localAPPR_SECURITY_TYPE = param;
}

/** field for APPR_PERIOD_CD */
protected String localAPPR_PERIOD_CD;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_PERIOD_CDTracker = false;

public boolean isAPPR_PERIOD_CDSpecified() {
  return localAPPR_PERIOD_CDTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_PERIOD_CD() {
  return localAPPR_PERIOD_CD;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_PERIOD_CD
 */
public void setAPPR_PERIOD_CD(String param) {
  localAPPR_PERIOD_CDTracker = param != null;

  this.localAPPR_PERIOD_CD = param;
}

/** field for APP_URL */
protected String localAPP_URL;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPP_URLTracker = false;

public boolean isAPP_URLSpecified() {
  return localAPP_URLTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPP_URL() {
  return localAPP_URL;
}

/**
 * Auto generated setter method
 *
 * @param param APP_URL
 */
public void setAPP_URL(String param) {
  localAPP_URLTracker = param != null;

  this.localAPP_URL = param;
}

/** field for APP_WAIT_URL */
protected String localAPP_WAIT_URL;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPP_WAIT_URLTracker = false;

public boolean isAPP_WAIT_URLSpecified() {
  return localAPP_WAIT_URLTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPP_WAIT_URL() {
  return localAPP_WAIT_URL;
}

/**
 * Auto generated setter method
 *
 * @param param APP_WAIT_URL
 */
public void setAPP_WAIT_URL(String param) {
  localAPP_WAIT_URLTracker = param != null;

  this.localAPP_WAIT_URL = param;
}

/** field for APP_MOBILE_URL */
protected String localAPP_MOBILE_URL;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPP_MOBILE_URLTracker = false;

public boolean isAPP_MOBILE_URLSpecified() {
  return localAPP_MOBILE_URLTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPP_MOBILE_URL() {
  return localAPP_MOBILE_URL;
}

/**
 * Auto generated setter method
 *
 * @param param APP_MOBILE_URL
 */
public void setAPP_MOBILE_URL(String param) {
  localAPP_MOBILE_URLTracker = param != null;

  this.localAPP_MOBILE_URL = param;
}

/** field for APPR_DOC_NO */
protected String localAPPR_DOC_NO;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_DOC_NOTracker = false;

public boolean isAPPR_DOC_NOSpecified() {
  return localAPPR_DOC_NOTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_DOC_NO() {
  return localAPPR_DOC_NO;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_DOC_NO
 */
public void setAPPR_DOC_NO(String param) {
  localAPPR_DOC_NOTracker = param != null;

  this.localAPPR_DOC_NO = param;
}

/** field for APPR_STATUS */
protected String localAPPR_STATUS;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_STATUSTracker = false;

public boolean isAPPR_STATUSSpecified() {
  return localAPPR_STATUSTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_STATUS() {
  return localAPPR_STATUS;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_STATUS
 */
public void setAPPR_STATUS(String param) {
  localAPPR_STATUSTracker = param != null;

  this.localAPPR_STATUS = param;
}

/** field for APPR_MESSAGE */
protected String localAPPR_MESSAGE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localAPPR_MESSAGETracker = false;

public boolean isAPPR_MESSAGESpecified() {
  return localAPPR_MESSAGETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getAPPR_MESSAGE() {
  return localAPPR_MESSAGE;
}

/**
 * Auto generated setter method
 *
 * @param param APPR_MESSAGE
 */
public void setAPPR_MESSAGE(String param) {
  localAPPR_MESSAGETracker = param != null;

  this.localAPPR_MESSAGE = param;
}

/** field for IS_ALL_DELETE */
protected String localIS_ALL_DELETE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localIS_ALL_DELETETracker = false;

public boolean isIS_ALL_DELETESpecified() {
  return localIS_ALL_DELETETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getIS_ALL_DELETE() {
  return localIS_ALL_DELETE;
}

/**
 * Auto generated setter method
 *
 * @param param IS_ALL_DELETE
 */
public void setIS_ALL_DELETE(String param) {
  localIS_ALL_DELETETracker = param != null;

  this.localIS_ALL_DELETE = param;
}

/** field for DELETE_USER */
protected String localDELETE_USER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localDELETE_USERTracker = false;

public boolean isDELETE_USERSpecified() {
  return localDELETE_USERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getDELETE_USER() {
  return localDELETE_USER;
}

/**
 * Auto generated setter method
 *
 * @param param DELETE_USER
 */
public void setDELETE_USER(String param) {
  localDELETE_USERTracker = param != null;

  this.localDELETE_USER = param;
}

/** field for NEXT_APPR_TYPE */
protected String localNEXT_APPR_TYPE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localNEXT_APPR_TYPETracker = false;

public boolean isNEXT_APPR_TYPESpecified() {
  return localNEXT_APPR_TYPETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getNEXT_APPR_TYPE() {
  return localNEXT_APPR_TYPE;
}

/**
 * Auto generated setter method
 *
 * @param param NEXT_APPR_TYPE
 */
public void setNEXT_APPR_TYPE(String param) {
  localNEXT_APPR_TYPETracker = param != null;

  this.localNEXT_APPR_TYPE = param;
}

/** field for NEXT_APPROVER */
protected String localNEXT_APPROVER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localNEXT_APPROVERTracker = false;

public boolean isNEXT_APPROVERSpecified() {
  return localNEXT_APPROVERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getNEXT_APPROVER() {
  return localNEXT_APPROVER;
}

/**
 * Auto generated setter method
 *
 * @param param NEXT_APPROVER
 */
public void setNEXT_APPROVER(String param) {
  localNEXT_APPROVERTracker = param != null;

  this.localNEXT_APPROVER = param;
}

/** field for NEXT_APPROVER_URL */
protected String localNEXT_APPROVER_URL;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localNEXT_APPROVER_URLTracker = false;

public boolean isNEXT_APPROVER_URLSpecified() {
  return localNEXT_APPROVER_URLTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getNEXT_APPROVER_URL() {
  return localNEXT_APPROVER_URL;
}

/**
 * Auto generated setter method
 *
 * @param param NEXT_APPROVER_URL
 */
public void setNEXT_APPROVER_URL(String param) {
  localNEXT_APPROVER_URLTracker = param != null;

  this.localNEXT_APPROVER_URL = param;
}

/** field for READ_USER */
protected String localREAD_USER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localREAD_USERTracker = false;

public boolean isREAD_USERSpecified() {
  return localREAD_USERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getREAD_USER() {
  return localREAD_USER;
}

/**
 * Auto generated setter method
 *
 * @param param READ_USER
 */
public void setREAD_USER(String param) {
  localREAD_USERTracker = param != null;

  this.localREAD_USER = param;
}

/** field for READ_DEPT */
protected String localREAD_DEPT;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localREAD_DEPTTracker = false;

public boolean isREAD_DEPTSpecified() {
  return localREAD_DEPTTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getREAD_DEPT() {
  return localREAD_DEPT;
}

/**
 * Auto generated setter method
 *
 * @param param READ_DEPT
 */
public void setREAD_DEPT(String param) {
  localREAD_DEPTTracker = param != null;

  this.localREAD_DEPT = param;
}

/** field for IS_RETURN_APPR_ID */
protected String localIS_RETURN_APPR_ID;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localIS_RETURN_APPR_IDTracker = false;

public boolean isIS_RETURN_APPR_IDSpecified() {
  return localIS_RETURN_APPR_IDTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getIS_RETURN_APPR_ID() {
  return localIS_RETURN_APPR_ID;
}

/**
 * Auto generated setter method
 *
 * @param param IS_RETURN_APPR_ID
 */
public void setIS_RETURN_APPR_ID(String param) {
  localIS_RETURN_APPR_IDTracker = param != null;

  this.localIS_RETURN_APPR_ID = param;
}

/**
 * @param parentQName
 * @param factory
 * @return org.apache.axiom.om.OMElement
 */
public org.apache.axiom.om.OMElement getOMElement(
    final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
    throws org.apache.axis2.databinding.ADBException {

  return factory.createOMElement(
      new org.apache.axis2.databinding.ADBDataSource(this, parentQName));
}

public void serialize(
    final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
  serialize(parentQName, xmlWriter, false);
}

public void serialize(
    final javax.xml.namespace.QName parentQName,
    javax.xml.stream.XMLStreamWriter xmlWriter,
    boolean serializeType)
    throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

  String prefix = null;
  String namespace = null;

  prefix = parentQName.getPrefix();
  namespace = parentQName.getNamespaceURI();
  writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

  if (serializeType) {

    String namespacePrefix = registerPrefix(xmlWriter, "http://www.lgchem.com/APRV");
    if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
      writeAttribute(
          "xsi",
          "http://www.w3.org/2001/XMLSchema-instance",
          "type",
          namespacePrefix + ":requestList_type0",
          xmlWriter);
    } else {
      writeAttribute(
          "xsi",
          "http://www.w3.org/2001/XMLSchema-instance",
          "type",
          "requestList_type0",
          xmlWriter);
    }
  }
  if (localAPI_TYPETracker) {
    namespace = "";
    writeStartElement(null, namespace, "API_TYPE", xmlWriter);

    if (localAPI_TYPE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("API_TYPE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPI_TYPE);
    }

    xmlWriter.writeEndElement();
  }
  if (localSYSTEM_IDTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SYSTEM_ID", xmlWriter);

    if (localSYSTEM_ID == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SYSTEM_ID cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSYSTEM_ID);
    }

    xmlWriter.writeEndElement();
  }
  if (localFORM_IDTracker) {
    namespace = "";
    writeStartElement(null, namespace, "FORM_ID", xmlWriter);

    if (localFORM_ID == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("FORM_ID cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localFORM_ID);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_TITLETracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_TITLE", xmlWriter);

    if (localAPPR_TITLE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPR_TITLE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_TITLE);
    }

    xmlWriter.writeEndElement();
  }
  if (localREQ_USERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "REQ_USER", xmlWriter);

    if (localREQ_USER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("REQ_USER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localREQ_USER);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPKEY_01Tracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPKEY_01", xmlWriter);

    if (localAPPKEY_01 == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPKEY_01 cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPKEY_01);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPKEY_02Tracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPKEY_02", xmlWriter);

    if (localAPPKEY_02 == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPKEY_02 cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPKEY_02);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPKEY_03Tracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPKEY_03", xmlWriter);

    if (localAPPKEY_03 == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPKEY_03 cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPKEY_03);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPKEY_04Tracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPKEY_04", xmlWriter);

    if (localAPPKEY_04 == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPKEY_04 cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPKEY_04);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPKEY_05Tracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPKEY_05", xmlWriter);

    if (localAPPKEY_05 == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPKEY_05 cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPKEY_05);
    }

    xmlWriter.writeEndElement();
  }
  if (localFORM_EDITOR_DATATracker) {
    namespace = "";
    writeStartElement(null, namespace, "FORM_EDITOR_DATA", xmlWriter);

    if (localFORM_EDITOR_DATA == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("FORM_EDITOR_DATA cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localFORM_EDITOR_DATA);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_SECURITY_TYPETracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_SECURITY_TYPE", xmlWriter);

    if (localAPPR_SECURITY_TYPE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException(
          "APPR_SECURITY_TYPE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_SECURITY_TYPE);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_PERIOD_CDTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_PERIOD_CD", xmlWriter);

    if (localAPPR_PERIOD_CD == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPR_PERIOD_CD cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_PERIOD_CD);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPP_URLTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APP_URL", xmlWriter);

    if (localAPP_URL == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APP_URL cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPP_URL);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPP_WAIT_URLTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APP_WAIT_URL", xmlWriter);

    if (localAPP_WAIT_URL == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APP_WAIT_URL cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPP_WAIT_URL);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPP_MOBILE_URLTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APP_MOBILE_URL", xmlWriter);

    if (localAPP_MOBILE_URL == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APP_MOBILE_URL cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPP_MOBILE_URL);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_DOC_NOTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_DOC_NO", xmlWriter);

    if (localAPPR_DOC_NO == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPR_DOC_NO cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_DOC_NO);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_STATUSTracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_STATUS", xmlWriter);

    if (localAPPR_STATUS == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPR_STATUS cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_STATUS);
    }

    xmlWriter.writeEndElement();
  }
  if (localAPPR_MESSAGETracker) {
    namespace = "";
    writeStartElement(null, namespace, "APPR_MESSAGE", xmlWriter);

    if (localAPPR_MESSAGE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("APPR_MESSAGE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localAPPR_MESSAGE);
    }

    xmlWriter.writeEndElement();
  }
  if (localIS_ALL_DELETETracker) {
    namespace = "";
    writeStartElement(null, namespace, "IS_ALL_DELETE", xmlWriter);

    if (localIS_ALL_DELETE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("IS_ALL_DELETE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localIS_ALL_DELETE);
    }

    xmlWriter.writeEndElement();
  }
  if (localDELETE_USERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "DELETE_USER", xmlWriter);

    if (localDELETE_USER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("DELETE_USER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localDELETE_USER);
    }

    xmlWriter.writeEndElement();
  }
  if (localNEXT_APPR_TYPETracker) {
    namespace = "";
    writeStartElement(null, namespace, "NEXT_APPR_TYPE", xmlWriter);

    if (localNEXT_APPR_TYPE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("NEXT_APPR_TYPE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localNEXT_APPR_TYPE);
    }

    xmlWriter.writeEndElement();
  }
  if (localNEXT_APPROVERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "NEXT_APPROVER", xmlWriter);

    if (localNEXT_APPROVER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("NEXT_APPROVER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localNEXT_APPROVER);
    }

    xmlWriter.writeEndElement();
  }
  if (localNEXT_APPROVER_URLTracker) {
    namespace = "";
    writeStartElement(null, namespace, "NEXT_APPROVER_URL", xmlWriter);

    if (localNEXT_APPROVER_URL == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("NEXT_APPROVER_URL cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localNEXT_APPROVER_URL);
    }

    xmlWriter.writeEndElement();
  }
  if (localREAD_USERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "READ_USER", xmlWriter);

    if (localREAD_USER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("READ_USER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localREAD_USER);
    }

    xmlWriter.writeEndElement();
  }
  if (localREAD_DEPTTracker) {
    namespace = "";
    writeStartElement(null, namespace, "READ_DEPT", xmlWriter);

    if (localREAD_DEPT == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("READ_DEPT cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localREAD_DEPT);
    }

    xmlWriter.writeEndElement();
  }
  if (localIS_RETURN_APPR_IDTracker) {
    namespace = "";
    writeStartElement(null, namespace, "IS_RETURN_APPR_ID", xmlWriter);

    if (localIS_RETURN_APPR_ID == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("IS_RETURN_APPR_ID cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localIS_RETURN_APPR_ID);
    }

    xmlWriter.writeEndElement();
  }
  xmlWriter.writeEndElement();
}

private static String generatePrefix(String namespace) {
  if (namespace.equals("http://www.lgchem.com/APRV")) {
    return "ns1";
  }
  return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
}

/** Utility method to write an element start tag. */
private void writeStartElement(
    String prefix,
    String namespace,
    String localPart,
    javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {
  String writerPrefix = xmlWriter.getPrefix(namespace);
  if (writerPrefix != null) {
    xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
  } else {
    if (namespace.length() == 0) {
      prefix = "";
    } else if (prefix == null) {
      prefix = generatePrefix(namespace);
    }

    xmlWriter.writeStartElement(prefix, localPart, namespace);
    xmlWriter.writeNamespace(prefix, namespace);
    xmlWriter.setPrefix(prefix, namespace);
  }
}

/** Util method to write an attribute with the ns prefix */
private void writeAttribute(
    String prefix,
    String namespace,
    String attName,
    String attValue,
    javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {
  String writerPrefix = xmlWriter.getPrefix(namespace);
  if (writerPrefix != null) {
    xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
  } else {
    xmlWriter.writeNamespace(prefix, namespace);
    xmlWriter.setPrefix(prefix, namespace);
    xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
  }
}

/** Util method to write an attribute without the ns prefix */
private void writeAttribute(
    String namespace,
    String attName,
    String attValue,
    javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {
  if (namespace.equals("")) {
    xmlWriter.writeAttribute(attName, attValue);
  } else {
    xmlWriter.writeAttribute(
        registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
  }
}

/** Util method to write an attribute without the ns prefix */
private void writeQNameAttribute(
    String namespace,
    String attName,
    javax.xml.namespace.QName qname,
    javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {

  String attributeNamespace = qname.getNamespaceURI();
  String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
  if (attributePrefix == null) {
    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
  }
  String attributeValue;
  if (attributePrefix.trim().length() > 0) {
    attributeValue = attributePrefix + ":" + qname.getLocalPart();
  } else {
    attributeValue = qname.getLocalPart();
  }

  if (namespace.equals("")) {
    xmlWriter.writeAttribute(attName, attributeValue);
  } else {
    registerPrefix(xmlWriter, namespace);
    xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
  }
}
/** method to handle Qnames */
private void writeQName(
    javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {
  String namespaceURI = qname.getNamespaceURI();
  if (namespaceURI != null) {
    String prefix = xmlWriter.getPrefix(namespaceURI);
    if (prefix == null) {
      prefix = generatePrefix(namespaceURI);
      xmlWriter.writeNamespace(prefix, namespaceURI);
      xmlWriter.setPrefix(prefix, namespaceURI);
    }

    if (prefix.trim().length() > 0) {
      xmlWriter.writeCharacters(
          prefix
              + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    } else {
      // i.e this is the default namespace
      xmlWriter.writeCharacters(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
    }

  } else {
    xmlWriter.writeCharacters(
        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
  }
}

private void writeQNames(
    javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
    throws javax.xml.stream.XMLStreamException {

  if (qnames != null) {
    // we have to store this data until last moment since it is not possible to write any
    // namespace data after writing the charactor data
    StringBuffer stringToWrite = new StringBuffer();
    String namespaceURI = null;
    String prefix = null;

    for (int i = 0; i < qnames.length; i++) {
      if (i > 0) {
        stringToWrite.append(" ");
      }
      namespaceURI = qnames[i].getNamespaceURI();
      if (namespaceURI != null) {
        prefix = xmlWriter.getPrefix(namespaceURI);
        if ((prefix == null) || (prefix.length() == 0)) {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0) {
          stringToWrite
              .append(prefix)
              .append(":")
              .append(
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        } else {
          stringToWrite.append(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
        }
      } else {
        stringToWrite.append(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
      }
    }
    xmlWriter.writeCharacters(stringToWrite.toString());
  }
}

/** Register a namespace prefix */
private String registerPrefix(
    javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
    throws javax.xml.stream.XMLStreamException {
  String prefix = xmlWriter.getPrefix(namespace);
  if (prefix == null) {
    prefix = generatePrefix(namespace);
    javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
    while (true) {
      String uri = nsContext.getNamespaceURI(prefix);
      if (uri == null || uri.length() == 0) {
        break;
      }
      prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }
    xmlWriter.writeNamespace(prefix, namespace);
    xmlWriter.setPrefix(prefix, namespace);
  }
  return prefix;
}

/** Factory class that keeps the parse method */
public static class Factory {
  private static org.apache.commons.logging.Log log =
      org.apache.commons.logging.LogFactory.getLog(Factory.class);

  /**
 * static method to create the object Precondition: If this object is an element, the current
 * or next start element starts this object and any intervening reader events are ignorable If
 * this object is not an element, it is a complex type and the reader is at the event just
 * after the outer start element Postcondition: If this object is an element, the reader is
 * positioned at its end element If this object is a complex type, the reader is positioned at
 * the end element of its outer element
 */
public static RequestList_type0 parse(javax.xml.stream.XMLStreamReader reader)
    throws Exception {
  RequestList_type0 object = new RequestList_type0();

  int event;
  javax.xml.namespace.QName currentQName = null;
  String nillableValue = null;
  String prefix = "";
  String namespaceuri = "";
  try {

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    currentQName = reader.getName();

    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")
        != null) {
      String fullTypeName =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
      if (fullTypeName != null) {
        String nsPrefix = null;
        if (fullTypeName.indexOf(":") > -1) {
          nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
        }
        nsPrefix = nsPrefix == null ? "" : nsPrefix;

        String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

        if (!"requestList_type0".equals(type)) {
          // find namespace for the prefix
          String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
          return (RequestList_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
        }
      }
    }

    // Note all attributes that were handled. Used to differ normal attributes
    // from anyAttributes.
    java.util.Vector handledAttributes = new java.util.Vector();

    reader.next();

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "API_TYPE").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "API_TYPE" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPI_TYPE(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "SYSTEM_ID").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "SYSTEM_ID" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setSYSTEM_ID(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "FORM_ID").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "FORM_ID" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setFORM_ID(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPR_TITLE").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPR_TITLE" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPR_TITLE(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "REQ_USER").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "REQ_USER" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setREQ_USER(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPKEY_01").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPKEY_01" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPKEY_01(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPKEY_02").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPKEY_02" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPKEY_02(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPKEY_03").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPKEY_03" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPKEY_03(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPKEY_04").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPKEY_04" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPKEY_04(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

    if (reader.isStartElement()
        && new javax.xml.namespace.QName("", "APPKEY_05").equals(reader.getName())) {

      nillableValue =
          reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
      if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
        throw new org.apache.axis2.databinding.ADBException(
            "The element: " + "APPKEY_05" + "  cannot be null");
      }

      String content = reader.getElementText();

      object.setAPPKEY_05(
          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

      reader.next();

    } // End of if for expected property start element
    else {

    }

  while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "FORM_EDITOR_DATA").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "FORM_EDITOR_DATA" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setFORM_EDITOR_DATA(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APPR_SECURITY_TYPE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APPR_SECURITY_TYPE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPPR_SECURITY_TYPE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APPR_PERIOD_CD").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APPR_PERIOD_CD" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPPR_PERIOD_CD(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APP_URL").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APP_URL" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPP_URL(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APP_WAIT_URL").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APP_WAIT_URL" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPP_WAIT_URL(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APP_MOBILE_URL").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APP_MOBILE_URL" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPP_MOBILE_URL(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APPR_DOC_NO").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APPR_DOC_NO" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPPR_DOC_NO(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APPR_STATUS").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APPR_STATUS" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPPR_STATUS(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "APPR_MESSAGE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "APPR_MESSAGE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setAPPR_MESSAGE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "IS_ALL_DELETE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "IS_ALL_DELETE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setIS_ALL_DELETE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "DELETE_USER").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "DELETE_USER" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setDELETE_USER(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "NEXT_APPR_TYPE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "NEXT_APPR_TYPE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setNEXT_APPR_TYPE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "NEXT_APPROVER").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "NEXT_APPROVER" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setNEXT_APPROVER(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "NEXT_APPROVER_URL").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "NEXT_APPROVER_URL" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setNEXT_APPROVER_URL(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "READ_USER").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "READ_USER" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setREAD_USER(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "READ_DEPT").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "READ_DEPT" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setREAD_DEPT(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "IS_RETURN_APPR_ID").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "IS_RETURN_APPR_ID" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setIS_RETURN_APPR_ID(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement())
          // 2 - A start element we are not expecting indicates a trailing invalid property

          throw new org.apache.axis2.databinding.ADBException(
              "Unexpected subelement " + reader.getName());

      } catch (javax.xml.stream.XMLStreamException e) {
        throw new Exception(e);
      }

      return object;
    }
  } // end of factory class
}

private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_APRV_EA_TOTALAPRV_04_S param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_APRV_EA_TOTALAPRV_04_S
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_APRV_EA_TOTALAPRV_04_S_response
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      MT_LGCY_APRV_EA_TOTALAPRV_04_S param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  MT_LGCY_APRV_EA_TOTALAPRV_04_S
                      .MY_QNAME,
                  factory));
      return emptyEnvelope;
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  /* methods to provide back word compatibility */

  /** get the default envelope */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
    return factory.getDefaultEnvelope();
  }

  private Object fromOM(org.apache.axiom.om.OMElement param, Class type)
      throws org.apache.axis2.AxisFault {

    try {

      if (MT_LGCY_APRV_EA_TOTALAPRV_04_S.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_APRV_EA_TOTALAPRV_04_S
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (MT_LGCY_APRV_EA_TOTALAPRV_04_S_response.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_APRV_EA_TOTALAPRV_04_S_response.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}

