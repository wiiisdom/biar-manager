package com.gbandsmith.biarmanager.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

public class InputStreamNoClose extends FilterInputStream {
    public InputStreamNoClose(InputStream in) {
      super(in);
    }
  
    @Override 
    public void close() {
      // do nothing
    }
  }