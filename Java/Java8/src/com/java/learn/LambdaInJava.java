package com.java.learn;

import java.util.Random;

public class LambdaInJava {

	public static void main(String[] args) {
		
		
		ActorSupplier actor = () ->{
			String actorName = "";
			
			Random randNum = new Random();
			
			int a=randNum.nextInt()%3;
			
			switch (a) {
			case 1:
				actorName = "Sivaji";
				break;
			case 2:
				actorName = "MGR";
				break;
			case 0:
				actorName = "Rajini";
				break;

			default:
				 actorName = "someActor";
				break;
			}
			
			return actorName;
		};
		
		
		ActorConsumer hero = (heroName) -> {
			System.out.println("Born as "+heroName);
			System.out.println(heroName+" works hard");
			heroName = heroName.concat(" Becomes rolemodel and a ***Hero****");
			System.out.println(heroName);
		};
		
		hero.act(actor.getName());
		
		ActorConsumer villain =(villainName) ->{
			System.out.println("Born as "+villainName);
			System.out.println(villainName+" works hard");
			System.out.println(villainName+" becomes fed up as he does not get what he deserved");
			System.out.println(villainName+" gets his vengeance atlast");
			
		};
		
		villain.act(actor.getName());

	}
	
	
	
	@FunctionalInterface
	interface ActorConsumer{
		void act(String role);
	}
	
	@FunctionalInterface
	interface ActorSupplier{
		String getName();
	}


}
