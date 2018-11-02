package org.eclipse.acceleo.module.ECSE539Assignment2.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import grl.Actor;
import grl.Belief;
import grl.BeliefLink;
import grl.Contribution;
import grl.Decomposition;
import grl.Dependency;
import grl.ElementLink;
import grl.GRLspec;
import grl.IntentionalElement;
import grl.IntentionalElementRef;
import grl.LinkRef;
import urn.URNspec;
import urncore.IURNContainerRef;

public class generateQueries {
	
	public int getNumActors(urn.URNspec u){
		GRLspec g = u.getGrlspec();
		return g.getActors().size();
	}
	
	public IntentionalElement getRoot(URNspec u){
		GRLspec g = u.getGrlspec();
		for(Object e : g.getIntElements()) {
			if(((IntentionalElement)e).getLinksSrc().size() == 0) {
				return (IntentionalElement) e;
			}
		}
		return null;
	}
	
	public Integer getNumDestLinks(IntentionalElement ie){		
		return ie.getLinksDest().size();
	}
	
	public String getDecompositionType(IntentionalElement ie) {
		for(int i = 0; i < ie.getLinksDest().size(); i++){
			try{
				@SuppressWarnings("unused")
				Decomposition d =((Decomposition)ie.getLinksDest().get(i));
				return  ie.getDecompositionType().getName().toUpperCase() + " "; 
			} catch (ClassCastException cce){}
		}
		return ""; 
	}
	
	public String getNodeType(IntentionalElement ie){
		return (ie.getType().getName().toLowerCase() != "")?ie.getType().getName().toLowerCase():"softgoal";
	}
	
	public List<IntentionalElement> getElementsOfActor(Actor a){
		ArrayList<IntentionalElement> list = new ArrayList<IntentionalElement>();
		for(int i = 0; i < ((IURNContainerRef)a.getContRefs().get(0)).getNodes().size(); i++){
			try{
				IntentionalElement j = ((IntentionalElementRef)((IURNContainerRef)a.getContRefs().get(0)).getNodes().get(i)).getDef();
				list.add(j);
			}catch (ClassCastException cce){ }
		}
		return list;
	}
	
	public List<Belief> getBeliefs(IntentionalElement ie){
		ArrayList<Belief> list = new ArrayList<Belief>();
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getPred().size(); i++){
			try{
				list.add(((Belief)((BeliefLink)((IntentionalElementRef)ie.getRefs().get(0)).getPred().get(i)).getSource()));
			}catch (ClassCastException cce){}
		}
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getSucc().size(); i++){
			try{
				list.add(((Belief)((BeliefLink)((IntentionalElementRef)ie.getRefs().get(0)).getSucc().get(i)).getSource()));
			}catch (ClassCastException cce){}
		}
		return list;
	}
	
	public String getIEActorName(IntentionalElement ie){
		for(Object a: ie.getGrlspec().getActors()) {
			List<IntentionalElement> iel = getElementsOfActor((Actor) a);
			for(IntentionalElement ie2: iel) {
				if(ie == ie2) return ((Actor)a).getName();
			}
		}
		return "";
	}
	
	public String isCorrelated(Contribution c){
		if(c.isCorrelation()){
			return "correlated ";
		}
		else{
			return "";
		}
	}
	
}