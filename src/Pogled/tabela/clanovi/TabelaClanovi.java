package Pogled.tabela.clanovi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import Pogled.tabela.naslovi.TabelaModelNaslovi;
import util.PogledUtil;

public class TabelaClanovi extends JTable {
	public TabelaClanovi(TabelaModelClanovi tabelaModelClanovi) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel( tabelaModelClanovi);
		this.getTableHeader().setBackground(PogledUtil.getPrimarnaBoja());
		this.getTableHeader().setForeground(PogledUtil.getForegroundColor());
		this.getTableHeader().setFont(PogledUtil.getTeksPoljeFont());
		this.setFont(PogledUtil.getTeksPoljeFont());
		this.setRowHeight(60);
		TableCellRenderer stringCellRenderer = this.getDefaultRenderer(String.class);
		TableCellRenderer floatCellRenderer = this.getDefaultRenderer(Float.class);
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)stringCellRenderer;
        DefaultTableCellRenderer floatRenderer = (DefaultTableCellRenderer)floatCellRenderer;
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        floatRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
