package model;

public class Category {
    private int idCategory;
    private String namecategory;

    public Category() {
    }

    public Category(int idCategory, String namecategory) {
        this.idCategory = idCategory;
        this.namecategory = namecategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }
}
