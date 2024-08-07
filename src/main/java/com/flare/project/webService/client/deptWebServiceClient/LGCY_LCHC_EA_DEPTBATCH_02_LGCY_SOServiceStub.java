/**
 * LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.flare.project.webService.client.deptWebServiceClient;

/*
 *  LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub java implementation
 */
public class LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub extends org.apache.axis2.client.Stub {
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
            "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOService" + getUniqueSuffix());
    addAnonymousOperations();

    // creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[1];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(
        new javax.xml.namespace.QName(
            "http://www.lgchem.com/PI/LGC", "lGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"));
    _service.addOperation(__operation);

    _operations[0] = __operation;
  }

  // populates the faults
  private void populateFaults() {}

  /** Constructor that takes in a configContext */
  public LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext,
      String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(configurationContext, targetEndpoint, false);
  }

  /** Constructor that takes in a configContext and useseperate listner */
  public LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub(
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
  public LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub(
      org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault {

    this(
        configurationContext,
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC");
  }

  /** Default Constructor */
  public LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub() throws org.apache.axis2.AxisFault {

    this(
        "http://10.94.23.4:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC");
  }

  /** Constructor taking the target endpoint */
  public LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceStub(String targetEndpoint)
      throws org.apache.axis2.AxisFault {
    this(null, targetEndpoint);
  }

  public MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
      lGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(
          MT_LGCY_LCHC_EA_DEPTBATCH_02_S
              mT_LGCY_LCHC_EA_DEPTBATCH_02_S0)
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
              mT_LGCY_LCHC_EA_DEPTBATCH_02_S0,
              optimizeContent(
                  new javax.xml.namespace.QName(
                      "http://www.lgchem.com/PI/LGC", "lGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO")),
              new javax.xml.namespace.QName(
                  "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S"));

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
              MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
                  .class);
      org.apache.axis2.kernel.TransportUtils.detachInputStream(_returnMessageContext);

      return (MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response)
          object;

    } catch (org.apache.axis2.AxisFault f) {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null) {
        if (faultExceptionNameMap.containsKey(
            new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"))) {
          // make the fault by reflection
          try {
            String exceptionClassName =
                faultExceptionClassNameMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"));
            Class exceptionClass = Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor =
                exceptionClass.getConstructor(String.class);
            Exception ex = (Exception) constructor.newInstance(f.getMessage());
            // message class
            String messageClassName =
                faultMessageMap.get(
                    new org.apache.axis2.client.FaultMapKey(
                        faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"));
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

  public void startlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(
    MT_LGCY_LCHC_EA_DEPTBATCH_02_S
        mT_LGCY_LCHC_EA_DEPTBATCH_02_S0,
    final LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SOServiceCallbackHandler callback)
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
          mT_LGCY_LCHC_EA_DEPTBATCH_02_S0,
          optimizeContent(
              new javax.xml.namespace.QName(
                  "http://www.lgchem.com/PI/LGC", "lGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO")),
          new javax.xml.namespace.QName(
              "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S"));

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
                    MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
                        .class);
            callback.receiveResultlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(
                (MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response)
                    object);

          } catch (org.apache.axis2.AxisFault e) {
            callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(e);
          }
        }

        public void onError(Exception error) {
          if (error instanceof org.apache.axis2.AxisFault) {
            org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
              if (faultExceptionNameMap.containsKey(
                  new org.apache.axis2.client.FaultMapKey(
                      faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"))) {
                // make the fault by reflection
                try {
                  String exceptionClassName =
                      faultExceptionClassNameMap.get(
                          new org.apache.axis2.client.FaultMapKey(
                              faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"));
                  Class exceptionClass = Class.forName(exceptionClassName);
                  java.lang.reflect.Constructor constructor =
                      exceptionClass.getConstructor(String.class);
                  Exception ex =
                      (Exception) constructor.newInstance(f.getMessage());
                  // message class
                  String messageClassName =
                      faultMessageMap.get(
                          new org.apache.axis2.client.FaultMapKey(
                              faultElt.getQName(), "LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO"));
                  Class messageClass = Class.forName(messageClassName);
                  Object messageObject = fromOM(faultElt, messageClass);
                  java.lang.reflect.Method m =
                      exceptionClass.getMethod(
                          "setFaultMessage", new Class[] {messageClass});
                  m.invoke(ex, new Object[] {messageObject});

                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(
                      new java.rmi.RemoteException(ex.getMessage(), ex));
                } catch (ClassCastException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (ClassNotFoundException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (NoSuchMethodException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (java.lang.reflect.InvocationTargetException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (IllegalAccessException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (InstantiationException e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                } catch (org.apache.axis2.AxisFault e) {
                  // we cannot intantiate the class - throw the original Axis fault
                  callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
                }
              } else {
                callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
              }
            } else {
              callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(f);
            }
          } else {
            callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(error);
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
            callback.receiveErrorlGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO(axisFault);
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
// http://lchaspeaq01:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=LGCY_DEV&receiverParty=&receiverService=&interface=LGCY_LCHC_EA_DEPTBATCH_02_LGCY_SO&interfaceNamespace=http%3A%2F%2Fwww.lgchem.com%2FPI%2FLGC
public static class RETURN_type0 implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = RETURN_type0
  Namespace URI = http://www.lgchem.com/PI/LGC
  Namespace Prefix = ns1
  */

  /** field for CODE_NAME_CN */
  protected String localCODE_NAME_CN;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCODE_NAME_CNTracker = false;

  public boolean isCODE_NAME_CNSpecified() {
    return localCODE_NAME_CNTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCODE_NAME_CN() {
    return localCODE_NAME_CN;
  }

  /**
   * Auto generated setter method
   *
   * @param param CODE_NAME_CN
   */
  public void setCODE_NAME_CN(String param) {
    localCODE_NAME_CNTracker = param != null;

    this.localCODE_NAME_CN = param;
  }

  /** field for CODE_NAME_EN */
  protected String localCODE_NAME_EN;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCODE_NAME_ENTracker = false;

  public boolean isCODE_NAME_ENSpecified() {
    return localCODE_NAME_ENTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCODE_NAME_EN() {
    return localCODE_NAME_EN;
  }

  /**
   * Auto generated setter method
   *
   * @param param CODE_NAME_EN
   */
  public void setCODE_NAME_EN(String param) {
    localCODE_NAME_ENTracker = param != null;

    this.localCODE_NAME_EN = param;
  }

  /** field for CODE_NAME_KO */
  protected String localCODE_NAME_KO;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCODE_NAME_KOTracker = false;

  public boolean isCODE_NAME_KOSpecified() {
    return localCODE_NAME_KOTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCODE_NAME_KO() {
    return localCODE_NAME_KO;
  }

  /**
   * Auto generated setter method
   *
   * @param param CODE_NAME_KO
   */
  public void setCODE_NAME_KO(String param) {
    localCODE_NAME_KOTracker = param != null;

    this.localCODE_NAME_KO = param;
  }

  /** field for CODE_NUMB */
  protected String localCODE_NUMB;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCODE_NUMBTracker = false;

  public boolean isCODE_NUMBSpecified() {
    return localCODE_NUMBTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCODE_NUMB() {
    return localCODE_NUMB;
  }

  /**
   * Auto generated setter method
   *
   * @param param CODE_NUMB
   */
  public void setCODE_NUMB(String param) {
    localCODE_NUMBTracker = param != null;

    this.localCODE_NUMB = param;
  }

  /** field for CODE_UPER */
  protected String localCODE_UPER;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCODE_UPERTracker = false;

  public boolean isCODE_UPERSpecified() {
    return localCODE_UPERTracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCODE_UPER() {
    return localCODE_UPER;
  }

  /**
   * Auto generated setter method
   *
   * @param param CODE_UPER
   */
  public void setCODE_UPER(String param) {
    localCODE_UPERTracker = param != null;

    this.localCODE_UPER = param;
  }

  /** field for CREATEDATE */
  protected String localCREATEDATE;

  /*  This tracker boolean wil be used to detect whether the user called the set method
   *   for this attribute. It will be used to determine whether to include this field
   *   in the serialized XML
   */
  protected boolean localCREATEDATETracker = false;

  public boolean isCREATEDATESpecified() {
    return localCREATEDATETracker;
  }

  /**
   * Auto generated getter method
   *
   * @return java.lang.String
   */
  public String getCREATEDATE() {
    return localCREATEDATE;
  }

  /**
   * Auto generated setter method
   *
   * @param param CREATEDATE
   */
  public void setCREATEDATE(String param) {
    localCREATEDATETracker = param != null;

    this.localCREATEDATE = param;
  }

  /** field for DIVISION */
protected String localDIVISION;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localDIVISIONTracker = false;

public boolean isDIVISIONSpecified() {
  return localDIVISIONTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getDIVISION() {
  return localDIVISION;
}

/**
 * Auto generated setter method
 *
 * @param param DIVISION
 */
public void setDIVISION(String param) {
  localDIVISIONTracker = param != null;

  this.localDIVISION = param;
}

/** field for UPDATEDATE */
protected String localUPDATEDATE;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localUPDATEDATETracker = false;

public boolean isUPDATEDATESpecified() {
  return localUPDATEDATETracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getUPDATEDATE() {
  return localUPDATEDATE;
}

/**
 * Auto generated setter method
 *
 * @param param UPDATEDATE
 */
public void setUPDATEDATE(String param) {
  localUPDATEDATETracker = param != null;

  this.localUPDATEDATE = param;
}

/** field for VALID_FLAG */
protected String localVALID_FLAG;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localVALID_FLAGTracker = false;

public boolean isVALID_FLAGSpecified() {
  return localVALID_FLAGTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getVALID_FLAG() {
  return localVALID_FLAG;
}

/**
 * Auto generated setter method
 *
 * @param param VALID_FLAG
 */
public void setVALID_FLAG(String param) {
  localVALID_FLAGTracker = param != null;

  this.localVALID_FLAG = param;
}

/** field for ChiefNumb */
protected String localChiefNumb;

/*  This tracker boolean wil be used to detect whether the user called the set method
 *   for this attribute. It will be used to determine whether to include this field
 *   in the serialized XML
 */
protected boolean localChiefNumbTracker = false;

public boolean isChiefNumbSpecified() {
  return localChiefNumbTracker;
}

/**
 * Auto generated getter method
 *
 * @return java.lang.String
 */
public String getChiefNumb() {
  return localChiefNumb;
}

/**
 * Auto generated setter method
 *
 * @param param ChiefNumb
 */
public void setChiefNumb(String param) {
  localChiefNumbTracker = param != null;

  this.localChiefNumb = param;
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
  if (localCODE_NAME_CNTracker) {
    namespace = "";
    writeStartElement(null, namespace, "CODE_NAME_CN", xmlWriter);

    if (localCODE_NAME_CN == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CODE_NAME_CN cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCODE_NAME_CN);
    }

    xmlWriter.writeEndElement();
  }
  if (localCODE_NAME_ENTracker) {
    namespace = "";
    writeStartElement(null, namespace, "CODE_NAME_EN", xmlWriter);

    if (localCODE_NAME_EN == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CODE_NAME_EN cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCODE_NAME_EN);
    }

    xmlWriter.writeEndElement();
  }
  if (localCODE_NAME_KOTracker) {
    namespace = "";
    writeStartElement(null, namespace, "CODE_NAME_KO", xmlWriter);

    if (localCODE_NAME_KO == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CODE_NAME_KO cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCODE_NAME_KO);
    }

    xmlWriter.writeEndElement();
  }
  if (localCODE_NUMBTracker) {
    namespace = "";
    writeStartElement(null, namespace, "CODE_NUMB", xmlWriter);

    if (localCODE_NUMB == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CODE_NUMB cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCODE_NUMB);
    }

    xmlWriter.writeEndElement();
  }
  if (localCODE_UPERTracker) {
    namespace = "";
    writeStartElement(null, namespace, "CODE_UPER", xmlWriter);

    if (localCODE_UPER == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CODE_UPER cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCODE_UPER);
    }

    xmlWriter.writeEndElement();
  }
  if (localCREATEDATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "CREATEDATE", xmlWriter);

    if (localCREATEDATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("CREATEDATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localCREATEDATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localDIVISIONTracker) {
    namespace = "";
    writeStartElement(null, namespace, "DIVISION", xmlWriter);

    if (localDIVISION == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("DIVISION cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localDIVISION);
    }

    xmlWriter.writeEndElement();
  }
  if (localUPDATEDATETracker) {
    namespace = "";
    writeStartElement(null, namespace, "UPDATEDATE", xmlWriter);

    if (localUPDATEDATE == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("UPDATEDATE cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localUPDATEDATE);
    }

    xmlWriter.writeEndElement();
  }
  if (localVALID_FLAGTracker) {
    namespace = "";
    writeStartElement(null, namespace, "VALID_FLAG", xmlWriter);

    if (localVALID_FLAG == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("VALID_FLAG cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localVALID_FLAG);
    }

    xmlWriter.writeEndElement();
  }
  if (localChiefNumbTracker) {
    namespace = "";
    writeStartElement(null, namespace, "chiefNumb", xmlWriter);

    if (localChiefNumb == null) {
      // write the nil attribute

      throw new org.apache.axis2.databinding.ADBException("chiefNumb cannot be null!!");

    } else {

      xmlWriter.writeCharacters(localChiefNumb);
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
            && new javax.xml.namespace.QName("", "CODE_NAME_CN").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CODE_NAME_CN" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCODE_NAME_CN(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "CODE_NAME_EN").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CODE_NAME_EN" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCODE_NAME_EN(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "CODE_NAME_KO").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CODE_NAME_KO" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCODE_NAME_KO(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "CODE_NUMB").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CODE_NUMB" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCODE_NUMB(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "CODE_UPER").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CODE_UPER" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCODE_UPER(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "CREATEDATE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "CREATEDATE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setCREATEDATE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "DIVISION").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "DIVISION" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setDIVISION(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "UPDATEDATE").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "UPDATEDATE" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setUPDATEDATE(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "VALID_FLAG").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "VALID_FLAG" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setVALID_FLAG(
              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

          reader.next();

        } // End of if for expected property start element
        else {

        }

        while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

        if (reader.isStartElement()
            && new javax.xml.namespace.QName("", "chiefNumb").equals(reader.getName())) {

          nillableValue =
              reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
          if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
            throw new org.apache.axis2.databinding.ADBException(
                "The element: " + "chiefNumb" + "  cannot be null");
          }

          String content = reader.getElementText();

          object.setChiefNumb(
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

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI) && "RETURN_type0".equals(typeName)) {

      return RETURN_type0.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI)
        && "DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response".equals(typeName)) {

      return DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response.Factory.parse(reader);
    }

    if ("http://www.lgchem.com/PI/LGC".equals(namespaceURI)
        && "DT_LGCY_LCHC_EA_DEPTBATCH_02_S".equals(typeName)) {

      return DT_LGCY_LCHC_EA_DEPTBATCH_02_S.Factory.parse(reader);
    }

    throw new org.apache.axis2.databinding.ADBException(
        "Unsupported type " + namespaceURI + " " + typeName);
  }
}

public static class DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
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
            namespacePrefix + ":DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response",
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
    public static DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response parse(
        javax.xml.stream.XMLStreamReader reader) throws Exception {
      DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response object =
          new DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response();

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

            if (!"DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response)
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

public static class DT_LGCY_LCHC_EA_DEPTBATCH_02_S
    implements org.apache.axis2.databinding.ADBBean {
  /* This type was generated from the piece of schema that had
  name = DT_LGCY_LCHC_EA_DEPTBATCH_02_S
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
            namespacePrefix + ":DT_LGCY_LCHC_EA_DEPTBATCH_02_S",
            xmlWriter);
      } else {
        writeAttribute(
            "xsi",
            "http://www.w3.org/2001/XMLSchema-instance",
            "type",
            "DT_LGCY_LCHC_EA_DEPTBATCH_02_S",
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
    public static DT_LGCY_LCHC_EA_DEPTBATCH_02_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      DT_LGCY_LCHC_EA_DEPTBATCH_02_S object = new DT_LGCY_LCHC_EA_DEPTBATCH_02_S();

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

            if (!"DT_LGCY_LCHC_EA_DEPTBATCH_02_S".equals(type)) {
              // find namespace for the prefix
              String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
              return (DT_LGCY_LCHC_EA_DEPTBATCH_02_S)
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

public static class MT_LGCY_LCHC_EA_DEPTBATCH_02_S
    implements org.apache.axis2.databinding.ADBBean {

  public static final javax.xml.namespace.QName MY_QNAME =
      new javax.xml.namespace.QName(
          "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S", "ns1");

  /** field for MT_LGCY_LCHC_EA_DEPTBATCH_02_S */
  protected DT_LGCY_LCHC_EA_DEPTBATCH_02_S localMT_LGCY_LCHC_EA_DEPTBATCH_02_S;

  /**
   * Auto generated getter method
   *
   * @return DT_LGCY_LCHC_EA_DEPTBATCH_02_S
   */
  public DT_LGCY_LCHC_EA_DEPTBATCH_02_S getMT_LGCY_LCHC_EA_DEPTBATCH_02_S() {
    return localMT_LGCY_LCHC_EA_DEPTBATCH_02_S;
  }

  /**
   * Auto generated setter method
   *
   * @param param MT_LGCY_LCHC_EA_DEPTBATCH_02_S
   */
  public void setMT_LGCY_LCHC_EA_DEPTBATCH_02_S(DT_LGCY_LCHC_EA_DEPTBATCH_02_S param) {

    this.localMT_LGCY_LCHC_EA_DEPTBATCH_02_S = param;
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

    if (localMT_LGCY_LCHC_EA_DEPTBATCH_02_S == null) {
      throw new org.apache.axis2.databinding.ADBException(
          "MT_LGCY_LCHC_EA_DEPTBATCH_02_S cannot be null!");
    }
    localMT_LGCY_LCHC_EA_DEPTBATCH_02_S.serialize(MY_QNAME, xmlWriter);
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
    public static MT_LGCY_LCHC_EA_DEPTBATCH_02_S parse(javax.xml.stream.XMLStreamReader reader)
        throws Exception {
      MT_LGCY_LCHC_EA_DEPTBATCH_02_S object = new MT_LGCY_LCHC_EA_DEPTBATCH_02_S();

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
                        "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S")
                    .equals(reader.getName())) {

              object.setMT_LGCY_LCHC_EA_DEPTBATCH_02_S(
                  DT_LGCY_LCHC_EA_DEPTBATCH_02_S.Factory.parse(reader));

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

public static class MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
      implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName(
            "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response", "ns1");

    /** field for MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response */
    protected DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response localMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response;

    /**
     * Auto generated getter method
     *
     * @return DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
     */
    public DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response getMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response() {
      return localMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response;
    }

    /**
     * Auto generated setter method
     *
     * @param param MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
     */
    public void setMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response(
        DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response param) {

      this.localMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response = param;
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

      if (localMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response == null) {
        throw new org.apache.axis2.databinding.ADBException(
            "MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response cannot be null!");
      }
      localMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response.serialize(MY_QNAME, xmlWriter);
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
      public static MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response parse(
          javax.xml.stream.XMLStreamReader reader) throws Exception {
        MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response object =
            new MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response();

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
                          "http://www.lgchem.com/PI/LGC", "MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response")
                      .equals(reader.getName())) {

                object.setMT_LGCY_LCHC_EA_DEPTBATCH_02_S_response(
                    DT_LGCY_LCHC_EA_DEPTBATCH_02_S_response.Factory.parse(reader));

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
      MT_LGCY_LCHC_EA_DEPTBATCH_02_S
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_LCHC_EA_DEPTBATCH_02_S
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.om.OMElement toOM(
      MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
          param,
      boolean optimizeContent)
      throws org.apache.axis2.AxisFault {

    try {
      return param.getOMElement(
          MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response
              .MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    } catch (org.apache.axis2.databinding.ADBException e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
      org.apache.axiom.soap.SOAPFactory factory,
      MT_LGCY_LCHC_EA_DEPTBATCH_02_S
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
                  MT_LGCY_LCHC_EA_DEPTBATCH_02_S
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

      if (MT_LGCY_LCHC_EA_DEPTBATCH_02_S.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_LCHC_EA_DEPTBATCH_02_S.Factory.parse(reader);
        reader.close();
        return result;
      }

      if (MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response.class.equals(type)) {

        javax.xml.stream.XMLStreamReader reader = param.getXMLStreamReaderWithoutCaching();
        Object result =
            MT_LGCY_LCHC_EA_DEPTBATCH_02_S_response.Factory.parse(reader);
        reader.close();
        return result;
      }

    } catch (Exception e) {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }
}