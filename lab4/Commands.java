package com.company;
import java.io.IOException;

public interface Commands {
   void  add(Graph graph) ;
   void list() ;
   void open(String path) throws IOException;
   void save(String path) throws IOException;
   void load(String nume) throws IOException;
}
