package com.unixera.thrift.custom;

import com.unixera.thrift.tutorial.MultiplicationService;
import org.apache.thrift.TException;

/**
 * Created by frost on 10/21/16.
 */
public class MultiplicationHandler implements MultiplicationService.Iface {
    @Override
    public int multiply(int n1, int n2) throws TException {
        System.out.println("Multiply(" + n1 + "," + n2 + ")");
        return n1 * n2;
    }
}
