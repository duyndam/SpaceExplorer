package gui;

import java.awt.Color;

import javax.swing.JSplitPane;

public class JSplitPaneIndexed extends JSplitPane{

	private int m_indexCrewMember = 0;

	/**
	 * @return the indexCrewMember
	 */
	public int get_IndexCrewMember() {
		return m_indexCrewMember;
	}

	/**
	 * @param indexCrewMember the indexCrewMember to set
	 */
	public void set_IndexCrewMember(int indexCrewMember) {
		this.m_indexCrewMember = indexCrewMember;
	}
	
}
