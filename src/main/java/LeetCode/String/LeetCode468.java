package LeetCode.String;

public class LeetCode468 {
    public String validIPAddress(String IP) {
        String[] IPv4 = IP.split("\\.",-1);
        String[] IPv6 = IP.split("\\:",-1);
        if(IP.chars().filter(ch -> ch == '.').count() == 3) {
            for(String s : IPv4) {
                if(!isIPv4Segments(s)) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        if(IP.chars().filter(ch -> ch == ':').count() == 7) {
            for(String s : IPv6) {
                if(!isIPv6Segments(s)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4Segments(String s) {
        try {
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255;
        } catch(Exception e) {
            return false;
        }
    }

    private boolean isIPv6Segments(String s) {
        if(s.length() > 4) return false;
        try {
            // special checking: "1081:db8:85a3:01:-0:8A2E:0370:7334"
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        } catch(Exception e) {
            return false;
        }
    }
}
