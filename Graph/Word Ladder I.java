class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        
        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int count = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) return count;

            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String newWord = new String(replacedCharArray);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord, count+1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair{
    String first;
    int second;

    public Pair(String i, int j){
        this.first = i;
        this.second = j;
    }
}
