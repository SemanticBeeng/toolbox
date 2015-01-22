package eu.amidst.core.models;

import COM.hugin.HAPI.DefaultClassParseListener;
import COM.hugin.HAPI.Domain;
import COM.hugin.HAPI.ExceptionHugin;
import COM.hugin.HAPI.ParseListener;
import eu.amidst.core.huginlink.ConverterToAMIDST;
import eu.amidst.core.huginlink.ConverterToHugin;

import java.io.*;

/**
 * Created by afa on 11/12/14.
 */
public class BayesianNetworkLoader {


    //TODO Move this method to the module huginLink
    public static BayesianNetwork loadFromHugin(String file) throws ExceptionHugin {

        ParseListener parseListener = new DefaultClassParseListener();
        Domain huginBN = new Domain (file, parseListener);
        BayesianNetwork amidstBN = ConverterToAMIDST.convertToAmidst(huginBN);
        return amidstBN;
    }

    public static BayesianNetwork loadFromFile(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Object obj = ois.readObject();
        ois.close();
        return (BayesianNetwork)obj;
    }
}

