# 1768. Merge String Alternatively 

### [Question](https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75)


You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

#### Example 
```
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
```

### Solution

- Simply iterate over the word and save one char at a time and if one word is finished add all as it is.
- Check which word has characters remaining the pending string can be fetched using `str.substring(i,wordx.length())`

#### Time Complexity 
$\text{O}(m+n)$ where $m$ & $n$ are length of the strings to be merged

#### Space Complexity 
$\text{O}(m+n)$ the combined length of the two string

