
/*
12-04-2023
https://leetcode.com/problems/simplify-path/description/

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style 
file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, 
a double period '..' refers to the directory up a level, 
and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. 
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory 
(i.e., no period '.' or double period '..')
Return the simplified canonical path. 

Examples:
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, 
as the root level is the highest level you can go.

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

*/
import java.util.*;
class simplifyPath {
    public static String simplifyPathFn(String path) {
        StringBuilder sb = new StringBuilder();
        String [] pathArr = path.split("/");
        ArrayList <String> resultPath = new ArrayList<>();

        for(String p : pathArr){
            if(p.isEmpty()) continue;
            
            else if(p.equals("..")){
                if (resultPath.size() > 0)
                    resultPath.remove(resultPath.size() - 1);
                if (resultPath.size() > 0)
                    resultPath.remove(resultPath.size() - 1);
            }
            else if (!p.equals(".")) {
                resultPath.add("/");
                resultPath.add(p);
            }
        }
        for (String s : resultPath)
            sb.append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path =  sc.next();
        String result = simplifyPathFn(path);
        System.out.println("The simplified path is : "+result);
        sc.close();
    }
}