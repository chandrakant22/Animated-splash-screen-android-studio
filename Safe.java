class Reserve implements Runnable{
//available berths are 1
	int available=1;
	int wanted;
		Reserve(int i){
		//accept berth at runtime
		wanted = i;
	}	
	public void run(){
		synchronized(this){ //synchronized the current object
			
			//display the available berths
			System.out.println("Available Berths = " +available);
			//if available berths are more then wanted berths
			if(available>=wanted){
				String name = Thread.currentThread().getName();
				//allot berths to him
				System.out.println(wanted+" Berths Reseeve For "+name);
				try{
					Thread.sleep(1500);//wait for printing ticket
					available = available-wanted;
				}catch(InterruptedException ie){}
			}else System.out.println("Sorry No Berths Available");
	    }
	}
}

class Safe{
	public static void main(String args[]){
		Reserve obj = new Reserve(1);
		Thread t1 = new Thread(obj);
		Thread t2= new Thread(obj);
		
		t1.setName("First Person");
		t2.setName("Second Person");
		t1.start();
		t2.start();
	}
}