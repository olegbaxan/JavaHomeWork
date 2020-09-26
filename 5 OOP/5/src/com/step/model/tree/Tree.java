package com.step.model.tree;

public class Tree {
    String treeType;
    String category;

    public void tree(String _treeType, String _category){
        treeType=_treeType;
        category=_category;

        System.out.println(treeType + " : "+ category);
    }
    public void initial(){
        System.out.println("In this park you can see:");
    }


}
