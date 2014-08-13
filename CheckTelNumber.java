package myProg;

public class CheckTelNumber {

    public static boolean checkTelNumber(String telNumber)
    {
        if(telNumber.matches("^\\+\\d{12}")) {
            return true;
        } else if(telNumber.matches("^\\+\\d*\\(\\d{3}\\)\\d+") && telNumber.matches(".{15}")) {
            return true;
        } else if (telNumber.matches("^\\+\\d*\\(\\d{3}\\)\\d*\\-\\d+") &&  telNumber.matches(".{16}")) {
            return true;
        } else if (telNumber.matches("^\\+\\d*\\(\\d{3}\\)\\d*\\-\\d+\\-\\d+") &&  telNumber.matches(".{17}")) {
            return true;
        } else if (telNumber.matches("^\\+\\d*\\-\\d+") && telNumber.matches(".{14}")) {
            return true;
        } else if (telNumber.matches("^\\+\\d*\\-\\d+") && telNumber.matches(".{14}")) {
            return true;
        } else if (telNumber.matches("^\\+\\d*\\-\\d+\\d+\\-\\d+") && telNumber.matches(".{15}")) {
            return true;
        }


        if (telNumber.matches("^\\d{10}")) {
            return true;
        } else if (telNumber.matches("^\\d+\\-\\d+") && telNumber.matches(".{11}")) {
            return true;
        } else if (telNumber.matches("^\\d+\\-\\d+\\-\\d+") && telNumber.matches(".{12}")) {
            return true;
        } else if (telNumber.matches("^\\d+\\(\\d{3}\\)\\d*\\-\\d+") && telNumber.matches(".{13}")) {
            return true;
        } else if (telNumber.matches("^\\d+\\(\\d{3}\\)\\d*\\-\\d+\\-\\d+") && telNumber.matches(".{14}")) {
            return true;
        } else if (telNumber.matches("^\\d+\\(\\d{3}\\)\\d+") && telNumber.matches(".{12}")) {
            return true;
        }


        if (telNumber.matches("^\\(\\d{3}\\)\\d+") && telNumber.matches(".{12}")) {
            return true;
        } else if (telNumber.matches("^\\(\\d{3}\\)\\d*\\-\\d+") && telNumber.matches(".{13}")) {
            return true;
        } else if (telNumber.matches("^\\(\\d{3}\\)\\d*\\-\\d+\\-\\d+") && telNumber.matches(".{14}")) {
            return true;
        }

        return false;
    }
}
