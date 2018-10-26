package org.eclipse.acceleo.module.ecse539A2.common;

import org.eclipse.emf.common.util.EList;

import grl.Actor;
import grl.GRLspec;
import urn.URNspec;

public class generateQueries {

	@SuppressWarnings("unchecked")
	public int getNumActors(URNspec u){
		GRLspec g = u.getGrlspec();
		EList<Actor> actorsList = g.getActors();
		if(actorsList.size() == 0){
			return 0;
		}
		else{
			return actorsList.size();
		}
	}
	
	public String getActorName(Actor a){
		return a.getName();
	}
	
}