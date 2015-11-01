package coreGame;

import gameData.GameObject;

import java.util.List;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.reflections.Reflections;



public class TreePopupMenu extends javax.swing.JPopupMenu {

	Reflections reflections = new Reflections("com.mycompany");    
	Set<Class<? extends GameObject>> classes = reflections.getSubTypesOf(GameObject.class);
	
	   List<JMenuItem> actionMenuItems;
	   JMenuItem delete;
	   public TreePopupMenu(){
		    delete = new JMenuItem("Delete");
		    newActionSubMenu = new JMenu("New Action");
		    newActionSubMenu.add(createNewChoice);
		this.add(createNewState);
		this.add(newActionSubMenu);
		this.add(delete);
		
	}
	
	
}
