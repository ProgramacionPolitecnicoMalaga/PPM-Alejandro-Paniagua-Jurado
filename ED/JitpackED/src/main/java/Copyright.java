public class Copyright {
    private String text = "Copyright (C) 2001 Alejandro Panaigua - All Rights Reserved You may use, distribute and modify this code under the terms of the XYZ license, which unfortunately won't be written for another century. You should have received a copy of the XYZ license with this file. If not, please visit : http:www.nicolas-fernandez.com";

    public Copyright() {
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Copyright{" +
                "text='" + text + '\'' +
                '}';
    }
}
