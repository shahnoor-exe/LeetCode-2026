class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue=new LinkedList<>();
        if(digits==null||digits.isEmpty()) return queue;
        String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        queue.add("");
        for(char digit:digits.toCharArray()){
            String letters=phone[digit-'0'];
            int size=queue.size();
            for(int i=0;i<size;i++){
                String prefix=queue.poll();
                for (char c:letters.toCharArray()){
                    queue.add(prefix+c);
                }
            }
        }return queue;
    }
}