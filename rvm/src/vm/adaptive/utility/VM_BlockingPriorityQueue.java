/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_BlockingPriorityQueue.java,v 1.7 2004/12/15 22:38:12 augart-oss Exp $
package com.ibm.JikesRVM.adaptive;

import com.ibm.JikesRVM.VM;

/**
 * This class extends VM_PriorityQueue to safely
 * support multiple producers/consumers where 
 * the consumers are blocked if no objects are available
 * to consume.
 *
 * @author Dave Grove
 * @author Michael Hind
 */
class VM_BlockingPriorityQueue extends VM_PriorityQueue {

  /**
   * Used to notify consumers when about to wait and when notified
   * Default implementation does nothing, but can be overriden as needed by client.
   */
  public static class CallBack {
    void aboutToWait() {}
    void doneWaiting() {}
  }
  CallBack callback;

  /**
   * @param _cb the callback object
   */
  VM_BlockingPriorityQueue(CallBack _cb) {
    super();
    callback = _cb;
  }

  VM_BlockingPriorityQueue() {
    this(new CallBack());
  }

  /**
   * Insert the object passed with the priority value passed
   * 
   * Notify any sleeping consumer threads that an object
   * is available for consumption.
   *
   * @param _priority  the priority to 
   * @param _data the object to insert
   */
  synchronized final public void insert(double _priority, Object _data) { 
    super.insert(_priority, _data);
    try {
      notifyAll();
    } catch (Exception e) {
      // TODO: should we exit or something more dramatic?
      VM.sysWrite("Exception occurred while notifying that element was inserted!\n");
    }
  }

  /**
   * Remove and return the front (minimum) object.  If the queue is currently
   * empty, then block until an object is available to be dequeued.
   *
   * @return the front (minimum) object.
   */
  synchronized final public Object deleteMin() {
    // While the queue is empty, sleep until notified that an object has been enqueued.
    while (isEmpty()) {
      try {
        callback.aboutToWait();
        wait();
        callback.doneWaiting();
      } catch (InterruptedException e) {
        // TODO: should we exit or something more dramatic?
        VM.sysWrite("Interrupted Exception occurred!\n");
      }
    }

    // When we get to here, we know the queue is non-empty, so dequeue an object and return it.
    return super.deleteMin();
  }
}
