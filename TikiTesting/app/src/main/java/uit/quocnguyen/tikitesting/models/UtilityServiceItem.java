package uit.quocnguyen.tikitesting.models;

public class UtilityServiceItem {
    private String name;
    private int mIconResource;

    public UtilityServiceItem(String name, int mIconResource) {
        this.name = name;
        this.mIconResource = mIconResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmIconResource() {
        return mIconResource;
    }

    public void setmIconResource(int mIconResource) {
        this.mIconResource = mIconResource;
    }
}
