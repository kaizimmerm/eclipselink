/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the License).  You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * Header Notice in each file and include the License file 
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.  
 * If applicable, add the following below the CDDL Header, 
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information: 
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */

package javax.jms;

/**
 * <P> This exception is thrown when an 
 *     operation is invalid because a transaction is in progress. 
 *     For instance, an attempt to call <CODE>Session.commit</CODE> when a 
 *     session is part of a distributed transaction should throw a 
 *     <CODE>TransactionInProgressException</CODE>.
 *
 * @version     26 August 1998
 * @author      Rahul Sharma
 **/

public class TransactionInProgressException extends JMSException {

  /** Constructs a <CODE>TransactionInProgressException</CODE> with the 
   *  specified reason and error code.
   *
   *  @param  reason        a description of the exception
   *  @param  errorCode     a string specifying the vendor-specific
   *                        error code
   *                        
   **/
  public 
  TransactionInProgressException(String reason, String errorCode) {
    super(reason, errorCode);
  }

  /** Constructs a <CODE>TransactionInProgressException</CODE> with the 
   *  specified reason. The error code defaults to null.
   *
   *  @param  reason        a description of the exception
   **/
  public 
  TransactionInProgressException(String reason) {
    super(reason);
  }

}
