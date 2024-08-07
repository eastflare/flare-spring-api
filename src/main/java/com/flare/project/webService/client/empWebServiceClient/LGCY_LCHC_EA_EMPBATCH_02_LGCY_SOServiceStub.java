/**
 * LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.flare.project.webService.client.empWebServiceClient;
/*
 *  LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub java implementation
 */

public class LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub extends org.apache.axis2.client.Stub {
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
            "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOService" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[1];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName(
            "http://www.lgchem.com/PI/LGC", "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"));
    _service.addOperation(__operation);

    _operations[0] = __operation;
  }

  // populates the faults
  private void populateFaults() {}

  /** Constructor that takes in a configContext */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub(
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
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(
        configurationContext,
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC");
  }

  /** Default Constructor */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub() throws org.apache.axis2.AxisFault {

    this(
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC");
  }

  /** Constructor taking the target endpoint */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub(String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  public MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
      LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(
          MT_LGCY_LCHC_EA_EMPBATCH_02_S
              mT_LGCY_LCHC_EA_EMPBATCH_02_S0)
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
              mT_LGCY_LCHC_EA_EMPBATCH_02_S0,
              optimizeContent(
                  new javax.xml.namespace.QName(
                      "http://www.lgchem.com/PI/LGC", "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO")),
              new javax.xml.namespace.QName(
                  "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S"));

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
              MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (MT_LGCY_LCHC_EA_EMPBATCH_02_S_response)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"))) {
          // make the fault by reflection
          try {
            String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"));
            Class exceptionClass = Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(String.class);
            Exception ex = (Exception) constructor.newInstance(f.getMessage());
            // message class
            String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"));
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
  }public void startLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(
      MT_LGCY_LCHC_EA_EMPBATCH_02_S
          mT_LGCY_LCHC_EA_EMPBATCH_02_S0,
      final LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler callback)
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
            mT_LGCY_LCHC_EA_EMPBATCH_02_S0,
            optimizeContent(
                new javax.xml.namespace.QName(
                    "http://www.lgchem.com/PI/LGC", "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO")),
            new javax.xml.namespace.QName(
                "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S"));

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
                      MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
                          .class);
              callback.receiveResultLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(
                  (MT_LGCY_LCHC_EA_EMPBATCH_02_S_response)
                      object);

            } catch (org.apache.axis2.AxisFault e) {
              callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(e);
            }
          }

          public void onError(Exception error) {
            if (error instanceof org.apache.axis2.AxisFault) {
              org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
              org.apache.axiom.om.OMElement faultElt = f.getDetail();
              if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"))) {
                  // make the fault by reflection
                  try {
                    String exceptionClassName =
                        faultExceptionClassNameMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"));
                    Class exceptionClass = Class.forName(exceptionClassName);
                    java.lang.reflect.Constructor constructor =
                        exceptionClass.getConstructor(String.class);
                    Exception ex =
                        (Exception) constructor.newInstance(f.getMessage());
                    // message class
                    String messageClassName =
                        faultMessageMap.get(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO"));
                    Class messageClass = Class.forName(messageClassName);
                    Object messageObject = fromOM(faultElt, messageClass);
                    java.lang.reflect.Method m =
                        exceptionClass.getMethod(
                            "setFaultMessage", new Class[] {messageClass});
                    m.invoke(ex, new Object[] {messageObject});

                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(
                        new java.rmi.RemoteException(ex.getMessage(), ex));
                  } catch (ClassCastException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (ClassNotFoundException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (NoSuchMethodException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (java.lang.reflect.InvocationTargetException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (IllegalAccessException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (InstantiationException e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  } catch (org.apache.axis2.AxisFault e) {
                    // we cannot intantiate the class - throw the original Axis fault
                    callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                  }
                } else {
                  callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
                }
              } else {
                callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(f);
              }
            } else {
              callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(error);
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
            callback.receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(axisFault);
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
// http://lchaspeaq01:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_EMPBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC
public static class DT_LGCY_LCHC_EA_EMPBATCH_02_S_response
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_LCHC_EA_EMPBATCH_02_S_response
  Namespace URI = http://www.lgchem.com/PI/LGC
  Namespace Prefix = ns1
  */

  /** field for RETURN This was an Array! */
  protected RETURN_type0[] localRETURN;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localRETURNTracker = false;

  public boolean isRETURNSpecified() {
    return localRETURNTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return RETURN_type0[]
   */
  public RETURN_type0[] getRETURN() {
    return localRETURN;
  }

  /** validate the array for RETURN */
  protected void validateRETURN(RETURN_type0[] param) {}

  /**
   * Auto generated setter method
   *
   * @param param RETURN
   */
  public void setRETURN(RETURN_type0[] param) {

    validateRETURN(param);

    localRETURNTracker = param != null;

    this.localRETURN = param;
  }

  /**
   * Auto generated add method for the array for convenience
   *
   * @param param RETURN_type0
   */
  public void addRETURN(RETURN_type0 param) {
    if (localRETURN == null) {
      localRETURN = new RETURN_type0[] {};
    }

    // update the setting tracker
    localRETURNTracker = true;

    java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localRETURN);
    list.add(param);
    this.localRETURN = (RETURN_type0[]) list.toArray(new RETURN_type0[list.size()]);
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

      String namespacePrefix =
          registerPrefix(xmlWriter, "http://www.lgchem.com/PI/LGC");
      if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            namespacePrefix + ":DT_LGCY_LCHC_EA_EMPBATCH_02_S_response",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_LCHC_EA_EMPBATCH_02_S_response",
            xmlWriter);
      }
    }
    if (localRETURNTracker) {
      if (localRETURN != null) {
        for (int i = 0; i < localRETURN.length; i++) {
          if (localRETURN[i] != null) {
            localRETURN[i].serialize(new javax.xml.namespace.QName("", "RETURN"), xmlWriter);
          } else {

            // we don't have to do any thing since minOccures is zero

          }
        }
      } else {

        throw new org.apache.axis2.databinding.ADBException("RETURN cannot be null!!");
      }
    }
    xmlWriter.writeEndElement();
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/PI/LGC")) {
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
    public static DT_LGCY_LCHC_EA_EMPBATCH_02_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      DT_LGCY_LCHC_EA_EMPBATCH_02_S_response object =
          new DT_LGCY_LCHC_EA_EMPBATCH_02_S_response();

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

            if (!"DT_LGCY_LCHC_EA_EMPBATCH_02_S_response".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_LCHC_EA_EMPBATCH_02_S_response)
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
            && new javax.xml.namespace.QName("", "RETURN").equals(reader.getName())) {

          // Process the array and step past its final element's end.

          list1.add(RETURN_type0.Factory.parse(reader));

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
              if (new javax.xml.namespace.QName("", "RETURN").equals(reader.getName())) {
                list1.add(RETURN_type0.Factory.parse(reader));

              } else {
                loopDone1 = true;
              }
            }
          }
          // call the converter utility  to convert and set the array

          object.setRETURN(
              (RETURN_type0[])
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                      RETURN_type0.class, list1));

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

public static class RETURN_type0 implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = RETURN_type0
  Namespace URI = http://www.lgchem.com/PI/LGC
  Namespace Prefix = ns1
  */

  /** field for SA_COMP */
  protected String localSA_COMP;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_COMPTracker = false;

  public boolean isSA_COMPSpecified() {
    return localSA_COMPTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_COMP() {
    return localSA_COMP;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_COMP
   */
  public void setSA_COMP(String param) {
    localSA_COMPTracker = param != null;

    this.localSA_COMP = param;
  }

  /** field for SA_DEPT */
  protected String localSA_DEPT;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_DEPTTracker = false;

  public boolean isSA_DEPTSpecified() {
    return localSA_DEPTTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_DEPT() {
    return localSA_DEPT;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_DEPT
   */
  public void setSA_DEPT(String param) {
    localSA_DEPTTracker = param != null;

    this.localSA_DEPT = param;
  }

  /** field for SA_DEPT_NAME */
  protected String localSA_DEPT_NAME;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_DEPT_NAMETracker = false;

  public boolean isSA_DEPT_NAMESpecified() {
    return localSA_DEPT_NAMETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_DEPT_NAME() {
    return localSA_DEPT_NAME;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_DEPT_NAME
   */
  public void setSA_DEPT_NAME(String param) {
    localSA_DEPT_NAMETracker = param != null;

    this.localSA_DEPT_NAME = param;
  }

  /** field for SA_DEPT_NAME_C */
  protected String localSA_DEPT_NAME_C;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_DEPT_NAME_CTracker = false;

  public boolean isSA_DEPT_NAME_CSpecified() {
    return localSA_DEPT_NAME_CTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_DEPT_NAME_C() {
    return localSA_DEPT_NAME_C;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_DEPT_NAME_C
   */
  public void setSA_DEPT_NAME_C(String param) {
    localSA_DEPT_NAME_CTracker = param != null;

    this.localSA_DEPT_NAME_C = param;
  }

  /** field for SA_DEPT_NAME_E */
  protected String localSA_DEPT_NAME_E;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_DEPT_NAME_ETracker = false;

  public boolean isSA_DEPT_NAME_ESpecified() {
    return localSA_DEPT_NAME_ETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_DEPT_NAME_E() {
    return localSA_DEPT_NAME_E;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_DEPT_NAME_E
   */
  public void setSA_DEPT_NAME_E(String param) {
    localSA_DEPT_NAME_ETracker = param != null;

    this.localSA_DEPT_NAME_E = param;
  }

  /** field for SA_DEPT_NEW */
  protected String localSA_DEPT_NEW;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_DEPT_NEWTracker = false;

  public boolean isSA_DEPT_NEWSpecified() {
    return localSA_DEPT_NEWTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_DEPT_NEW() {
    return localSA_DEPT_NEW;
  }

  /**
   * Auto generated setter method
   *
   * @param param SA_DEPT_NEW
   */
  public void setSA_DEPT_NEW(String param) {
    localSA_DEPT_NEWTracker = param != null;

    this.localSA_DEPT_NEW = param;
  }

  /** field for SA_EDEPT_NAME */
  protected String localSA_EDEPT_NAME;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSA_EDEPT_NAMETracker = false;

  public boolean isSA_EDEPT_NAMESpecified() {
    return localSA_EDEPT_NAMETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSA_EDEPT_NAME() {
    return localSA_EDEPT_NAME;
  }

  /**
 * Auto generated setter method
 *
 * @param param SA_EDEPT_NAME
 */
public void setSA_EDEPT_NAME(String param) {
  localSA_EDEPT_NAMETracker = param != null;

  this.localSA_EDEPT_NAME = param;
}

/** field for SA_FUNC */
protected String localSA_FUNC;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_FUNCTracker = false;

public boolean isSA_FUNCSpecified() {
  return localSA_FUNCTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_FUNC() {
  return localSA_FUNC;
}

/**
 * Auto generated setter method
 *
 * @param param SA_FUNC
 */
public void setSA_FUNC(String param) {
  localSA_FUNCTracker = param != null;

  this.localSA_FUNC = param;
}

/** field for SA_FUNC_NAME */
protected String localSA_FUNC_NAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_FUNC_NAMETracker = false;

public boolean isSA_FUNC_NAMESpecified() {
  return localSA_FUNC_NAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_FUNC_NAME() {
  return localSA_FUNC_NAME;
}

/**
 * Auto generated setter method
 *
 * @param param SA_FUNC_NAME
 */
public void setSA_FUNC_NAME(String param) {
  localSA_FUNC_NAMETracker = param != null;

  this.localSA_FUNC_NAME = param;
}

/** field for SA_FUNC_NAME_C */
protected String localSA_FUNC_NAME_C;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_FUNC_NAME_CTracker = false;

public boolean isSA_FUNC_NAME_CSpecified() {
  return localSA_FUNC_NAME_CTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_FUNC_NAME_C() {
  return localSA_FUNC_NAME_C;
}

/**
 * Auto generated setter method
 *
 * @param param SA_FUNC_NAME_C
 */
public void setSA_FUNC_NAME_C(String param) {
  localSA_FUNC_NAME_CTracker = param != null;

  this.localSA_FUNC_NAME_C = param;
}

/** field for SA_FUNC_NAME_E */
protected String localSA_FUNC_NAME_E;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_FUNC_NAME_ETracker = false;

public boolean isSA_FUNC_NAME_ESpecified() {
  return localSA_FUNC_NAME_ETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_FUNC_NAME_E() {
  return localSA_FUNC_NAME_E;
}

/**
 * Auto generated setter method
 *
 * @param param SA_FUNC_NAME_E
 */
public void setSA_FUNC_NAME_E(String param) {
  localSA_FUNC_NAME_ETracker = param != null;

  this.localSA_FUNC_NAME_E = param;
}

/** field for SA_HAND */
protected String localSA_HAND;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_HANDTracker = false;

public boolean isSA_HANDSpecified() {
  return localSA_HANDTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_HAND() {
  return localSA_HAND;
}

/**
 * Auto generated setter method
 *
 * @param param SA_HAND
 */
public void setSA_HAND(String param) {
  localSA_HANDTracker = param != null;

  this.localSA_HAND = param;
}

/** field for SA_HNAME */
protected String localSA_HNAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_HNAMETracker = false;

public boolean isSA_HNAMESpecified() {
  return localSA_HNAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_HNAME() {
  return localSA_HNAME;
}

/**
 * Auto generated setter method
 *
 * @param param SA_HNAME
 */
public void setSA_HNAME(String param) {
  localSA_HNAMETracker = param != null;

  this.localSA_HNAME = param;
}

/** field for SA_JOBX */
protected String localSA_JOBX;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_JOBXTracker = false;

public boolean isSA_JOBXSpecified() {
  return localSA_JOBXTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_JOBX() {
  return localSA_JOBX;
}

/**
 * Auto generated setter method
 *
 * @param param SA_JOBX
 */
public void setSA_JOBX(String param) {
  localSA_JOBXTracker = param != null;

  this.localSA_JOBX = param;
}

/** field for SA_JOBX_NAME */
protected String localSA_JOBX_NAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_JOBX_NAMETracker = false;

public boolean isSA_JOBX_NAMESpecified() {
  return localSA_JOBX_NAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_JOBX_NAME() {
  return localSA_JOBX_NAME;
}

/**
 * Auto generated setter method
 *
 * @param param SA_JOBX_NAME
 */
public void setSA_JOBX_NAME(String param) {
  localSA_JOBX_NAMETracker = param != null;

  this.localSA_JOBX_NAME = param;
}

/** field for SA_JOBX_NAME_C */
protected String localSA_JOBX_NAME_C;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_JOBX_NAME_CTracker = false;

public boolean isSA_JOBX_NAME_CSpecified() {
  return localSA_JOBX_NAME_CTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_JOBX_NAME_C() {
  return localSA_JOBX_NAME_C;
}

/**
 * Auto generated setter method
 *
 * @param param SA_JOBX_NAME_C
 */
public void setSA_JOBX_NAME_C(String param) {
  localSA_JOBX_NAME_CTracker = param != null;

  this.localSA_JOBX_NAME_C = param;
}

/** field for SA_JOBX_NAME_E */
protected String localSA_JOBX_NAME_E;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_JOBX_NAME_ETracker = false;

public boolean isSA_JOBX_NAME_ESpecified() {
  return localSA_JOBX_NAME_ETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_JOBX_NAME_E() {
  return localSA_JOBX_NAME_E;
}

/**
 * Auto generated setter method
 *
 * @param param SA_JOBX_NAME_E
 */
public void setSA_JOBX_NAME_E(String param) {
  localSA_JOBX_NAME_ETracker = param != null;

  this.localSA_JOBX_NAME_E = param;
}

/** field for SA_NAME */
protected String localSA_NAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_NAMETracker = false;

public boolean isSA_NAMESpecified() {
  return localSA_NAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_NAME() {
  return localSA_NAME;
}

/**
 * Auto generated setter method
 *
 * @param param SA_NAME
 */
public void setSA_NAME(String param) {
  localSA_NAMETracker = param != null;

  this.localSA_NAME = param;
}

/** field for SA_NAME_E */
protected String localSA_NAME_E;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_NAME_ETracker = false;

public boolean isSA_NAME_ESpecified() {
  return localSA_NAME_ETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_NAME_E() {
  return localSA_NAME_E;
}

/**
 * Auto generated setter method
 *
 * @param param SA_NAME_E
 */
public void setSA_NAME_E(String param) {
  localSA_NAME_ETracker = param != null;

  this.localSA_NAME_E = param;
}

/** field for SA_PHON_AREA */
protected String localSA_PHON_AREA;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PHON_AREATracker = false;

public boolean isSA_PHON_AREASpecified() {
  return localSA_PHON_AREATracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PHON_AREA() {
  return localSA_PHON_AREA;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PHON_AREA
 */
public void setSA_PHON_AREA(String param) {
  localSA_PHON_AREATracker = param != null;

  this.localSA_PHON_AREA = param;
}

/** field for SA_PHON_D */
protected String localSA_PHON_D;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PHON_DTracker = false;

public boolean isSA_PHON_DSpecified() {
  return localSA_PHON_DTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PHON_D() {
  return localSA_PHON_D;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PHON_D
 */
public void setSA_PHON_D(String param) {
  localSA_PHON_DTracker = param != null;

  this.localSA_PHON_D = param;
}

/** field for SA_PHON_H */
protected String localSA_PHON_H;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PHON_HTracker = false;

public boolean isSA_PHON_HSpecified() {
  return localSA_PHON_HTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PHON_H() {
  return localSA_PHON_H;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PHON_H
 */
public void setSA_PHON_H(String param) {
  localSA_PHON_HTracker = param != null;

  this.localSA_PHON_H = param;
}

/** field for SA_PHON_HAREA */
protected String localSA_PHON_HAREA;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PHON_HAREATracker = false;

public boolean isSA_PHON_HAREASpecified() {
  return localSA_PHON_HAREATracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PHON_HAREA() {
  return localSA_PHON_HAREA;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PHON_HAREA
 */
public void setSA_PHON_HAREA(String param) {
  localSA_PHON_HAREATracker = param != null;

  this.localSA_PHON_HAREA = param;
}

/** field for SA_PHON_O */
protected String localSA_PHON_O;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PHON_OTracker = false;

public boolean isSA_PHON_OSpecified() {
  return localSA_PHON_OTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PHON_O() {
  return localSA_PHON_O;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PHON_O
 */
public void setSA_PHON_O(String param) {
  localSA_PHON_OTracker = param != null;

  this.localSA_PHON_O = param;
}

/** field for SA_RECT */
protected String localSA_RECT;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_RECTTracker = false;

public boolean isSA_RECTSpecified() {
  return localSA_RECTTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_RECT() {
  return localSA_RECT;
}

/**
 * Auto generated setter method
 *
 * @param param SA_RECT
 */
public void setSA_RECT(String param) {
  localSA_RECTTracker = param != null;

  this.localSA_RECT = param;
}

/** field for SA_SABUN */
protected String localSA_SABUN;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SABUNTracker = false;

public boolean isSA_SABUNSpecified() {
  return localSA_SABUNTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SABUN() {
  return localSA_SABUN;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SABUN
 */
public void setSA_SABUN(String param) {
  localSA_SABUNTracker = param != null;

  this.localSA_SABUN = param;
}

/** field for SA_SABUN_LEADER */
protected String localSA_SABUN_LEADER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SABUN_LEADERTracker = false;

public boolean isSA_SABUN_LEADERSpecified() {
  return localSA_SABUN_LEADERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SABUN_LEADER() {
  return localSA_SABUN_LEADER;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SABUN_LEADER
 */
public void setSA_SABUN_LEADER(String param) {
  localSA_SABUN_LEADERTracker = param != null;

  this.localSA_SABUN_LEADER = param;
}

/** field for SA_SABUN_NEW */
protected String localSA_SABUN_NEW;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SABUN_NEWTracker = false;

public boolean isSA_SABUN_NEWSpecified() {
  return localSA_SABUN_NEWTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SABUN_NEW() {
  return localSA_SABUN_NEW;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SABUN_NEW
 */
public void setSA_SABUN_NEW(String param) {
  localSA_SABUN_NEWTracker = param != null;

  this.localSA_SABUN_NEW = param;
}

/** field for SA_SYSTEM */
protected String localSA_SYSTEM;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SYSTEMTracker = false;

public boolean isSA_SYSTEMSpecified() {
  return localSA_SYSTEMTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SYSTEM() {
  return localSA_SYSTEM;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SYSTEM
 */
public void setSA_SYSTEM(String param) {
  localSA_SYSTEMTracker = param != null;

  this.localSA_SYSTEM = param;
}

/** field for SA_TEMP */
protected String localSA_TEMP;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_TEMPTracker = false;

public boolean isSA_TEMPSpecified() {
  return localSA_TEMPTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_TEMP() {
  return localSA_TEMP;
}

/**
 * Auto generated setter method
 *
 * @param param SA_TEMP
 */
public void setSA_TEMP(String param) {
  localSA_TEMPTracker = param != null;

  this.localSA_TEMP = param;
}

/** field for SA_TEMP_DATE */
protected String localSA_TEMP_DATE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_TEMP_DATETracker = false;

public boolean isSA_TEMP_DATESpecified() {
  return localSA_TEMP_DATETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_TEMP_DATE() {
  return localSA_TEMP_DATE;
}

/**
 * Auto generated setter method
 *
 * @param param SA_TEMP_DATE
 */
public void setSA_TEMP_DATE(String param) {
  localSA_TEMP_DATETracker = param != null;

  this.localSA_TEMP_DATE = param;
}

/** field for SA_USER */
protected String localSA_USER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_USERTracker = false;

public boolean isSA_USERSpecified() {
  return localSA_USERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_USER() {
  return localSA_USER;
}

/**
 * Auto generated setter method
 *
 * @param param SA_USER
 */
public void setSA_USER(String param) {
  localSA_USERTracker = param != null;

  this.localSA_USER = param;
}

/** field for SSO_EX_FLAG */
protected String localSSO_EX_FLAG;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_EX_FLAGTracker = false;

public boolean isSSO_EX_FLAGSpecified() {
  return localSSO_EX_FLAGTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_EX_FLAG() {
  return localSSO_EX_FLAG;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_EX_FLAG
 */
public void setSSO_EX_FLAG(String param) {
  localSSO_EX_FLAGTracker = param != null;

  this.localSSO_EX_FLAG = param;
}

/** field for SSO_MAILSERVER */
protected String localSSO_MAILSERVER;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_MAILSERVERTracker = false;

public boolean isSSO_MAILSERVERSpecified() {
  return localSSO_MAILSERVERTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_MAILSERVER() {
  return localSSO_MAILSERVER;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_MAILSERVER
 */
public void setSSO_MAILSERVER(String param) {
  localSSO_MAILSERVERTracker = param != null;

  this.localSSO_MAILSERVER = param;
}

/** field for SSO_PS_DATE */
protected String localSSO_PS_DATE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_PS_DATETracker = false;

public boolean isSSO_PS_DATESpecified() {
  return localSSO_PS_DATETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_PS_DATE() {
  return localSSO_PS_DATE;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_PS_DATE
 */
public void setSSO_PS_DATE(String param) {
  localSSO_PS_DATETracker = param != null;

  this.localSSO_PS_DATE = param;
}

/** field for SA_GNMU */
protected String localSA_GNMU;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_GNMUTracker = false;

public boolean isSA_GNMUSpecified() {
  return localSA_GNMUTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_GNMU() {
  return localSA_GNMU;
}

/**
 * Auto generated setter method
 *
 * @param param SA_GNMU
 */
public void setSA_GNMU(String param) {
  localSA_GNMUTracker = param != null;

  this.localSA_GNMU = param;
}

/** field for SA_GNMU_NAME */
protected String localSA_GNMU_NAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_GNMU_NAMETracker = false;

public boolean isSA_GNMU_NAMESpecified() {
  return localSA_GNMU_NAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_GNMU_NAME() {
  return localSA_GNMU_NAME;
}

/**
 * Auto generated setter method
 *
 * @param param SA_GNMU_NAME
 */
public void setSA_GNMU_NAME(String param) {
  localSA_GNMU_NAMETracker = param != null;

  this.localSA_GNMU_NAME = param;
}

/** field for SSO_LOCATE */
protected String localSSO_LOCATE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_LOCATETracker = false;

public boolean isSSO_LOCATESpecified() {
  return localSSO_LOCATETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_LOCATE() {
  return localSSO_LOCATE;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_LOCATE
 */
public void setSSO_LOCATE(String param) {
  localSSO_LOCATETracker = param != null;

  this.localSSO_LOCATE = param;
}

/** field for SA_PAYXGB */
protected String localSA_PAYXGB;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_PAYXGBTracker = false;

public boolean isSA_PAYXGBSpecified() {
  return localSA_PAYXGBTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_PAYXGB() {
  return localSA_PAYXGB;
}

/**
 * Auto generated setter method
 *
 * @param param SA_PAYXGB
 */
public void setSA_PAYXGB(String param) {
  localSA_PAYXGBTracker = param != null;

  this.localSA_PAYXGB = param;
}

/** field for SA_SNBNGB */
protected String localSA_SNBNGB;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SNBNGBTracker = false;

public boolean isSA_SNBNGBSpecified() {
  return localSA_SNBNGBTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SNBNGB() {
  return localSA_SNBNGB;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SNBNGB
 */
public void setSA_SNBNGB(String param) {
  localSA_SNBNGBTracker = param != null;

  this.localSA_SNBNGB = param;
}

/** field for SA_SNBNGR */
protected String localSA_SNBNGR;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_SNBNGRTracker = false;

public boolean isSA_SNBNGRSpecified() {
  return localSA_SNBNGRTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_SNBNGR() {
  return localSA_SNBNGR;
}

/**
 * Auto generated setter method
 *
 * @param param SA_SNBNGR
 */
public void setSA_SNBNGR(String param) {
  localSA_SNBNGRTracker = param != null;

  this.localSA_SNBNGR = param;
}

/** field for SA_MAIL */
protected String localSA_MAIL;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_MAILTracker = false;

public boolean isSA_MAILSpecified() {
  return localSA_MAILTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_MAIL() {
  return localSA_MAIL;
}

/**
 * Auto generated setter method
 *
 * @param param SA_MAIL
 */
public void setSA_MAIL(String param) {
  localSA_MAILTracker = param != null;

  this.localSA_MAIL = param;
}

/** field for SSO_SU_GNMU */
protected String localSSO_SU_GNMU;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_SU_GNMUTracker = false;

public boolean isSSO_SU_GNMUSpecified() {
  return localSSO_SU_GNMUTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_SU_GNMU() {
  return localSSO_SU_GNMU;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_SU_GNMU
 */
public void setSSO_SU_GNMU(String param) {
  localSSO_SU_GNMUTracker = param != null;

  this.localSSO_SU_GNMU = param;
}

/** field for SSO_CNAME */
protected String localSSO_CNAME;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSSO_CNAMETracker = false;

public boolean isSSO_CNAMESpecified() {
  return localSSO_CNAMETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSSO_CNAME() {
  return localSSO_CNAME;
}

/**
 * Auto generated setter method
 *
 * @param param SSO_CNAME
 */
public void setSSO_CNAME(String param) {
  localSSO_CNAMETracker = param != null;

  this.localSSO_CNAME = param;
}

/** field for SA_NATIONALITY */
protected String localSA_NATIONALITY;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localSA_NATIONALITYTracker = false;

public boolean isSA_NATIONALITYSpecified() {
  return localSA_NATIONALITYTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getSA_NATIONALITY() {
  return localSA_NATIONALITY;
}

/**
 * Auto generated setter method
 *
 * @param param SA_NATIONALITY
 */
public void setSA_NATIONALITY(String param) {
  localSA_NATIONALITYTracker = param != null;

  this.localSA_NATIONALITY = param;
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

    String namespacePrefix =
        registerPrefix(xmlWriter, "http://www.lgchem.com/PI/LGC");
    if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
      writeAttribute(
          "xsi",
          "http://www.w3.org/2001/XMLSchema-instance",
          "type",
          namespacePrefix + ":RETURN_type0",
          xmlWriter);
    } else {
      writeAttribute(
          "xsi",
          "http://www.w3.org/2001/XMLSchema-instance",
          "type",
          "RETURN_type0",
          xmlWriter);
    }
  }
  if (localSA_COMPTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_COMP", xmlWriter);

    if (localSA_COMP == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_COMP cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_COMP);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_DEPTTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_DEPT", xmlWriter);

    if (localSA_DEPT == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_DEPT cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_DEPT);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_DEPT_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_DEPT_NAME", xmlWriter);

    if (localSA_DEPT_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_DEPT_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_DEPT_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_DEPT_NAME_CTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_DEPT_NAME_C", xmlWriter);

    if (localSA_DEPT_NAME_C == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_DEPT_NAME_C cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_DEPT_NAME_C);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_DEPT_NAME_ETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_DEPT_NAME_E", xmlWriter);

    if (localSA_DEPT_NAME_E == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_DEPT_NAME_E cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_DEPT_NAME_E);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_DEPT_NEWTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_DEPT_NEW", xmlWriter);

    if (localSA_DEPT_NEW == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_DEPT_NEW cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_DEPT_NEW);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_EDEPT_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_EDEPT_NAME", xmlWriter);

    if (localSA_EDEPT_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_EDEPT_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_EDEPT_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_FUNCTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_FUNC", xmlWriter);

    if (localSA_FUNC == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_FUNC cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_FUNC);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_FUNC_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_FUNC_NAME", xmlWriter);

    if (localSA_FUNC_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_FUNC_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_FUNC_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_FUNC_NAME_CTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_FUNC_NAME_C", xmlWriter);

    if (localSA_FUNC_NAME_C == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_FUNC_NAME_C cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_FUNC_NAME_C);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_FUNC_NAME_ETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_FUNC_NAME_E", xmlWriter);

    if (localSA_FUNC_NAME_E == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_FUNC_NAME_E cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_FUNC_NAME_E);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_HANDTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_HAND", xmlWriter);

    if (localSA_HAND == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_HAND cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_HAND);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_HNAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_HNAME", xmlWriter);

    if (localSA_HNAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_HNAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_HNAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_JOBXTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_JOBX", xmlWriter);

    if (localSA_JOBX == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_JOBX cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_JOBX);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_JOBX_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_JOBX_NAME", xmlWriter);

    if (localSA_JOBX_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_JOBX_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_JOBX_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_JOBX_NAME_CTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_JOBX_NAME_C", xmlWriter);

    if (localSA_JOBX_NAME_C == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_JOBX_NAME_C cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_JOBX_NAME_C);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_JOBX_NAME_ETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_JOBX_NAME_E", xmlWriter);

    if (localSA_JOBX_NAME_E == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_JOBX_NAME_E cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_JOBX_NAME_E);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_NAME", xmlWriter);

    if (localSA_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_NAME_ETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_NAME_E", xmlWriter);

    if (localSA_NAME_E == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_NAME_E cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_NAME_E);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PHON_AREATracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PHON_AREA", xmlWriter);

    if (localSA_PHON_AREA == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PHON_AREA cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PHON_AREA);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PHON_DTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PHON_D", xmlWriter);

    if (localSA_PHON_D == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PHON_D cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PHON_D);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PHON_HTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PHON_H", xmlWriter);

    if (localSA_PHON_H == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PHON_H cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PHON_H);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PHON_HAREATracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PHON_HAREA", xmlWriter);

    if (localSA_PHON_HAREA == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PHON_HAREA cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PHON_HAREA);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PHON_OTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PHON_O", xmlWriter);

    if (localSA_PHON_O == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PHON_O cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PHON_O);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_RECTTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_RECT", xmlWriter);

    if (localSA_RECT == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_RECT cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_RECT);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SABUNTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SABUN", xmlWriter);

    if (localSA_SABUN == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SABUN cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SABUN);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SABUN_LEADERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SABUN_LEADER", xmlWriter);

    if (localSA_SABUN_LEADER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SABUN_LEADER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SABUN_LEADER);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SABUN_NEWTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SABUN_NEW", xmlWriter);

    if (localSA_SABUN_NEW == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SABUN_NEW cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SABUN_NEW);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SYSTEMTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SYSTEM", xmlWriter);

    if (localSA_SYSTEM == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SYSTEM cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SYSTEM);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_TEMPTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_TEMP", xmlWriter);

    if (localSA_TEMP == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_TEMP cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_TEMP);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_TEMP_DATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_TEMP_DATE", xmlWriter);

    if (localSA_TEMP_DATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_TEMP_DATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_TEMP_DATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_USERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_USER", xmlWriter);

    if (localSA_USER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_USER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_USER);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_EX_FLAGTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_EX_FLAG", xmlWriter);

    if (localSSO_EX_FLAG == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_EX_FLAG cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_EX_FLAG);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_MAILSERVERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_MAILSERVER", xmlWriter);

    if (localSSO_MAILSERVER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_MAILSERVER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_MAILSERVER);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_PS_DATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_PS_DATE", xmlWriter);

    if (localSSO_PS_DATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_PS_DATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_PS_DATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_GNMUTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_GNMU", xmlWriter);

    if (localSA_GNMU == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_GNMU cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_GNMU);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_GNMU_NAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_GNMU_NAME", xmlWriter);

    if (localSA_GNMU_NAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_GNMU_NAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_GNMU_NAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_LOCATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_LOCATE", xmlWriter);

    if (localSSO_LOCATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_LOCATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_LOCATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_PAYXGBTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_PAYXGB", xmlWriter);

    if (localSA_PAYXGB == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_PAYXGB cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_PAYXGB);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SNBNGBTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SNBNGB", xmlWriter);

    if (localSA_SNBNGB == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SNBNGB cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SNBNGB);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_SNBNGRTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_SNBNGR", xmlWriter);

    if (localSA_SNBNGR == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_SNBNGR cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_SNBNGR);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_MAILTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_MAIL", xmlWriter);

    if (localSA_MAIL == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_MAIL cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_MAIL);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_SU_GNMUTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_SU_GNMU", xmlWriter);

    if (localSSO_SU_GNMU == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_SU_GNMU cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_SU_GNMU);
    }

    xmlWriter.writeEndElement();
  }
  if (localSSO_CNAMETracker) {
    namespace = "";
    writeStartElement(null, namespace, "SSO_CNAME", xmlWriter);

    if (localSSO_CNAME == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SSO_CNAME cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSSO_CNAME);
    }

    xmlWriter.writeEndElement();
  }
  if (localSA_NATIONALITYTracker) {
    namespace = "";
    writeStartElement(null, namespace, "SA_NATIONALITY", xmlWriter);

    if (localSA_NATIONALITY == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("SA_NATIONALITY cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localSA_NATIONALITY);
    }

    xmlWriter.writeEndElement();
  }
  xmlWriter.writeEndElement();
}

private static String generatePrefix(String namespace) {
  if (namespace.equals("http://www.lgchem.com/PI/LGC")) {
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
  public static RETURN_type0 parse(javax.xml.stream.XMLStreamReader reader)
      throws Exception {
    RETURN_type0 object = new RETURN_type0();

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

          if (!"RETURN_type0".equals(type)) {
            // find namespace for the prefix
            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
            return (RETURN_type0) ExtensionMapper.getTypeObject(nsUri, type, reader);
          }
        }
      }

      // Note all attributes that were handled. Used to differ normal attributes
      // from anyAttributes.
      java.util.Vector handledAttributes = new java.util.Vector();

      reader.next();

      while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

      if (reader.isStartElement()
          && new javax.xml.namespace.QName("", "SA_COMP").equals(reader.getName())) {

        nillableValue =
            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
          throw new org.apache.axis2.databinding.ADBException(
              "The element: " + "SA_COMP" + "  cannot be null");
        }

        String content = reader.getElementText();

        object.setSA_COMP(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

        reader.next();

      } // End of if for expected property start element
      else {

      }

      while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

      if (reader.isStartElement()
          && new javax.xml.namespace.QName("", "SA_DEPT").equals(reader.getName())) {

        nillableValue =
            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
          throw new org.apache.axis2.databinding.ADBException(
              "The element: " + "SA_DEPT" + "  cannot be null");
        }

        String content = reader.getElementText();

        object.setSA_DEPT(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

        reader.next();

      } // End of if for expected property start element
      else {

      }

      while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

      if (reader.isStartElement()
          && new javax.xml.namespace.QName("", "SA_DEPT_NAME").equals(reader.getName())) {

        nillableValue =
            reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
          throw new org.apache.axis2.databinding.ADBException(
              "The element: " + "SA_DEPT_NAME" + "  cannot be null");
        }

        String content = reader.getElementText();

        object.setSA_DEPT_NAME(
            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

        reader.next();

      } // End of if for expected property start element
      else {

      }

    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_DEPT_NAME_C").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_DEPT_NAME_C" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_DEPT_NAME_C(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_DEPT_NAME_E").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_DEPT_NAME_E" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_DEPT_NAME_E(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_DEPT_NEW").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_DEPT_NEW" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_DEPT_NEW(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_EDEPT_NAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_EDEPT_NAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_EDEPT_NAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_FUNC").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_FUNC" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_FUNC(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_FUNC_NAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_FUNC_NAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_FUNC_NAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_FUNC_NAME_C").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_FUNC_NAME_C" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_FUNC_NAME_C(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_FUNC_NAME_E").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_FUNC_NAME_E" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_FUNC_NAME_E(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_HAND").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_HAND" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_HAND(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_HNAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_HNAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_HNAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_JOBX").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_JOBX" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_JOBX(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_JOBX_NAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_JOBX_NAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_JOBX_NAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_JOBX_NAME_C").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_JOBX_NAME_C" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_JOBX_NAME_C(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_JOBX_NAME_E").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_JOBX_NAME_E" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_JOBX_NAME_E(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_NAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_NAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_NAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_NAME_E").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_NAME_E" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_NAME_E(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PHON_AREA").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PHON_AREA" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PHON_AREA(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PHON_D").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PHON_D" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PHON_D(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PHON_H").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PHON_H" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PHON_H(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PHON_HAREA").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PHON_HAREA" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PHON_HAREA(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PHON_O").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PHON_O" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PHON_O(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_RECT").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_RECT" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_RECT(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SABUN").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SABUN" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SABUN(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SABUN_LEADER").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SABUN_LEADER" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SABUN_LEADER(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SABUN_NEW").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SABUN_NEW" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SABUN_NEW(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SYSTEM").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SYSTEM" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SYSTEM(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_TEMP").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_TEMP" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_TEMP(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_TEMP_DATE").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_TEMP_DATE" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_TEMP_DATE(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_USER").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_USER" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_USER(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SSO_EX_FLAG").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SSO_EX_FLAG" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSSO_EX_FLAG(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SSO_MAILSERVER").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SSO_MAILSERVER" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSSO_MAILSERVER(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SSO_PS_DATE").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SSO_PS_DATE" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSSO_PS_DATE(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_GNMU").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_GNMU" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_GNMU(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_GNMU_NAME").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_GNMU_NAME" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_GNMU_NAME(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SSO_LOCATE").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SSO_LOCATE" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSSO_LOCATE(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_PAYXGB").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_PAYXGB" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_PAYXGB(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SNBNGB").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SNBNGB" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SNBNGB(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_SNBNGR").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_SNBNGR" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_SNBNGR(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SA_MAIL").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SA_MAIL" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSA_MAIL(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

if (reader.isStartElement()
    && new javax.xml.namespace.QName("", "SSO_SU_GNMU").equals(reader.getName())) {

  nillableValue =
      reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
  if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
    throw new org.apache.axis2.databinding.ADBException(
        "The element: " + "SSO_SU_GNMU" + "  cannot be null");
  }

  String content = reader.getElementText();

  object.setSSO_SU_GNMU(
      org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

  reader.next();

} // End of if for expected property start element
else {

}

while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "SSO_CNAME").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "SSO_CNAME" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setSSO_CNAME(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "SA_NATIONALITY").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "SA_NATIONALITY" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setSA_NATIONALITY(
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

public static class ExtensionMapper {

  public static Object getTypeObject(
      String namespaceURI,
      String typeName,
      javax.xml.stream.XMLStreamReader reader)
      throws Exception {

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI)
        && "DT_LGCY_LCHC_EA_EMPBATCH_02_S_response".equals(typeName)) {

      return DT_LGCY_LCHC_EA_EMPBATCH_02_S_response.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI) && "RETURN_type0".equals(typeName)) {

      return RETURN_type0.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI)
        && "DT_LGCY_LCHC_EA_EMPBATCH_02_S".equals(typeName)) {

      return DT_LGCY_LCHC_EA_EMPBATCH_02_S.Factory.parse(reader);
    }

    throw new org.apache.axis2.databinding.ADBException(
        "Unsupported type " + namespaceURI + " " + typeName);
  }
}

public static class MT_LGCY_LCHC_EA_EMPBATCH_02_S
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S", "ns1");

  /** field for MT_LGCY_LCHC_EA_EMPBATCH_02_S */
  protected DT_LGCY_LCHC_EA_EMPBATCH_02_S localMT_LGCY_LCHC_EA_EMPBATCH_02_S;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_LCHC_EA_EMPBATCH_02_S
   */
  public DT_LGCY_LCHC_EA_EMPBATCH_02_S getMT_LGCY_LCHC_EA_EMPBATCH_02_S() {
    return localMT_LGCY_LCHC_EA_EMPBATCH_02_S;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_LCHC_EA_EMPBATCH_02_S
   */
  public void setMT_LGCY_LCHC_EA_EMPBATCH_02_S(DT_LGCY_LCHC_EA_EMPBATCH_02_S param) {

    this.localMT_LGCY_LCHC_EA_EMPBATCH_02_S = param;
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

    if (localMT_LGCY_LCHC_EA_EMPBATCH_02_S == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_LCHC_EA_EMPBATCH_02_S cannot be null!");
    }
    localMT_LGCY_LCHC_EA_EMPBATCH_02_S.serialize(MY_QNAME, xmlWriter);
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/PI/LGC")) {
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
    public static MT_LGCY_LCHC_EA_EMPBATCH_02_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      MT_LGCY_LCHC_EA_EMPBATCH_02_S object = new MT_LGCY_LCHC_EA_EMPBATCH_02_S();

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
                        "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S")
                    .equals(reader.getName())) {

              object.setMT_LGCY_LCHC_EA_EMPBATCH_02_S(
                  DT_LGCY_LCHC_EA_EMPBATCH_02_S.Factory.parse(reader));

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

public static class DT_LGCY_LCHC_EA_EMPBATCH_02_S
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_LCHC_EA_EMPBATCH_02_S
  Namespace URI = http://www.lgchem.com/PI/LGC
  Namespace Prefix = ns1
  */

  /** field for SystemKey */
  protected String localSystemKey;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localSystemKeyTracker = false;

  public boolean isSystemKeySpecified() {
    return localSystemKeyTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getSystemKey() {
    return localSystemKey;
  }

  /**
   * Auto generated setter method
   *
   * @param param SystemKey
   */
  public void setSystemKey(String param) {
    localSystemKeyTracker = param != null;

    this.localSystemKey = param;
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

      String namespacePrefix =
          registerPrefix(xmlWriter, "http://www.lgchem.com/PI/LGC");
      if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            namespacePrefix + ":DT_LGCY_LCHC_EA_EMPBATCH_02_S",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_LCHC_EA_EMPBATCH_02_S",
            xmlWriter);
      }
    }
    if (localSystemKeyTracker) {
      namespace = "";
      writeStartElement(null, namespace, "systemKey", xmlWriter);

      if (localSystemKey == null) {
        // write the nil attribute

        throw new org.apache.axis2.databinding.ADBException("systemKey cannot be null!!");

      } else {

        xmlWriter.writeCharacters(localSystemKey);
      }

      xmlWriter.writeEndElement();
    }
    xmlWriter.writeEndElement();
  }

  private static String generatePrefix(String namespace) {
    if (namespace.equals("http://www.lgchem.com/PI/LGC")) {
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
    public static DT_LGCY_LCHC_EA_EMPBATCH_02_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      DT_LGCY_LCHC_EA_EMPBATCH_02_S object = new DT_LGCY_LCHC_EA_EMPBATCH_02_S();

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

            if (!"DT_LGCY_LCHC_EA_EMPBATCH_02_S".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_LCHC_EA_EMPBATCH_02_S)
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
            && new javax.xml.namespace.QName("", "systemKey").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "systemKey" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setSystemKey(
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

public static class MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S_response", "ns1");

  /** field for MT_LGCY_LCHC_EA_EMPBATCH_02_S_response */
  protected DT_LGCY_LCHC_EA_EMPBATCH_02_S_response localMT_LGCY_LCHC_EA_EMPBATCH_02_S_response;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_LCHC_EA_EMPBATCH_02_S_response
   */
  public DT_LGCY_LCHC_EA_EMPBATCH_02_S_response getMT_LGCY_LCHC_EA_EMPBATCH_02_S_response() {
    return localMT_LGCY_LCHC_EA_EMPBATCH_02_S_response;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
   */
  public void setMT_LGCY_LCHC_EA_EMPBATCH_02_S_response(
      DT_LGCY_LCHC_EA_EMPBATCH_02_S_response param) {

    this.localMT_LGCY_LCHC_EA_EMPBATCH_02_S_response = param;
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

      if (localMT_LGCY_LCHC_EA_EMPBATCH_02_S_response == null) {
        throw new org.apache.axis2.databinding.ADBException(
            "MT_LGCY_LCHC_EA_EMPBATCH_02_S_response cannot be null!");
      }
      localMT_LGCY_LCHC_EA_EMPBATCH_02_S_response.serialize(MY_QNAME, xmlWriter);
    }

    private static String generatePrefix(String namespace) {
      if (namespace.equals("http://www.lgchem.com/PI/LGC")) {
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
      public static MT_LGCY_LCHC_EA_EMPBATCH_02_S_response parse(
          javax.xml.stream.XMLStreamReader reader) throws Exception {
        MT_LGCY_LCHC_EA_EMPBATCH_02_S_response object =
            new MT_LGCY_LCHC_EA_EMPBATCH_02_S_response();

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
                          "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_EMPBATCH_02_S_response")
                      .equals(reader.getName())) {

                object.setMT_LGCY_LCHC_EA_EMPBATCH_02_S_response(
                    DT_LGCY_LCHC_EA_EMPBATCH_02_S_response.Factory.parse(reader));

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

  private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_LCHC_EA_EMPBATCH_02_S
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_LCHC_EA_EMPBATCH_02_S
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      MT_LGCY_LCHC_EA_EMPBATCH_02_S
          param,
      boolean optimizeContent,
      javax.xml.namespace.QName elementQName)
      throws org.apache.axis2.AxisFault {

    try {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope
          .getBody()
          .addChild(
              param.getOMElement(
                  MT_LGCY_LCHC_EA_EMPBATCH_02_S
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

      if (MT_LGCY_LCHC_EA_EMPBATCH_02_S.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_LCHC_EA_EMPBATCH_02_S.Factory.parse(reader);
        reader.close();
        return result;
      }

      if (MT_LGCY_LCHC_EA_EMPBATCH_02_S_response.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_LCHC_EA_EMPBATCH_02_S_response.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}