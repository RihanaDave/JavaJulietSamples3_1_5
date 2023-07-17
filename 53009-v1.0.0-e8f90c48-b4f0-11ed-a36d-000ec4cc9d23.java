/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_12.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-12.tmpl.java
*/
/*
* @description
* CWE: 321 Hard coded crypto key
* BadSource:  hardcoded key
* GoodSource: read key from console
* BadSink:  use data as a key
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_12 extends AbstractTestCase
{

    /* uses badsource and badsink - see how tools report flaws that don't always occur */
    public void bad() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: hardcoded key */
            data = "23 ~j;asn!@#/>as";
        }
        else {

            java.util.logging.Logger log_gsrc = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            data = ""; /* init data */

            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                /* FIX: read key from console */
                data = bufread2.readLine();
            }
            catch(IOException e)
            {
                log_gsrc.warning("Error reading from console");
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    log_gsrc.warning("Error closing bufread2");
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gsrc.warning("Error closing inread2");
                    }
                }
            }

        }

        String sToEncrypt = "Super secret Squirrel";
        byte[] bToEncrypt = sToEncrypt.getBytes();

        /* POTENTIAL FLAW: use the potentially-hardcoded key for encryption */
        SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);

        byte[] bCipherText = aesCipher.doFinal(bToEncrypt);

        IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */

    }

    /* goodG2B() - use goodsource and badsink by changing the "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_gsrc = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            data = ""; /* init data */
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                /* FIX: read key from console */
                data = bufread2.readLine();
            }
            catch(IOException e)
            {
                log_gsrc.warning("Error reading from console");
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    log_gsrc.warning("Error closing bufread2");
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gsrc.warning("Error closing inread2");
                    }
                }
            }
        }
        else {

            java.util.logging.Logger log_gsrc = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            data = ""; /* init data */

            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                /* FIX: read key from console */
                data = bufread2.readLine();
            }
            catch(IOException e)
            {
                log_gsrc.warning("Error reading from console");
            }
            finally
            {
                try
                {
                    if( bufread2 != null )
                    {
                        bufread2.close();
                    }
                }
                catch( IOException e )
                {
                    log_gsrc.warning("Error closing bufread2");
                }
                finally
                {
                    try
                    {
                        if( inread2 != null )
                        {
                            inread2.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gsrc.warning("Error closing inread2");
                    }
                }
            }

        }

        String sToEncrypt = "Super secret Squirrel";
        byte[] bToEncrypt = sToEncrypt.getBytes();

        /* POTENTIAL FLAW: use the potentially-hardcoded key for encryption */
        SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);

        byte[] bCipherText = aesCipher.doFinal(bToEncrypt);

        IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */

    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
