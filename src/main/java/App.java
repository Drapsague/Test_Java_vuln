import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;

class IO {
    public static Logger logger = Logger.getLogger(IO.class.getName());
}

public class App {
        
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
        
        public static void main(String[] args) {
            App app = new App();
            try {
                app.ident1();
            } catch (Throwable e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
}
