/**
 * LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.flare.project.webService.client.setEntrustClient;
/*
 *  LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub java implementation
 */

public class LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub extends org.apache.axis2.client.Stub {
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
            "LGCY_APRV_EA_TOTALAPRV_06_SOService" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[1];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName(
            "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_06_SO"));
    _service.addOperation(__operation);

    _operations[0] = __operation;
  }

  // populates the faults
  private void populateFaults() {}

  /** Constructor that takes in a configContext */
  public LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub(
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
  public LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(
        configurationContext,
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_06_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV");
  }

  /** Default Constructor */
  public LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub() throws org.apache.axis2.AxisFault {

    this(
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_06_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV");
  }

  /** Constructor taking the target endpoint */
  public LGCY_APRV_EA_TOTALAPRV_06_SOServiceStub(String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  public MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
      lGCY_APRV_EA_TOTALAPRV_06_SO(
          MT_LGCY_APRV_EA_TOTALAPRV_06_S
              mT_LGCY_APRV_EA_TOTALAPRV_06_S0)
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
              mT_LGCY_APRV_EA_TOTALAPRV_06_S0,
              optimizeContent(
                  new javax.xml.namespace.QName(
                      "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_06_SO")),
              new javax.xml.namespace.QName(
                  "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S"));

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
              MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (MT_LGCY_APRV_EA_TOTALAPRV_06_S_response)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"))) {
          // make the fault by reflection
          try {
            String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"));
            Class exceptionClass = Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(String.class);
            Exception ex = (Exception) constructor.newInstance(f.getMessage());
            // message class
            String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"));
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

  public void startlGCY_APRV_EA_TOTALAPRV_06_SO(
      MT_LGCY_APRV_EA_TOTALAPRV_06_S
          mT_LGCY_APRV_EA_TOTALAPRV_06_S0,
      final LGCY_APRV_EA_TOTALAPRV_06_SOServiceCallbackHandler callback)
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
            mT_LGCY_APRV_EA_TOTALAPRV_06_S0,
            optimizeContent(
                new javax.xml.namespace.QName(
                    "http://www.lgchem.com/APRV", "lGCY_APRV_EA_TOTALAPRV_06_SO")),
            new javax.xml.namespace.QName(
                "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S"));

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
                      MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
                          .class);
              callback.receiveResultlGCY_APRV_EA_TOTALAPRV_06_SO(
                  (MT_LGCY_APRV_EA_TOTALAPRV_06_S_response)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(e);
            }
          }

      public void onError(Exception error) {
          if (error instanceof org.apache.axis2.AxisFault) {
            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
              if (faultExceptionNameMap.containsKey(
                  new org.apache.axis2.client.FaultMapKey(
                      faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"))) {
                // make the fault by reflection
                try {
                  String exceptionClassName =
                      faultExceptionClassNameMap.get(
                          new org.apache.axis2.client.FaultMapKey(
                              faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"));
                  Class exceptionClass = Class.forName(exceptionClassName);
                  java.lang.reflect.Constructor constructor =
                      exceptionClass.getConstructor(String.class);
                  Exception ex =
                      (Exception) constructor.newInstance(f.getMessage());
                  // message class
                  String messageClassName =
                      faultMessageMap.get(
                          new org.apache.axis2.client.FaultMapKey(
                              faultElt.getQName(), "LGCY_APRV_EA_TOTALAPRV_06_SO"));
                  Class messageClass = Class.forName(messageClassName);
                  Object messageObject = fromOM(faultElt, messageClass);
                  java.lang.reflect.Method m =
                      exceptionClass.getMethod(
                          "setFaultMessage", new Class[] {messageClass});
                  m.invoke(ex, new Object[] {messageObject});

                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(
                      new java.rmi.RemoteException(ex.getMessage(), ex));
                } catch (ClassCastException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (ClassNotFoundException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (NoSuchMethodException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (java.lang.reflect.InvocationTargetException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (IllegalAccessException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (InstantiationException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                } catch (org.apache.axis2.AxisFault e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
                }
              } else {
                callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
              }
            } else {
              callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(f);
            }
          } else {
            callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(error);
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
            callback.receiveErrorlGCY_APRV_EA_TOTALAPRV_06_SO(axisFault);
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
// http://lchaspeaq01:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_APRV_EA_TOTALAPRV_06_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FAPRV
public static class MT_LGCY_APRV_EA_TOTALAPRV_06_S
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S", "ns1");

  /** field for MT_LGCY_APRV_EA_TOTALAPRV_06_S */
  protected DT_LGCY_APRV_EA_TOTALAPRV_06_S localMT_LGCY_APRV_EA_TOTALAPRV_06_S;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_APRV_EA_TOTALAPRV_06_S
   */
  public DT_LGCY_APRV_EA_TOTALAPRV_06_S getMT_LGCY_APRV_EA_TOTALAPRV_06_S() {
    return localMT_LGCY_APRV_EA_TOTALAPRV_06_S;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_APRV_EA_TOTALAPRV_06_S
   */
  public void setMT_LGCY_APRV_EA_TOTALAPRV_06_S(DT_LGCY_APRV_EA_TOTALAPRV_06_S param) {

    this.localMT_LGCY_APRV_EA_TOTALAPRV_06_S = param;
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

    if (localMT_LGCY_APRV_EA_TOTALAPRV_06_S == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_APRV_EA_TOTALAPRV_06_S cannot be null!");
    }
    localMT_LGCY_APRV_EA_TOTALAPRV_06_S.serialize(MY_QNAME, xmlWriter);
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
    public static MT_LGCY_APRV_EA_TOTALAPRV_06_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      MT_LGCY_APRV_EA_TOTALAPRV_06_S object = new MT_LGCY_APRV_EA_TOTALAPRV_06_S();

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
                        "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S")
                    .equals(reader.getName())) {

              object.setMT_LGCY_APRV_EA_TOTALAPRV_06_S(
                  DT_LGCY_APRV_EA_TOTALAPRV_06_S.Factory.parse(reader));

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
        && "setEntrust_type0".equals(typeName)) {

      return SetEntrust_type0.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI)
        && "DT_LGCY_APRV_EA_TOTALAPRV_06_S".equals(typeName)) {

      return DT_LGCY_APRV_EA_TOTALAPRV_06_S.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI)
        && "DT_LGCY_APRV_EA_TOTALAPRV_06_S_response".equals(typeName)) {

      return DT_LGCY_APRV_EA_TOTALAPRV_06_S_response.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/APRV".equals(namespaceURI) && "return_type0".equals(typeName)) {

      return Return_type0.Factory.parse(reader);
    }

    throw new org.apache.axis2.databinding.ADBException(
        "Unsupported type " + namespaceURI + " " + typeName);
  }
}

public static class MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S_response", "ns1");

  /** field for MT_LGCY_APRV_EA_TOTALAPRV_06_S_response */
  protected DT_LGCY_APRV_EA_TOTALAPRV_06_S_response localMT_LGCY_APRV_EA_TOTALAPRV_06_S_response;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_APRV_EA_TOTALAPRV_06_S_response
   */
  public DT_LGCY_APRV_EA_TOTALAPRV_06_S_response getMT_LGCY_APRV_EA_TOTALAPRV_06_S_response() {
    return localMT_LGCY_APRV_EA_TOTALAPRV_06_S_response;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
   */
  public void setMT_LGCY_APRV_EA_TOTALAPRV_06_S_response(
      DT_LGCY_APRV_EA_TOTALAPRV_06_S_response param) {

    this.localMT_LGCY_APRV_EA_TOTALAPRV_06_S_response = param;
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

    if (localMT_LGCY_APRV_EA_TOTALAPRV_06_S_response == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_APRV_EA_TOTALAPRV_06_S_response cannot be null!");
    }
    localMT_LGCY_APRV_EA_TOTALAPRV_06_S_response.serialize(MY_QNAME, xmlWriter);
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
    public static MT_LGCY_APRV_EA_TOTALAPRV_06_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      MT_LGCY_APRV_EA_TOTALAPRV_06_S_response object =
          new MT_LGCY_APRV_EA_TOTALAPRV_06_S_response();

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
                        "http://www.lgchem.com/APRV", "MT_LGCY_APRV_EA_TOTALAPRV_06_S_response")
                    .equals(reader.getName())) {

              object.setMT_LGCY_APRV_EA_TOTALAPRV_06_S_response(
                  DT_LGCY_APRV_EA_TOTALAPRV_06_S_response.Factory.parse(reader));

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

public static class DT_LGCY_APRV_EA_TOTALAPRV_06_S
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_APRV_EA_TOTALAPRV_06_S
  Namespace URI = http://www.lgchem.com/APRV
  Namespace Prefix = ns1
  */

  /** field for SetEntrust */
  protected SetEntrust_type0 localSetEntrust;

  /**
   * Auto generated getter method
   *
   * @return SetEntrust_type0
   */
  public SetEntrust_type0 getSetEntrust() {
    return localSetEntrust;
  }

  /**
   * Auto generated setter method
   *
   * @param param SetEntrust
   */
  public void setSetEntrust(SetEntrust_type0 param) {

    this.localSetEntrust = param;
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
            namespacePrefix + ":DT_LGCY_APRV_EA_TOTALAPRV_06_S",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_APRV_EA_TOTALAPRV_06_S",
            xmlWriter);
      }
    }

    if (localSetEntrust == null) {
      throw new org.apache.axis2.databinding.ADBException("setEntrust cannot be null!!");
    }
    localSetEntrust.serialize(new javax.xml.namespace.QName("", "setEntrust"), xmlWriter);

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
    public static DT_LGCY_APRV_EA_TOTALAPRV_06_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      DT_LGCY_APRV_EA_TOTALAPRV_06_S object = new DT_LGCY_APRV_EA_TOTALAPRV_06_S();

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

            if (!"DT_LGCY_APRV_EA_TOTALAPRV_06_S".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_APRV_EA_TOTALAPRV_06_S)
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
            && new javax.xml.namespace.QName("", "setEntrust").equals(reader.getName())) {

          object.setSetEntrust(SetEntrust_type0.Factory.parse(reader));

          reader.next();

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

public static class DT_LGCY_APRV_EA_TOTALAPRV_06_S_response
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_APRV_EA_TOTALAPRV_06_S_response
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
            namespacePrefix + ":DT_LGCY_APRV_EA_TOTALAPRV_06_S_response",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_APRV_EA_TOTALAPRV_06_S_response",
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
    public static DT_LGCY_APRV_EA_TOTALAPRV_06_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      DT_LGCY_APRV_EA_TOTALAPRV_06_S_response object =
          new DT_LGCY_APRV_EA_TOTALAPRV_06_S_response();

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

            if (!"DT_LGCY_APRV_EA_TOTALAPRV_06_S_response".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_APRV_EA_TOTALAPRV_06_S_response)
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

public static class SetEntrust_type0 implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = setEntrust_type0
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

  /** field for SIGN_USER */
  protected String localSIGN_USER;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSIGN_USERTracker = false;

  public boolean isSIGN_USERSpecified() {
    return localSIGN_USERTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSIGN_USER() {
    return localSIGN_USER;
  }

  /**
   * Auto generated setter method
   *
   * @param param SIGN_USER
   */
  public void setSIGN_USER(String param) {
    localSIGN_USERTracker = param != null;

    this.localSIGN_USER = param;
  }

  /** field for START_DATE */
  protected String localSTART_DATE;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSTART_DATETracker = false;

  public boolean isSTART_DATESpecified() {
    return localSTART_DATETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSTART_DATE() {
    return localSTART_DATE;
  }

  /**
   * Auto generated setter method
   *
   * @param param START_DATE
   */
  public void setSTART_DATE(String param) {
    localSTART_DATETracker = param != null;

    this.localSTART_DATE = param;
  }

  /** field for END_DATE */
  protected String localEND_DATE;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localEND_DATETracker = false;

  public boolean isEND_DATESpecified() {
    return localEND_DATETracker;
  }

  /**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getEND_DATE() {
  return localEND_DATE;
}

/**
 * Auto generated setter method
 *
 * @param param END_DATE
 */
public void setEND_DATE(String param) {
  localEND_DATETracker = param != null;

  this.localEND_DATE = param;
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
          namespacePrefix + ":setEntrust_type0",
          xmlWriter);
    } else {
      writeAttribute(
          "xsi",
          "http://www.w3.org/2001/XMLSchema-instance",
          "type",
          "setEntrust_type0",
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
  if (localSIGN_USERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SIGN_USER", xmlWriter);

    if (localSIGN_USER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SIGN_USER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSIGN_USER);
    }

    xmlWriter.writeEndElement();
  }
  if (localSTART_DATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "START_DATE", xmlWriter);

    if (localSTART_DATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("START_DATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSTART_DATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localEND_DATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "END_DATE", xmlWriter);

    if (localEND_DATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("END_DATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localEND_DATE);
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
    public static SetEntrust_type0 parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      SetEntrust_type0 object = new SetEntrust_type0();

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

            if (!"setEntrust_type0".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (SetEntrust_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
            && new javax.xml.namespace.QName("", "SIGN_USER").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "SIGN_USER" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setSIGN_USER(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "START_DATE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "START_DATE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setSTART_DATE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "END_DATE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "END_DATE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setEND_DATE(
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
      MT_LGCY_APRV_EA_TOTALAPRV_06_S param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_APRV_EA_TOTALAPRV_06_S
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      MT_LGCY_APRV_EA_TOTALAPRV_06_S param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  MT_LGCY_APRV_EA_TOTALAPRV_06_S
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

      if (MT_LGCY_APRV_EA_TOTALAPRV_06_S.class
          .equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_APRV_EA_TOTALAPRV_06_S
                .Factory.parse(reader);
        reader.close();
        return result;
      }

      if (MT_LGCY_APRV_EA_TOTALAPRV_06_S_response
          .class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_APRV_EA_TOTALAPRV_06_S_response.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}

