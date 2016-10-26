package com.unixera.thrift.custom;

import com.unixera.thrift.tutorial.MultiplicationService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by frost on 10/21/16.
 */
public class MultiplicationServer {
    public static MultiplicationHandler handler;
    public static MultiplicationService.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new MultiplicationHandler();
            processor = new MultiplicationService.Processor(handler);
            Runnable simple = () -> simple(processor);
            new Thread(simple).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void simple(MultiplicationService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting simple server.");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
