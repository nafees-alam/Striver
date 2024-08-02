class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet<String> set = new HashSet<>();
        int n = wordList.length;
        for(int i = 0; i < n; i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            ArrayList<String> vec = q.remove();
            
            if(vec.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }
            
            String word = vec.get(vec.size() - 1);
            if(word.equals(targetWord)){
                if(ans.size() == 0){
                    ans.add(vec);
                } else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String newWord = new String(replacedCharArray);
                    
                    if(set.contains(newWord)){
                        vec.add(newWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        
                        usedOnLevel.add(newWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
            
        }
        
        return ans;
    }
}
