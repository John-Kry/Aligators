package scripts;

import org.tribot.api.DynamicClicking;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Banking;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSGroundItem;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;

public class FirstTry extends Script {
	public int totalBanked = 0;
	@Override
	public void run() {
		if(Inventory.isFull()){
			WalkToBank();
			WalkToField();
		}else{
			WalkToField();
		}
		while (true) {
			if (Inventory.isFull())
					{
				WalkToBank();
				WalkToField();
					}
			else{
				if ((Math.abs((Player.getPosition().getX() - 3255))>=50) || (Math.abs(Player.getPosition().getY() - 3255))>=50){
					WalkToField();
				}
				final RSGroundItem[] cowhide = GroundItems.findNearest("Cowhide");
				if (cowhide != null){
				DynamicClicking.clickRSGroundItem(cowhide[0], "Take Cowhide");
				
				sleep(400,760);
				
				while(Player.isMoving()){
					sleep(10, 20);
					}
				}else if (cowhide == null){
					org.tribot.api2007.Camera.setCameraRotation((int) (Math.random()*180));
					}
				}
			}
		}
	public void WalkToBank(){
		
		//Positionable destination = new RSTile(3208,3210, 0);
		//WebWalking.walkTo(destination);
		//climbUp(16671);
		//climbUp(16672);
		Positionable destination2 = new RSTile(3208,3217, 2);
		WebWalking.walkTo(destination2);
		RSObject[] booth = Objects.find(30, 18491);
		booth[0].click("Bank");
		sleep(5000, 10000);
		Banking.depositAll();
		Banking.close();
		totalBanked = totalBanked + 28;
		System.out.println(totalBanked);
		//testcomment

	}
	private void climbUp(int OBJ_ID) {
		RSTile currentTile = Player.getPosition();
		RSObject[] x = Objects.find(6, OBJ_ID);
		if(x.length > 0 && x[0] != null) {
			x[0].click("Climb-Up");
		}
	}
	public void WalkToField(){
		
		Positionable destination = new RSTile(3255, 3266, 0);
		WebWalking.walkTo(destination);
		
	}
	}