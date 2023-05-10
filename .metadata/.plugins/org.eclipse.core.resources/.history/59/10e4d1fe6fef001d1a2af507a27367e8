package keyExpansion;

public class KeyExpansionFunctions {

      /**
       * Print the values of words
       * Note: 1 word 32 bits are 4 bytes long that equals 8 letters hexadecimal
       * 
       * @param w bits of the word to print
       */
      public static void ShowWord(int w) {
            for (int i = 1; i <= 8; i++) {
                  int hexa = (w >> 32 - i * 4) & 0xF; // Move 4 bits forward and keep 1 letter hexadecimal
                  System.out.printf("%X", hexa);
            }
            System.out.printf("\n");
      }

      /**
       * Move the left round 1 byte
       * 
       * @param w
       * @return
       */
      public static int RotWord(int w) {
            int byte1 = (w >> 24) & 0xFF; // move 24 bits forward and get one byte
            int byte234 = w & 0xFFFFFF; // get three last bytes
            int rot = (byte234 << 8) | byte1; // three last bytes are moved 8 bits and connected with byte1

            return rot;
      }

      public static int SubWord(int w) {
            // S-board Array
            int S[] = {
                        0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
                        0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
                        0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
                        0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
                        0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
                        0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
                        0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
                        0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
                        0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
                        0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
                        0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
                        0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
                        0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
                        0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
                        0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
                        0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16
            };
            int kq = 0;
            // variables w has 4 bytes
            for (int i = 1; i <= 4; i++) {
                  int bytei = (w >> (32 - i * 8)) & 0xFF; // get byte i each time
                  int subB = S[bytei]; // get sub byte on S-board where index is byte i
                  kq = (kq << 8) | subB; // add sub byte to create new keyword
            }

            return kq;
      }

      public static int XorRcon(int w, int j) {
            int Rc[] = {
                        0x8d, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36, 0x6c, 0xd8, 0xab, 0x4d, 0x9a,
                        0x2f, 0x5e, 0xbc, 0x63, 0xc6, 0x97, 0x35, 0x6a, 0xd4, 0xb3, 0x7d, 0xfa, 0xef, 0xc5, 0x91, 0x39
            };
            int byte1 = (w >> 24) & 0xFF; // get byte 1
            int kqXor = (byte1 ^ Rc[j]) & 0xFF; // XOR byte1 with Rc[j], get 1 byte from result
            int byte234 = w & 0xFFFFFF; // get 3 last bytes form w
            int kq = (kqXor << 24) | byte234; // connect byte234 with byte1

            return kq;
      }

      // Step by step implement
      public static int G(int w, int j) {
            int rotW = RotWord(w);
            int subW = SubWord(rotW);
            int kq = XorRcon(subW, j);

            // System.out.printf("\n\tG(%X) = ", w);
            // ShowWord(kq);

            return kq;
      }

      public static int[] KeyExpansion(int[] key) {
            int[] w = new int[44];
            w[0] = key[0];
            w[1] = key[1];
            w[2] = key[2];
            w[3] = key[3];

            for (int i = 4; i < 44; i++) {
                  if (i % 4 == 0) {
                        w[i] = G(w[i - 1], i / 4) ^ w[i - 4];
                  } else {
                        w[i] = w[i - 1] ^ w[i - 4];
                  }
                  // System.out.printf("\n\tw[%d] = ", i);
                  // ShowWord(w[i]);
            }

            return w;
      }

      public static int[] AddRoundKey(int[] state, int[] key) {
            int[] kq = new int[4];
            kq[0] = state[0] ^ key[0];
            kq[1] = state[1] ^ key[1];
            kq[2] = state[2] ^ key[2];
            kq[3] = state[3] ^ key[3];
            // System.out.printf("\nAddRoundKey\n");
            // for (int i = 0; i < 4; i++) {
            // System.out.printf("\n\t");
            // ShowWord(kq[i]);
            // }

            return kq;
      }

      public static int[] SubBytes(int[] state) {
            int[] kq = new int[4];
            for (int i = 0; i < 4; i++) {
                  kq[i] = SubWord(state[i]);
            }
            // System.out.printf("\nSubBytes\n");
            // for (int i = 0; i < 4; i++) {
            // System.out.printf("\n\t");
            // ShowWord(kq[i]);
            // }

            return kq;
      }

      public static int[] ShiftRows(int[] state) {
            int[] kq = new int[4];

            for (int i = 0; i < 4; i++) {
                  int byte1 = state[i] & 0xFF000000;
                  int byte2 = state[(i + 1) % 4] & 0xFF0000;
                  int byte3 = state[(i + 2) % 4] & 0xFF00;
                  int byte4 = state[(i + 3) % 4] & 0xFF;

                  kq[i] = byte1 | byte2 | byte3 | byte4;
            }

            // System.out.printf("\nShiftRows\n");
            // for (int i = 0; i < 4; i++) {
            // System.out.printf("\n\t");
            // ShowWord(kq[i]);
            // }

            return kq;
      }

      public static int MultiplyTwo(int w) {
            int kq = w << 1;
            if (kq > 256) {
                  kq = kq ^ 0x11b;
            }
            kq = kq & 0xFF;
            return kq;
      }

      public static int MultiplyThree(int w) {
            int kq = w ^ MultiplyTwo(w);
            kq = kq & 0xFF;

            return kq;
      }

      public static int MultiplyColumn(int w) {
            int kq;
            int byte1 = (w >> 24) & 0xFF;
            int byte2 = (w >> 16) & 0xFF;
            int byte3 = (w >> 8) & 0xFF;
            int byte4 = w & 0xFF;

            int kq1 = MultiplyTwo(byte1) ^ MultiplyThree(byte2) ^ byte3 ^ byte4;
            int kq2 = byte1 ^ MultiplyTwo(byte2) ^ MultiplyThree(byte3) ^ byte4;
            int kq3 = byte1 ^ byte2 ^ MultiplyTwo(byte3) ^ MultiplyThree(byte4);
            int kq4 = MultiplyThree(byte1) ^ byte2 ^ byte3 ^ MultiplyTwo(byte4);

            kq = (kq1 << 24) | (kq2 << 16) | (kq3 << 8) | kq4;
            // System.out.printf("\n\t");
            // ShowWord(kq);

            return kq;
      }

      public static int[] MixColumns(int[] state) {
            int[] kq = new int[4];
            // System.out.printf("\nMixColumns\n");
            for (int i = 0; i < 4; i++) {
                  kq[i] = MultiplyColumn(state[i]);
            }

            return kq;
      }

}
