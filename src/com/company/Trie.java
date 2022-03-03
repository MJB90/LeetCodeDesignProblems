package com.company;

import java.util.HashMap;

class Trie {

    class Node{
        private Boolean isWord;
        private HashMap<Character,Node> next;

        Node(Boolean isWord){
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public void setIsWord(Boolean val){
            isWord = val;
        }
        public Boolean getIsWord(){
            return isWord;
        }
        public HashMap<Character,Node> getNext(){
            return next;
        }
    }

    private Node root;

    public Trie() {
        root = new Node(false);
    }

    public void insert(String word) {
        int i = 0;
        Node tempRoot = root;
        while(i<word.length()){
            if(tempRoot.getNext().get(word.charAt(i))==null){
                Node node = new Node(false);
                tempRoot.getNext().put(word.charAt(i),node);
                tempRoot = node;
            }
            else{
                tempRoot = tempRoot.getNext().get(word.charAt(i));
            }
            i++;
        }
        tempRoot.setIsWord(true);
    }

    public boolean search(String word) {
        int i = 0;
        Node tempRoot = root;
        while(i<word.length()){
            if(tempRoot.getNext().get(word.charAt(i))==null){
                return false;
            }
            else{
                tempRoot = tempRoot.getNext().get(word.charAt(i));
            }
            i++;
        }
        return tempRoot.getIsWord();
    }

    public boolean startsWith(String prefix) {
        int i = 0;
        Node tempRoot = root;
        while(i<prefix.length()){
            if(tempRoot.getNext().get(prefix.charAt(i))==null){
                return false;
            }
            else{
                tempRoot = tempRoot.getNext().get(prefix.charAt(i));
            }
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */