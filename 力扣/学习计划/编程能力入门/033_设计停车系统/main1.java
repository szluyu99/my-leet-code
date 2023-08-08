class ParkingSystem {
    int[] cars = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        cars[0] = big;
        cars[1] = medium;
        cars[2] = small;
    }

    public boolean addCar(int carType) {
        return cars[carType - 1]-- > 0;
    }
}
