package org.eclipse.acceleo.module.ecse539A2.common;

import org.eclipse.emf.ecore.EObject;

import grl.Actor;
import urn.URNspec;

public class generateQueries {

	public int getNumActors(URNspec u){
		int i = 0;
		for(EObject a : u.eContents()){
			if(a instanceof Actor){
				i++;
			}
		}
		return i;
	}
	
	public String getActorName(Actor a){
		return a.getName();
	}
	
}