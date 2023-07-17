/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_03.java
Label Definition File: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic.label.xml
Template File: point-flaw-03.tmpl.java
*/
/*
* @description
* CWE: 329 Not using random IV with CBC Mode
* Sinks:
*    GoodSink: use random iv
*    BadSink : use hardcoded iv
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE329_Not_Using_Random_IV_with_CBC_Mode;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_03 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (5==5)
        {
            byte[] text ="asdf".getBytes();
            byte[] iv =
            {
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
            };
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();
            /* FLAW: hardcoded initialization vector used */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ips);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            byte[] text ="asdf".getBytes();

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, ips);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

        }
    }

    /* good1() changes 5==5 to 5!=5 */
    private void good1() throws Throwable
    {
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            byte[] text ="asdf".getBytes();
            byte[] iv =
            {
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
            };
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();
            /* FLAW: hardcoded initialization vector used */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ips);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
        }
        else {

            byte[] text ="asdf".getBytes();

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, ips);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(5==5)
        {
            byte[] text ="asdf".getBytes();
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ips);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            byte[] text ="asdf".getBytes();
            byte[] iv ={
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
            };

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();

            /* FLAW: hardcoded initialization vector used */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, ips);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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