package algorithm;

import java.util.Arrays;

import keyExpansion.KeyExpansionFunctions;

public class AesEncryptFunctions {

      public static void ShowMatrix(int[] w) {
            for (int i = 0; i < w.length; i++) {
                  System.out.printf("\n\t");
                  KeyExpansionFunctions.ShowWord(w[i]);
            }
      }

      public static int[] AesEncrypt(int[] state, int[] key) {
            int[] w = KeyExpansionFunctions.KeyExpansion(key);
            state = KeyExpansionFunctions.AddRoundKey(state, Arrays.copyOfRange(w, 0, 4));

            for (int i = 1; i <= 9; i++) {
                  state = KeyExpansionFunctions.SubBytes(state);
                  state = KeyExpansionFunctions.ShiftRows(state);
                  state = KeyExpansionFunctions.MixColumns(state);
                  state = KeyExpansionFunctions.AddRoundKey(state, Arrays.copyOfRange(w, i * 4, i * 4 + 4));

                  // System.out.printf("\nRound %d: \n", i);
                  // ShowMatrix(state);
            }

            // Round 10
            state = KeyExpansionFunctions.SubBytes(state);
            state = KeyExpansionFunctions.ShiftRows(state);
            state = KeyExpansionFunctions.AddRoundKey(state, Arrays.copyOfRange(w, 10 * 4, 10 * 4 + 4));

            // System.out.printf("\nRound 10: \n");
            // ShowMatrix(state);
            int[] kq = new int[4];
            kq = state;
            return kq;
      }

      public static void main(String[] args) {
            int w0 = 0x2b7e1516, w1 = 0x28aed2a6, w2 = 0xabf71588, w3 = 0x09cf4f3c;
            int key[] = { w0, w1, w2, w3 };
            int state[] = new int[4];
            state[0] = 0x3243f6a8;
            state[1] = 0x885a308d;
            state[2] = 0x313198a2;
            state[3] = 0xe0370734;

            int[] C = AesEncrypt(state, key);

            System.out.printf("\nBan ma: \n");
            ShowMatrix(C);
      }

}
