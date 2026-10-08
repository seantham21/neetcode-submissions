class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, int[]> hor = new HashMap<>();
        HashMap<Integer, int[]> ver = new HashMap<>();
        HashMap<Integer, int[]> sub = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            hor.put(i, new int[9]);
            ver.put(i, new int[9]);
            sub.put(i, new int[9]);
        }

        for (int k = 0; k < 9; k++) {
            for (int j = 0; j < 9; j++) {
                if (board[k][j] == '.'){
                    continue;
                }

                int curr = board[k][j] - '0';
                if (hor.get(k)[curr - 1] == 1) { 
                    return false; 
                } else {
                    hor.get(k)[curr - 1] = 1;
                }

                if (ver.get(j)[curr - 1] != 0) { 
                    return false;
                } else {
                    ver.get(j)[curr - 1] = 1;
                }

                // 11, 12, 13, 21, 22, 23, 31, 32, 33
                // 14, 15, 16,
                int currSub = 0;
                if (k < 3) {
                    if (j < 3) { currSub = 0; }
                    else if (j < 6) { currSub = 1; }
                    else { currSub = 2; }
                }
                else if (k < 6) {
                    if (j < 3) { currSub = 3; }
                    else if (j < 6) { currSub = 4; }
                    else { currSub = 5; }
                }
                else {
                    if (j < 3) { currSub = 6; }
                    else if (j < 6) { currSub = 7; }
                    else { currSub = 8; }
                }               

                if (sub.get(currSub)[curr - 1] != 0) { 
                    return false;
                } else {
                    sub.get(currSub)[curr - 1] = 1;
                }
            }
        }

        return true;
    }
}
