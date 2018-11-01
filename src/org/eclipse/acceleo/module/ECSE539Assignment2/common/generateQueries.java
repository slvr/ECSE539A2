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
	
	@SuppressWarnings("unchecked")
	public int getNumActors(urn.URNspec u){
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
	
	@SuppressWarnings("unchecked")
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
		@SuppressWarnings("unchecked")
		EList<IntentionalElement> list = g.getIntElements();
		for(IntentionalElement e : list) {
			if(e.getLinksSrc().size() == 0) {
				return e;
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public EList<ElementLink> getDestLinks(IntentionalElement ie){		
		return ie.getLinksDest();
	}
	
	public Integer getNumDestLinks(IntentionalElement ie){		
		return ie.getLinksDest().size();
	}


	public String getIEName(IntentionalElement ie) {
		return  ie.getName();
	}
	
	public String printNull() {
		System.out.println("null");
		return  "null";
	}
	
	public String getDecompositionType(IntentionalElement ie) {
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getSucc().size(); i++){
			try{
				@SuppressWarnings("unused")
				Decomposition d =((Decomposition)((LinkRef)((IntentionalElementRef)ie.getRefs().get(0)).getPred().get(i)).getLink());
				return  ie.getDecompositionType().getName().toUpperCase() + " "; 
			} catch (ClassCastException cce){}
		}
		return ""; 
	}
	
	public IntentionalElement getLinkChild(ElementLink e) {
		return (IntentionalElement) e.getSrc();
	}
	
	/////////////////////////////
	@SuppressWarnings("unchecked")
	public EList<IntentionalElement> getDestNodes(ElementLink e){		
		return e.getToLinks();
	}
	
	@SuppressWarnings("unchecked")
	public EList<ElementLink> getOutgoingLinks(IntentionalElement ie){
		return ie.getLinksDest();
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
	
	//TODO
	public String getDependencyName(ElementLink l){
		return "";
	}
	
	
	public String getImportance(IntentionalElement ie){
		return Integer.toString(ie.getImportanceQuantitative());
	}
	
	public boolean hasImportance(IntentionalElement ie){
		if(ie.getImportance().toString().equals("None")){
			return false;
		}
		return true;
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
	
	public String getBeliefName(Belief b){
		return b.getDescription();
	}
	
	public List<IntentionalElement> getDependencies(IntentionalElement ie){
		ArrayList<IntentionalElement> list = new ArrayList<IntentionalElement>();
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getSucc().size(); i++){
			try{
				list.add((IntentionalElement)((Dependency)((LinkRef)((IntentionalElementRef)ie.getRefs().get(0)).getSucc().get(i)).getLink()).getSrc());
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
	
	public List<IntentionalElement> getDecompositions(IntentionalElement ie){
		ArrayList<IntentionalElement> list = new ArrayList<IntentionalElement>();
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getSucc().size(); i++){
			try{
				list.add((IntentionalElement)((Decomposition)((LinkRef)((IntentionalElementRef)ie.getRefs().get(0)).getSucc().get(i)).getLink()).getDest());
			}catch (ClassCastException cce){}
		}
		return list;
	}
	
	public List<Contribution> getContributions(IntentionalElement ie){
		ArrayList<Contribution> list = new ArrayList<Contribution>();
		for(int i = 0; i < ((IntentionalElementRef)ie.getRefs().get(0)).getSucc().size(); i++){
			try{
				list.add((Contribution)((LinkRef)((IntentionalElementRef)ie.getRefs().get(0)).getSucc().get(i)).getLink());
			}catch (ClassCastException cce){}
		}
		return list;
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