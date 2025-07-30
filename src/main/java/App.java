import juliet.support.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang3.StringEscapeUtils;

public class IO {
    public static final Logger logger = Logger.getLogger(IO.class.getName());

    public static void writeLine(String message) {
        System.out.println(message);
    }
}

public class App {
        
        private boolean privateReturnsFalse() {
            return false;
        }

        private boolean privateReturnsTrue() {
            return true;
        }
        
        public void ident1() throws Throwable
        {
            String data;
            if (privateReturnsTrue())
            {
                data = ""; 
                {
                    File file = new File("data.txt");
                    FileInputStream streamFileInput = null;
                    InputStreamReader readerInputStream = null;
                    BufferedReader readerBuffered = null;
                    try
                    {
                    
                        streamFileInput = new FileInputStream(file);
                        readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                        readerBuffered = new BufferedReader(readerInputStream);
                    
                    
                        data = readerBuffered.readLine();
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                    }
                    finally
                    {
                    
                        try
                        {
                            if (readerBuffered != null)
                            {
                                readerBuffered.close();
                            }
                        }
                        catch (IOException exceptIO)
                        {
                            IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                        }

                        try
                        {
                            if (readerInputStream != null)
                            {
                                readerInputStream.close();
                            }
                        }
                        catch (IOException exceptIO)
                        {
                            IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                        }

                        try
                        {
                            if (streamFileInput != null)
                            {
                                streamFileInput.close();
                            }
                        }
                        catch (IOException exceptIO)
                        {
                            IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                        }
                    }
                }
            }
            else
            {
            
                data = null;
            }

            if (privateReturnsTrue())
            {
                String xmlFile = null;
                if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
                {
                
                    xmlFile = "\\src\\testcases\\ident2\\ident3.xml";
                }
                else
                {
                
                    xmlFile = "./src/testcases/ident2/ident3.xml";
                }
                if (data != null)
                {
                
                    String [] tokens = data.split("\\|\\|");
                    if (tokens.length < 2)
                    {
                        return;
                    }
                    String username = tokens[0];
                    String password = tokens[1];
                
                    XPath xPath = XPathFactory.newInstance().newXPath();
                    InputSource inputXml = new InputSource(xmlFile);
                
                
                    String query = "//users/user[login/text()='" + username + 
                                   "' and pass/text()='" + password + "']" +
                                   "/secret/text()";
                    xPath.evaluate(query, inputXml, XPathConstants.STRING);
                }
            }
        }

        private void ident() throws Throwable
      {
          String data;
          if (privateReturnsTrue())
          {
              data = "";
              {
                  File file = new File("data.txt");
                  FileInputStream streamFileInput = null;
                  InputStreamReader readerInputStream = null;
                  BufferedReader readerBuffered = null;
                  try
                  {
                      streamFileInput = new FileInputStream(file);
                      readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                      readerBuffered = new BufferedReader(readerInputStream);
                    
                      data = readerBuffered.readLine();
                  }
                  catch (IOException exceptIO)
                  {
                      IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                  }
                  finally
                  {
                      
                      try
                      {
                          if (readerBuffered != null)
                          {
                              readerBuffered.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                      }
  
                      try
                      {
                          if (readerInputStream != null)
                          {
                              readerInputStream.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                      }
  
                      try
                      {
                          if (streamFileInput != null)
                          {
                              streamFileInput.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                      }
                  }
              }
          }
          else
          {
             
        
              data = null;
          }
  
          if (privateReturnsFalse())
          {
              
              IO.writeLine("Benign, fixed string");
          }
          else
          {
  
              String xmlFile = null;
              if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
              {
          
                  xmlFile = "\\src\\testcases\\ident2\\ident3.xml";
              }
              else
              {
                  
                  xmlFile = "./src/testcases/ident2/ident3.xml";
              }
  
              if (data != null)
              {
                 
                  String [] tokens = data.split("\\|\\|");
                  if( tokens.length < 2 )
                  {
                      return;
                  }
                  String username = StringEscapeUtils.escapeXml(tokens[0]);
                  String password = StringEscapeUtils.escapeXml(tokens[1]);
        
                  XPath xPath = XPathFactory.newInstance().newXPath();
                  InputSource inputXml = new InputSource(xmlFile);
                  String query = "//users/user[name/text()='" + username +
                                 "' and pass/text()='" + password + "']" +
                                 "/secret/text()";
                  String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
              }
  
          }
      }
  
    
      private void ident2() throws Throwable
      {
          String data;
          if (privateReturnsTrue())
          {
              data = ""; 
              {
                  File file = new File("data.txt");
                  FileInputStream streamFileInput = null;
                  InputStreamReader readerInputStream = null;
                  BufferedReader readerBuffered = null;
                  try
                  {
                     
                      streamFileInput = new FileInputStream(file);
                      readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                      readerBuffered = new BufferedReader(readerInputStream);
                    
                      data = readerBuffered.readLine();
                  }
                  catch (IOException exceptIO)
                  {
                      IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                  }
                  finally
                  {
                      
                      try
                      {
                          if (readerBuffered != null)
                          {
                              readerBuffered.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                      }
  
                      try
                      {
                          if (readerInputStream != null)
                          {
                              readerInputStream.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                      }
  
                      try
                      {
                          if (streamFileInput != null)
                          {
                              streamFileInput.close();
                          }
                      }
                      catch (IOException exceptIO)
                      {
                          IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                      }
                  }
              }
          }
          else
          {
             
              data = null;
          }
  
          if (privateReturnsTrue())
          {
              String xmlFile = null;
              if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
              {
                
                 xmlFile = "\\src\\testcases\\ident2\\ident3.xml";
              }
              else
              {
                  xmlFile = "./src/testcases/ident2/ident3.xml";
              }
              if (data != null)
              {
                  
                  String [] tokens = data.split("\\|\\|");
                  if( tokens.length < 2 )
                  {
                      return;
                  }
                 
                  String username = StringEscapeUtils.escapeXml(tokens[0]);
                  String password = StringEscapeUtils.escapeXml(tokens[1]);
                  
                  XPath xPath = XPathFactory.newInstance().newXPath();
                  InputSource inputXml = new InputSource(xmlFile);
                  String query = "//users/user[name/text()='" + username +
                                 "' and pass/text()='" + password + "']" +
                                 "/secret/text()";
                  String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
              }
          }
      }

    
        
        public static void main(String[] args) {
            App app = new App();
            try {
                app.ident1();
                app.ident2();
                app.ident();

            } catch (Throwable e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
}
