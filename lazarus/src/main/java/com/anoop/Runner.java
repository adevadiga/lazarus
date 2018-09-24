package com.anoop;

import com.anoop.arraysandstrings.CheckPermutation;
import com.anoop.arraysandstrings.PalindromePermutation;
import com.anoop.arraysandstrings.StringCompression;
import com.anoop.arraysandstrings.StringRotation;
import com.anoop.arraysandstrings.URLify;
import com.anoop.arraysandstrings.UniqueCharInString;

public class Runner {
    public static void main(String[] args) {

        StringRotation.isSubString("anoop", "no");
        StringRotation.isSubString("anoop", "op");
        StringRotation.isSubString("anoop", "an");
        StringRotation.isSubString("anoop", "ap");
        StringRotation.isSubString("anoop", "n");

        // StringCompression.compress("aabcccccaaa");
        // StringCompression.compress("anoop");
        // boolean r = UniqueCharInString.isUnique_Take3("anop");

        /*
         * boolean r = CheckPermutation.isPermutation("anoop", "opona");
         * System.out.println(r);
         * 
         * boolean r1 = CheckPermutation.isPermutation("abcd", "bcea");
         * System.out.println(r1);
         * 
         * String url = "Mr John Smith    "; System.out.println(URLify.replaceChars(url,
         * 13));
         * 
         * boolean k = PalindromePermutation.check("Tact Coa"); System.out.println(k);
         */
    }
}