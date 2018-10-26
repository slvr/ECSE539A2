package org.eclipse.acceleo.module.ecse539A2.common;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import grl.Actor;
import grl.ElementLink;
import grl.GRLspec;
import grl.IntentionalElement;
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
	
	//TODO
	public String getRootName(URNspec u){
		return "";
	}
	
	//TODO
	public ArrayList<Integer> getOutgoingLinks(IntentionalElement ie){
		return new ArrayList<Integer>();
	}
	
	//TODO
	public int getDestNode(ElementLink l){
		return 0;
	}
	
	//TODO
	public String getNodeType(IntentionalElement ie){
		return "";
	}
	
	//TODO
	public ArrayList<Integer> getElementsOfActor(Actor a){
		return new ArrayList<Integer>();
	}
	
	//TODO
	public String getLinkType(ElementLink l){
		return "";
	}
	
	//TODO
	public String getDependencyName(ElementLink l){
		return "";
	}
	
	//TODO
	public ArrayList<Integer> getComplimentaryDecompositionLinks(ElementLink l){
		return new ArrayList<Integer>();
	}
	
}