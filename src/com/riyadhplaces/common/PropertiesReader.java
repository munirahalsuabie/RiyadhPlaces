/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riyadhplaces.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesReader {

    private String fileName;
    private Properties props = new Properties();

    public PropertiesReader(String fileName) {
        this.fileName = fileName;
        load();
    }

    private final Properties load() {
        try ( InputStream input = new FileInputStream(fileName)) {
            props.load(input);
            return props;
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public String get(String key){
        
      return props.getProperty(key);
        
    }

}
