public class Leetcode71 {
    public String simplifyPath(String path) {
        String result = "";

        String[] path_array = path.split("/");

        int keep = 0;

        for(int i = path_array.length - 1; i >= 0; i--) {
            if ("".equals(path_array[i]) || ".".equals(path_array[i])) {
                continue;
            }

            if ("..".equals(path_array[i])) {
                keep++;
                continue;
            }

            if(keep > 0) {
                keep--;
                continue;
            }

            if(result.length() == 0) {
                result = "/" + path_array[i];
            } else {
                result = "/"+ path_array[i] + result;
            }
        }

        if(result.length() == 0) {
            return "/";
        }else {
            return result;
        }

    }

    public static void main(String[] args) {
        Leetcode71 l = new Leetcode71();
        String path = "/home/";
        System.out.println(l.simplifyPath(path));
    }
}
