package coreGame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class TreePopupMenu extends javax.swing.JPopupMenu {
	   JMenuItem createNewState; 
	   JMenuItem createNewChoice;
	   JMenuItem delete;
	   JMenu newActionSubMenu;
	public TreePopupMenu(){
		    createNewState= new JMenuItem("Create New State");
		    createNewChoice= new JMenuItem("Choice");
		    delete = new JMenuItem("Delete");
		    newActionSubMenu = new JMenu("New Action");
		    newActionSubMenu.add(createNewChoice);
		this.add(createNewState);
		this.add(newActionSubMenu);
		this.add(delete);
		
	}
	
	
}
