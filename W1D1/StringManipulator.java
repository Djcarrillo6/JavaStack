public class StringManipulator {

    public void testCompiler() {
    System.out.println("Compiler Connection Successful!");
    };



    public String trimAndConcat(String string1, String string2) {

        String trimedStr1 = string1.trim();
        String trimedStr2 = string2.trim();

        System.out.println(trimedStr1 + " " + trimedStr2);
        return trimedStr1 + trimedStr2;
    }


    public Integer getIndexOrNull(String str, char target) {
        int result = str.indexOf(target); 

        if(result == -1) {
            System.out.println("Null!");
            return null;
        }
        System.out.println("Search char:" + target + " was found at index: " + result);
        return result;
    }

    public String concatSubstring(String strToSplice, int start, int end, String strToJoin) {

        String cutOut = strToSplice.substring(start, end);
        String finalResult = cutOut + strToJoin;
        System.out.println(finalResult);
        return finalResult;

    }
}