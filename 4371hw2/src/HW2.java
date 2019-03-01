package hw2;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
// BEGIN SOLUTION
// please import only standard libraries and make sure that your code compiles and runs
//without unhandled exceptions
// END SOLUTION
public class HW2 {

  static void P1() throws Exception {
    byte[] cipherBMP = Files.readAllBytes(Paths.get("cipher1.bmp"));
// BEGIN SOLUTION
    byte[] key = new byte[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
    byte[] iv = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    SecretKeySpec skey = new SecretKeySpec(key,"AES");
    IvParameterSpec ivspec=new IvParameterSpec(iv);

    Cipher ci = Cipher.getInstance("AES/CFB/Nopadding");
    ci.init(Cipher.DECRYPT_MODE,skey,ivspec);
    cipherBMP=ci.doFinal(cipherBMP);


    byte[] plainBMP = cipherBMP;
// END SOLUTION
    Files.write(Paths.get("plain1.bmp"), plainBMP);

  }

  static void P2() throws Exception {
// BEGIN SOLUTION
    Scanner scanner = new Scanner(new File("msg1.txt"));
    while (scanner.hasNextLine()) {
      String message = scanner.nextLine();
      MessageDigest messageDigest=MessageDigest.getInstance("MD5");
      messageDigest.update(message.getBytes());
      byte[] a=messageDigest.digest();
      if(a[0]==70 && a[1]==124 && a[2]==72 ){
        System.out.println(message);
      }

    }
    scanner.close();
// END SOLUTION
  }

  static void P3() throws Exception {
    byte[] cipherBMP = Files.readAllBytes(Paths.get("cipher3.bmp"));
// BEGIN SOLUTION
    byte[] a=  Files.readAllBytes(Paths.get("plain1.bmp"));
    for(int i=0 ; i<100 ;i++){
      cipherBMP[i]=a[i];
    }
    byte[] modifiedBMP = cipherBMP;
// END SOLUTION
    Files.write(Paths.get("cipher3_modified.bmp"), modifiedBMP);
  }


  static void P4() throws Exception {
    byte[] cipherPNG = Files.readAllBytes(Paths.get("cipher4.png"));
// BEGIN SOLUTION
    byte[] key = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    byte[] iv = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    byte[] plainPNG = new byte[]{};
    byte y,m,d;
    boolean flag=true;
    for( y= 0 ; y<100 && flag ; y++){
      key[0]=y;
      for( m= 1 ; m<=12 && flag; m++){
        key[1]=m;
        for( d=1 ; d<=31 && flag ; d++){
          key[2]=d;
          SecretKeySpec skey = new SecretKeySpec(key,"AES");
          IvParameterSpec ivspec=new IvParameterSpec(iv);

          Cipher ci = Cipher.getInstance("AES/CBC/Nopadding");
          ci.init(Cipher.DECRYPT_MODE,skey,ivspec);
          plainPNG=ci.doFinal(cipherPNG);

          if(plainPNG[1]==80 && plainPNG[2]==78 && plainPNG[3]==71){
            flag=false;
          }
        }
      }
    }
// END SOLUTION
    Files.write(Paths.get("plain4.png"), plainPNG);
  }

  public static void main(String[]args){
    try {
      P1();
      P2();
      P3();
      P4();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
