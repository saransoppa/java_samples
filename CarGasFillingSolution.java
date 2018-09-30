package com.java.solutions;

public class CarGasFillingSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarGasFillingSolution carGas = new CarGasFillingSolution();
		int[] carsArray = {2,8,4,3,2};
		System.out.println( carGas.solution(carsArray, 7, 11, 3) );
	}
	
	private int maxWaitTime = 0;
	int numDispenser = 3;
	Dispenser[] dispensers = new Dispenser[numDispenser];
	
	public int solution(int[] A, int X, int Y, int Z) {
		keepDispenserReady(X, Y, Z);
		int time = 0;
		
		Car[] carsQueue = new Car[A.length];
		for(int i=0; i<A.length; i++) {
			carsQueue[i] = new Car(String.valueOf(i), A[i]);
		}
		
		int carsCount = 0;
		System.out.println("carsQueue.length ->"+ carsQueue.length);
		while(carsCount <= carsQueue.length-1) {
			System.out.println("carsCount ->"+ carsCount);
			Dispenser dispenserA = getAvailableDispenser( carsQueue[carsCount].getDemandfuel() );
			System.out.println("dispenserA ->"+ dispenserA);
			if(null != dispenserA) {
				if(maxWaitTime < carsQueue[carsCount].getDemandfuel()){
					maxWaitTime = carsQueue[carsCount].getDemandfuel();
				}
				System.out.println("At time "+time+", Car "+ carsQueue[carsCount].getName() +" drives to dispenser "+ dispenserA.getName() +" with MaxWaitTime "+ maxWaitTime +".");
				Dispenser dispenserB = getAvailableDispenser( carsQueue[carsCount++].getDemandfuel() );
				System.out.println("carsCount ->"+ carsCount);
				if(null != dispenserB) {
					if(maxWaitTime < carsQueue[carsCount].getDemandfuel()){
						maxWaitTime = carsQueue[carsCount].getDemandfuel();
					}
					System.out.println("At time "+time+", Car "+ carsQueue[carsCount].getName() +" drives to dispenser "+ dispenserB.getName() +" with MaxWaitTime "+ maxWaitTime +".");
					Dispenser dispenserC = getAvailableDispenser( carsQueue[carsCount++].getDemandfuel() );
					if(null != dispenserC) {
						if(maxWaitTime < carsQueue[carsCount].getDemandfuel()){
							maxWaitTime = carsQueue[carsCount].getDemandfuel();
						}
						System.out.println("At time "+time+", Car "+ carsQueue[carsCount].getName() +" drives to dispenser "+ dispenserC.getName() +" with MaxWaitTime "+ maxWaitTime +".");
						releaseDispenser(dispenserA);
						releaseDispenser(dispenserB);
						releaseDispenser(dispenserC);
					} else {
						releaseDispenser(dispenserA);
						releaseDispenser(dispenserB);
					}
				} else {
					releaseDispenser(dispenserA);
				}
			} else {
				
				return -1;
			}
		}
		
		return maxWaitTime;
    }
	
	private void keepDispenserReady(int X, int Y, int Z){
		dispensers[0] = new Dispenser("X",X,false,0);
		dispensers[1] = new Dispenser("Y",Y,false,0);
		dispensers[2] = new Dispenser("Z",Z,false,0);
	}
	
	private Dispenser getAvailableDispenser(int demandFule){
		for(Dispenser dispenser : dispensers){
			if(!dispenser.isOccupied && dispenser.getFuelAvailable() >= demandFule ) {
			   dispenser.isOccupied = true;
			   dispenser.fuelAvailable = dispenser.getFuelAvailable() - demandFule;
			   dispenser.vists++;
			  return dispenser; 
			}
		}
	  return null;
	}
	
	private void releaseDispenser(Dispenser dispenser) {
		dispenser.isOccupied = false;
	}
	
	class Dispenser {
		
		private String name;
		private int vists = 0;
		private int fuelAvailable = 0;
		private boolean isOccupied = false;
		
		public Dispenser(String name, int fuelAvailable, boolean isAssigned, int vists){
			this.name = name;
			this.fuelAvailable = fuelAvailable;
			this.isOccupied = isAssigned;
			this.vists = vists;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public boolean isOccupied() {
			return isOccupied;
		}
		public void setOccupied(boolean isOccupied) {
			this.isOccupied = isOccupied;
		}

		public int getFuelAvailable() {
			return fuelAvailable;
		}
		public void setFuelAvailable(int fuelAvailable) {
			this.fuelAvailable = fuelAvailable;
		}

		public int getVists() {
			return vists;
		}
		public void setVists(int vists) {
			this.vists = vists;
		}
		
	}
	
	
	class Car {
		
		private String name;
		private int demandFuel = 0;
		
		public Car(String name, int demandFuel){
			this.name = name;
			this.demandFuel = demandFuel;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDemandfuel() {
			return demandFuel;
		}
		public void setDemandfuel(int demandfuel) {
			this.demandFuel = demandfuel;
		}
	}
	
	

}
