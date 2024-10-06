package October;

import java.util.Arrays;

/*
You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.

Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.

For example,

s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.



Example 1:

Input: sentence1 = "My name is Haley", sentence2 = "My Haley"

Output: true

Explanation:

sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

Example 2:

Input: sentence1 = "of", sentence2 = "A lot of words"

Output: false

Explanation:

No single sentence can be inserted inside one of the sentences to make it equal to the other.

Example 3:

Input: sentence1 = "Eating right now", sentence2 = "Eating"

Output: true

Explanation:

sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.



Constraints:

1 <= sentence1.length, sentence2.length <= 100
sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
The words in sentence1 and sentence2 are separated by a single space.
 */
public class Sentence_Similarity_III {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        System.out.println("s1: " + sentence1 + "\ts2: " + sentence2);
        String[] sentence1Words = sentence1.split(" ");
        String[] sentence2Words = sentence2.split(" ");

        System.out.println(Arrays.toString(sentence1Words) + "\t" + Arrays.toString(sentence2Words));

        int l1 = sentence1Words.length;
        int l2 = sentence2Words.length;

        int left = 0;


        int right1 = sentence1Words.length - 1;
        int right2 = sentence2Words.length - 1;


        while (left < l1 && left < l2 && sentence1Words[left].equals(sentence2Words[left])) {
            left++;
        }

        while (right1 >= left && right2 >= left && sentence1Words[right1].equals(sentence2Words[right2])) {
            right1--;
            right2--;
        }

        System.out.println("left: " + left + "\tright1: " + right1 + "\tright2: " + right2);

        return left > right1 || left > right2;

    }

    public void driver() {
        String[] strings = {"A a a a A A A", "A A a a a", "A B C D B B", "A B B", "z z z z", "zz z", "A a a", "Aa a", "hello racecar", "hello racecar acecar", "A B C D B B", "A B B", "hello", "hr uyello", "DN PD", "D", "A A AAa", "A AAa"};
        for (int i = 0; i < strings.length; i += 2) {
            System.out.println("Result: " + areSentencesSimilar(strings[i], strings[i + 1]));
        }
    }

}
