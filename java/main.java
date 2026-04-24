import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        GetData getData=new GetData();
        String keyword="";
        while(keyword!="exit") {
            System.out.println("please input the keyword");
            keyword=scanner.nextLine();
            int kL = keyword.length();
            int stream=kL;
            if(kL>=3){
             stream=3;
            }
            String lastWord = keyword.substring(kL - 1);
            ResultSet lW = getData.getWordsWithFirstWord(lastWord);
            lW.next();
            String lPN = lW.getString("phoneticNotation");
            String sLPN = "";
            String tLPN = "";
            int length = lPN.length();
            if (lPN.endsWith("£½") || lPN.endsWith("£¾") || lPN.endsWith("£¿")) {
                lPN = lPN.substring(length - 2, length - 1);
            } else {
                lPN = lPN.substring(length - 1);
            }
            ResultSet rs = getData.getRhythm(lPN);
            if (stream > 1) {
                String secondLastWord = keyword.substring(kL - 2, kL - 1);
                ResultSet sLW = getData.getWordsWithFirstWord(secondLastWord);
                sLW.next();
                sLPN = sLW.getString("phoneticNotation");
                int sLength = sLPN.length();
                if (sLPN.endsWith("£½") || sLPN.endsWith("£¾") || sLPN.endsWith("£¿")) {
                    sLPN = sLPN.substring(sLength - 2, sLength - 1);
                } else {
                    sLPN = sLPN.substring(sLength - 1);
                }
                if (stream == 3) {
                    String thirdLastWord = keyword.substring(kL - 3, kL - 2);
                    ResultSet tLW = getData.getWordsWithFirstWord(thirdLastWord);
                    tLW.next();
                    tLPN = tLW.getString("phoneticNotation");
                    int tLength = tLPN.length();
                    if (tLPN.endsWith("£½") || tLPN.endsWith("£¾") || tLPN.endsWith("£¿")) {
                        tLPN = tLPN.substring(tLength - 2, tLength - 1);
                    } else {
                        tLPN = tLPN.substring(tLength - 1);
                    }
                }
            }
            switch (stream) {
                case 1:
                    System.err.println("³æÀ£");
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                    }
                case 2
                        :
                    System.err.println("ÂùÀ£");
                    while (rs.next()) {
                        String[] rsS = rs.getString("phoneticNotation").split("¡@");
                        int rsSize = rsS.length;
                        String rsSLPN = "";
                        if (rsSize >= 2) {
                            rsSLPN = rsS[rsSize - 2];
                        }
                        //System.out.println(rsSLPN);
                        if (rsSLPN.endsWith(sLPN)) {
                            System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                        } else if (rsSLPN.length() >= 2 && (rsSLPN.endsWith("£½") || rsSLPN.endsWith("£¾") || rsSLPN.endsWith("£¿"))) {
                            if (rsSLPN.substring(rsSLPN.length() - 2, rsSLPN.length() - 1).equals(sLPN)) {
                                System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                            }
                        }
                    }
                    rs = getData.getRhythm(lPN);
                    System.err.println("³æÀ£");
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                    }
                case 3:
                    System.err.println("¤TÀ£");
                    while (rs.next()) {
                        String[] rsS = rs.getString("phoneticNotation").split("¡@");
                        int rsSize = rsS.length;
                        String rsSLPN = "";
                        String rsTLPN = "";
                        if (rsSize >= 2) {
                            rsSLPN = rsS[rsSize - 2];
                        }
                        if (rsSize >= 3) {
                            rsTLPN = rsS[rsSize - 3];
                        }
                        //System.out.println(rsSLPN);
                        if (rsSLPN.endsWith(sLPN)) {
                            if (rsTLPN.endsWith(tLPN)) {
                                System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                            } else if (rsTLPN.length() >= 3 && (rsTLPN.endsWith("£½") || rsTLPN.endsWith("£¾") || rsTLPN.endsWith("£¿"))) {
                                if (rsTLPN.substring(rsTLPN.length() - 2, rsTLPN.length() - 1).equals(tLPN)) {
                                    System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                                }
                            }
                        } else if (rsSLPN.length() >= 2 && (rsSLPN.endsWith("£½") || rsSLPN.endsWith("£¾") || rsSLPN.endsWith("£¿"))) {
                            if (rsSLPN.substring(rsSLPN.length() - 2, rsSLPN.length() - 1).equals(sLPN)) {
                                if (rsTLPN.endsWith(tLPN)) {
                                    System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                                } else if (rsTLPN.length() >= 3 && (rsTLPN.endsWith("£½") || rsTLPN.endsWith("£¾") || rsTLPN.endsWith("£¿"))) {
                                    if (rsTLPN.substring(rsTLPN.length() - 2, rsTLPN.length() - 1).equals(tLPN)) {
                                        System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                                    }
                                }
                            }
                        }
                    }
                    rs = getData.getRhythm(lPN);
                    System.err.println("ÂùÀ£");
                    while (rs.next()) {
                        String[] rsS = rs.getString("phoneticNotation").split("¡@");
                        int rsSize = rsS.length;
                        String rsSLPN = "";
                        if (rsSize >= 2) {
                            rsSLPN = rsS[rsSize - 2];
                        }
                        //System.out.println(rsSLPN);
                        if (rsSLPN.endsWith(sLPN)) {
                            System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                        } else if (rsSLPN.length() >= 2 && (rsSLPN.endsWith("£½") || rsSLPN.endsWith("£¾") || rsSLPN.endsWith("£¿"))) {
                            if (rsSLPN.substring(rsSLPN.length() - 2, rsSLPN.length() - 1).equals(sLPN)) {
                                System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                            }
                        }
                    }
                    rs = getData.getRhythm(lPN);
                    System.err.println("³æÀ£");
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
                    }
            }
        }
        getData.close();
    }
    public static ResultSet sortStream(ResultSet rs,String rhy,int stream) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getString("phoneticNotation"));
        }
        if(stream>1){

            rs=sortStream(rs,rhy,stream-1);
        }
        return rs;

    }
}
