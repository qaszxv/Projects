/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlsb1;

/**
 *
 * @author hungle
 */
public class data {

    private int attrs;
    private int queries;
    private int sites;
    private int attrsKey[] = new int[10];
    public int aaMatrix[][] = new int[10][10];
    public int caMatrix[][] = new int[10][10];
    public int ca[] = new int[11];
    private int currOrder[] = new int[3];
    public String processing;

    public int useMatrix[][] = new int[7][10];
    public int accessMatrix[][] = new int[7][10];

    data() {
        attrs = 0;
        queries = 0;
        sites = 0;
        for (int i = 0; i < 10; i++) {
            attrsKey[i] = -1;
        }
        resetCA(); 
        processing = "*******TÍNH MA TRẬN ÁI LỰC AFFINITY MATRIX (AA)*******" + System.lineSeparator();
    }
    
    public void running() {
        resetCA(); 
        processing = "*******TÍNH MA TRẬN ÁI LỰC AFFINITY MATRIX (AA)*******" + System.lineSeparator();
        
        calculateAA(); 
        calculateCA(); 
    }
    
    private void resetCA() {
        for (int i = 0; i < 10; i++) {
            ca[i] = i + 1;
            for (int j = 0; j < 10; j++) {
                aaMatrix[i][j] = 0;
                caMatrix[i][j] = 0;
            }
        }
    }

    public void setAttrs(int value) {
        attrs = value;
    }

    public int getAttrs() {
        return attrs;
    }

    public void setQueries(int value) {
        queries = value;
    }

    public int getQueries() {
        return queries;
    }

    public void setSites(int value) {
        sites = value;
    }

    public int getSites() {
        return sites;
    }

    public void setAttrsKey(int i, int value) {
        if (value != 0) {
            attrsKey[i] = 1;
        } else {
            attrsKey[i] = 0;
        }
    }

    public int getAttrsKey(int i) {
        return attrsKey[i];
    }

    //Calculate the AA matrix
    private void calculateAA() {
        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                findQuery(i, j);
            }
        }
    }

    private void findQuery(int a1, int a2) {

        processing = processing + "A[" + a1 + "]A[" + a2 + "] = ";

        if (a1 == a2) {

            int currSum = 0;
            boolean checkFirst = true; 

            for (int j = 1; j <= queries; j++) {
                if (useMatrix[j][a1] == 1) {
                    currSum = currSum + sumAccessQuery(j, checkFirst);
                    checkFirst = false; 
                }
            }

            aaMatrix[a1][a1] = currSum;
        } else {

            int currSum = 0;
            boolean checkFirst = true; 
            
            for (int i = 1; i <= queries; i++) {
                //If it is in the diagonal
                if ((useMatrix[i][a1] == 1) && (useMatrix[i][a2] == 1)) {
                    //Do use this query => next calculate the AA matrix

                    //System.out.print("yes    ");
                    currSum = currSum + sumAccessQuery(i, checkFirst);
                    checkFirst = false;
                }
            }

            aaMatrix[a1][a2] = currSum;
        }
        
        if (aaMatrix[a1][a2] == 0) {
            processing = processing + aaMatrix[a1][a2] + System.lineSeparator();
        } else {
            processing = processing + " = " + aaMatrix[a1][a2] + System.lineSeparator();
        }
        
    }

    private int sumAccessQuery(int i, boolean checkFirst) {
        //Sum all the value of the access matrix 
        int sumAA = 0;
        for (int j = 1; j <= sites; j++) {
            sumAA = sumAA + accessMatrix[i][j];
            
            if (checkFirst == true) {
                processing = processing + accessMatrix[i][j];
                checkFirst = false; 
            } else {
                processing = processing + " + " + accessMatrix[i][j];
            }
        }

        return sumAA;
    }

    private void displayAA() {
        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                System.out.print(aaMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //******End of calculate the AA matrix
    //******Start of CA matrix
    private void calculateCA() {
        
        processing = processing + System.lineSeparator() + System.lineSeparator(); 
        processing = processing + "********TÍNH MA TRẬN GOM CỤM CLUSTER AFFINITY MATRIX (CA)********" + System.lineSeparator(); 
        processing = processing + "Cố định trước: A1, A2" + System.lineSeparator(); 
        
        int q = attrs; //number of attrs
        int w = 2; //number of arranged attrs

        displayAA();
        while (q - w > 0) {
            int k = w + 1;
            processing = processing + "Chọn vị trí đặt: A" + k + System.lineSeparator(); 
            
            int maxCont = 0;
            String choosen = null;

            for (int i = 0; i < k; i++) {

                if (i == 0) {

                    System.out.print("  Calculate: _; " + k + "; " + ca[i] + " = " + findCont("_", k, ca[i]));
                    processing = processing + "+ Cont(_; " + k + "; " + ca[i] + ") = " + findCont("_", k, ca[i]) + System.lineSeparator(); 
                    int cont = findCont("_", k, ca[i]);

                    //If cont > max -> update the order
                    if (cont >= maxCont) {
                        setCurrOrder(0, k, ca[i]);
                        maxCont = cont;
                        choosen = "=> Chọn phương án: + cont(_; " + k + "; " + ca[i] + ")"; 
                    }
                } else if (i == w) {
                    System.out.print("  Calculate: " + ca[i - 1] + "; " + k + "; _" + " = " + findCont(ca[i - 1], k, "_"));
                    processing = processing + "+ Cont(" + ca[i - 1] + "; " + k + "; _" + ") = " + findCont(ca[i - 1], k, "_") + System.lineSeparator(); 
                    int cont = findCont(ca[i - 1], k, "_");

                    //If cont > max -> update the order
                    if (cont >= maxCont) {
                        setCurrOrder(ca[i - 1], k, 0);
                        maxCont = cont;
                        choosen = "=> Chọn phương án: + cont("+ ca[i-1] +"; " + k + ";_)";
                    }
                } else {
                    System.out.print("  Calculate: " + ca[i - 1] + "; " + k + "; " + ca[i] + " = " + findCont(ca[i - 1], k, ca[i]));
                    processing = processing + "+ Cont(" + ca[i - 1] + "; " + k + "; " + ca[i] + ") = " + findCont(ca[i - 1], k, ca[i]) + System.lineSeparator(); 
                    int cont = findCont(ca[i - 1], k, ca[i]);

                    //If cont > max -> update the order
                    if (cont >= maxCont) {
                        setCurrOrder(ca[i - 1], k, ca[i]);
                        maxCont = cont;
                        choosen = "=> Chọn phương án: + cont("+ ca[i-1] +"; " + k + "; " + ca[i] + ")";
                    }
                }
            }

            processing = processing + choosen + System.lineSeparator(); 
            
            if (currOrder[0] == 0) {
                //Put the number to the first of the array ca[]
                for (int i = k; i > 0; i--) {
                    ca[i] = ca[i - 1];
                }
                ca[0] = k; //put the element to the first of ca[]
            } else if (currOrder[2] == 0) {
                //Put the number to the last of the array ca[]
                ca[k - 1] = k;
                System.out.println("abc" + k);
            } else {
                //Put the number before the value a[w] of the array ca[]
                //Moving array: 

                int pos = 0;
                for (int j = 0; j < 11; j++) {
                    if (ca[j] == currOrder[2]) {
                        pos = j;
                        break;
                    }
                }

                for (int i = k; i > pos; i--) {
                    ca[i] = ca[i - 1];
                }
                ca[pos] = k;
            }

            
            System.out.println();
            w++;
        }

        //Set the CA matrix
        setCAMatrix();
        displayCA();
    }

    private void setCAMatrix() {
        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                caMatrix[i][j] = aaMatrix[i][ca[j - 1]];
            }
        }
        int caMatrix2[][] = new int[10][10];

        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                caMatrix2[i][j] = caMatrix[i][j];
            }
        }

        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                caMatrix[j][i] = caMatrix2[ca[j - 1]][i];
            }
        }
    }

    private void displayCA() {
        for (int i = 1; i <= attrs; i++) {
            for (int j = 1; j <= attrs; j++) {
                System.out.print(caMatrix[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i < attrs; i++) {
            System.out.println(ca[i]);
        }
    }

    private void setCurrOrder(int x, int y, int z) {
        currOrder[0] = x;
        currOrder[1] = y;
        currOrder[2] = z;
    }

    private void displayCurr() {
        for (int i = 0; i < attrs; i++) {
            System.out.print(ca[i] + "  ");
        }
        System.out.println();
    }

    //Calculate the bond
    /*public int findBond(int a1, int a2) {

        int bond = 0;

        if ((a1 < 1) || (a2 > attrs)) {
            bond = 0;
        } else {
            for (int i = 1; i <= attrs; i++) {
                bond = bond + aaMatrix[i][a1] * aaMatrix[i][a2];
            }
        }
        return bond;
    }*/
    private int findBond(int a1, int a2) {

        int bond = 0;

        if ((a1 < 1) || (a2 > 4)) {
            bond = 0;
        } else {
            for (int i = 1; i < 5; i++) {
                bond = bond + aaMatrix[i][a1] * aaMatrix[i][a2];
            }
        }
        return bond;
    }

    //Calculate the contribution
    private int findCont(int a1, int a2, int a3) {
        int cont = 0;

        cont = 2 * findBond(a1, a2) + 2 * findBond(a2, a3) - 2 * findBond(a1, a3);

        return cont;
    }

    private int findCont(String a1, int a2, int a3) {
        int cont = 0;

        cont = 2 * findBond(a2, a3);

        return cont;
    }

    private int findCont(int a1, int a2, String a3) {
        int cont = 0;

        cont = 2 * findBond(a1, a2);

        return cont;
    }

}