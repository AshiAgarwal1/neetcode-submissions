class Solution {
    public String foreignDictionary(String[] words) {
      // put every character into graph
      Map<Character,Set<Character>> adj=new HashMap<>();
      Map<Character,Integer> indegree=new HashMap<>();
      for(String w:words){
        for(char c:w.toCharArray()){
            adj.putIfAbsent(c,new HashSet<>());
            indegree.putIfAbsent(c,0);
        }
      }
      for(int i=0;i<words.length-1;i++){
        String s1=words[i];
        String s2=words[i+1];
        int minLen=Math.min(s1.length(),s2.length());
        if(s1.length()>s2.length() && s1.substring(0,minLen).equals(s2.substring(0,minLen))){
            return "";
        }
        for(int j=0;j<minLen;j++){
            char ch1=s1.charAt(j);
            char ch2=s2.charAt(j);
            if(ch1!=ch2){
                if(!adj.get(ch1).contains(ch2)){//check to prevent inc indegree multiple times,  only if edge is new add it and inc indegree
                adj.get(ch1).add(ch2);//a->b
                indegree.put(ch2,indegree.get(ch2)+1);
                }
                break;
            }
        }
      }
      Queue<Character> q=new LinkedList<>();
      for(char c:indegree.keySet()){
        if(indegree.get(c)==0) q.add(c);
      }
      StringBuilder res=new StringBuilder();
      while(!q.isEmpty()){
        char ch=q.remove();
        res.append(ch);
        for(char n:adj.get(ch)){
            indegree.put(n,indegree.get(n)-1);
            if(indegree.get(n)==0) q.add(n);
        }
      }
      if(res.length()!=indegree.size()) return "";
      return res.toString();
    }
}
