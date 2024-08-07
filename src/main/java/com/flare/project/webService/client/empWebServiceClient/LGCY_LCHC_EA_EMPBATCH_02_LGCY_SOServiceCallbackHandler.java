/**
 * LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.flare.project.webService.client.empWebServiceClient;

/**
 * LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler Callback class, Users can extend this
 * class and implement their own receiveResult and receiveError methods.
 */
public abstract class LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler {

  protected Object clientData;

  /**
   * User can pass in any object that needs to be accessed once the NonBlocking Web service call is
   * finished and appropriate method of this CallBack is called.
   *
   * @param clientData Object mechanism by which the user can pass in user data that will be
   *     avilable at the time this callback is called.
   */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler(Object clientData) {
    this.clientData = clientData;
  }

  /** Please use this constructor if you don't want to set any clientData */
  public LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceCallbackHandler() {
    this.clientData = null;
  }

  /** Get the client data */
  public Object getClientData() {
    return clientData;
  }

  /**
   * auto generated Axis2 call back method for lGCY_LCHC_EA_EMPBATCH_02_LGCY_SO method override this
   * method for handling normal response from lGCY_LCHC_EA_EMPBATCH_02_LGCY_SO operation
   */
  public void receiveResultLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(
      LGCY_LCHC_EA_EMPBATCH_02_LGCY_SOServiceStub
              .MT_LGCY_LCHC_EA_EMPBATCH_02_S_response
          result) {}

  /**
   * auto generated Axis2 Error handler override this method for handling error response from
   * lGCY_LCHC_EA_EMPBATCH_02_LGCY_SO operation
   */
  public void receiveErrorLGCY_LCHC_EA_EMPBATCH_02_LGCY_SO(Exception e) {}
}