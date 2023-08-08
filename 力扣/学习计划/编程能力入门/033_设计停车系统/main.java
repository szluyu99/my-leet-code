class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            return big > 0 ? (big-- >= 0) : false;
        } else if (carType == 2) {
            return medium > 0 ? (medium-- >= 0) : false;
        } else if (carType == 3) {
            return small > 0 ? (small-- >= 0) : false;
        } else
            return false; // 非法数据
    }
}