import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'canReach' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER y1
     *  3. INTEGER x2
     *  4. INTEGER y2
     */

    static HashMap<axis, Integer> myHashMap = new HashMap();


    public static class axis {
        int x = 0;
        int y = 0;

        public axis(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            axis axis = (axis) o;
            return x == axis.x &&
                    y == axis.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void populateTreeMap(int x, int y, int x2, int y2) {
        if (x > 1000 || y > 1000 || x > x2 || y > y2) {
            return;
        }

        axis stayThere = new axis(x, y);

        if (myHashMap.get(stayThere) == null) {
            myHashMap.put(stayThere, 1);
        }

        populateTreeMap(x + y, y, x2, y2);
        populateTreeMap(x, x + y, x2, y2);


    }

    public static String canReach(int x1, int y1, int x2, int y2) {
        // Write your code here


        populateTreeMap(x1, y1, x2, y2);

        axis target = new axis(x2, y2);

        if (myHashMap.size() == 0) {
            return "No";
        }
        if (myHashMap.get(target) != null) {
            return "Yes";
        }

        return "No";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x1 = Integer.parseInt(bufferedReader.readLine().trim());

        int y1 = Integer.parseInt(bufferedReader.readLine().trim());

        int x2 = Integer.parseInt(bufferedReader.readLine().trim());

        int y2 = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.canReach(x1, y1, x2, y2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

