class Solution {
public:
    string longestNiceSubstring(string s) {
    int max_length = 0;
    string result = "";
    
    for (int i = 0; i < s.length(); i++) {
        int lower_mask = 0, upper_mask = 0;
        for (int j = i; j < s.length(); j++) {
            if (islower(s[j]))
                lower_mask |= (1 << (s[j] - 'a'));
            else
                upper_mask |= (1 << (s[j] - 'A'));
            
            if (lower_mask == upper_mask && j - i + 1 > max_length) {
                max_length = j - i + 1;
                result = s.substr(i, j - i + 1);
            }
        }
    }
    return result;    
    }
};