class ParkingSystem {
    private int[] capacity = new int[3];
    
    public ParkingSystem(int big, int medium, int small) {
        capacity[0] = big;
        capacity[1] = medium;
        capacity[2] = small;
    }
    
    public boolean addCar(int carType) {
        return capacity[carType-1]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */