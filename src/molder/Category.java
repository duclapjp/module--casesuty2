package molder;

public class Category {
    private String nameCategory;
    private String codeCategory;

    public Category() {
    }

    public Category(String nameCategory, String codeCategory) {
        this.nameCategory = nameCategory;
        this.codeCategory = codeCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "nameCategory='" + nameCategory + '\'' +
                ", codeCategory='" + codeCategory + '\'' +
                '}';
    }
}
