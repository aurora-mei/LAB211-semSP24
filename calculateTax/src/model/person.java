/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

public final class person {
    private String name;
    private int NoChildren;
    private List<resources> resourcesTotal;
    private List<child> children;
    private List<parent>  parents;
    private int NoBrSis;
    private int deductionSelf;
    

    public person() {
    }

    public person(String name, int NoChildren, List<resources> resourcesTotal, List<child> children, List<parent> parents, int NoBrSis) {
        setDeductionSelf();
        this.name = name;
        this.NoChildren = NoChildren;
        this.resourcesTotal = resourcesTotal;
        this.children = children;
        this.parents = parents;
        this.NoBrSis = NoBrSis;
    }

    public int getNoBrSis() {
        return NoBrSis;
    }

    public void setNoBrSis(int NoBrSis) {
        this.NoBrSis = NoBrSis;
    }


    public int getNoChildren() {
        return NoChildren;
    }

    public void getNoChildren(int NoStudent) {
        this.NoChildren = NoStudent;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<resources>getResourcesTotal() {
        return resourcesTotal;
    }

    public void setResourcesTotal(List<resources> resourcesTotal) {
        this.resourcesTotal = resourcesTotal;
    }

    public List<child>getChildren() {
        return children;
    }

    public void setChildren(List<child> children) {
        this.children = children;
    }

    public List<parent> getParents() {
        return parents;
    }

    public void setParents(List<parent> parents) {
        this.parents = parents;
    }

    public int getDeductionSelf() {
        return deductionSelf;
    }

    public void setDeductionSelf() {
        this.deductionSelf = 11000000;
    }

    @Override
    public String toString() {
        return "person{" + "name=" + name + ", NoChildren=" + NoChildren + ", resourcesTotal=" + resourcesTotal + ", children=" + children + ", parents=" + parents + ", NoBrSis=" + NoBrSis + '}';
    }

}

