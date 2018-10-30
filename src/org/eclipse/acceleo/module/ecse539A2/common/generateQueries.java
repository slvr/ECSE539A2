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
	
	public String getRootName(URNspec u){
		GRLspec g = u.getGrlspec();
		EList<IntentionalElement> list = g.getIntElements();
		for(IntentionalElement e : list) {
			if(e.getLinksSrc().size() == 0) {
				return e.getName();
			}
		}
		
		return "";
	}
	
	public IntentionalElement getRoot(URNspec u){
		GRLspec g = u.getGrlspec();
		EList<IntentionalElement> list = g.getIntElements();
		for(IntentionalElement e : list) {
			if(e.getLinksSrc().size() == 0) {
				return e;
			}
		}
		
		return null;
	}
	
	public EList<ElementLink> getDestLinks(IntentionalElement ie){		
		return ie.getLinksDest();
	}
	
	public Integer getNumDestLinks(IntentionalElement ie){		
		return ie.getLinksDest().size();
	}


	public String getIEName(IntentionalElement ie) {
		return  ie.getName();
	}
	
	public String getDecompositionType(ElementLink e) {
		// What happens when there's no decompositionType? Should return empty String, but this might give a Null pointer exception. We'll see.
		return  ((IntentionalElement) e.getSrc()).getDecompositionType().getName().toUpperCase(); 
	}
	
	public IntentionalElement getLinkChild(ElementLink e) {
		return (IntentionalElement) e.getSrc();
	}
	
	/////////////////////////////
	public EList<IntentionalElement> getDestNodes(ElementLink e){		
		return e.getToLinks();
	}
	
	//TODO
	public EList<ElementLink> getOutgoingLinks(IntentionalElement ie){
		return ie.getLinksDest();
	}
	
	//TODO
	public String getNodeType(IntentionalElement ie){
		return ie.getType().getName();
	}
	
	//TODO
	public ArrayList<Integer> getElementsOfActor(Actor a){
		return new ArrayList<Integer>();
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