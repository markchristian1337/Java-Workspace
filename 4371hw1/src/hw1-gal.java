import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class hw1
{
    
     static final int alphaIndex = (int) 'A';
     
  
  static void Problem1() {
    String cipherText = "Z ENIZNMN GWBG KA. RO ZD B LNLENA RQ B DNHANG RATBOZYBGZRO HBIINK U.W.B.O.G.R.L., PWRDN TRBI ZD GRGBI PRAIK KRLZOBGZRO. GWNZA UIBO ZD GR BHXJZAN B DJUNAPNBURO BOK GR WRIK GWN PRAIK ABODRL. Z QNBA GWBG PN KR ORG WBMN LJHW GZLN JOGZI GWNV DJHHNNK. Z WBMN ZOGNAHNUGNK GPR NOHAVUGNK LNDDBTND (HZUWNA_B.GSG BOK HZUWNA_E.GSG) GWBG PNAN DNOG EV KA. RO GR WZD HRODUZABGRA, LA. EIRPQZNIK. Z LBOBTNK GR KZDHRMNA GWN UIBZOGNSG RQ GWN QZADG LNDDBTN:\n\"LA. EIRPQZNIK, LV BDDRHZBGN PZII KNIZMNA GWN UBVLNOG ONSG QAZKBV BG ORRO. Z NSUNHG VRJ GR KNIZMNA GWN UIBOD QRA GWN DJUNAPNBURO ZO NSHWBOTN. VRJ DWRJIK NOHAVUG GWNL PZGW ENOKNAHZUWNA GR UANMNOG BOVRON QARL DGNBIZOT GWNL. Z PZII DUNHZQV GWN IRHBGZRO QRA GWN NSHWBOTN ZO LV ONSG LNDDBTN. KR ORG KBAN GR QBZI LN.\"\nZ ENIZNMN GWBG GWN DNHROK LNDDBTN PBD NOHAVUGNK JDZOT GWN DBLN FNV, EJG GWN NOHAVUGZRO IRRFD UNAQNHG, BOK Z PBD ORG BEIN GR EANBF ZG.\nUINBDN DNOK ANZOQRAHNLNOGD ZLLNKZBGNIV! Z GAZNK GR BHG HBJGZRJDIV, EJG Z WBMN B QNNIZOT GWBG KA. RO'D WNOHWLNO BAN ROGR LN. Z KRO'G FORP WRP IROT Z WBMN ENQRAN GWNV KZDHRMNA LV ZKNOGZGV BOK LV DNHANG WZKZOT";
    // BEGIN SOLUTION
    
    // this is a a function to process the frequency of the characters
       String K_vals = Frequency(cipherText);
      
      
     System.out.println("this is the value of T:"+ K_vals.charAt(1)+ " and e respectively :"+ K_vals.charAt(0));
      
      //System.out.println("here is the value "+ alphaIndex);
      
      int pet = (int)('e' - alphaIndex) - (int)('t' - alphaIndex);  // this is: e=4 , t=19 
      int petInverse = 0;
      
      System.out.println("HERE IS PET: " + pet);
      
      Map<Integer, Integer> x_map = new HashMap<Integer, Integer>();
      
      int[] x = new int []         {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
      int[] x_inverse = new int [] {1, 9, 21, 15, 3, 19, 7, 23, 11, 5, 17, 25};
       
       
      int x_raised_m_one = Math.abs(4 - 19);    //
      int x_multiplicative_inverse_value = 0;
      
      for(int temp = 0; temp < x.length; temp++)
      {
    	  x_map.put(x[temp], x_inverse[temp]);
      }
      
    //   System.out.println("this is the value of X^-1 :"+x_raised_m_one   );
      
      if(pet < 0 )
    	  pet = pet % 26 + 26;
      else
    	  pet %= 26;
      
      int pet_inverse = 0;
      
      if(x_map.containsKey(pet)) pet_inverse = x_map.get(pet);
      
      int iCe = 78; //this is N
      int iCt = 71; // this is G
      int pE = 4;
      
      int k1 = (iCe - iCt) * petInverse % 26;
      int k2 = iCe - pE * k1 % 26;
      
      
    for (char cipherChar : cipherText.toCharArray())
      if (Character.isLetter(cipherChar)) { // only letters are encrypted, punctuation marks and whitespace are not
        // following line converts letters to numbers between 0 and 25
        int cipher = (int) cipherChar - alphaIndex;
        int plain = Math.floorMod((cipher - k2)*k1, 26); // decrypt
        // following line coverts numbers between 0 and 25 to letters
        char plainChar = (char) (plain + alphaIndex);
        System.out.print(plainChar);
      }
      else
        System.out.print(cipherChar);
    // END SOLUTION
    System.out.println();
  }
  
  
	public static void main(String[] args) {
 Problem1();
	}
	  public static String Frequency(String str) {

            Map<Character, Integer> hm = new HashMap<Character, Integer>();
            

           // TreeMap<Character, Integer> sorted = new TreeMap<>();

  
	  }

}