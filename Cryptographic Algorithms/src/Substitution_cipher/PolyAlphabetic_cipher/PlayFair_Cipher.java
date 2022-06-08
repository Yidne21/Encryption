package Substitution_cipher.PolyAlphabetic_cipher;

import java.util.ArrayList;

public class PlayFair_Cipher {

    private String keyword;
    private static int index;
    private ArrayList<ArrayList<String>> matrix;

    PlayFair_Cipher(String keyword) {
        index = 0;
        this.keyword = keyword;
        this.matrix = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.matrix.add(new ArrayList<>());
        }
        this.setList();
    }

    private void setList() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (((i == 0) || (i > 0)) && (this.keyword.length() > index)) {
                    if (this.matrix.get(i).contains(this.keyword.charAt(index))) {
                        if (index < this.keyword.length()) {
                            index++;
                            this.matrix.get(i).add("" + keyword.charAt(index));
                        }
                    } else {
                        if (index < this.keyword.length()) {
                            this.matrix.get(i).add("" + keyword.charAt(index));
                        }
                    }
                    // for inresing index
                    if (this.keyword.length() > index) {
                        index++;
                    } else {
                        index = 0;
                    }

                } else {
                    // for adding abcd
                    // series of characters
                    char temp_char = 'A';
                    int temp_int = (int) temp_char;
                    for (temp_int = 65; temp_int < 91; temp_int++) {

                        // for checking not to duplicate keyword loop

                        if (this.CheckKeywordChar((char) temp_int)) {

                        } else {
                            if ((char) temp_int == 'I') {
                                if (j < 5) {

                                } else if (j == 5) {
                                    i++;
                                    j = 0;
                                }
                                this.matrix.get(i).add("I/J");
                                j++;
                                temp_int++;
                            } else {
                                if (j < 5) {

                                } else if (j == 5) {
                                    i++;
                                    j = 0;
                                }

                                this.matrix.get(i).add("" + (char) temp_int);
                                j++;
                            }
                        }

                    }

                    break;
                }

            } // end row
        } // end column
    }

    public String Encryption(String txt) {
        ArrayList<String> temp_list = new ArrayList<>();
        temp_list = this.createBigrams(txt);
        String temp = "";
        for (int i = 0; i < temp_list.size(); i++) {
            String index1 = this.getIndex("" + temp_list.get(i).charAt(0));
            String index2 = this.getIndex("" + temp_list.get(i).charAt(1));
            if ((index1 == null) || (index2 == null)) {
                temp += "@";
            } else {
                String[] temp_index1 = index1.split("-");
                String[] temp_index2 = index2.split("-");
                // for same row
                if (temp_index1[0].equals(temp_index2[0])) {

                    temp += this.matrix.get(Integer.parseInt(temp_index1[0])).get(Integer.parseInt(temp_index1[1]) + 1)
                            + this.matrix.get(Integer.parseInt(temp_index2[0]))
                                    .get(Integer.parseInt(temp_index2[1]) + 1)
                            + " ";
                    // for same column
                } else if (temp_index1[1].equals(temp_index2[1])) {
                    temp += this.matrix.get(Integer.parseInt(temp_index1[0]) + 1).get(Integer.parseInt(temp_index1[1]))
                            + this.matrix.get(Integer.parseInt(temp_index2[0]) + 1)
                                    .get(Integer.parseInt(temp_index2[1]))
                            + " ";
                } // other cases
                else {
                    temp += this.matrix.get(Integer.parseInt(temp_index1[0])).get(Integer.parseInt(temp_index2[1]))
                            + this.matrix.get(Integer.parseInt(temp_index2[0])).get(Integer.parseInt(temp_index1[1]))
                            + " ";
                }

            }
        }
        temp = temp.replace("/J", "");

        return temp;
    }

    private ArrayList<String> createBigrams(String txt) {
        ArrayList<String> temp_list = new ArrayList<>();
        String text = txt.toUpperCase();
        if (text.length() % 2 != 0) {

        } else {
            text += "X";

        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                temp_list.add(text.charAt(i) + "" + text.charAt(i + 1));
                i++;
            } else if (text.charAt(i) == text.charAt(i + 1)) {
                char temp_ch = 'X';
                temp_list.add(text.charAt(i) + "" + temp_ch);

            }
        }
        return temp_list;
    }

    public String Decryption(String txt) {
        String temp = "";
        txt = txt.replace("I", "I/J");

        String[] temp_list = txt.split(" ");
        for (int i = 0; i < temp_list.length; i++) {
            String index1, index2;
            if ((temp_list[i].charAt(0) == 'I')) {
                index1 = this.getIndex("" + temp_list[i].charAt(0) + "/J");
                index2 = this.getIndex("" + temp_list[i].charAt(3));

            } else if ((temp_list[i].charAt(1) == 'I')) {
                index1 = this.getIndex("" + temp_list[i].charAt(0));
                index2 = this.getIndex("" + temp_list[i].charAt(1) + "/J");
            } else if ((temp_list[i].length() > 2) && (temp_list[i].charAt(3) == 'I')) {
                index1 = this.getIndex("" + temp_list[i].charAt(0));
                index2 = this.getIndex("" + temp_list[i].charAt(3) + "/J");
            } else {
                index1 = this.getIndex("" + temp_list[i].charAt(0));
                index2 = this.getIndex("" + temp_list[i].charAt(1));
            }
            if ((index1 == null) || (index2 == null)) {
                temp += "@";
            } else {
                String[] temp_index1 = index1.split("-");
                String[] temp_index2 = index2.split("-");
                // for same row
                if (temp_index1[0].equals(temp_index2[0])) {

                    temp += this.matrix.get(Integer.parseInt(temp_index1[0])).get(Integer.parseInt(temp_index1[1]) - 1)
                            + this.matrix.get(Integer.parseInt(temp_index2[0]))
                                    .get(Integer.parseInt(temp_index2[1]) - 1)
                            + " ";
                    // for same column
                } else if (temp_index1[1].equals(temp_index2[1])) {
                    temp += this.matrix.get(Integer.parseInt(temp_index1[0]) - 1).get(Integer.parseInt(temp_index1[1]))
                            + this.matrix.get(Integer.parseInt(temp_index2[0]) - 1)
                                    .get(Integer.parseInt(temp_index2[1]))
                            + " ";
                } // other cases
                else {
                    temp += this.matrix.get(Integer.parseInt(temp_index1[0])).get(Integer.parseInt(temp_index2[1]))
                            + this.matrix.get(Integer.parseInt(temp_index2[0])).get(Integer.parseInt(temp_index1[1]))
                            + " ";

                }

            }
        }

        temp = temp.replace("X", "");

        return temp;
    }

    private boolean CheckKeywordChar(char ch) {
        for (int i = 0; i < this.keyword.length(); i++) {
            if (this.keyword.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    private String getIndex(String str) {
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                if (this.matrix.get(i).get(j).equals(str)) {
                    return i + "-" + j;
                }
            }
        }
        return null;
    }

}