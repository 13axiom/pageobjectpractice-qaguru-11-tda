package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

 class TmpOne {

     String gender;

     public void tmpOne(String gender) {
         if (gender == "Male") {
             System.out.println("$(\"[for=gender-radio-1]\").click();");
         } else {
             if (gender == "Female") {
                 System.out.println("$(\"[for=gender-radio-2]\").click();");
             } else {
                 System.out.println("$(\"[for=gender-radio-3]\").click();");
             }
         }
     }
 }



class TmpOneTest {
    public static void main(String[] args) {
        TmpOne tmp1 = new TmpOne();
        tmp1.gender = "Female";
        System.out.println("gender: " + tmp1.gender);
        tmp1.tmpOne(tmp1.gender);
    }
}
