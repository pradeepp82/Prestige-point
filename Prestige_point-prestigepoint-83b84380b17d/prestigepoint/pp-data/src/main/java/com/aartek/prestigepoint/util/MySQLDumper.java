/*package com.aartek.prestigepoint.util;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
public class MySQLDumper {
  private static String ip="";
  @SuppressWarnings("unused")
   private static String port="";
  private static String database="";
  private static String user="";
  private static String pass="";
  private static String path="";
  
 private static String ip="localhost";
  @SuppressWarnings("unused")
  private static String port="3306";
  private static String database="aartek14_perstigepoint_dbpro1";
  private static String user="root";
  private static String pass="root";
  private static String path="";
  public static void export(){
  String dumpCommand = "mysqldump " + database + " -h " + ip + " -u " + user +" -p" + pass;
 String dumpCommand = " " + database + " -h " + ip + " -u " + user +" -p" + pass;
  Runtime rt = Runtime.getRuntime();
  File test=new File(path);
  PrintStream ps;
  try{
  Process child = rt.exec(dumpCommand);
  ps=new PrintStream(test);
  InputStream in = child.getInputStream();
  int ch;
  while ((ch = in.read()) != -1) {
  ps.write(ch);
  System.out.write(ch); //to view it by console
  }

  InputStream err = child.getErrorStream();
  while ((ch = err.read()) != -1) {
  System.out.write(ch);
  }
  }catch(Exception exc) {
  exc.printStackTrace();
  }
  }

  public static void main(String args[]){
  export();
  }
}
*/